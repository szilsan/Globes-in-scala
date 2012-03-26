package com.ftl.globe
import com.ftl.globe.model.Globe
import scala.collection.mutable.ListBuffer
import model.Coordinate
import com.ftl.globe.model.Coordinate
import com.ftl.globe.model.Coordinate

object MovementFactory {
  val G = 6.67428E-11
  
  def calculateNewPositions(globes: ListBuffer[Globe]) = {
    assert(globes != Nil)
//    println("calculate...")

    // calculate new speed and coord
    globes.foreach(g => calculate(g, globes.filter(_ != g)))

    // calculated coord become prevCoord
    globes.foreach(_.rotateCoordToOld)
    
//    println("calculated values")
//    globes.foreach(println _)
  }

  private def calculate(globe: Globe, globes: ListBuffer[Globe]) {
//    println(globe)
    var accCoord: Coordinate = new Coordinate
    for (g <- globes) {
      if (g != globe) {
        val directionVector = g.prevCoord - globe.prevCoord
        val forceLength = G * globe.weight * g.weight / Math.pow(directionVector.length, 2)

        val ratio = forceLength / (directionVector.length * globe.weight)
        val accVector = new Coordinate(directionVector.x * ratio, directionVector.y * ratio, directionVector.z * ratio)

        accCoord += accVector
      }
    }

    // calculate new position (old position + new speed)
    globe.speed += accCoord
    globe.coord += globe.speed

  }
}
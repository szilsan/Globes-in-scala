package com.ftl.globe
import com.ftl.globe.model.Globe
import scala.collection.mutable.ListBuffer
import model.Coordinate
import com.ftl.globe.model.Coordinate
import com.ftl.globe.model.Coordinate

object MovementFactory {
  def calculateNewPositions(globes: ListBuffer[Globe]) = {
    assert(globes != Nil)
    println("calculate...")

    // calculate new speed and coord
    globes.foreach(calculateNewPosition(_, globes));

    // calculated coord become prevCoord
    globes.foreach(_.rotateCoordToOld)
  }

  private def calculateNewPosition(globe: Globe, globes: ListBuffer[Globe]) = {
    // calculate new speed coords (sum of each calculated speed)
    var forceCoord: Coordinate = new Coordinate(globe.coord)

//    globes.filter(_ != globe).foreach(println _)

    for (g <- globes if (!globes.contains(g))) {
      val directionVector = globe.prevCoord - g.prevCoord
      val forceLength = g.measure * globe.measure / Math.pow(directionVector.length, 2)

      val ratio = forceLength / directionVector.length
      val forceVector = new Coordinate(directionVector.x / ratio, directionVector.y / ratio, directionVector.z / ratio)

      forceCoord +=forceVector
    }
    
    val a = forceCoord.length / globe.measure
    globe.speed +=a
    
    
    // calculate new position (old position + new speed)

  }
}
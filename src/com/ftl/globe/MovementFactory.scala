package com.ftl.globe
import com.ftl.globe.model.Globe
import scala.collection.mutable.ListBuffer
import model.Coordinate
import com.ftl.globe.model.Coordinate
import com.ftl.globe.model.Coordinate
import com.sun.xml.internal.bind.v2.util.CollisionCheckStack
import model.Globe
import java.awt.Color

object MovementFactory {
  val G = 6.67428E-11

  def calculateNewPositions(globes: ListBuffer[Globe]) = {
    require(globes != Nil)
    
    // detect collisions
    var coll = false
    do {
      coll = false
      for (g <- globes if !coll) {
        coll = detectCollisions(g, globes)
      }
    } while (coll)

    // calculate new speed and coord
    globes.foreach(g => calculate(g, globes.filter(_ != g)))

    // calculated coord become prevCoord
    globes.foreach(_.rotateCoordToOld)
  }

  private def calculate(globe: Globe, globes: ListBuffer[Globe]) {
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

  private def detectCollisions(globe: Globe, globes: ListBuffer[Globe]) = {
    var isCollision = false
    for (g <- globes.filter(_ != globe) if !isCollision) {
      isCollision = (g.radius + globe.radius) >= g.coord.distance(globe.coord)

      // merge two objects
      if (isCollision) {
        println("collision")
        var gNew = g + globe
        globes -= g
        globes -= globe
        globes += gNew
        println(gNew)
      }
    }
    isCollision
  }
}
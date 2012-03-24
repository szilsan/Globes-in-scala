package com.ftl.globe
import com.ftl.globe.model.Globe
import scala.collection.mutable.ListBuffer
import model.Coordinate
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

    for (g <- globes) {
      if (!globes.contains(g)) {
    	  var force = new Coordinate
    	  // TODO
    	  
    	  forceCoord += force
      }
    }

    // calculate new position (old position + new speed)

  }
}
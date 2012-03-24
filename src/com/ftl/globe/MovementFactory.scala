package com.ftl.globe
import com.ftl.globe.model.Globe
import scala.collection.mutable.ListBuffer

object MovementFactory {
  def calculateNewPositions(globes: ListBuffer[Globe]) = {
    assert(globes != Nil)
    println("calculate...")
    
    // calculate new speed and coord
    globes.foreach(calculateNewPosition(_, globes));
    
    // calculated coord become prevCoord
    globes.foreach((g:Globe) => g.prevCoord = g.coord)
  }

  private def calculateNewPosition(globe: Globe, globes: ListBuffer[Globe]) = {
    // calculate new speed (sum of each calculated speed)
    
    // calculate new position (old position + new speed)
    
    
    
    
  }
}
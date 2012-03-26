package com.ftl.globe.model
import java.awt.Color

/*
 * Describe a globe (object in space) 
 */
class Globe(startSpeed: Coordinate = new Coordinate, val startCoord: Coordinate = new Coordinate, val paintColor: Color = Color.RED) extends Element {

  // paiinting color
  speed = startSpeed
  coord = startCoord
  prevCoord = startCoord

  def +(g: Globe): Globe = {
    var globe: Globe = new Globe(paintColor = new Color((Math.random * 255).intValue(), (Math.random * 255).intValue(), (Math.random * 255).intValue()))
    globe.coord.x = coord.x + (coord.x - g.coord.x) / 2
    globe.coord.y = coord.y + (coord.y - g.coord.y) / 2
    globe.coord.z = coord.z + (coord.z - g.coord.z) / 2

    globe.radius = g.radius + radius

    globe.weight = weight + g.weight

    var speedLength = (weight * speed.length + g.weight * g.speed.length) / globe.weight
    var speedDirectionVector = (speed * weight) + (g.speed * g.weight)

    var ratio = speedLength / speedDirectionVector.length
    var speedVector = new Coordinate(speedDirectionVector.x * ratio, speedDirectionVector.y * ratio, speedDirectionVector.z * ratio)
  	globe.speed = speedVector
    
    return globe
  }

  override def toString = "Position: " + coord + " Speed: " + speed + " Radius: " + radius
}
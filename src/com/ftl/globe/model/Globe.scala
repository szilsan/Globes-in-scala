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

  override def toString = "Position: " + coord + " Speed: " + speed
}
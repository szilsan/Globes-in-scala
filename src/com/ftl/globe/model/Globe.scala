package com.ftl.globe.model

class Globe(startSpeed: PointingVector = new PointingVector, val startCoord: Coordinate = new Coordinate) extends Element {

  var speed = startSpeed
  
  var coord = startCoord
  var prevCoord = startCoord
  
  override def toString = "Position: " + coord + " Speed: " + speed
}
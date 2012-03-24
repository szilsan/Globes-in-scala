package com.ftl.globe.model

class Globe(startSpeed: Coordinate = new Coordinate, val startCoord: Coordinate = new Coordinate) extends Element {

  var speed = startSpeed
  
  var coord = startCoord
  var prevCoord = startCoord
  
  override def toString = "Position: " + coord + " Speed: " + speed
}
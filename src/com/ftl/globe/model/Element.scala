package com.ftl.globe.model

abstract class Element {
  val measure: Long = 1
  val radius: Long = 1
  
  var coord: Coordinate  
  var prevCoord: Coordinate
  
  var speed: Coordinate
  
  def rotateCoordToOld = prevCoord = new Coordinate(coord);
}
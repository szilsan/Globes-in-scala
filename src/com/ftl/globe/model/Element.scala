package com.ftl.globe.model

/*
 * Descibe an object 
 */
class Element(measure: Long = 1, radius: Long = 1) {

  var coord: Coordinate = new Coordinate // current coordinate 
  var prevCoord: Coordinate = new Coordinate // previous coordinte - to calculate new one

  var speed: Coordinate = new Coordinate // speed vector
  
  var weight:Long = 1 // weight of object
  var radius:Long =1 // radius of object

  // copy calculated coordinate into prevCoord 
  def rotateCoordToOld = prevCoord = new Coordinate(coord);
}
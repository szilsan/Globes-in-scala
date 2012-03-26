package com.ftl.globe.model

class Coordinate {
  var x: Double = 0;
  var y: Double = 0;
  var z: Double = 0;

  def this(x: Double = 0, y: Double = 0, z: Double = 0) {
    this
    this.x = x;
    this.y = y;
    this.z = z;
  }

  def this(coord: Coordinate) {
    this
    assert(coord != Nil)
    this.x = coord.x;
    this.y = coord.y;
    this.z = coord.z;
  }

  def +=(otherCoord: Coordinate) {
    x += otherCoord.x
    y += otherCoord.y
    z += otherCoord.z
  }

  def -=(otherCoord: Coordinate) {
    x -= otherCoord.x
    y -= otherCoord.y
    z -= otherCoord.z
  }

  def -(otherCoord: Coordinate): Coordinate = 
    new Coordinate(x - otherCoord.x, y - otherCoord.y, z - otherCoord.z)
  
  def +(otherCoord: Coordinate): Coordinate = 
    new Coordinate(x + otherCoord.x, y + otherCoord.y, z + otherCoord.z)
  
  def *(gain:Double): Coordinate = 
    new Coordinate(x*gain, y * gain, z * gain)

  def length: Double = 
    Math.sqrt(Math.pow(Math.abs(x), 2) + Math.pow(Math.abs(y), 2) + Math.pow(Math.abs(z), 2))

  def distance(otherPoint: Coordinate): Double = 
    (this - otherPoint) length

  override def toString = "[x=" + x + ", y=" + y + ", z=" + z + "]"

}
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

  override def toString = { "[x=" + x + ", y=" + y + ", z=" + z + "]" }

}
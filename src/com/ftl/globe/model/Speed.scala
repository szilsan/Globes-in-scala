package com.ftl.globe.model

class Speed {
  var x: Double = 0;
  var y: Double = 0;
  var z: Double = 0;

  def this(x: Double = 0, y: Double = 0, z: Double = 0) {
    this
    this.x = x;
    this.y = y;
    this.z = z;
  }

  override def toString = "x=" + x + ", y=" + y + ", z=" + z;
}
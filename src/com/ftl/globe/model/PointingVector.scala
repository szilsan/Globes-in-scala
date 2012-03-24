package com.ftl.globe.model

class PointingVector(start: Coordinate = new Coordinate, end: Coordinate = new Coordinate) {

  override def toString = { "[" + start + " -> " + end + "]" }
}
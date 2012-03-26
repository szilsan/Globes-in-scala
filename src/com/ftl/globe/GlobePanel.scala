package com.ftl.globe
import scala.swing.Frame
import scala.swing.Panel
import java.awt.Graphics2D
import scala.util.Random
import java.awt.Color
import scala.swing.event.WindowClosing
import java.awt.Dimension

class GlobePanel extends Frame {
  val windowSizeX = 800
  val windowSizeY = 600

  title = "Globe app"

  contents = new Panel {
    preferredSize = new Dimension(windowSizeX, windowSizeY)
    opaque = true

    override def paint(g: Graphics2D) = {
      doOnPaint(g);
    }
  }

  centerOnScreen
  listenTo(this)
  reactions += {
    case WindowClosing(e) => {
      println("Exiting...")
      System.exit(0)
    }
  }

  def doOnPaint(g: Graphics2D) = {
    for (globe <- GlobeApp.globes) {
      g.setColor(globe.paintColor)
      g.fillOval(globe.coord.x.intValue(), globe.coord.y.intValue(), globe.radius.intValue() * 2, globe.radius.intValue() * 2)
    }
  }
}

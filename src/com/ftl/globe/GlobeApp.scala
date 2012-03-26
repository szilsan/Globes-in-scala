package com.ftl.globe
import model.Speed
import model.Coordinate
import model.Globe
import model.Element
import scala.collection.mutable.ListBuffer
import com.ftl.globe.model.PointingVector
import com.ftl.globe.model.Coordinate
import scala.swing.SimpleSwingApplication
import scala.swing.SwingApplication
import java.awt.Dimension
import javax.swing.Timer
import java.awt.Color

object GlobeApp extends SwingApplication {
  val globes: ListBuffer[Globe] = new ListBuffer[Globe];

  val sleep = 0

  val globe1 = new Globe(new Coordinate(0.05, 0.02, 0), new Coordinate(320, 200, 0), Color.RED)
  globe1.radius = 4
  globes += globe1
  
  var globe2 = new Globe(new Coordinate(0,0,0), new Coordinate(320, 220, 0), Color.BLUE)
  globe2.weight = 10000
  globe2.radius = 10
  globes += globe2

  var globe3 = new Globe(new Coordinate(0.02,0.01,0), new Coordinate(350, 200, 0), Color.BLUE)
  globe3.weight = 100000
  globe3.radius = 10
  globes += globe3
  
  var globe4 = new Globe(new Coordinate(0,0,0), new Coordinate(400, 300, 0), Color.GREEN)
  globe4.weight = 10000000
  globe4.radius = 30
  globes += globe4

  def top = new GlobePanel

  override def startup(args: Array[String]) {
    val t = top
    if (t.size == new Dimension(0, 0)) t.pack()
    t.visible = true

    val myTimer: Timer = new Timer(sleep, new java.awt.event.ActionListener {
      def actionPerformed(e: java.awt.event.ActionEvent) {
        MovementFactory.calculateNewPositions(globes)
        t.repaint()
      }
    })
    myTimer.start()
  }

  def resourceFromClassloader(path: String): java.net.URL =
    this.getClass.getResource(path)

  def resourceFromUserDirectory(path: String): java.io.File =
    new java.io.File(util.Properties.userDir, path)

}

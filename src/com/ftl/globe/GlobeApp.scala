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

object GlobeApp extends SwingApplication {
  val globes: ListBuffer[Globe] = new ListBuffer[Globe];

  val sleep =50

  globes += new Globe(new Coordinate(0.3,0.2,0), new Coordinate(1, 1, 0))
  globes += new Globe(new Coordinate(-0.1,-0.2,0), new Coordinate(800, 600, 0))
//  globes += new Globe(new Coordinate, new Coordinate(780, 1, 0))
//  globes += new Globe(new Coordinate, new Coordinate(780, 580, 0))

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

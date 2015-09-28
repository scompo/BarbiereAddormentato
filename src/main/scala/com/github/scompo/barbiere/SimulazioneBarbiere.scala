package com.github.scompo.barbiere

import scala.actors.Actor._
import scala.collection.{ immutable, mutable }
import scala.util.Random

object SimulazioneBarbiere {
  private val random = new Random()
  private val clienti = new mutable.ArrayBuffer[Cliente]()
  private val salone = new Salone()

  def creaClienti {
    for (i <- 1 to 100) {
      val cliente = new Cliente(i)
      cliente.start()
      clienti += cliente
    }

    println("[sim] generato " + clienti.size + " clienti")
  }

  def mandaClienti {

    for (cliente <- clienti) {

      salone ! cliente
      Thread.sleep(random.nextInt(450))
    }
  }

  def terminaTagli {

    Thread.sleep(5000)

    val tagliEffettuati = clienti.filter(c => c.servito).size

    println("[sim] tagliati " + tagliEffettuati + " capelli oggi")
  }

  def main(args: Array[String]): Unit = {

    println("[sim] Inizio simulazione barbiere")
    salone.start()

    creaClienti
    mandaClienti
    terminaTagli

    System.exit(0)
  }
}
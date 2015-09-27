package com.github.scompo.barbiere

import scala.actors.Actor
import scala.actors.Actor._

class Salone extends Actor {

  var barbiere = new Barbiere()
  barbiere.start

  def act() = {

    println("[s] salone aperto")

    loop {
      react {
        case cliente: Cliente => barbiere ! cliente
      }
    }
  }
}
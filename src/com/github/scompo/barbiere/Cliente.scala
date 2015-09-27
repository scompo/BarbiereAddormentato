package com.github.scompo.barbiere

import scala.actors.Actor
import scala.actors.Actor._

case object Haircut 

class Cliente(val id : Int) extends Actor{
  
  var servito = false
  
  def act() = {
    loop {
      react {
        case Haircut => {
          servito = true
          println("[c] capelli tagliati a : " + id)
        }
      }
    }
  }
}
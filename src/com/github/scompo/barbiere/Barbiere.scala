package com.github.scompo.barbiere

import scala.actors.Actor
import scala.actors.Actor._
import scala.util.Random

class Barbiere extends Actor {

  private val random = new Random()

  def tagliaCapelliCliente(cliente: Cliente) {
    
    if (this.mailboxSize >= 3){      
      
    	println("[b] troppe poche sedie, ciao " + cliente.id)
      
    }else{
      
      println("[b] tagli capelli a " + cliente.id)
      Thread.sleep(100 + random.nextInt(400));
      cliente ! Haircut
    }
  }

  def act() {
    loop {
      react {
        case cliente: Cliente => tagliaCapelliCliente(cliente)
      }
    }
  }
}
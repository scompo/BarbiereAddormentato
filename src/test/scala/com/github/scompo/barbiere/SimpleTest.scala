package com.github.scompo.barbiere

import org.junit.Test

class SimpleTest {

  @Test
  def first() {
    assert(true)
  }

  @Test
  def second() {

    val cliente: Cliente = new Cliente(1)

    cliente.start()
    
    cliente ! Haircut
    
    Thread.sleep(100);
    
    assert(cliente.servito)
  }
}
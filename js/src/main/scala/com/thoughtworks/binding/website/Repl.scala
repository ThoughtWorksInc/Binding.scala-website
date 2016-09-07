package com.thoughtworks.binding.website

import com.thoughtworks.binding.Binding.Vars
import com.thoughtworks.binding.dom

import scala.scalajs.js

import org.scalajs.dom.window
import org.scalajs.dom.raw.Event

object Repl extends Sample {

  @dom
  override def render = {
    val logs = Vars("Input code:")
    val input = <input type="text"/>
    val submitHandler = { event: Event =>
      event.preventDefault()
      logs.get += input.value
      logs.get += js.eval(input.value).toString
      input.value = ""
    }
    <form onsubmit={ submitHandler }>
      { for { log <- logs } yield <div>{ log }</div> }
      { input }
    </form>
  }

}

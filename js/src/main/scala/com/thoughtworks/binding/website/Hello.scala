package com.thoughtworks.binding.website

import com.thoughtworks.binding.dom
import com.thoughtworks.binding.Binding.Vars

object Hello extends Sample {

  override def fileName = CurrentSource.fileName

  override def content = CurrentSource.content

  @dom
  override def render = {
    val logs = Vars("Hello", "Binding.scala")
    <div>
	    { for { log <- logs } yield <div>{ log }</div> }
    </div>
  }

}

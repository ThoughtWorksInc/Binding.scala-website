package com.thoughtworks.binding.website

import com.thoughtworks.binding.dom
import org.scalajs.dom.raw.Event
import com.thoughtworks.binding.Binding.Vars

object CommandList extends Sample {

  override def fileName = CurrentSource.fileName

  override def content = CurrentSource.content

  @dom
  override def render = {
    val logs = Vars.empty[String]
    val input = <input type="text"/>
    val submitHandler = { event: Event =>
      logs.get += input.value
      event.preventDefault()
    }
    <form onsubmit={ submitHandler }>
      { for { log <- logs } yield <div>{ log }</div> }
      { input }
    </form>
  }

}

package com.thoughtworks.binding.website

import com.thoughtworks.binding.Binding
import com.thoughtworks.binding.dom

import com.thoughtworks.binding.Binding._

import com.thoughtworks.binding.Binding.Var
import com.thoughtworks.binding.Binding.Vars
import com.thoughtworks.binding.Binding.BindingSeq

import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.Node
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.html.Table
import org.scalajs.dom.html.Input

object TagEditor extends Sample {

  @dom def render() = {
    val tags = Vars("initial-tag-1", "initial-tag-2")
    <div>
      { tagPicker(tags).each }
      <h3>全部标签：</h3>
      <ol>{ for (tag <- tags) yield <li>{ tag }</li> }</ol>
    </div>
  }

  @dom def tagPicker(tags: Vars[String]) = {
    val input: Input = <input type="text"/>
    val addHandler = { event: Event =>
      if (input.value != "" && !tags.get.contains(input.value)) {
        tags.get += input.value
        input.value = ""
      }
    }
    <section>
      <div>{
        for (tag <- tags) yield <q>
          { tag }
          <button onclick={ event: Event => tags.get -= tag }>x</button>
        </q>
      }</div>
      <div>{ input } <button onclick={ addHandler }>Add</button></div>
    </section>
  }

}

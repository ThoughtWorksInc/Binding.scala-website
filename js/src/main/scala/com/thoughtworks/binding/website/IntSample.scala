package com.thoughtworks.binding.website

import com.thoughtworks.binding.Binding.{Var, Vars}
import com.thoughtworks.binding.dom
import com.thoughtworks.binding.website.TableSample.Contact
import org.scalajs.dom.raw.Event

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
object IntSample extends Sample {

  @dom
  private def intEditor(int: Var[Int]) = {
    <div>
      <button onclick={event: Event => int := int.get - 1}>-</button>
      {int.each.toString}
      <button onclick={event: Event => int := int.get + 1}>+</button>
    </div>
  }

  override def fileName = CurrentSource.fileName

  override def content = CurrentSource.content

  @dom
  override def render = {

    val i = Var(0)

    @dom
    val j = i.each + 1

    <div>
      {intEditor(i).each}
      <br/>
      {j.each.toString}
    </div>
  }
}

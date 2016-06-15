package com.thoughtworks.binding.website

import com.thoughtworks.binding.Binding.{ Var, Vars }
import com.thoughtworks.binding.dom
import com.thoughtworks.binding.website.TableSample.Contact
import org.scalajs.dom.raw.Event

/**
 * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
 */
object IntSample extends Sample {
  override def fileName = CurrentSource.fileName
  override def content = CurrentSource.content

  @dom
  def spinner(i: Var[Int]) = {
    <div>
      <button onclick={ event: Event => i := i.get - 1 }>-</button>
      { i.each.toString }
      <button onclick={ event: Event => i := i.get + 1 }>+</button>
    </div>
  }
  
  @dom
  def render = {
    val i = Var(0)
    <div>
      { spinner(i).each }
      The current value of the spinner is { i.each.toString }
    </div>
  }
  
}

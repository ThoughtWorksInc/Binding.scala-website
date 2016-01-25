package com.thoughtworks.binding.website

import com.thoughtworks.binding.Binding
import com.thoughtworks.binding.Binding.BindingSeq
import org.scalajs.dom.raw.Node

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
trait Sample {

  def render:Binding[Node]

  def fileName:String

  def content:String

}

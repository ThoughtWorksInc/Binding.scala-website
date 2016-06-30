package com.thoughtworks.binding.website

import com.thoughtworks.binding.Binding
import com.thoughtworks.binding.Binding.BindingSeq
import org.scalajs.dom.raw.Node

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
abstract class Sample(implicit val currentSource: CurrentSource) {

  def render:Binding[Node]

}

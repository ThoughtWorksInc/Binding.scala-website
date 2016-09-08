package com.thoughtworks.binding.website

import scala.language.experimental.macros

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
object CurrentSource {

  private[CurrentSource] final class MacroBundle(val c: scala.reflect.macros.whitebox.Context) {
    final def implicitCurrentSource = {
      import c.universe._
      q"new _root_.com.thoughtworks.binding.website.CurrentSource(${
        new _root_.scala.String(c.enclosingPosition.source.content)
      }, ${
        c.enclosingPosition.source.path
      })"
    }
  }
  
  implicit def implicitCurrentSource: CurrentSource = macro MacroBundle.implicitCurrentSource

}

final case class CurrentSource(content: String, fileName: String)

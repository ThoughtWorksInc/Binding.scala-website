package com.thoughtworks.binding.website

import scala.language.experimental.macros

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
object CurrentSource {

  final def content_impl(c: scala.reflect.macros.whitebox.Context) = {
    import c.universe._
    c.Expr(Literal(Constant(new String(c.enclosingPosition.source.content))))
  }

  implicit final def content: String = macro content_impl

  final def fileName_impl(c: scala.reflect.macros.whitebox.Context) = {
    import c.universe._
    c.Expr(Literal(Constant(c.enclosingPosition.source.path)))
  }

  implicit final def fileName: String = macro fileName_impl

}
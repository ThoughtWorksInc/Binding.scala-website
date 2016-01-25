package com.thoughtworks.binding.website

import com.thoughtworks.binding.Binding.{Var, Vars}
import com.thoughtworks.binding.dom
import org.scalajs.dom.document
import org.scalajs.dom.raw.Event

import scala.scalajs.js.annotation.JSExport

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
@JSExport
object SampleBrowser {


  val Samples = Seq(IntSample, TableSample)

  @dom
  def render = {
    val currentSampleIndex = Var(0)


    <section>
      <button onclick={event: Event =>
        currentSampleIndex := {
          if (currentSampleIndex.get + 1 == Samples.length) {
            0
          } else {
            currentSampleIndex.get + 1
          }
        }
      }>
        Next Sample
      </button>
      <hr/>
      {
        val sample = Samples(currentSampleIndex.each)
        <section>
          {sample.render.each}
          <hr/>
          <fieldset>
            <legend>
              {sample.fileName}
            </legend>
            <pre><code>{sample.content}</code></pre>
          </fieldset>
        </section>
      }
    </section>
  }

  @JSExport
  def main(): Unit = {
    dom.render(document.body, render)
  }

}
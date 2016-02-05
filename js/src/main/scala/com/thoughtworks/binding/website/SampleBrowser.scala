package com.thoughtworks.binding.website

import com.thoughtworks.binding.Binding.{ Var, Vars }
import com.thoughtworks.binding.dom
import org.scalajs.dom.location
import org.scalajs.dom.window
import org.scalajs.dom.document
import org.scalajs.dom.raw.{ Event, HashChangeEvent }
import scala.util._

import scala.scalajs.js.annotation.JSExport

/**
 * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
 */
@JSExport
object SampleBrowser {

  private val Samples = Seq(IntSample, TableSample)

  private def hashIndex = Try(location.hash.substring(1).toInt).getOrElse(0)

  @dom
  private def render = {
    val currentSampleIndex = Var(hashIndex)

    window.onhashchange = { event: HashChangeEvent =>
      currentSampleIndex := hashIndex
    }
    location.hash = s"#${currentSampleIndex.each.toString}"

    <section>
      <button onclick={ event: Event =>
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
          { sample.render.each }
          <hr/>
          <fieldset>
            <legend>
              { sample.fileName }
            </legend>
            <pre><code>{ sample.content }</code></pre>
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
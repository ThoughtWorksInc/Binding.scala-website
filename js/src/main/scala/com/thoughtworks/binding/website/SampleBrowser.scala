package com.thoughtworks.binding.website

import com.thoughtworks.binding.Binding.{ Var, Vars }
import com.thoughtworks.binding.dom
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

  private val Samples = Seq(
      IntSample, TableSample, DateFlowchart, TechSupportCheatSheet, TagEditor, 
      InputSample, Hello, Repl, CounterWithTime, GithubAvatar, HtmlLiteral)

  private def hashIndex = Try(window.location.hash.substring(1).toInt).getOrElse(0)

  private def nextIndex(i: Int) = {
    if (i + 1 == Samples.length) {
      0
    } else {
      i + 1
    }
  }

  @dom
  private def render = {
    val currentSampleIndex = Var(hashIndex)

    window.onhashchange = { event: HashChangeEvent =>
      currentSampleIndex := hashIndex
    }
    window.location.hash = s"#${currentSampleIndex.bind.toString}"

    val sample = Samples(currentSampleIndex.bind)

    <h1>{ sample.currentSource.fileName }</h1>
    <div>
      <button onclick={ event: Event =>
        currentSampleIndex := nextIndex(currentSampleIndex.get)
      }>
        Next Sample
      </button>
    </div>
    <table>
      <thead>
        <tr>
          <th>
            Live DEMO
          </th>
          <th>
            Source code
          </th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>{ sample.render.bind }</td>
          <td><pre><code>{ sample.currentSource.content }</code></pre></td>
        </tr>
      </tbody>
    </table>
  }

  @JSExport
  def main(): Unit = {
    dom.render(document.body, render)
  }

}
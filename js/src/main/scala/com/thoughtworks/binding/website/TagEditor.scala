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

  override def fileName = CurrentSource.fileName

  override def content = CurrentSource.content

  @dom
  override def render = {
    val tags = Vars("tag1", "tag2-from-server-side")
    <section>
      <h2>Tag Picker</h2>
      { tagPicker(tags).each }
      <hr/>
      <h2>Tag Preview</h2>
      { tagPreview(tags).each }
      <div>
        See
        <a href="https://github.com/ThoughtWorksInc/Binding.scala-website/blob/master/js/src/test/scala/com/thoughtworks/binding/website/TagEditorTestSuite.scala">
          TagEditorTestSuite.scala
        </a>
        for test cases for the <code>tagPicker</code> method in this example.
      </div>
    </section>
  }

  @dom
  def tagPreview(tags: BindingSeq[String]) = {
    <ol>
      {
        for {
          tag <- tags
        } yield <li>{ tag }</li>
      }
    </ol>

  }

  @dom
  def tagPicker(tags: Vars[String]) = {
    val input: Input = <input type="text"/>;
    <section>
      <div>
        {
          for (tag <- tags) yield {
            <q className="tag">
              { tag }
              <button onclick={ event: Event =>
                tags.get -= tag
              }>x</button>
            </q>
          }
        }
      </div>
      { input }
      <button onclick={ event: Event =>
        if (input.value != "" && !tags.get.contains(input.value)) {
          tags.get += input.value
          input.value = ""
        }
      }>Add</button>
    </section>
  }

}

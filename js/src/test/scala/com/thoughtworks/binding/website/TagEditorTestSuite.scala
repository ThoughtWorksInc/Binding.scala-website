package com.thoughtworks.binding.website

import utest._
import org.scalajs.dom.document
import com.thoughtworks.binding.dom
import com.thoughtworks.binding.Binding.Vars
import org.scalajs.dom.html.Quote
import org.scalajs.dom.html.Button

object TagEditorTestSuite extends TestSuite {
  val tests = TestSuite {

    "The initial DOM should be rendered for a tagPicker" - {
      val tags = Vars("tag0", "tag1")
      dom.render(document.body, TagEditor.tagPicker(tags))

      assert(tags.get.length == 2)
      assert(document.getElementsByTagName("q").length == 2)
      assert(document.body.childNodes.length == 1)
      "when the delect button of the first tag is clicked" - {
        val xButtons = document.getElementsByTagName("q")(0).asInstanceOf[Quote].getElementsByTagName("button")
        assert(xButtons.length == 1)
        xButtons(0).asInstanceOf[Button].onclick(null)
        val tag1 = document.getElementsByTagName("q")(0).asInstanceOf[Quote]

        "number of tags should be decreased " - {
          assert(document.getElementsByTagName("q").length == 1)
          assert(tags.get.length == 1)
        }

        "the first tag should be changed" - {
          val tag1Text = tag1.textContent
          assert(tag1Text.trim.startsWith("tag1"))
        }
        
        "when a data item is appended" - {
          tags.get += "tag2"

          "tags should be updated" - {
            assert(tags.get.length == 2)
            assert(tags.get(0) == "tag1")
            assert(tags.get(1) == "tag2")
            assert(document.getElementsByTagName("q").length == 2)

          }

          "when a data item is prepended" - {
            "tag3" +=: tags.get

            "tags should be updated" - {

              assert(tags.get.length == 3)
              assert(tags.get(0) == "tag3")
              assert(tags.get(1) == "tag1")
              assert(tags.get(2) == "tag2")
              assert(document.getElementsByTagName("q").length == 3)
            }

            "the HTML element for the second tag should be the original HTML element for the first tag" - {
              assert(document.getElementsByTagName("q")(1) == tag1)
            }
          }
        }
      }
    }
  }
}
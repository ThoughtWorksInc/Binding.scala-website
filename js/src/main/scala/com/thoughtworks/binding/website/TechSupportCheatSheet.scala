package com.thoughtworks.binding.website

import com.thoughtworks.binding.Binding
import com.thoughtworks.binding.Binding.{ Constants, Var, Vars, BindingSeq }
import com.thoughtworks.binding.dom
import com.thoughtworks.binding.website.TableSample.Contact
import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.Node
import org.scalajs.dom.html.Element
import org.scalajs.dom.html.Input

/**
 * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
 */
object TechSupportCheatSheet extends Sample {

  @dom override def render = {
    <section>
      <h1>Tech Support Cheat Sheet</h1>
      <p>See <a href="https://xkcd.com/627/">xkcd: Tech Support Cheat Sheet</a> about how to use this flowchart.</p>
      {
        val checked = Var(false)
        <section>
          {
            check(checked, "START").bind
          }
          {
            if (checked.bind) {
              findButton.bind
            } else {
              <p>(Check the box to continue)</p>
            }

          }
        </section>
      }
    </section>
  }

  @dom private def findButton: Binding[Element] = {
    val answer = Var[Option[String]](None)
    <section>
      {
        choice(answer, "FIND A MENU ITEM OR BUTTON WHICH LOOKS RELATED TO WHAT YOU WANT TO DO.", "OK", "I CAN'T FIND ONE").bind
      }
      {
        answer.bind match {
          case Some("OK") =>
            clickIt.bind
          case Some("I CAN'T FIND ONE") =>
            val answer = Var[Option[String]](None)
            <section>
              {
                choice(answer, "PICK ONE AT RANDOM", "I'VE TRIED THEM ALL.", "NO").bind
              }
              {
                answer.bind match {
                  case Some("I'VE TRIED THEM ALL.") =>

                    val checked = Var(false)
                    <section>
                      {
                        check(checked, "GOOGLE THE NAME OF THE PROGRAM PLUS A FEW WORDS RELATED TO WHAT YOU WANT TO DO. FOLLOW ANY INSTRUCTIONS.").bind
                      }
                      {
                        if (checked.bind) {
                          didItWork.bind
                        } else {
                          <p>(Check the box to continue)</p>
                        }
                      }
                    </section>
                  case Some("NO") =>
                    clickIt.bind
                  case _ =>
                    <p>(Choose a branch)</p>
                }
              }
            </section>
          case _ =>
            <p>(Choose a branch)</p>
        }
      }
    </section>
  }

  @dom private def clickIt: Binding[Element] = {
    val checked = Var(false)
    <section>
      {
        check(checked, "CLICK IT.").bind
      }
      {
        if (checked.bind) {
          didItWork.bind
        } else {
          <p>(Check the box to continue)</p>
        }
      }
    </section>
  }

  @dom private def didItWork: Binding[Element] = {
    val answer = Var[Option[String]](None)
    <section>
      {
        choice(answer, "DID IT WORK?", "YES", "NO").bind
      }
      {
        answer.bind match {
          case Some("YES") =>
            <p>YOU'RE DONE!</p>
          case Some("NO") =>
            val answer = Var[Option[String]](None)
            <section>
              {
                choice(answer, "HAVE YOU BEEN TRYING THIS FOR OVER HALF AN HOUR?", "YES", "NO").bind
              }
              {
                answer.bind match {
                  case Some("YES") =>
                    <p>ASK SOMEONE FOR HELP OR GIVE UP.</p>
                  case Some("NO") =>
                    findButton.bind
                  case _ =>
                    <p>(Choose a branch)</p>
                }
              }
            </section>
          case _ =>
            <p>(Choose a branch)</p>
        }
      }
    </section>
  }

  @dom private def check(checked: Var[Boolean], label: String): Binding[BindingSeq[Node]] = {
    val id = System.currentTimeMillis
    <input type="checkbox" id={ s"$label/$id" } name={ s"$label/$id" } onclick={ event: Event => checked := event.currentTarget.asInstanceOf[Input].checked }/>
    <label htmlFor={ s"$label/$id" }>{ label }</label>
  }

  @dom private def choice(answer: Var[Option[String]], question: String, options: String*): Binding[BindingSeq[Node]] = {
    val id = System.currentTimeMillis
    <p>{ question }</p>
    <ul>
      {
        for {
          option <- Constants(options: _*)
        } yield {
          <li>
            <input type="radio" name={ s"$question/$id" } id={ s"$question/$option/$id" } onclick={ event: Event => answer := Some(option) }/>
            <label htmlFor={ s"$question/$option/$id" }>{ option }</label>
          </li>
        }
      }
    </ul>
  }
  
}

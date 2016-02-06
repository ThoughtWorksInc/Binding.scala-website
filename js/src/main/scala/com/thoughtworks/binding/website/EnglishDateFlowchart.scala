package com.thoughtworks.binding.website

import com.thoughtworks.binding.Binding
import com.thoughtworks.binding.Binding.{ Var, Vars }
import com.thoughtworks.binding.dom
import com.thoughtworks.binding.website.TableSample.Contact
import org.scalajs.dom.raw.Event
import org.scalajs.dom.html.Element
import org.scalajs.dom.html.Input

/**
 * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
 */
object EnglishDateFlowchart extends Sample {

  override def fileName = CurrentSource.fileName

  override def content = CurrentSource.content

  @dom override def render = {
    <section>
      <h1>A Flowchart to Determine If You're Going to Have Sex on this Date</h1>
      {
        val answer = Var[Option[Boolean]](None)
        <section>
          <p>Is This a First Date?</p>
          <ul>
            <li>
              <input type="radio" name="Is This a First Date?" id="Is This a First Date? YES" onclick={ event: Event => answer := Some(true) }/>
              <label htmlFor="Is This a First Date? YES">YES</label>
            </li>
            <li>
              <input type="radio" name="Is This a First Date?" id="Is This a First Date? NO" onclick={ event: Event => answer := Some(false) }/>
              <label htmlFor="Is This a First Date? NO">NO</label>
            </li>
          </ul>
          {
            answer.each match {
              case None =>
                <p>(Choose a branch)</p>
              case Some(true) =>
                val answer = Var[Option[Boolean]](None)
                <section>
                  <p>Are you Incredibly Rich?</p>
                  <ul>
                    <li>
                      <input type="radio" name="Are you Incredibly Rich?" id="Are you Incredibly Rich? YES" onclick={ event: Event => answer := Some(true) }/>
                      <label htmlFor="Are you Incredibly Rich? YES">YES</label>
                    </li>
                    <li>
                      <input type="radio" name="Are you Incredibly Rich?" id="Are you Incredibly Rich? NO" onclick={ event: Event => answer := Some(false) }/>
                      <label htmlFor="Are you Incredibly Rich? NO">NO</label>
                    </li>
                  </ul>
                  {
                    answer.each match {
                      case None =>
                        <p>(Choose a branch)</p>
                      case Some(true) =>
                        sex.each
                      case Some(false) =>
                        val answer = Var[Option[Boolean]](None)
                        <section>
                          <p>Are you Incredibly Good Looking?</p>
                          <ul>
                            <li>
                              <input type="radio" name="Are you Incredibly Good Looking?" id="Are you Incredibly Good Looking? YES" onclick={ event: Event => answer := Some(true) }/>
                              <label htmlFor="Are you Incredibly Good Looking? YES">YES</label>
                            </li>
                            <li>
                              <input type="radio" name="Are you Incredibly Good Looking?" id="Are you Incredibly Good Looking? NO" onclick={ event: Event => answer := Some(false) }/>
                              <label htmlFor="Are you Incredibly Good Looking? NO">NO</label>
                            </li>
                          </ul>
                          {
                            answer.each match {
                              case None =>
                                <p>(Choose a branch)</p>
                              case Some(true) =>
                                sex.each
                              case Some(false) =>
                                buyDrinks(0).each
                            }
                          }
                        </section>
                    }
                  }
                </section>
              case Some(false) =>
                val answer = Var[Option[String]](None)
                <section>
                  <p>Where Are You Going on the Date?</p>
                  <ul>
                    <li>
                      <input type="radio" name="Where Are You Going on the Date?" id="Party" onclick={ event: Event => answer := Some("Party") }/>
                      <label htmlFor="Party">Party</label>
                    </li>
                    <li>
                      <input type="radio" name="Where Are You Going on the Date?" id="Dinner &#38; A Movie" onclick={ event: Event => answer := Some("Dinner & A Movie") }/>
                      <label htmlFor="Dinner &#38; A Movie">Dinner &#38; A Movie</label>
                    </li>
                    <li>
                      <input type="radio" name="Where Are You Going on the Date?" id="Prom" onclick={ event: Event => answer := Some("Prom") }/>
                      <label htmlFor="Prom">Prom</label>
                    </li>
                  </ul>
                  {
                    answer.each match {
                      case None =>
                        <p>(Choose a branch)</p>
                      case Some("Party") =>
                        val answer = Var[Option[Boolean]](None)
                        <section>
                          <p>Is She Dressed Slutty?</p>
                          <ul>
                            <li>
                              <input type="radio" name="Is She Dressed Slutty?" id="Is She Dressed Slutty? YES" onclick={ event: Event => answer := Some(true) }/>
                              <label htmlFor="Is She Dressed Slutty? YES">YES</label>
                            </li>
                            <li>
                              <input type="radio" name="Is She Dressed Slutty?" id="Is She Dressed Slutty? NO" onclick={ event: Event => answer := Some(false) }/>
                              <label htmlFor="Is She Dressed Slutty? NO">NO</label>
                            </li>
                          </ul>
                          {
                            answer.each match {
                              case None =>
                                <p>(Choose a branch)</p>
                              case Some(true) =>
                                val answer = Var[Option[Boolean]](None)
                                <section>
                                  <p>Is She Dancing With You?</p>
                                  <ul>
                                    <li>
                                      <input type="radio" name="Is She Dancing With You?" id="Is She Dancing With You? YES" onclick={ event: Event => answer := Some(true) }/>
                                      <label htmlFor="Is She Dancing With You? YES">YES</label>
                                    </li>
                                    <li>
                                      <input type="radio" name="Is She Dancing With You?" id="Is She Dancing With You? No, with someone else" onclick={ event: Event => answer := Some(false) }/>
                                      <label htmlFor="Is She Dancing With You? No, with someone else">No, with someone else</label>
                                    </li>
                                  </ul>
                                  {
                                    answer.each match {
                                      case None =>
                                        <p>(Choose a branch)</p>
                                      case Some(true) =>
                                        isDrunk(0).each
                                      case Some(false) =>
                                        noSex.each
                                    }
                                  }
                                </section>
                              case Some(false) =>
                                buyDrinks(0).each
                            }
                          }
                        </section>
                      case Some("Dinner & A Movie") =>
                        val answer = Var[Option[Boolean]](None)
                        <section>
                          <p>Are You Seeing a Sad Movie?</p>
                          <ul>
                            <li>
                              <input type="radio" name="Are You Seeing a Sad Movie?" id="Are You Seeing a Sad Movie? YES" onclick={ event: Event => answer := Some(true) }/>
                              <label htmlFor="Are You Seeing a Sad Movie? YES">YES</label>
                            </li>
                            <li>
                              <input type="radio" name="Are You Seeing a Sad Movie?" id="Are You Seeing a Sad Movie? NO" onclick={ event: Event => answer := Some(false) }/>
                              <label htmlFor="Are You Seeing a Sad Movie? NO">NO</label>
                            </li>
                          </ul>
                          {
                            answer.each match {
                              case None =>
                                <p>(Choose a branch)</p>
                              case Some(true) =>
                                noSex.each
                              case Some(false) =>
                                val answer = Var[Option[Boolean]](None)
                                <section>
                                  <p>Was the Dinner Expensive?</p>
                                  <ul>
                                    <li>
                                      <input type="radio" name="Was the Dinner Expensive?" id="Was the Dinner Expensive? YES" onclick={ event: Event => answer := Some(true) }/>
                                      <label htmlFor="Was the Dinner Expensive? YES">YES</label>
                                    </li>
                                    <li>
                                      <input type="radio" name="Was the Dinner Expensive?" id="Was the Dinner Expensive? NO" onclick={ event: Event => answer := Some(false) }/>
                                      <label htmlFor="Was the Dinner Expensive? NO">NO</label>
                                    </li>
                                  </ul>
                                  {
                                    answer.each match {
                                      case None =>
                                        <p>(Choose a branch)</p>
                                      case Some(true) =>
                                        soberEnough.each
                                      case Some(false) =>
                                        noSex.each
                                    }
                                  }
                                </section>
                            }
                          }
                        </section>
                      case Some("Prom") =>
                        sex.each
                    }
                  }
                </section>
            }
          }
        </section>
      }
    </section>
  }

  @dom private def buyDrinks(numberOfCupsOfDrinks: Int): Binding[Element] = {
    val checked = Var(false)
    <section>
      <input type="checkbox" id={ s"Buy Her Some Drinks.$numberOfCupsOfDrinks" } name="Buy Her Some Drinks." onclick={ event: Event => checked := event.currentTarget.asInstanceOf[Input].checked }/>
      <label htmlFor={ s"Buy Her Some Drinks.$numberOfCupsOfDrinks" }>Buy Her Some Drinks.</label>
      {
        if (checked.each) {
          isDrunk(numberOfCupsOfDrinks).each
        } else {
          <p>(Choose a branch)</p>
        }
      }
    </section>
  }

  @dom private def isDrunk(numberOfCupsOfDrinks: Int): Binding[Element] = {
    val answer = Var[Option[Boolean]](None)
    <section>
      <p>Is She Drunk?</p>
      <ul>
        <li>
          <input type="radio" name={ s"Is She Drunk? $numberOfCupsOfDrinks" } id={ s"Is She Drunk? YES $numberOfCupsOfDrinks" } onclick={ event: Event => answer := Some(true) }/>
          <label htmlFor={ s"Is She Drunk? YES $numberOfCupsOfDrinks" }>YES</label>
        </li>
        <li>
          <input type="radio" name={ s"Is She Drunk? $numberOfCupsOfDrinks" } id={ s"Is She Drunk? NO $numberOfCupsOfDrinks" } onclick={ event: Event => answer := Some(false) }/>
          <label htmlFor={ s"Is She Drunk? NO $numberOfCupsOfDrinks" }>NO</label>
        </li>
      </ul>
      {
        answer.each match {
          case None =>
            <p>(Choose a branch)</p>
          case Some(true) =>
            soberEnough.each
          case Some(false) =>
            buyDrinks(numberOfCupsOfDrinks + 1).each
        }
      }
    </section>
  }

  @dom private def soberEnough = {
    val answer = Var[Option[Boolean]](None)
    <section>
      <p>Is She Still Sober Enough to Stand Up?</p>
      <ul>
        <li>
          <input type="radio" name="Is She Still Sober Enough to Stand Up?" id="Is She Still Sober Enough to Stand Up? YES" onclick={ event: Event => answer := Some(true) }/>
          <label htmlFor="Is She Still Sober Enough to Stand Up? YES">YES</label>
        </li>
        <li>
          <input type="radio" name="Is She Still Sober Enough to Stand Up?" id="Is She Still Sober Enough to Stand Up? NO" onclick={ event: Event => answer := Some(false) }/>
          <label htmlFor="Is She Still Sober Enough to Stand Up? NO">NO</label>
        </li>
      </ul>
      {
        answer.each match {
          case None =>
            <p>(Choose a branch)</p>
          case Some(true) =>
            sex.each
          case Some(false) =>
            noSex.each
        }
      }
    </section>
  }

  @dom private def noSex = <p>You Are Not Having Sex Tonight</p>

  @dom private def sex = <p>You Are Definitely Having Sex</p>

}
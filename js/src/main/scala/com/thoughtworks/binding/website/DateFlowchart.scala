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
object DateFlowchart extends Sample {

  @dom override def render = {
    <section>
      <h1>约会后是否会啪啪啪的流程图</h1>
      <div>本 DEMO 问题描述，详见<a href="https://www.zhihu.com/question/29273443/answer/85078003">函数式语言开发GUI是不是自虐?</a></div>
      {
        val answer = Var[Option[Boolean]](None)
        <section>
          <p>是第一次约会吗？</p>
          <ul>
            <li>
              <input type="radio" name="是第一次约会吗？" id="是第一次约会吗？是" onclick={ event: Event => answer := Some(true) }/>
              <label htmlFor="是第一次约会吗？是">是</label>
            </li>
            <li>
              <input type="radio" name="是第一次约会吗？" id="是第一次约会吗？否" onclick={ event: Event => answer := Some(false) }/>
              <label htmlFor="是第一次约会吗？否">否</label>
            </li>
          </ul>
          {
            answer.bind match {
              case None =>
                <p>（请选择分支）</p>
              case Some(true) =>
                val answer = Var[Option[Boolean]](None)
                <section>
                  <p>你富可敌国？</p>
                  <ul>
                    <li>
                      <input type="radio" name="你富可敌国？" id="你富可敌国？是" onclick={ event: Event => answer := Some(true) }/>
                      <label htmlFor="你富可敌国？是">是</label>
                    </li>
                    <li>
                      <input type="radio" name="你富可敌国？" id="你富可敌国？否" onclick={ event: Event => answer := Some(false) }/>
                      <label htmlFor="你富可敌国？否">否</label>
                    </li>
                  </ul>
                  {
                    answer.bind match {
                      case None =>
                        <p>（请选择分支）</p>
                      case Some(true) =>
                        sex.bind
                      case Some(false) =>
                        val answer = Var[Option[Boolean]](None)
                        <section>
                          <p>你貌比潘安？</p>
                          <ul>
                            <li>
                              <input type="radio" name="你貌比潘安？" id="你貌比潘安？是" onclick={ event: Event => answer := Some(true) }/>
                              <label htmlFor="你貌比潘安？是">是</label>
                            </li>
                            <li>
                              <input type="radio" name="你貌比潘安？" id="你貌比潘安？否" onclick={ event: Event => answer := Some(false) }/>
                              <label htmlFor="你貌比潘安？否">否</label>
                            </li>
                          </ul>
                          {
                            answer.bind match {
                              case None =>
                                <p>（请选择分支）</p>
                              case Some(true) =>
                                sex.bind
                              case Some(false) =>
                                buyDrinks(0).bind
                            }
                          }
                        </section>
                    }
                  }
                </section>
              case Some(false) =>
                val answer = Var[Option[String]](None)
                <section>
                  <p>在哪儿约的会？</p>
                  <ul>
                    <li>
                      <input type="radio" name="在哪儿约的会？" id="聚会" onclick={ event: Event => answer := Some("聚会") }/>
                      <label htmlFor="聚会">聚会</label>
                    </li>
                    <li>
                      <input type="radio" name="在哪儿约的会？" id="晚餐+电影" onclick={ event: Event => answer := Some("晚餐+电影") }/>
                      <label htmlFor="晚餐+电影">晚餐+电影</label>
                    </li>
                    <li>
                      <input type="radio" name="在哪儿约的会？" id="学校舞会" onclick={ event: Event => answer := Some("学校舞会") }/>
                      <label htmlFor="学校舞会">学校舞会</label>
                    </li>
                  </ul>
                  {
                    answer.bind match {
                      case Some("聚会") =>
                        val answer = Var[Option[Boolean]](None)
                        <section>
                          <p>她的衣着清凉否？</p>
                          <ul>
                            <li>
                              <input type="radio" name="她的衣着清凉否？" id="她的衣着清凉否？是" onclick={ event: Event => answer := Some(true) }/>
                              <label htmlFor="她的衣着清凉否？是">是</label>
                            </li>
                            <li>
                              <input type="radio" name="她的衣着清凉否？" id="她的衣着清凉否？否" onclick={ event: Event => answer := Some(false) }/>
                              <label htmlFor="她的衣着清凉否？否">否</label>
                            </li>
                          </ul>
                          {
                            answer.bind match {
                              case None =>
                                <p>（请选择分支）</p>
                              case Some(true) =>
                                val answer = Var[Option[Boolean]](None)
                                <section>
                                  <p>她跟你跳舞了？</p>
                                  <ul>
                                    <li>
                                      <input type="radio" name="她跟你跳舞了？" id="她跟你跳舞了？是" onclick={ event: Event => answer := Some(true) }/>
                                      <label htmlFor="她跟你跳舞了？是">是</label>
                                    </li>
                                    <li>
                                      <input type="radio" name="她跟你跳舞了？" id="她跟你跳舞了？没，跟别人跳了" onclick={ event: Event => answer := Some(false) }/>
                                      <label htmlFor="她跟你跳舞了？没，跟别人跳了">没，跟别人跳了</label>
                                    </li>
                                  </ul>
                                  {
                                    answer.bind match {
                                      case None =>
                                        <p>（请选择分支）</p>
                                      case Some(true) =>
                                        isDrunk(0).bind
                                      case Some(false) =>
                                        noSex.bind
                                    }
                                  }
                                </section>
                              case Some(false) =>
                                buyDrinks(0).bind
                            }
                          }
                        </section>
                      case Some("晚餐+电影") =>
                        val answer = Var[Option[Boolean]](None)
                        <section>
                          <p>看了部悲情片？</p>
                          <ul>
                            <li>
                              <input type="radio" name="看了部悲情片？" id="看了部悲情片？是" onclick={ event: Event => answer := Some(true) }/>
                              <label htmlFor="看了部悲情片？是">是</label>
                            </li>
                            <li>
                              <input type="radio" name="看了部悲情片？" id="看了部悲情片？否" onclick={ event: Event => answer := Some(false) }/>
                              <label htmlFor="看了部悲情片？否">否</label>
                            </li>
                          </ul>
                          {
                            answer.bind match {
                              case None =>
                                <p>（请选择分支）</p>
                              case Some(true) =>
                                noSex.bind
                              case Some(false) =>
                                val answer = Var[Option[Boolean]](None)
                                <section>
                                  <p>晚饭贵不？</p>
                                  <ul>
                                    <li>
                                      <input type="radio" name="晚饭贵不？" id="晚饭贵不？是" onclick={ event: Event => answer := Some(true) }/>
                                      <label htmlFor="晚饭贵不？是">是</label>
                                    </li>
                                    <li>
                                      <input type="radio" name="晚饭贵不？" id="晚饭贵不？否" onclick={ event: Event => answer := Some(false) }/>
                                      <label htmlFor="晚饭贵不？否">否</label>
                                    </li>
                                  </ul>
                                  {
                                    answer.bind match {
                                      case None =>
                                        <p>（请选择分支）</p>
                                      case Some(true) =>
                                        soberEnough.bind
                                      case Some(false) =>
                                        noSex.bind
                                    }
                                  }
                                </section>
                            }
                          }
                        </section>
                      case Some("学校舞会") =>
                        sex.bind
                      case _ =>
                        <p>（请选择分支）</p>
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
      <input type="checkbox" id={ s"给她买点酒喝啦$numberOfCupsOfDrinks" } name="给她买点酒喝啦" onclick={ event: Event => checked := event.currentTarget.asInstanceOf[Input].checked }/>
      <label htmlFor={ s"给她买点酒喝啦$numberOfCupsOfDrinks" }>给她买点酒喝啦</label>
      {
        if (checked.bind) {
          isDrunk(numberOfCupsOfDrinks).bind
        } else {
          <p>（请选择分支）</p>
        }
      }
    </section>
  }

  @dom private def isDrunk(numberOfCupsOfDrinks: Int): Binding[Element] = {
    val answer = Var[Option[Boolean]](None)
    <section>
      <p>她已经喝醉了？</p>
      <ul>
        <li>
          <input type="radio" name={ s"她已经喝醉了？$numberOfCupsOfDrinks" } id={ s"她已经喝醉了？是$numberOfCupsOfDrinks" } onclick={ event: Event => answer := Some(true) }/>
          <label htmlFor={ s"她已经喝醉了？是$numberOfCupsOfDrinks" }>是</label>
        </li>
        <li>
          <input type="radio" name={ s"她已经喝醉了？$numberOfCupsOfDrinks" } id={ s"她已经喝醉了？否$numberOfCupsOfDrinks" } onclick={ event: Event => answer := Some(false) }/>
          <label htmlFor={ s"她已经喝醉了？否$numberOfCupsOfDrinks" }>否</label>
        </li>
      </ul>
      {
        answer.bind match {
          case None =>
            <p>（请选择分支）</p>
          case Some(true) =>
            soberEnough.bind
          case Some(false) =>
            buyDrinks(numberOfCupsOfDrinks + 1).bind
        }
      }
    </section>
  }

  @dom private def soberEnough = {
    val answer = Var[Option[Boolean]](None)
    <section>
      <p>她还没醉得不省人事吧？</p>
      <ul>
        <li>
          <input type="radio" name="她还没醉得不省人事吧？" id="她还没醉得不省人事吧？是" onclick={ event: Event => answer := Some(true) }/>
          <label htmlFor="她还没醉得不省人事吧？是">是</label>
        </li>
        <li>
          <input type="radio" name="她还没醉得不省人事吧？" id="她还没醉得不省人事吧？否" onclick={ event: Event => answer := Some(false) }/>
          <label htmlFor="她还没醉得不省人事吧？否">否</label>
        </li>
      </ul>
      {
        answer.bind match {
          case None =>
            <p>（请选择分支）</p>
          case Some(true) =>
            sex.bind
          case Some(false) =>
            noSex.bind
        }
      }
    </section>
  }

  @dom private def noSex = <p>你今晚想滚床单是没戏了</p>

  @dom private def sex = <p>你小子的性福来了</p>

}
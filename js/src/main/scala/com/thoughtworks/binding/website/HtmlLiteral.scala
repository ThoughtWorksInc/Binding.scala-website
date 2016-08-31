package com.thoughtworks.binding.website

import com.thoughtworks.binding.dom
import java.util.Date
import com.thoughtworks.binding.Binding.Var
import com.thoughtworks.binding.Binding
import scala.scalajs.js.timers.setInterval
import org.scalajs.dom.raw.HTMLButtonElement

object HtmlLiteral extends Sample {

  @dom def introductionDiv = {
    <div style="font-size:0.8em">
      <h3>Binding.scala的优点</h3>
      <ul>
        <li>简单</li>
        <li>概念少<br/>功能多</li>
      </ul>
    </div>
  }

  @dom def typedButton: Binding[HTMLButtonElement] = {
    <button>按钮</button>
  }

  @dom def comment = {
    <!-- 你看不见我 -->
  }
  
  @dom def inlineStyle = {
    <section>
      <style><![CDATA[
        .highlight {
          background-color:gold
        }
      ]]></style>
      <p class="highlight">Binding.scala真好用！</p>
    </section>
  }

  @dom def randomParagraph = {
    <p>生成一个随机数： { math.random.toString }</p>
  }

  @dom def myCustomDiv = {
    <div data:customAttributeName="attributeValue"></div>
  }

  val now = Var(new Date)
  setInterval(1000) { now := new Date }
  
  @dom def render = {
    <div>
      现在时间：{ now.bind.toString }
      { introductionDiv.bind }
      { inlineStyle.bind }
      { typedButton.bind }
      { comment.bind }
      { randomParagraph.bind }
      { myCustomDiv.bind }
    </div>
  }

  @dom val autoPrintln: Binding[Unit] = {
    println(render.bind.innerHTML) // 在控制台中打印页面 HTML
  }
  autoPrintln.watch()
  
}

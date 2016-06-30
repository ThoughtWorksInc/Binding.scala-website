package com.thoughtworks.binding.website

import com.thoughtworks.binding.Binding.Var
import com.thoughtworks.binding.Binding
import java.util.Date
import com.thoughtworks.binding.dom
import org.scalajs.dom.raw.Event

object CounterWithTime extends Sample {

  

  

  val count = Var(0)

  @dom def status: Binding[String] = {
    val startTime = new Date
    "本页面初始化的时间是" + startTime.toString + "。按钮被按过" + count.each.toString + "次。按钮最后一次按下的时间是" + (new Date).toString
  }

  @dom def render = {
    <div>
      { status.each }
      <button onclick={ event: Event => count := count.get + 1 }>更新状态</button>
    </div>
  }

}

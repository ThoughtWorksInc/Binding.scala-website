package com.thoughtworks.binding.website

import com.thoughtworks.binding.dom
import com.thoughtworks.binding.Binding.{ FutureBinding, Var }

import org.scalajs.dom.raw.Event
import org.scalajs.dom.html.Input
import org.scalajs.dom.ext.Ajax

import scala.scalajs.js.JSON
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.util.{ Failure, Success }

object GithubAvatar extends Sample {

  @dom def render = {
    val githubUserName = Var("")
    def inputHandler = { event: Event => githubUserName := event.currentTarget.asInstanceOf[Input].value }
    <div>
      <input type="text" oninput={ inputHandler }/>
      <hr/>
      {
        val name = githubUserName.bind
        if (name == "") {                                                                     // 如果用户名为空：
          <div>Please input your Github user name</div>                                       // 显示提示文字；
        } else {                                                                              // 如果用户名非空：
          val githubResult = FutureBinding(Ajax.get(s"https://api.github.com/users/${name}")) // 发起 Github API 请求，
          githubResult.bind match {                                                           // 并根据 API 结果显示不同的内容：
            case None =>                                                                      // 如果尚未加载完毕：
              <div>Loading the avatar for { name }</div>                                      // 显示提示信息；
            case Some(Success(response)) =>                                                   // 如果成功加载：
              val json = JSON.parse(response.responseText)                                    // 把回应解析成 JSON；
              <img src={ json.avatar_url.toString }/>                                         // 并显示头像；
            case Some(Failure(exception)) =>                                                  // 如果加载时出错，
              <div>{ exception.toString }</div>                                               // 显示错误信息。
          }
        }
      }
    </div>
  }

}

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
        val name = githubUserName.each
        if (name == "") {
          <div>Please input your Github user name</div>
        } else {
          val githubResult = FutureBinding(Ajax.get(s"https://api.github.com/users/${name}"))
          githubResult.each match {
            case None =>
              <div>Loading the avatar for { name }</div>
            case Some(Success(response)) =>
              val json = JSON.parse(response.responseText)
              <img src={ json.avatar_url.toString }/>
            case Some(Failure(exception)) =>
              <div>{ exception.toString }</div>
          }
        }
      }
    </div>
  }

}

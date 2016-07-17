package com.thoughtworks.binding.website

import com.thoughtworks.binding.Binding.{Vars, Var}
import com.thoughtworks.binding.dom
import org.scalajs.dom.raw.Event

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
object TableSample extends Sample {

  case class Contact(name: Var[String], email: Var[String])

  @dom
  override def render = {

    val data = Vars.empty[Contact]

    <section>
      <div>
        <button
        onclick={event: Event =>
          data.get += Contact(Var("Yang Bo"), Var("yang.bo@rea-group.com"))}>
          Add a contact
        </button>
      </div>
      <table border="1" cellPadding="5">
        <thead>
          <tr>
            <th>Name</th>
            <th>E-mail</th>
            <th>Operation</th>
          </tr>
        </thead>
        <tbody>
          {for (contact <- data) yield {
          <tr>
            <td>
              {contact.name.bind}
            </td>
            <td>
              {contact.email.bind}
            </td>
            <td>
              <button
              onclick={event: Event =>
                contact.name := "Modified Name"}>
                Modify the name
              </button>
            </td>
          </tr>
        }}
        </tbody>
      </table>
    </section>
  }
}

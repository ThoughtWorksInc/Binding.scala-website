import au.com.realcommercial.binding.Binding.{Var, Vars}
import au.com.realcommercial.binding.dom
import org.scalajs.dom.document
import org.scalajs.dom.raw.Event

import scala.scalajs.js.annotation.JSExport

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
@JSExport
object SampleMain {

  case class Contact(name: Var[String], email: Var[String])

  val data = Vars.empty[Contact]

  @dom
  def table = {
    <div>
      <button
        onclick={ event: Event =>
          data.get += Contact(Var("Yang Bo"), Var("yang.bo@rea-group.com"))
        }
      >
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
        {
          for (contact <- data) yield {
            <tr>
              <td>
                {contact.name.each}
              </td>
              <td>
                {contact.email.each}
              </td>
              <td>
                <button
                  onclick={ event: Event =>
                    contact.name := "Modified Name"
                  }
                >
                  Modify the name
                </button>
              </td>
            </tr>
          }
        }
      </tbody>
    </table>
  }

  @JSExport
  def main(): Unit = {
    dom.render(document.body, table)
  }

}
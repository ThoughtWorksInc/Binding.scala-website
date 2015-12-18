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

  case class Log(name: Var[String], email: Var[String])

  val data = Vars.empty[Log]

  @dom def table = {
    <div>
      <button
        onclick={ event: Event =>
          data.get += Log(Var("Yang Bo"), Var("yang.bo@rea-group.com"))
        }
      >
        Add a contact
      </button>
      <button
        onclick={ event: Event =>
          data.get.last.name := "Modified Name"
        }
      >
        Modify the last contact
      </button>
    </div>
    <table border="1">
      <thead>
        <tr>
          <th>Name</th>
          <th>E-mail</th>
        </tr>
      </thead>
      <tbody>
        {for (contact <- data) yield {
        <tr>
          <td>
            {contact.name.each}
          </td>
          <td>
            {contact.email.each}
          </td>
        </tr>
      }}
      </tbody>
    </table>
  }

  @JSExport
  def main(): Unit = {
    dom.render(document.body, table)
  }

}
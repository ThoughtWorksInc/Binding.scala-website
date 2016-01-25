site.settings

ghpages.settings

git.remoteRepo := "git@github.com:ThoughtWorksInc/Binding.scala.git"

val `macro` = project

val js = project dependsOn `macro`

scalaVersion in ThisBuild := "2.11.7"

import com.typesafe.sbt.SbtSite.SiteKeys

SiteKeys.siteMappings ++= {
  val jsFile = (fastOptJS in js in Compile).value.data
  val indexHtml = crossTarget.value / "index.html"
  IO.writeLines(
    indexHtml,
    Seq(
      "<!DOCTYPE html>",
      xml.Xhtml.toXhtml(<html>
        <head>
          <script type="text/javascript" src={jsFile.getName}></script>
        </head>
        <body>
          <script type="text/javascript">
            com.thoughtworks.binding.website.SampleBrowser().main()
          </script>
        </body>
      </html>)))
  Seq(jsFile -> jsFile.getName, indexHtml -> "index.html")
}

enablePlugins(ScalaJSPlugin)

resolvers += "releases" at "http://nexus.delivery.realestate.com.au/nexus/content/repositories/releases"

libraryDependencies += "au.com.realcommercial.binding" %%% "dom" % "1.0.3"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

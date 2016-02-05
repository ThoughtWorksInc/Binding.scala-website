enablePlugins(ScalaJSPlugin)

resolvers += "releases" at "http://nexus.delivery.realestate.com.au/nexus/content/repositories/releases"

libraryDependencies += "com.thoughtworks.binding" %%% "dom" % "2.0.1"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

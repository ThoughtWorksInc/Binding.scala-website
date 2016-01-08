enablePlugins(ScalaJSPlugin)

resolvers += "releases" at "http://nexus.delivery.realestate.com.au/nexus/content/repositories/releases"

libraryDependencies += "com.thoughtworks.binding" %%% "dom" % "1.0.5"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

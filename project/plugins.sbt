//plugins
resolvers += Classpaths.typesafeResolver

resolvers += "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"

//eclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.1.0")

//idea
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.1.0")

repositories.remote << 'http://repo1.maven.org/maven2'

define 'javtang' do
  project.version = '0.1.0-SNAPSHOT'
  project.group = 'me.itang'

  compile.options.source = '1.8'
  compile.options.target = '1.8'
  compile.options.deprecation = true
  compile.options.lint = true
  compile.options.other = %w[-encoding UTF-8]

  compile.with 'com.google.code.findbugs:jsr305:jar:3.0.0'
  compile.with 'com.google.guava:guava:jar:18.0'

  package :jar
end

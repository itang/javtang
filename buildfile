Buildr.settings.build['scala.version'] = "2.9.1"
require 'buildr/scala'

repositories.remote << 'http://repo1.maven.org/maven2' <<
					'http://scala-tools.org/repo-releases'

module Buildr::Scala
  class CustomScalaTest < Buildr::Scala::ScalaTest
    class << self
      def dependencies
        ["org.scalatest:scalatest_2.9.0:jar:1.6.1"] + JMock.dependencies + JUnit.dependencies # + Check.dependencies
      end 
    end 
  end
end

Buildr::TestFramework << Buildr::Scala::CustomScalaTest

define 'javtang' do
	project.version = '0.1.0-SNAPSHOT'
	project.group = 'me.itang'
	
	compile.using :target => '1.5', :javac => %w[-encoding UTF-8], :deprecation => true
	
	#test.with 'org.scalatest:scalatest_2.9.0:jar:1.6.1'
	test.using(:customscalatest)
	
	package :jar
end


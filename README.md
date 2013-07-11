dyn
===

A Scala `case class` that can be used as a wrapper around other data. With dyn,
you can access an objects properties without the need of an explicit class
declaration.


Installation
------------

### SBT ###

Add the following line to your `build.sbt` file

~~~ scala
libraryDependencies += "de.vorb" % "dyn" % "0.0.+"
~~~


Usage
-----

Here is an example.

~~~ scala
import de.vorb.data.immutable.Dyn

val document = Map(
  "title" -> "Document title",
  "tags" -> List("dev", "scala")
)

val dynDoc = Dyn(document)

println(dyn.title[String]) // will print "Document title"
println(dyn("tags")(0))    // will print "dev"
println(dyn("tags")(0))    // will print "scala"
~~~

This is particularly helpful when you are dealing with the output of Scala's
built-in [JSON parser](http://www.scala-lang.org/api/current/index.html#scala.util.parsing.json.JSON$).


License
-------

Copyright © 2013 Paul Vorbach

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the “Software”), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

package de.vorb.data

import org.scalatest.FunSpec

import de.vorb.data.immutable.Dyn

class DynSpec extends FunSpec {

  val immutable = Map(
    "title" -> "Document title",
    "tags" -> List("dev", "scala")
  )

  describe("mutable.Dyn") {
    it("should make arbitrary properties accessible") {
      val dyn = Dyn(immutable)
      assert(dyn.title[String] == "Document title")
      assert(dyn("tags")(0).value[String] == "dev")
      assert(dyn("tags")(1).value[String] == "scala")
    }
  }
}

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class Week1Test extends AnyFreeSpec with Matchers {

  val week1 = new Week1()

  "part1" - {
    "must return true for word aa" in {
      week1.part1("aa") mustBe true
    }

    "must return false for word ab" in {
      week1.part1("ab") mustBe false
    }

    "must return true for word abba" in {
      week1.part1("abba") mustBe true
    }

    "must return false for word abca" in {
      week1.part1("abca") mustBe false
    }

    "must return true for word racecar" in {
      week1.part1("racecar") mustBe true
    }

    "must return true for word nurses run" in {
      week1.part1("nurses run") mustBe true
    }
  }

  "part2" - {
    "must return 100 for word aa" in {
      week1.part2("aa") mustBe 100
    }

    "must return 0 for word ab" in {
      week1.part2("ab") mustBe 0
    }

    "must return 100 for word abba" in {
      week1.part2("abba") mustBe 100
    }

    "must return 50 for word abca" in {
      week1.part2("abca") mustBe 50
    }

    "must return 80 for word racecar" in {
      week1.part2("racecar") mustBe 100
    }

    "must return 85 for word nurses run" in {
      week1.part2("nurses run") mustBe 100
    }

  }

}

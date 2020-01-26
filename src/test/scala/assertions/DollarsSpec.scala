package assertions

import com.h2.entities.Dollars
import org.scalatest.flatspec.AnyFlatSpec

class DollarsSpec extends AnyFlatSpec {
  behavior of "A Dollar"

  it should "create a correct Dollar object for amount 10 as input" in {
    val tenDollars = Dollars(10)
    assert("$10" === tenDollars.toString)
  }

  /**
    * Added this condition, bcz in Dollars class Ordered trait's compare method implemented.
    */
  it should "correctly identify that $10 > $5" in {
    assert( Dollars(10) > Dollars(5))
  }

  it should "correctly identify that $10 < $12" in {
    assert( Dollars(10) < Dollars(12))
  }

  it should "correctly add two dollar amounts" in {
    val tenDollar = Dollars(10)
    val twoDollar = Dollars(2)

    assertResult("$12") {
      (tenDollar + twoDollar).toString
    }
  }

  it should "correctly subtract two dollar amounts" in {
    val tenDollar = Dollars(10)
    val twoDollar = Dollars(2)

    assertResult("$8") {
      (tenDollar - twoDollar).toString
    }
  }

  it should "correctly confirm equality $10 == $10" in {
    val tenDollar = Dollars(10)

    assertResult(true) {
      tenDollar === tenDollar
    }
  }

  it should "throw exception when wrong number is provided for Dollar" in {
    assertThrows[ArithmeticException] {
      Dollars(10 / 0)
    }
  }
  
}

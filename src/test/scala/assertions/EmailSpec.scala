package assertions

import com.h2.entities.{Email}
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec {
  behavior of "An Email"

  it should "return an Email object for a valid email address" in {
    val email = Email("imransarwar.dev@gmail.com")

    assert(email.localPart === "imransarwar.dev")
    assert(email.domain === "gmail.com")
  }

  it should "return another email object with valid email provided" in {
    assertResult("imransarwar") {
      Email("imransarwar@gmail.com").localPart
    }
  }

  it should "throw exception when in email '@' symbol not provided" in {
    assertThrows[IllegalArgumentException] {
      Email("imransarwar")
    }
  }

  it should "throw exception when in email '@' symbol provided more than one" in {
    assertThrows[IllegalArgumentException] {
      Email("imransarwar@@gmail.com")
    }
  }

  it should "intercept the correct error message when '@' symbol in email is not provided" in {
    val exception = intercept[IllegalArgumentException] { Email("imransarwar")}
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("does not contain '@' symbol"))
  }

  it should "intercept the correct error message when '@' symbol in email is provided more than one" in {
    val exception = intercept[IllegalArgumentException] { Email("imransarwar@2@gmail.com")}
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("should not contain '@' symbol more than once"))
  }
}

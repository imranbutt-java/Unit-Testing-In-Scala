import org.scalatest.flatspec.AnyFlatSpec

class HelloWorldSpec extends AnyFlatSpec {
  //Subject
  behavior of "Hello World"

  //Nature of test
  it should "start with 'Hello'" in {
    assert("Hello World".startsWith("Hello"))
  }

  it should "end with 'World'" in {
    assert("Hello World".endsWith("World"))
  }
}
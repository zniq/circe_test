package circe_test

object Main extends App {

  val address = Address("tokyo", "city")
  val user = User(123, "userName", address, None)

  val w1 = new WrapperClass("hoge", "fuga", user, address)
  w1.printAsJson()

}

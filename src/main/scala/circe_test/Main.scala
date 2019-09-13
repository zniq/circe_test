package circe_test

object Main extends App {

  val address = Address("tokyo", "city")
  val user = User(123, "userName", address, None)
  val employee = Employee("duncan", "dev")
ß
  val w1 = new WrapperClass("hoge", "fuga", user, employee)
  w1.printAsJson()

}

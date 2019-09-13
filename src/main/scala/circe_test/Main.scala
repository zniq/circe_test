package circe_test

object Main extends App {

  val address = Address("tokyo", "city")
  val user = User(123, "userName", address, None)
  val employee = Employee("duncan", "dev")

  implicit val e = Employee.camelEncoder
  val w1 = new WrapperClass("hoge", "fuga", user, employee)
  w1.printAsJson()

}

package circe_test

import java.time.LocalDateTime

import circe_test.model.{Address, Employee, User, WrapperClass}

object Main extends App {

  val address = Address("tokyo", "city")
  val user = User(123, "userName", address, None)
  val employee = Employee("duncan", "dev")

  val sec = LocalDateTime.now.getSecond
  val wrapperClass = if (sec % 2 == 0) {
    println("*** snake_case format.")
    new WrapperClass("hoge", "fuga", user, employee)
  } else {
    println("*** camelCase format.")
    implicit val ue = User.camelEncoder
    implicit val ee = Employee.camelEncoder
    new WrapperClass("hoge", "fuga", user, employee)
  }

  wrapperClass.printAsJson()

}

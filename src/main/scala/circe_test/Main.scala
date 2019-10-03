package circe_test

import java.time.LocalDateTime

import circe_test.Main.{employee, user}
import io.circe.syntax._
import io.circe.parser._
import circe_test.model.{Address, Employee, User, WrapperClass}
import io.circe.{Decoder, Encoder}

object Main extends App {

  val address = Address("tokyo", "city")
  val user = User(123, "userName", address, None)
  val employee = Employee("duncan", "dev")

  val sec = LocalDateTime.now.getSecond
  if (sec % 2 == 0) {
    println("*** snake_case format.")

    printEncode(user)
    printEncodeUsingWrapClass(user, employee)
    printDecode(user.asJson.noSpaces)
  } else {
    println("*** camelCase format.")
    implicit val ue = User.camelEncoder
    implicit val ee = Employee.camelEncoder
    implicit val ud = User.camelDecoder

    printEncode(user)
    printEncodeUsingWrapClass(user, employee)
    printDecode(user.asJson.noSpaces)
  }

  def printEncode(user: User)(implicit userEncoder: Encoder[User]): Unit = {
    println(user.asJson)
  }

  def printEncodeUsingWrapClass(user: User, employee: Employee)(
      implicit userEncoder: Encoder[User],
      employeeEncoder: Encoder[Employee]): Unit = {
    new WrapperClass("hoge", "fuga", user, employee).printAsJson()
  }

  def printDecode(jsonString: String)(
      implicit userDecoder: Decoder[User]): Unit = {
    val decodedUser = decode[User](jsonString).right.get
    println(decodedUser)
  }
}

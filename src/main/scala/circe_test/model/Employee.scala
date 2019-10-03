package circe_test.model

import io.circe._
import io.circe.generic.extras._
import io.circe.generic.semiauto._

@ConfiguredJsonCodec case class Employee(employeeName: String,
                                         department: String)

object Employee {
  val camelEncoder: Encoder[Employee] = deriveEncoder
  val camelDecoder: Decoder[Employee] = deriveDecoder
}

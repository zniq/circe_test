package circe_test

import io.circe._
import io.circe.generic.extras._
import io.circe.generic.semiauto._

@ConfiguredJsonCodec case class User(userId: Int, userName: String, address: Address, mail: Option[String])
@ConfiguredJsonCodec case class Address(prefectureName: String, cityName: String)

object User {
  implicit lazy val jsonConfig: Configuration = Configuration.default.withSnakeCaseMemberNames
  val camelDecoder: Decoder[User] = deriveDecoder
  val camelEncoder: Encoder[User] = deriveEncoder
}

object Address {
  implicit lazy val jsonConfig: Configuration = Configuration.default.withSnakeCaseMemberNames
  val camelDecoder: Decoder[Address] = deriveDecoder
  val camelEncoder: Encoder[Address] = deriveEncoder
}
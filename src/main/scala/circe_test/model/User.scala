package circe_test.model

import io.circe._
import io.circe.generic.extras._
import io.circe.generic.semiauto._

@ConfiguredJsonCodec case class User(userId: Int,
                                     userName: String,
                                     address: Address,
                                     mail: Option[String])
@ConfiguredJsonCodec case class Address(prefectureName: String,
                                        cityName: String)

object User {
  val camelDecoder: Decoder[User] = {
    implicit val jsonConfig: Configuration = Configuration.default
    implicit val addressDecoder: Decoder[Address] = Address.camelDecoder
    deriveDecoder
  }

  val camelEncoder: Encoder[User] = {
    implicit val jsonConfig: Configuration = Configuration.default
    implicit val addressEncoder: Encoder[Address] = Address.camelEncoder
    deriveEncoder
  }
}

object Address {
  val camelDecoder: Decoder[Address] = deriveDecoder
  val camelEncoder: Encoder[Address] = deriveEncoder
}

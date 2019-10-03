package circe_test

import io.circe.generic.extras.Configuration

package object model {
  implicit val jsonConfig: Configuration = Configuration.default.withSnakeCaseMemberNames
}

package circe_test

import io.circe.Encoder
import io.circe.syntax._

class WrapperClass[A:Encoder, B:Encoder](foo: String, bar: String, model1: A, model2: B) {

  def printAsJson(): Unit = {
    println("==== model1 ======")
    println(model1.asJson)
    println("==========")
    println("==== model2 ======")
    println(model2.asJson)
    println("==========")
  }


}

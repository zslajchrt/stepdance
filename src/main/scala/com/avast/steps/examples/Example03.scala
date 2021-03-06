package com.avast.steps.examples

import java.io.{FileReader, BufferedReader}
import com.avast.steps.StepsBuilder._

/**
 * StepDance: Basic Usage
 */
class Example03 extends StepDanceExample {

  /**
   * Step functions decoration
   */
  def example() {
    var counter: Long = 0
    lazy val input =
      new BufferedReader(new FileReader(sourceFile))

    val scanner = buildSteps {
      input.readLine()
    }.closeWith {
      input.close()
      println("Closed")
    }.build().decorate(decorStepFn => {
      counter += 1
      decorStepFn()
    })

    for (line <- scanner) {
      println(line)
    }

    println("Lines read " + counter)
  }

}

package org.szhua

object HighOrderFunctions extends  App {

  val salaries = Seq(20000, 70000, 40000)
  val doubleSalary = (x: Int) => x * 2
   salaries.map(doubleSalary).foreach(println)
   salaries.map(_*3).foreach(println)

   println()
   print(WeeklyWeatherForecast(Seq(100)).convertCtoF(37))

  println()
  SalaryRaiser.promotion(List[Double](1000,1000),v=>{
    v * v
  }).foreach(println(_))



  //Functions that return functions
    //There are certain cases where you want to generate a function.
    // Here’s an example of a method that returns a function.
  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }

  //Notice the return type of urlBuilder (String, String) => String.
  // This means that the returned anonymous function takes two Strings and returns a String.
  // In this case, the returned anonymous function is
  // (endpoint: String, query: String) => s"https://www.example.com/$endpoint?$query"
  val result = urlBuilder(true,"szhua")("szhua","dffdf")
  println(result)
}


/**
Coercing methods into functions
     It is also possible to pass methods as arguments to higher-order functions because
     the Scala compiler will coerce the method into a function.


 **/

 case class WeeklyWeatherForecast(temperatures: Seq[Double]) {
  /**
   * Here the method convertCtoF is passed to the higher order function map.
   * This is possible because the compiler coerces convertCtoF to the function x => convertCtoF(x)
   * (note: x will be a generated name which is guaranteed to be unique within its scope).
   * @param temp
   * @return
   */
   def convertCtoF(temp: Double) = temp * 1.8 + 32

  def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF
}


object SalaryRaiser {

  /**
   * The new method, promotion, takes the salaries plus a function of
   * type Double => Double (i.e. a function that takes a Double and returns a Double) and returns the product.
   *
   * Methods and functions usually express behaviours or data transformations,
   * therefore having functions that compose based on other functions can help building generic mechanisms.
   * Those generic operations defer to lock down the entire operation behaviour giving clients a way to
   * control or further customize parts of the operation itself.
   * @param salaries
   * @param promotionFunction
   * @return
   */

   def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)
}



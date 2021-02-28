import java.util.Scanner
import scala.io.Source

/**
 *  created by malevinsky
 *  date: 28.02.2021
 */

object Suggest {
  def main(args: Array[String]): Unit = {

    /**
     * Здесь всё стандартно: сканнер и в Африке сканнер
     */

    val scanner = new Scanner(System.in)
    println("Введите строку с которой начинается название компании:")
    val input = scanner.next();
    println("Введите кол-во компаний, которые нужно вывести:")
    val numberOfSuggest = scanner.nextInt();
    suggest(input, numberOfSuggest)

  }
  def suggest(input: String, numberOfSuggest : Int)  {

    /**
     * Алгоритм решения такой же, как и в github.com/malevinsky/yandex-scala, но код менее объемный. Удалось загнать и считывание файлов, и поиск нужного слога в один цикл (Браво, Настя!).
     * В общем, это та же джава, но аргументы в функциях странные и нет точек с запятыми.
     */

    var count: Int = 0
    println("Названия компаний:")
    val testTxtSource = Source.fromFile("/home/theodora/Downloads/scala-version2/src/main/scala/companies.txt")
    testTxtSource.getLines
      .foreach { line =>
        if (count < numberOfSuggest && line.startsWith(input)) {
          count += 1
          println(line)
        }
      }
    testTxtSource.close()
  }
}

import IO.ReadFromFile

import scala.annotation.tailrec
import scala.io.StdIn

object ConsoleHandler {
    def inputHandler(): (Constant.Languages.Value, Int, String, String) = {
        print("Выберете язык en или ru: ")
        val lang = StdIn.readLine() match {
            case "EN" | "en" | "ут" | "УТ" => Constant.Languages.en
            case "RU" | "ru" | "кг" | "КГ" => Constant.Languages.ru
        }
        print("Введите k: ")
        val k = StdIn.readInt()
        print("Введите ключевое слово: ")
        val key = StdIn.readLine().trim
//        print("Введите имя файла для чтения: ")
        (lang, k, key.toUpperCase, ReadFromFile.read("input")) //StdIn.readLine()
    }
}

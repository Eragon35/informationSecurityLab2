package IO

import scala.io.Source


object ReadFromFile {
    def read(fileName: String): String = {
        var input = ""
        try {
            FileChecker.check(fileName)
            val source = Source.fromFile(fileName)
            for (line <- source.getLines()) input += line
            source.close()
        } catch {
            case e: Throwable => Console.err.println("\tProblem with parsing file\n" + e.getMessage)
                e.printStackTrace()
        }
        input
    }
}

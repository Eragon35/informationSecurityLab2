object CipherUtils {

    def shiftAlphabet(alphabet: String, k: Int, key: String): Map[Char,Char] = {
        val (end, start) = alphabet.splitAt(alphabet.length - k)
        val shiftedAlphabet = start + key.toArray.filter(char => !start.contains(char)).mkString("") +
            end.toArray.filter(char => !key.contains(char)).mkString("")
        alphabet.map(char => char -> shiftedAlphabet.charAt(alphabet.indexOf(char))).toMap
    }

    def decode(alphabet: String, shiftedAlphabet: Map[Char, Char], input: String): String =
        input.map(char =>
            if (shiftedAlphabet.contains(char)) shiftedAlphabet(char)
            else char
        )

    def encode(alphabet: String, shiftedAlphabet: Map[Char, Char], input: String): String =
        input.map(char =>
            if (shiftedAlphabet.contains(char)) shiftedAlphabet.find(_._2 == char).map(_._1).get
            else char
        )
}

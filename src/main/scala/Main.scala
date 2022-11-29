object Main extends App{
    val (lang, k, key, input) = ConsoleHandler.inputHandler()
    val alphabet = Constant.Alphabets.getBy(lang)
    val shiftedAlphabet = CaesarCipherUtils.shiftAlphabet(alphabet, k, key)
    val decoded = CaesarCipherUtils.decode(alphabet, shiftedAlphabet, input)
    val encoded = CaesarCipherUtils.encode(alphabet, shiftedAlphabet, decoded)
    println(s"Caesar\nDecoded: $decoded\nEncoded: $encoded")

    if (lang == Constant.Languages.en) {
        val matrix = PlayfairCipherUtils.matrix(key)
        val biDecoded = PlayfairCipherUtils.decode(input, matrix)
        val biEncoded = PlayfairCipherUtils.encode(biDecoded, matrix)
        println(s"Bigrams\nDecoded: $biDecoded\nEncoded: $biEncoded")
    }
}

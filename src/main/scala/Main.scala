object Main extends App{
    val (lang, k, key, input) = ConsoleHandler.inputHandler()
    val alphabet = Constant.Alphabets.getBy(lang)
    val shiftedAlphabet = CipherUtils.shiftAlphabet(alphabet, k, key)
    val decoded = CipherUtils.decode(alphabet, shiftedAlphabet, input)
    val encoded = CipherUtils.encode(alphabet, shiftedAlphabet, decoded)
    println(s"Decoded: $decoded\nEncoded: $encoded")
}

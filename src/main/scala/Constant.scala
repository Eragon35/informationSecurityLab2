object Constant {
    object Languages extends Enumeration {
        val en = Value("EN")
        val ru = Value("RU")
    }

    object Alphabets {
        val enAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val ruAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"

        def getBy(lang: Languages.Value) = lang match {
            case Constant.Languages.en => enAlphabet
            case Constant.Languages.ru => ruAlphabet
        }
    }
}

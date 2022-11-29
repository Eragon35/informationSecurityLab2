object PlayfairCipherUtils {
    def decode(input: String, matrix: Seq[Seq[Char]]): String = {
        var result = ""
        var text = if (input.length % 2 == 1) input.appended(' ') else input
        text = text
//            .replace(' ', 'А')
//            .replace(',','Б')
//            .replace('.','В')
//            .replace('(','Г')
//            .replace(')','Д')
        while (text.nonEmpty) {
            val (firstI, firstJ) = findInMatrix(text(0).toUpper, matrix)
            val (secondI, secondJ) = findInMatrix(text(1).toUpper, matrix)
            var charOne = '%'
            var charTwo = '%'

            if (firstI == secondI) {
                if (firstJ != 0) {
                    charOne = matrix(firstI)(firstJ - 1)
                } else {
                    charOne = matrix(firstI)(4)
                }
                if (secondJ != 0) {
                    charTwo = matrix(secondI)(secondJ - 1)
                } else {
                    charTwo = matrix(secondI)(4)
                }
            } else if (firstJ == secondJ) {
                if (firstI != 0) {
                    charOne = matrix(firstI - 1)(firstJ)
                } else {
                    charOne = matrix(5)(firstJ)
                }
                if (secondI != 0) {
                    charTwo = matrix(secondI - 1)(secondJ)
                } else {
                    charTwo = matrix(5)(secondJ)
                }
            } else {
                charOne = matrix(firstI)(secondJ)
                charTwo = matrix(secondI)(firstJ)
            }
            if (text(0).isLower) result = result.appended(charOne.toLower) else result = result.appended(charOne)
            if (text(1).isLower) result = result.appended(charTwo.toLower) else result = result.appended(charTwo)
            text = text.substring(2)
        }
        result
    }

    def encode(input: String, matrix: Seq[Seq[Char]]): String = {
        var result = ""
        var text = if (input.length % 2 == 1) input.appended(' ') else input
        while (text.nonEmpty) {
            val (firstI, firstJ) = findInMatrix(text(0).toUpper, matrix)
            val (secondI, secondJ) = findInMatrix(text(1).toUpper, matrix)
            var charOne = '%'
            var charTwo = '%'

            if (firstI == secondI) {
                if (firstJ != 4) {
                    charOne = matrix(firstI)(firstJ + 1)
                } else {
                    charOne = matrix(firstI)(0)
                }
                if (secondJ != 4) {
                    charTwo = matrix(secondI)(secondJ + 1)
                } else {
                    charTwo = matrix(secondI)(0)
                }
            } else if (firstJ == secondJ) {
                if (firstI != 5) {
                    charOne = matrix(firstI + 1)(firstJ)
                } else {
                    charOne = matrix(0)(firstJ)
                }
                if (secondI != 5) {
                    charTwo = matrix(secondI + 1)(secondJ)
                } else {
                    charTwo = matrix(0)(secondJ)
                }
            } else {
                charOne = matrix(firstI)(secondJ)
                charTwo = matrix(secondI)(firstJ)
            }
            if (text(0).isLower) result = result.appended(charOne.toLower) else result = result.appended(charOne)
            if (text(1).isLower) result = result.appended(charTwo.toLower) else result = result.appended(charTwo)
            text = text.substring(2)
        }
        result
//            .replace('А',' ')
//            .replace('Б',',')
//            .replace('В','.')
//            .replace('Г','(')
//            .replace('Д',')')
    }

    private def findInMatrix(char: Char, matrix: Seq[Seq[Char]]): (Int, Int) = {
        for (i <- 0 to 5) {
            for (j <- 0 to 4) {
                if (matrix(i)(j) == char) return (i, j)
            }
        }
        (0, 0)
    }

    def matrix(key: String): Seq[Seq[Char]] = {
        val fixedKey = key.toUpperCase.distinct
        val alphabet = Constant.Alphabets.enAlphabet.filter(_ != 'Q')
        val keyLength = fixedKey.distinct.length
        val firstLine: Seq[Char] = if (keyLength <= 5) {
            fixedKey.concat(alphabet.filter(char => !fixedKey.contains(char)).substring(0, 5 - keyLength)).toString.toSeq
        } else {
            fixedKey.toSeq
        }
        val secondLine: Seq[Char] = if (keyLength > 5) {
            fixedKey.substring(5).concat(alphabet.filter(char => !fixedKey.contains(char)).substring(0, 5 - keyLength)).toString.substring(0, 5).toSeq
        } else {
            alphabet.filter(char => !fixedKey.contains(char)).substring(5 - keyLength).toString.substring(0, 5).toSeq
        }
        val thirdLine = alphabet.filter(char => !fixedKey.contains(char)).substring(10 - keyLength).toString.substring(0, 5).toSeq
        val forthLine = alphabet.filter(char => !fixedKey.contains(char)).substring(15 - keyLength).toString.substring(0, 5).toSeq
        val fifthLine = alphabet.filter(char => !fixedKey.contains(char)).substring(20 - keyLength).toString.substring(0, 5).toSeq
        val sixthLine = ",. ()".toSeq

        Seq(firstLine, secondLine, thirdLine, forthLine, fifthLine, sixthLine)
    }



}

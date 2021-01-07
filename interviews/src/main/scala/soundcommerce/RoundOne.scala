package soundcommerce

object RoundOne {

  /** Returns true if @word exists in a given @sentence */
  def wordExistsInSentence(word: String, sentence: String): Boolean = {
    // Selects everything which is NOT alpha
    val regex = "[^a-zA-Z]+"

    sentence
      .split(" ")
      .map(wordInSentence => wordInSentence.replaceAll(regex, ""))
      .contains(word)
  }
}

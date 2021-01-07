package soundcommerce

import org.scalatest.FunSpec
import org.scalatest.Matchers.convertToAnyShouldWrapper
import soundcommerce.RoundOne._

class RoundOneTest extends FunSpec {
  describe("testWordExistsInSentence") {
    val sentence = "this is a sentence, and another hyphen-word"

    it("tests whether a word exists in a sentence") {
      val word = "sentence"
      wordExistsInSentence(word, sentence) shouldBe true
    }
    it("returns false if the word does not exist in the sentence") {
      val wordTwo = "not"
      wordExistsInSentence(wordTwo, sentence) shouldBe false
    }
  }

}

import scala.annotation.tailrec

/*
A palindrome is a word, phrase, or sequence that reads the same backwards as forwards, e.g. madam, radar or nurses run.
Keep part 1 and part 2 as two separate methods so we can see the refactor process that happened between the two parts.
Will put something in for us to all go through together later in the week.

Part 1: Can you write a function that, given a string, returns true or false to notify if the given string is a palindrome or not.
The input can contain spaces that should be ignored and capital letters should not cause a problem.
Part 2: We are now interested in the words that aren't palindromes. So instead of returning a simple boolean to state if the input is palindromic or not.
Refactor the method to return a percentage of how close something is to being a palindrome. In this case radar would be 100%, but radas would only be 80%.
 */

class Week1 {

  def part1(word: String): Boolean = {

    @tailrec
    def checkPalindrome(remainingWord: String): Boolean = {
      remainingWord.length match {
        case 0 => true
        case 1 => true
        case _ if firstAndLastMatch(remainingWord) =>
          checkPalindrome(remainingWord.tail.reverse.tail.reverse)
        case _ => false
      }
    }

    checkPalindrome(stripSpace(word))
  }

  private def firstAndLastMatch(word: String): Boolean = {
    val firstLetter = word.head
    val lastLetter = word.reverse.head
    firstLetter == lastLetter
  }

  private def stripSpace(word: String): String = word.replaceAll(" ", "")

  def part2(word: String): BigDecimal = {

    val strippedWord = stripSpace(word)

    @tailrec
    def palindromicLetters(remainingWord: String, amountOfPalindromicLetters: BigDecimal): BigDecimal = {
      remainingWord.length match {
        case 0 => amountOfPalindromicLetters
        case 1 => amountOfPalindromicLetters + 1
        case _ if firstAndLastMatch(remainingWord) =>
          val newAmount = amountOfPalindromicLetters + 2
          palindromicLetters(remainingWord.tail.reverse.tail.reverse, newAmount)
        case _ =>
          palindromicLetters(remainingWord.tail.reverse.tail.reverse, amountOfPalindromicLetters)
      }
    }

    palindromicLetters(strippedWord, 0) / strippedWord.length * 100
  }



}

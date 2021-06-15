// Driver file for the StringConverter lab.
// You shouldn't have to modify anything in this file
// unless you want to try some different sample text.
// Your StringConverter class file should be made to work with this driver.
public class StringConverterDriver
{
  /**
   * Main method that starts the test. All four methods will be tested.
   */
  
  public static void main(String[] args)
  {
    // Reverse
    System.out.println("-----------------------------");
    String str = "Hello";
    String newstr = StringConverter.reverse(str);
    System.out.println(str);
    System.out.println(newstr);
    System.out.println("-----------------------------");

    // Palindrome
    String[] checks = new String[5];
    checks[0] = "radar";
    checks[1] = "J";
    checks[2] = "Eva: Can I see bees in a cave?";
    checks[3] = "Java is Java";
    checks[4] = "Are we not drawn onward, we few, drawn onward to new era?";
    
    for (String s : checks) {
      System.out.println("\"" + s + "\" is a palindrome: " + StringConverter.checkPalindrome(s));
    }
    System.out.println("-----------------------------");

    // Pig Latin
    // Only processes one word at a time
    str = "You need our new atomic refrigerator!";
    System.out.println(str);
    System.out.println(breakUp(str)); // passes str to breakUp, which in turn calls pigLatinate (see below)
    System.out.println("-----------------------------");

    // Shorthand
    
    String[] shorts = new String[3];
    shorts[0] = "For you and me to be best friends, we must be all to each other.";
    shorts[1] = "You are not as funny as you think you are.";
    shorts[2] = "Using hand tools often belies competence.";
    for (String s : shorts) {
      System.out.println(s);
      // passes str to shorthand, which returns the converted shorthand form.
      System.out.println(StringConverter.shorthand(s));
    }
    System.out.println("-----------------------------");
  }
  
  /**
   * Recursive function that takes a sentence and breaks it into individual words,
   * passing each word on to a StringConverter method. Then it reconstructs the sentence
   * and returns it to the main method.
   * @param str String that represents a sentence that will be broken up.
   */
  private static String breakUp(String str){
    //if single word->base case for recursion
    if (str.indexOf(" ") == -1)
    {
      if (str.substring(str.length() - 1).equals(".")) {
        str = str.substring(0, str.length() - 1);
      }
      return StringConverter.pigLatinate(str);
    }
    
    //if multiple words, pull out first word, send rest through the recursive loop
    String topig = "";
    String punc = " ";
    int i = str.indexOf(" ");
    String punctuation = ",.;?!:#$%&*)";
    if (punctuation.contains(str.substring(i - 1, i)))
    {
        topig = str.substring(0, i - 1);
        punc = str.substring(i - 1);
    }
    else
    {
      topig = str.substring(0, i);
    }
    str = str.substring(i + 1,str.length());
    return StringConverter.pigLatinate(topig) + punc + breakUp(str);
  }
}

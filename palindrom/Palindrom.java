package palindrom;

public class Palindrom
{
    private String sentence;

    Palindrom(String sentence)
    {
        this.sentence = sentence;
    }

    Palindrom()
    {

    }

    public void sentenceToLower()
    {
        sentence = sentence.toLowerCase();
    }

    public void removeWhitespace()
    {
        sentence = sentence.replaceAll("\\s+", "");
    }

    public boolean isPalindrome()
    {
        boolean palindrome = true;

        for(int i = 0, j = sentence.length() - 1; i < sentence.length(); i++, j--)
        {
            if(sentence.charAt(i) != sentence.charAt(j))
                palindrome = false;
        }
        return palindrome;
    }

    public void setSentence(String sentence)
    {
        this.sentence = sentence;
    }
}

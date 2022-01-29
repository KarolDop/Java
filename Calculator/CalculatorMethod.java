public class CalculatorMethod
{
    private int firstNumber;
    private int secendNumber;

    public CalculatorMethod(int firstNumber, int secendNumber)
    {
        this.firstNumber = firstNumber;
        this.secendNumber = secendNumber;
    }

    public int plus()
    {
        return firstNumber + secendNumber;
    }

    public int minus()
    {
        return firstNumber - secendNumber;
    }

    public int multiplay()
    {
        return firstNumber * secendNumber;
    }

    public double divided()
    {
        return (double)firstNumber / (double)secendNumber;
    }

    public int modulo()
    {
        return firstNumber % secendNumber;
    }
}

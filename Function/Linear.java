package Function;

public class Linear
{
    private double a;
    private  double b;
    private  double x;
    private byte direction;

    Linear(double a, double b)
    {
        this.a = a;
        this.b = b;
    }

    Linear()
    {
    }

    public void linearDirection()
    {
        if(a < 0)
            direction = -1;
        else if(a > 1)
            direction = 1;
        else
            direction = 0;
    }

    public void zeroPlace()
    {
        if (a != 0 && b != 0)
        {
            x = (-b / a);
            System.out.println("Function have one zero place: " + x + ".");
        }
        else if (a == 0 && b == 0)
            System.out.println("Fuction have inifinity zero place.");
        else if(a == 0 && b != 0)
            System.out.println(("Fuction don't have zero place"));
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getX() {
        return x;
    }

    public byte getDirection() {
        return direction;
    }
}

package finalProject;

public class Complex {
    protected double firstPart;
    protected double secondPart;
    public void setFirstPart(double firstPart) {
        this.firstPart = firstPart;
    }
    public void setSecondPart(double secondPart) {
        this.secondPart = secondPart;
    }
    public double getFirstPart() {
        return firstPart;
    }
    public double getSecondPart() {
        return secondPart;
    }
    public Complex(double firstPart, double secondPart) {
        this.firstPart = firstPart;
        this.secondPart = secondPart;
    }
    @Override
    public String toString() {
        if(secondPart > 0) {
            return firstPart + "+" + secondPart + "i";
        } else {
            return firstPart + "-" + Math.abs(secondPart) + "i";
        }
    }
    
}

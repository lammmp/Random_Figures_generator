public class Ellipse extends Figure {
    private double semiMajorAxis;
    private double semiMinorAxis;
 
    public Ellipse(double a, double b) {
        super(a, b);
        semiMajorAxis = Math.max(a, b) / 2;
        semiMinorAxis = Math.min(a, b) / 2;
    }
 
    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }
 
    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }
 
    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }
 
    public void setSemiMinorAxis(double semiMinorAxis) {
        this.semiMinorAxis = semiMinorAxis;
    }
 
    @Override
    public String getName() {
        return "Ellipse";
    }
 
    @Override
    public double getSquare() {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }
 
    public double getAxisSum() {
        return semiMajorAxis + semiMinorAxis;
    }
}
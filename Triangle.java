public class Triangle extends Figure {
    // катет
    private double leg;
    
    public double getLeg() {
        return leg;
    }
 
    public void setLeg(double leg) {
        this.leg = leg;
    }
 
    public Triangle(double a, double b) {
        super(a, b);
        leg = Math.min(a, b);
    }
 
    @Override
    public String getName() {
        return "Triangle";
    }
 
    @Override
    public double getSquare() {
        return leg * leg / 2;
    }
 
    public double getPerimeter() {
        return (2 + Math.sqrt(2)) * leg;
    }
}
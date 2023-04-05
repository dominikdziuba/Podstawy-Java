package pl.retsuz.point;

public class Point implements IPoint{
    private double pX;
    private double pY;
    private String name;

    public Point(String namePoint, double x, double y ){
        name=namePoint;
        this.pX =x;
        this.pY=y;

    }
    @Override
    public double getX(){return this.pX;}
    @Override
    public double getY(){return this.pY;}
    @Override
    public String getName(){return this.name;}
    @Override
    public void setX(double x){ this.pX = x; }
    @Override
    public void setY(double y){this.pY=y;}
    @Override
    public void printPoint(){
        System.out.println(this.name+"=("+this.pX+", "+this.pY+")");
    }
    @Override
    public void selectCoordinate(char nameCoordinate){
        switch (nameCoordinate) {
            case 'x':
                System.out.println("Coordinate x of the point " + this.name + ": " + getX());
                break;
            case 'y':
                System.out.println("Coordinate y of the point " + this.name + ": "  + getY());
                break;
        }

    }
    @Override
    public void changeCoordinate(char nameCoordinate, double newValue) {
        switch (nameCoordinate) {
            case 'x':
                setX(newValue);
                System.out.println(this.name+" after changed x:");
                printPoint();
                break;
            case 'y':
                setY(newValue);
                System.out.println(this.name+" after changed y:");
                printPoint();
                break;
        }

    }
    public double calculateDistance(Point point){
    return Math.sqrt(Math.pow(this.getX()-point.getX(), 2)+Math.pow(this.getY()-point.getY(), 2));
    }
    @Override
    public void updatePoint(Point point){
        this.pX=point.pX;
        this.pY=point.pY;
    }
}

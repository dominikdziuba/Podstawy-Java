package pl.retsuz.triangle;



import pl.retsuz.point.Point;
import java.util.ArrayList;

public class Triangle implements ITriangle {

    protected ArrayList<Point> vertex = new ArrayList<>();


    public Triangle(Point A, Point B, Point C) {
        vertex.add(A);
        vertex.add(B);
        vertex.add(C);
    }


    public void printTriangle() {
        System.out.println("Triangle: ");
        for (Point point : vertex) {
            point.printPoint();
        }
    }

    @Override
    public double calculatePerimeter() {
        double perimeter, aSide, bSide, cSide;
        aSide = vertex.get(1).calculateDistance(vertex.get(2));
        bSide = vertex.get(0).calculateDistance(vertex.get(2));
        cSide = vertex.get(0).calculateDistance(vertex.get(1));

        perimeter = aSide + bSide + cSide;
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double halfperimeter, aSide, bSide, cSide, triangleArea;
        halfperimeter = calculatePerimeter() * 0.5;
        aSide = vertex.get(1).calculateDistance(vertex.get(2));
        bSide = vertex.get(0).calculateDistance(vertex.get(2));
        cSide = vertex.get(0).calculateDistance(vertex.get(1));
        triangleArea = Math.sqrt(halfperimeter * (halfperimeter - aSide) * (halfperimeter - bSide) * (halfperimeter - cSide));
        return triangleArea;
    }

    @Override
    public double calculateAltitude(int choice) {
        double side = 0;
        double altitude;
            switch(choice) {
                case 0:
                double aSide = vertex.get(1).calculateDistance(vertex.get(2));
                side = aSide;
                break;
                case 1:
                double bSide = vertex.get(0).calculateDistance(vertex.get(2));
                side = bSide;
                break;
                case 2:
                double cSide = vertex.get(0).calculateDistance(vertex.get(1));
                side = cSide;
                break;
            }
        altitude=2*calculateArea()/side;
        return altitude;
    }
    @Override
    public void updateTriangle(String namePoint, double changedX, double changedY){
        for(Point p : vertex){

            if(p.getName().equals(namePoint))
            {
                p.updatePoint(new Point(p.getName(), changedX, changedY));
                p.printPoint();
            }
        }
    }
}
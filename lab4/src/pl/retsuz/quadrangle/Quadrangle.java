package pl.retsuz.quadrangle;

import pl.retsuz.point.Point;
import pl.retsuz.triangle.Triangle;

import java.util.ArrayList;

public class Quadrangle implements IQuadrangle {

    protected ArrayList<Point> vertex = new ArrayList<>();

    public Quadrangle(Point a, Point b, Point c, Point d)
    {
        vertex.add(a);
        vertex.add(b);
        vertex.add(c);
        vertex.add(d);
    }
    @Override
    public void printQuadrangle(){
        System.out.println("Quadrangle: ");
        for(Point point: vertex)
            point.printPoint();
    }
    @Override
    public double calculatePerimeter() {
        double perimeter, aSide, bSide, cSide, dSide;
        aSide = vertex.get(0).calculateDistance(vertex.get(1));
        bSide = vertex.get(1).calculateDistance(vertex.get(2));
        cSide = vertex.get(2).calculateDistance(vertex.get(3));
        dSide = vertex.get(3).calculateDistance(vertex.get(0));
        perimeter = aSide + bSide + cSide + dSide;
        return perimeter;
    }

    @Override
    public double calculateArea(){
        double quadrangleArea;
        Triangle firstTriangle = new Triangle(vertex.get(0), vertex.get(1), vertex.get(2));
        Triangle secondTriangle = new Triangle(vertex.get(0), vertex.get(2), vertex.get(3));
        quadrangleArea=firstTriangle.calculateArea()+secondTriangle.calculateArea();
        return  quadrangleArea;

    }

    public double calculateDiagonal(String v1, String v2){
        double diagonal = 0;
        if(vertex.get(0).getName().equals(v1) || vertex.get(0).getName().equals(v2))
        {
             diagonal = vertex.get(0).calculateDistance(vertex.get(2));

        }
        else if(vertex.get(1).getName().equals(v1) || vertex.get(1).getName().equals(v2)) //przekatna miedzy B i D
        {
             diagonal = vertex.get(1).calculateDistance(vertex.get(3));
        }
        return diagonal;
    }
    public void updateCoordinate(String namePoint, double newX, double newY){
        for(Point p : vertex){
            if(p.getName().equals(namePoint))
            {
                p.updatePoint(new Point(p.getName(), newX, newY));
                p.printPoint();
            }
        }

    }
}

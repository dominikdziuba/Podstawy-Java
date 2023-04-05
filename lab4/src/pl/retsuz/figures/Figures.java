package pl.retsuz.figures;
import pl.retsuz.point.Point;
import pl.retsuz.quadrangle.Quadrangle;
import pl.retsuz.triangle.Triangle;
import sort.Sort;

import java.util.ArrayList;

public class Figures {
    public static void main(String[] args) {
        Point P1= new Point("P1", 1.0,2.0);
        Point P2= new Point("P2",2.0,-2.0);
        P1.printPoint();
        P2.printPoint();
        P1.selectCoordinate('y');
        P2.changeCoordinate('y', -3);
        System.out.println("The distance between P1 and P2: " + P1.calculateDistance(P2));
        P1.updatePoint(P2);
        System.out.println("P1 after update to P2: ");
        P1.printPoint();


        Point A = new Point( "A",0.0,0.0);
        Point B = new Point("B",4.0, 0.0);
        Point C = new Point("C", 4.0, 3.0);

        Triangle triangle = new Triangle(A,B,C);
        triangle.printTriangle();
        System.out.println("Perimeter: " + triangle.calculatePerimeter());
        System.out.println("Area: " + triangle.calculateArea());
        System.out.println("Height from point B: "+ triangle.calculateAltitude(1));
        triangle.printTriangle();
        System.out.println("Triangle after update coordinates: ");
        triangle.updateTriangle("A", 2.0,-3.0);
        triangle.updateTriangle("B", 4.0,0.0);
        triangle.updateTriangle("C", 4.0,3.0);

        Point D = new Point("D",0.0,5.0);
        Point temp = new Point("A",0.0,0.0);
        A=temp;
        Quadrangle quadrangle = new Quadrangle(A,B,C,D);
        quadrangle.printQuadrangle();
        System.out.println("Perimeter: " + quadrangle.calculatePerimeter());
        System.out.println("Area: " + quadrangle.calculateArea());
        String first_d_coordinate = "A", second_d_coordinate = "C";
        System.out.println("Diagonal" + first_d_coordinate +" to " + second_d_coordinate +": " +quadrangle.calculateDiagonal(first_d_coordinate,second_d_coordinate));
        quadrangle.printQuadrangle();
        System.out.println("Quadrangle after update coordinates: ");
        quadrangle.updateCoordinate("A", 2.0,-3.0);
        quadrangle.updateCoordinate("B", 4.0,0.0);
        quadrangle.updateCoordinate("C", 4.0,3.0);
        quadrangle.updateCoordinate("D", 0.0,5.0);


        Triangle triangle1 = new Triangle(new Point("A",7.8,22.0), new Point("B",35.7,12.5), new Point("C",12.5, 16.5));
        Triangle triangle2 = new Triangle(new Point("A",1.0,6.3), new Point("B",15.0,6.7), new Point("C",25.5, 25.2));
        Triangle triangle3 = new Triangle(new Point("A",13.5, -6.6), new Point("B",15.4, 3.0), new Point("C",25.3, 45.4));
        ArrayList<Triangle> triangles = new ArrayList<Triangle>();
        triangles.add(triangle);
        triangles.add(triangle1);
        triangles.add(triangle2);
        triangles.add(triangle3);
        Sort.sortTriangles(triangles);

        Quadrangle quadrangle1 = new Quadrangle(new Point("A",3.5,14.5), new Point("B",14.5, 5.6), new Point("C",4.4, 56.5), new Point("D",11.1, 27.6));
        Quadrangle quadrangle2 = new Quadrangle(new Point("A",7.0,2.8), new Point("B",7.7,6.4), new Point("C",44.4, 9.9), new Point("D",10.1, 41.7));
        Quadrangle quadrangle3 = new Quadrangle(new Point("A",14.0, 5.7), new Point("B",12.5, 2.3), new Point("C",26.6, 13.3), new Point("D",9.1, 63.5));
        ArrayList<Quadrangle> quadrangles = new ArrayList<Quadrangle>();
        quadrangles.add(quadrangle);
        quadrangles.add(quadrangle1);
        quadrangles.add(quadrangle2);
        quadrangles.add(quadrangle3);
        Sort.sortQuadrangles(quadrangles);
    }
}

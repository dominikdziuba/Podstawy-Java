package sort;

import java.util.ArrayList;
import java.util.Collections;
import pl.retsuz.triangle.Triangle;
import pl.retsuz.quadrangle.Quadrangle;

public class Sort implements ISort {

    public static void sortTriangles(ArrayList<Triangle> triangles){
        System.out.println("An array of triangles: ");
        ArrayList<Double> arrTriangles = new ArrayList<>();
        for(Triangle triangle : triangles){
            System.out.println(triangle.calculateArea());
            arrTriangles.add(triangle.calculateArea());
        }
        Collections.sort(arrTriangles);
        System.out.println("An array after sorting triangles according area: ");
        for(double area : arrTriangles)
            System.out.println(area);
    }

    public static void sortQuadrangles(ArrayList<Quadrangle> quadrangles){
        System.out.println("An array of quadrangles: ");
        ArrayList<Double> arrQuadrangles = new ArrayList<>();
        for(Quadrangle quadrangle : quadrangles){
            System.out.println(quadrangle.calculateArea());
            arrQuadrangles.add(quadrangle.calculateArea());
        }
        Collections.sort(arrQuadrangles);
        System.out.println("An array after sorting quadrangles according area: ");
        for(double area : arrQuadrangles)
            System.out.println(area);

    }

}

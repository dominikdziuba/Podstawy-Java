package sort;

import pl.retsuz.quadrangle.Quadrangle;
import pl.retsuz.triangle.Triangle;

import java.util.ArrayList;

public interface ISort {

    static void sortTriangles(ArrayList<Triangle> t){};

    static void sortQuadrangles(ArrayList<Quadrangle> t){};
}

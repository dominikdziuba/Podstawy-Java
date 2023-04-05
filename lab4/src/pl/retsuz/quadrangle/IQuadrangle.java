package pl.retsuz.quadrangle;

public interface IQuadrangle {
     void printQuadrangle();
     double calculatePerimeter();
     double calculateArea();
     double calculateDiagonal(String one, String two);
     void updateCoordinate(String name, double new_x, double new_y);
}

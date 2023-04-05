package pl.retsuz.triangle;

public interface ITriangle {
     void printTriangle();

     double calculatePerimeter();

     double calculateArea();

     double calculateAltitude(int choice);

     void updateTriangle(String name, double new_x, double new_y);
}

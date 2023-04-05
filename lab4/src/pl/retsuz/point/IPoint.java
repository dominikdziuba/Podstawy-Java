package pl.retsuz.point;

public interface IPoint {
     double getX();
     double getY();
     String getName();
     void setX(double x);
     void setY(double y);
     void printPoint();
     void selectCoordinate(char nameCoordinate);
     void changeCoordinate(char nameCoordinate, double newValue);
     double calculateDistance(Point p);
     void updatePoint(Point p);
}

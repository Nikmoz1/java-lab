
public class quadrangle {
    private Point[] vertices = new Point[4];

    public quadrangle(Point p1, Point p2, Point p3, Point p4) {
        vertices[0] = p1;
        vertices[1] = p2;
        vertices[2] = p3;
        vertices[3] = p4;
    }

    public double calculateDistance(Point p1, Point p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calculatePerimeter() {
        double perimeter = 0;
        for (int i = 0; i < 3; i++) {
            perimeter += calculateDistance(vertices[i], vertices[i + 1]);
        }
        perimeter += calculateDistance(vertices[3], vertices[0]);
        return perimeter;
    }
public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 4);
        Point p3 = new Point(3, 4);
        Point p4 = new Point(3, 0);

        quadrangle square = new quadrangle(p1, p2, p3, p4);

        Point p5 = new Point(0, 0);
        Point p6 = new Point(0, 6);
        Point p7 = new Point(4, 6);
        Point p8 = new Point(4, 0);

        quadrangle rectangle = new quadrangle(p5, p6, p7, p8);

        double squareArea = square.calculateArea();
        double squarePerimeter = square.calculatePerimeter();

        double rectangleArea = rectangle.calculateArea();
        double rectanglePerimeter = rectangle.calculatePerimeter();

        System.out.println("Square Area: " + squareArea);
        System.out.println("Square Perimeter: " + squarePerimeter);

        System.out.println("Rectangle Area: " + rectangleArea);
        System.out.println("Rectangle Perimeter: " + rectanglePerimeter);
    }
    public double calculateArea() {
        // Отримуємо координати вершин чотирикутника
        double x1 = vertices[0].getX();
        double y1 = vertices[0].getY();
        double x2 = vertices[1].getX();
        double y2 = vertices[1].getY();
        double x3 = vertices[2].getX();
        double y3 = vertices[2].getY();
        double x4 = vertices[3].getX();
        double y4 = vertices[3].getY();
    
        // Обчислюємо вектори сторін чотирикутника
        double vector1X = x2 - x1;
        double vector1Y = y2 - y1;
        double vector2X = x3 - x2;
        double vector2Y = y3 - y2;
        double vector3X = x4 - x3;
        double vector3Y = y4 - y3;
        double vector4X = x1 - x4;
        double vector4Y = y1 - y4;
    
        // Обчислюємо площу чотирикутника за допомогою векторного аналізу
        double area = 0.5 * Math.abs(vector1X * vector2Y - vector1Y * vector2X +
                                   vector2X * vector3Y - vector2Y * vector3X +
                                   vector3X * vector4Y - vector3Y * vector4X +
                                   vector4X * vector1Y - vector4Y * vector1X);
    
        return area;
    }
    
}

public class Point {
    private double x; // Координата x
    private double y; // Координата y
    private double z; // Координата z (для тривимірного простору)
    private double time; // Час

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0; // За замовчуванням використовуємо двовимірний простір
        this.time = 0; // Початковий час
    }

    public Point(double x, double y, double z) {
        this(x, y);
        this.z = z;
    }

    // Метод для задання руху точки в певному напрямку з заданими швидкістю і прискоренням
    public void move(double vx, double vy, double vz, double ax, double ay, double az, double deltaTime) {
        x += vx * deltaTime + 0.5 * ax * deltaTime * deltaTime;
        y += vy * deltaTime + 0.5 * ay * deltaTime * deltaTime;
        z += vz * deltaTime + 0.5 * az * deltaTime * deltaTime;
        time += deltaTime;
    }

    // Метод для обчислення швидкості точки
    public double calculateSpeed(double deltaTime) {
        double vx = (x - x) / deltaTime;
        double vy = (y - y) / deltaTime;
        double vz = (z - z) / deltaTime;
        return Math.sqrt(vx * vx + vy * vy + vz * vz);
    }

    // Метод для обчислення прискорення точки
    public double calculateAcceleration(double deltaTime) {
        double ax = (x - x) / (0.5 * deltaTime * deltaTime);
        double ay = (y - y) / (0.5 * deltaTime * deltaTime);
        double az = (z - z) / (0.5 * deltaTime * deltaTime);
        return Math.sqrt(ax * ax + ay * ay + az * az);
    }

    // Метод для обчислення відстані між двома точками в заданий момент часу
    public double calculateDistance(Point otherPoint) {
        double dx = x - otherPoint.getX();
        double dy = y - otherPoint.getY();
        double dz = z - otherPoint.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    // Метод для перевірки перетину траєкторій з іншою точкою
    public boolean intersectsWith(Point otherPoint) {
        // Тут ви можете визначити, чи перетинаються траєкторії двох точок
        // на основі їх координат і часу
        // Наприклад, ви можете використовувати рівняння руху і враховувати їх швидкості та прискорення
        // Реалізація цього методу залежить від вашої конкретної задачі.
        return false; // Поки що завжди повертаємо false
    }

    // Getter і Setter методи для координат і часу
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public static void main(String[] args) {
        // точки для тестування
        Point point1 = new Point(0, 0);
        Point point2 = new Point(3, 4, 0); // Тривимірний простір (з координатами x, y, z)

        // Перемістіть точки та обчисліть відстань між ними
        point1.move(1, 2, 0, 0, 0, 0, 2);
        point2.move(1, 1, 0, 0, 0, 0, 2);

        // Обчисліть відстань між точками
        double distance = point1.calculateDistance(point2);

        // Виведіть результат
        System.out.println("Відстань між точкою 1 і точкою 2: " + distance);
    }
}

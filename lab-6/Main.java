// Інтерфейс "Корабель"
interface Ship {
    void sail();
}

// Клас "Вантажний корабель", який реалізує інтерфейс "Корабель"
class CargoShip implements Ship {
    private String name;
    private int cargoCapacity; // Вантажопідйомність в тоннах

    public CargoShip(String name, int cargoCapacity) {
        this.name = name;
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public void sail() {
        System.out.println("Вантажний корабель " + name + " відпливає.");
    }

    public void loadCargo() {
        System.out.println("Завантажено " + cargoCapacity + " тонн вантажу на корабель " + name);
    }
}

// Клас "Танкер", який також реалізує інтерфейс "Корабель"
class Tanker implements Ship {
    private String name;
    private int oilCapacity; // Поємність для нафти в тоннах

    public Tanker(String name, int oilCapacity) {
        this.name = name;
        this.oilCapacity = oilCapacity;
    }

    @Override
    public void sail() {
        System.out.println("Танкер " + name + " відпливає.");
    }

    public void loadOil() {
        System.out.println("Завантажено " + oilCapacity + " тонн нафти на танкер " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Ship ship1 = new CargoShip("Вантажник 1", 5000);
        Ship ship2 = new Tanker("Танкер 1", 3000);

        ship1.sail();
        ship2.sail();

        // Поліморфізм: викликаємо методи для конкретних типів кораблів
        if (ship1 instanceof CargoShip) {
            ((CargoShip) ship1).loadCargo();
        }

        if (ship2 instanceof Tanker) {
            ((Tanker) ship2).loadOil();
        }
    }
}

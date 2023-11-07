import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Базовий клас для електроприладів
class ElectricalAppliance {
    private String name;
    private int power; // Потужність в Ваттах (Вт)
    private boolean isPluggedIn; // Показує, чи включений прилад

    public ElectricalAppliance(String name, int power) {
        this.name = name;
        this.power = power;
        this.isPluggedIn = false; // При створенні за замовчуванням прилад не включений
    }

    // Метод для включення приладу
    public void plugIn() {
        isPluggedIn = true;
    }

    // Метод для вимкнення приладу
    public void unplug() {
        isPluggedIn = false;
    }

    public int getPower() {
        return isPluggedIn ? power : 0;
    }

    public boolean isPluggedIn() {
        return isPluggedIn;
    }

    @Override
    public String toString() {
        return name + " (Потужність: " + power + " Вт)";
    }
}

// Клас для представлення квартири
class Apartment {
    private List<ElectricalAppliance> appliances = new ArrayList<>();

    // Метод для додавання приладу до квартири
    public void addAppliance(ElectricalAppliance appliance) {
        appliances.add(appliance);
    }

    // Метод для підрахунку загальної споживаної потужності
    public int calculateTotalPower() {
        int totalPower = 0;
        for (ElectricalAppliance appliance : appliances) {
            totalPower += appliance.getPower();
        }
        return totalPower;
    }

    // Метод для сортування приладів за потужністю
    public void sortAppliancesByPower() {
        Collections.sort(appliances, (a1, a2) -> a2.getPower() - a1.getPower());
    }

    // Метод для пошуку приладу в заданому діапазоні потужності
    public List<ElectricalAppliance> findAppliancesInPowerRange(int minPower, int maxPower) {
        List<ElectricalAppliance> result = new ArrayList<>();
        for (ElectricalAppliance appliance : appliances) {
            if (appliance.getPower() >= minPower && appliance.getPower() <= maxPower) {
                result.add(appliance);
            }
        }
        return result;
    }
}

public class Electro {
    public static void main(String[] args) {
        ElectricalAppliance tv = new ElectricalAppliance("Телевізор", 100);
        ElectricalAppliance fridge = new ElectricalAppliance("Холодильник", 150);
        ElectricalAppliance laptop = new ElectricalAppliance("Ноутбук", 50);

        Apartment apartment = new Apartment();
        apartment.addAppliance(tv);
        apartment.addAppliance(fridge);
        apartment.addAppliance(laptop);

        tv.plugIn();
        fridge.plugIn();

        System.out.println("Загальна потужність: " + apartment.calculateTotalPower() + " Вт");

        apartment.sortAppliancesByPower();
        System.out.println("Прилади, відсортовані за потужністю:");
        for (ElectricalAppliance appliance : apartment.findAppliancesInPowerRange(50, 150)) {
            System.out.println(appliance);
        }
    }
}

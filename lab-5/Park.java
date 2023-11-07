public class Park {
    private String name;
    private Attraction[] attractions;

    public Park(String name, int numAttractions) {
        this.name = name;
        attractions = new Attraction[numAttractions];
    }

    // Внутрішній клас для представлення атракціону
    class Attraction {
        private String name;
        private int workingHours; // Час роботи в годинах
        private double cost; // Вартість

        public Attraction(String name, int workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Атракціон: " + name + ", Час роботи: " + workingHours + " год, Вартість: " + cost + " грн";
        }
    }

    // Метод для додавання атракціону в парк
    public void addAttraction(int index, String name, int workingHours, double cost) {
        attractions[index] = new Attraction(name, workingHours, cost);
    }

    // Метод для виведення інформації про атракції
    public void listAttractions() {
        System.out.println("Атракції у парку \"" + name + "\":");
        for (Attraction attraction : attractions) {
            if (attraction != null) {
                System.out.println(attraction);
            }
        }
    }

    public static void main(String[] args) {
        Park park = new Park("Парк розваг", 5);
        
        park.addAttraction(0, "Карусель", 4, 50.0);
        park.addAttraction(1, "Лабіринт", 2, 30.0);
        park.addAttraction(2, "Гойдалка", 3, 40.0);
        
        park.listAttractions();
    }
}

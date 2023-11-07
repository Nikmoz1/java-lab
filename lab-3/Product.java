import java.util.ArrayList;
import java.util.List;

public class Product implements product {
    private int id;
    private String name;
    private String upc;
    private String manufacturer;
    private double price;
    private int shelfLife;
    private int quantity;

    public Product(int id, String name, String upc, String manufacturer, double price, int shelfLife, int quantity) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.price = price;
        this.shelfLife = shelfLife;
        this.quantity = quantity;
    }

    // Getter і Setter методи для всіх полів
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", upc='" + upc + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", shelfLife=" + shelfLife +
                ", quantity=" + quantity +
                '}';
    }

    public static List<Product> createProductArray() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product1", "UPC1", "Manufacturer1", 10.0, 30, 50));
        products.add(new Product(2, "Product2", "UPC2", "Manufacturer2", 20.0, 60, 40));
        products.add(new Product(3, "Product3", "UPC3", "Manufacturer3", 30.0, 90, 20));
        return products;
    }

    public static List<Product> findProductsByName(List<Product> products, String searchName) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(searchName)) {
                result.add(product);
            }
        }
        return result;
    }

    public static List<Product> findProductsByNameAndPrice(List<Product> products, String searchName, double maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(searchName) && product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    public static List<Product> findProductsByShelfLife(List<Product> products, int minShelfLife) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getShelfLife() > minShelfLife) {
                result.add(product);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Product> products = createProductArray();

        // a) список товарів для заданого найменування
        String searchName = "Product1";
        List<Product> productsByName = findProductsByName(products, searchName);
        System.out.println("Товари з найменуванням '" + searchName + "':");
        for (product product : productsByName) {
            System.out.println(product);
        }

        // b) список товарів для заданого найменування, ціна яких не перевершує задану
        double maxPrice = 25.0;
        List<Product> productsByNameAndPrice = findProductsByNameAndPrice(products, searchName, maxPrice);
        System.out.println("Товари з найменуванням '" + searchName + "' та ціною не більше " + maxPrice + ":");
        for (product product : productsByNameAndPrice) {
            System.out.println(product);
        }

        // c) список товарів, термін зберігання яких більше заданого
        int minShelfLife = 45;
        List<Product> productsByShelfLife = findProductsByShelfLife(products, minShelfLife);
        System.out.println("Товари з терміном зберігання більше " + minShelfLife + " днів:");
        for (product product : productsByShelfLife) {
            System.out.println(product);
        }
    }
}

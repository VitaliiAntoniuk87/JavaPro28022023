import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Product {

    private String type;
    private double price;
    private boolean isDiscounted;
    private final LocalDateTime createDate;
    private static int counter;
    private final int id;

    public Product(String type, double price, boolean isDiscounted) {
        counter++;
        this.id = counter;
        this.type = type;
        this.price = price;
        this.isDiscounted = isDiscounted;
        this.createDate = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && isDiscounted == product.isDiscounted && id == product.id && Objects.equals(type, product.type) && Objects.equals(createDate, product.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price, isDiscounted, createDate, id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type=" + type +
                ", price=" + price +
                ", isDiscounted=" + isDiscounted +
                ", createDate=" + createDate +
                '}';
    }

    public static List<Product> filterByTypeAndPrice(List<Product> products, String type, int price) {
        return products.stream()
                .filter(e -> e.getType().equals(type))
                .filter(e -> e.getPrice() > price)
                .toList();
    }

    public static List<Product> filterByTypeAndDiscount(List<Product> products, String type, double discountPercent) {
        return products.stream()
                .filter(e -> e.getType().equals(type))
                .filter(Product::isDiscounted)
                .peek(e -> e.setPrice(e.getPrice() * ((100.0 - discountPercent) / 100)))
                .toList();
    }

    public static Product getCheapestProductByType(List<Product> products, String type) throws Exception {
        return products.stream()
                .filter(e -> e.getType().equals(type))
                .min(Product::compareByPrice)
                .orElseThrow(() -> new Exception("Product " + type + " not found"));
    }

    public static List<Product> getLastCreatedProducts(List<Product> products, int productElementsQuantityToReturn) {
        return products.stream()
                .sorted(Collections.reverseOrder(Product::compareByID))
                .limit(productElementsQuantityToReturn)
                .toList();
    }

    public static double getCalculateProductSumByTypeCreateDate(List<Product> products, String type, int price) {
        return products.stream()
                .filter(e -> e.getType().equals(type))
                .filter(e -> e.getCreateDate().getYear() == LocalDateTime.now().getYear())
                .filter(e -> e.getPrice() < price)
                .mapToDouble(Product::getPrice)
                .sum();

    }

    public static Map<String, List<Product>> groupByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.toMap(Product::getType, v -> {
                            ArrayList<Product> mapValue = new ArrayList<>();
                            mapValue.add(v);
                            return mapValue;
                        },
                        (v, c) -> {
                            c.addAll(v);
                            return c;
                        }
                ));
    }

    private int compareByPrice(Product product) {
        return Double.compare(this.getPrice(), product.getPrice());
    }

    private int compareByID(Product product) {
        return Integer.compare(this.getId(), product.getId());
    }

}

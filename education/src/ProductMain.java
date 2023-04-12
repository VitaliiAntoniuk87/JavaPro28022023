import java.util.List;

public class ProductMain {

    public static void main(String[] args) throws Exception {

        List<Product> products = List.of(
                new Product("food", 60.0, true),
                new Product("toy", 330.0, true),
                new Product("book", 290.0, true),
                new Product("book", 18.0, true),
                new Product("book", 73.0, false),
                new Product("book", 273.0, false)
        );

//        1.2:
//        System.out.println(Product.filterByTypeAndPrice(products, "book", 250));

//        2.2:
//        System.out.println(Product.filterByTypeAndDiscount(products, "book", 10));

//        3.2 & 3.3:
//        System.out.println(Product.getCheapestProductByType(products,"book"));

//        4.2:
//        System.out.println(Product.getLastCreatedProducts(products,3));

//        5.2:
//        System.out.println(Product.getCalculateProductSumByTypeCreateDate(products, "book", 75));

//        6.2:
        System.out.println(Product.groupByType(products));
    }
}

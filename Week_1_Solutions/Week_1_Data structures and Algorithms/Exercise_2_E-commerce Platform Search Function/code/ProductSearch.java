import java.util.Arrays;
import java.util.Comparator;

public class ProductSearch {

    // linear search by productName
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // binary search by productId
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = products[mid].getProductId();

            if (midId == targetId) {
                return products[mid];
            } else if (midId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Laptop", "Electronics"),
            new Product(101, "Phone", "Electronics"),
            new Product(110, "Shoes", "Footwear"),
            new Product(103, "Watch", "Accessories"),
            new Product(107, "Backpack", "Bags")
        };

        System.out.println("Linear Search by Product Name :");
        String searchName = "Shoes";
        Product resultByName = linearSearch(products, searchName);
        if (resultByName != null) {
            System.out.println("Found: " + resultByName);
        } else {
            System.out.println(searchName + " not found.");
        }

        System.out.println("\n Sorting products by Product ID for Binary Search : ");
        //used comparator to sort by product id
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        System.out.println("Binary Search by Product ID:");
        int searchId = 103;
        Product resultById = binarySearch(products, searchId);
        if (resultById != null) {
            System.out.println("Found: " + resultById);
        } else {
            System.out.println("Product ID " + searchId + " not found.");
        }
    }
}

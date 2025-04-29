package app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Blender", "Appliances", 50.0),
                new Product("Smartphone", "Electronics", 800.0),
                new Product("Television", "Electronics", 600.0),
                new Product("Microwave", "Appliances", 80.0)
        );

        Map<String, Double> averagePriceByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        System.out.println("Середня ціна продуктів за категоріями:");
        averagePriceByCategory.forEach((category, avgPrice) ->
                System.out.println(category + ": " + avgPrice));

        String highestCategory = averagePriceByCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Немає категорій");

        System.out.println("Категорія з найвищою середньою ціною: " + highestCategory);
    }
}

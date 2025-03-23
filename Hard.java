importjava.util.ArrayList; 
import java.util.List; 
import java.util.Map;
importj ava.util.stream.Collectors;


class Product { String name; 
               Stringcategory; 
               double price;

//Constructor
publicProduct(Stringname,Stringcategory,doubleprice){ 
  this.name = name;
this.category=category; 
                                                     this.price = price;
}


//Displayproductdetails public void display() {
System.out.println("Name:" +name+ ",Category:" +category+",Price:$"+ price);
}
}


publicclassProductProcessing{
publicstaticvoidmain(String[]args){
// Creating a large dataset of products List<Product>products=newArrayList<>();
products.add(new Product("Laptop", "Electronics", 80000)); products.add(new Product("Phone", "Electronics", 50000)); products.add(new Product("Shoes", "Fashion", 2500)); products.add(new Product("Jeans", "Fashion", 1500)); products.add(new Product("Headphones", "Electronics", 2000)); products.add(new Product("Shirt", "Fashion", 1000)); products.add(new Product("Microwave", "Appliances", 10000)); products.add(new Product("Refrigerator", "Appliances", 30000)); products.add(newProduct("SmartWatch","Electronics",15000)); products.add(new Product("Sofa", "Furniture", 25000)); products.add(new Product("Chair", "Furniture", 5000));


// Grouping products by category System.out.println("\nProductsGroupedbyCategory:");
Map<String,List<Product>>productsByCategory=products.stream()
.collect(Collectors.groupingBy(product->product.category)); productsByCategory.forEach((category, productList) -> {
System.out.println("\nCategory: " + category); productList.forEach(product->product.display());
});
// Finding the most expensive product in each category System.out.println("\nMostExpensiveProductinEachCategory:"); Map<String, Product> mostExpensiveProduct = products.stream()
.collect(Collectors.toMap(product->product.category, product -> product,
(product1,product2)->product1.price >product2.price? product1:product2
));
mostExpensiveProduct.forEach((category, product) -> { System.out.println("Category:"+category+" ->MostExpensiveProduct:"
+product.name +", Price:$" + product.price);
});//Calculatingtheaveragepriceofallproducts double averagePrice = products.stream()
.mapToDouble(product-> product.price)
.average()
.orElse(0.0);
System.out.println("\nAveragePriceofAllProducts:$"+averagePrice);
}}

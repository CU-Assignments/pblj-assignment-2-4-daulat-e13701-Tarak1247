import java.sql.*;
import java.util.Scanner;

publicclassProductCRUD{
//Databasecredentials
privatestaticfinalStringDB_URL="jdbc:mysql://localhost:3306/your_database"; 
private static final String USER = "your_username";
privatestaticfinalStringPASSWORD="your_password";
publicstaticvoidmain(String[]args){
try(Connectionconn=DriverManager.getConnection(DB_URL,USER,PASSWORD); 
    Scanner scanner = new Scanner(System.in)) {

conn.setAutoCommit(false);//Enabletransactionmanagement
while(true){
System.out.println("\n=====ProductCRUDOperations====="); System.out.println("1. Add Product");
System.out.println("2. View Products"); 
System.out.println("3.UpdateProduct"); 
System.out.println("4. Delete Product"); 
System.out.println("5. Exit"); 
System.out.print("Enter your choice: "); 
int choice = scanner.nextInt(); 
  scanner.nextLine(); // Consume newline
switch(choice){ case 1:
addProduct(conn,scanner); break;
case2:
viewProducts(conn); break;
case3:
updateProduct(conn,scanner); break;
case4:
deleteProduct(conn,scanner); break;
case5:
System.out.println("Exitingprogram."); return;
default:
System.out.println("Invalidchoice!Pleaseenteravalidoption.");
}
}
}catch(SQLExceptione){ e.printStackTrace();
}
}
//AddProduct
privatestaticvoidaddProduct(Connectionconn,Scannerscanner){ try {
System.out.print("EnterProductName:"); String name = scanner.nextLine(); System.out.print("Enter Price: ");
doubleprice=scanner.nextDouble(); System.out.print("EnterQuantity:"); int quantity = scanner.nextInt();

Stringquery="INSERTINTOProduct(ProductName,Price,Quantity)VALUES(?,?,?)"; try (PreparedStatement pstmt = conn.prepareStatement(query)) {
pstmt.setString(1, name); pstmt.setDouble(2,price); pstmt.setInt(3, quantity);
introws=pstmt.executeUpdate(); if (rows > 0) {
conn.commit();
System.out.println("Productaddedsuccessfully!");

}
}
}catch(SQLExceptione){ try {
conn.rollback();
}catch(SQLExceptionex){ ex.printStackTrace();
}
System.out.println("Erroraddingproduct:"+e.getMessage());
}
}

//ViewProducts
privatestaticvoidviewProducts(Connectionconn){ String query = "SELECT * FROM Product";
try (Statement stmt = conn.createStatement(); ResultSetrs=stmt.executeQuery(query)){
System.out.println("\n=====ProductList====="); while (rs.next()) {
System.out.println("ID:"+rs.getInt("ProductID")+ ", Name: " + rs.getString("ProductName") +
", Price: " + rs.getDouble("Price") +",Quantity:"+rs.getInt("Quantity"));
}
}catch(SQLExceptione){
System.out.println("Errorfetchingproducts:"+e.getMessage());
}
}
//UpdateProduct
privatestaticvoidupdateProduct(Connectionconn,Scannerscanner){ try {
System.out.print("EnterProductIDtoupdate:"); int id = scanner.nextInt();
scanner.nextLine(); // Consume newline System.out.print("EnternewProductName:"); String name = scanner.nextLine(); System.out.print("Enter new Price: ");
double price = scanner.nextDouble(); System.out.print("EnternewQuantity:"); int quantity = scanner.nextInt();

Stringquery="UPDATEProductSETProductName=?,Price=?,Quantity=?WHERE ProductID=?";
try(PreparedStatementpstmt=conn.prepareStatement(query)){ pstmt.setString(1, name);
pstmt.setDouble(2,price); pstmt.setInt(3, quantity); pstmt.setInt(4, id);
introws=pstmt.executeUpdate(); if (rows > 0) {
conn.commit();
System.out.println("Productupdatedsuccessfully!");
}else{
System.out.println("Productnotfound!");
}

}
}catch(SQLExceptione){ try {
conn.rollback();
}catch(SQLExceptionex){ ex.printStackTrace();
}
System.out.println("Errorupdatingproduct:"+e.getMessage());
}
}

//DeleteProduct
privatestaticvoiddeleteProduct(Connectionconn,Scannerscanner){ try {
System.out.print("EnterProductIDtodelete:"); int id = scanner.nextInt();
Stringquery="DELETEFROMProductWHEREProductID=?";
}                                      
}
}

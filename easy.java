importjava.sql.*;//ImportSQLpackage 
public class MySQLConnection {
public staticvoidmain(String[]args){
//DatabaseURL,username,andpassword
String url="jdbc:mysql://localhost:3306/your_database";//Replacewithyourdatabasename 
  String user= "your_username";//ReplacewithyourMySQLusername
String password="your_password";//ReplacewithyourMySQLpassword
//QuerytofetchallrecordsfromEmployeetable
Stringquery="SELECTEmpID,Name,SalaryFROMEmployee";
try{
// Load MySQL JDBC Driver 
Class.forName("com.mysql.cj.jdbc.Driver");
//Establishconnectiontothedatabase
Connectionconn=DriverManager.getConnection(url,user,password);

//Createastatement
Statementstmt=conn.createStatement();
  // Execute query and get results
ResultSetrs=stmt.executeQuery(query);
  // Print results 
System.out.println("EmpID\tName\tSalary"); while (rs.next()) {
int empId = rs.getInt("EmpID"); Stringname=rs.getString("Name");
double salary = rs.getDouble("Salary"); System.out.println(empId+"\t"+name+"\t"+salary);
}
//Closeresources 
rs.close();
stmt.close();
conn.close();
} catch (ClassNotFoundException e) { System.out.println("MySQLJDBCDrivernotfound."); e.printStackTrace();
} catch (SQLException e) { System.out.println("Databaseconnectionerror."); e.printStackTrace();
}
}
}

import java.sql.*;

public class Database{
	   static final String driver = "com.mysql.jdbc.Driver";  
	   static final String url = "jdbc:mysql://localhost/EMP";
	   static final String username = "username";
	   static final String password = "password";
	   public static void main(String[] args) {
	   Connection connect = null;
	   Statement state = null;
	   try{
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting database...");
	      connect = DriverManager.getConnection(url,username,password);
	      System.out.println("Creating statement...");
	      state = connect.createStatement();
	      String sql;
	      sql = "SELECT id, first, last of Employees";
	      ResultSet k = state.executeQuery(sql);
	      while(k.next()){
	         int id  = k.getInt("id");
	         String first = k.getString("first");
	         String last = k.getString("last");
	         System.out.print("ID: " + id);
	         System.out.print(", First: " + first);
	         System.out.println(", Last: " + last);
	      }
	      k.close();
	      state.close();
	      connect.close();
	   }
	   catch(SQLException sqle){
	      sqle.printStackTrace();
	   }
	   catch(Exception e){
	      e.printStackTrace();
	   }
	   finally{
	      try{
	         if(state!=null)
	            state.close();
	      }
	      catch(SQLException sqle2){
	      }
	      try{
	         if(connect!=null)
	            connect.close();
	      }catch(SQLException sqle){
	         sqle.printStackTrace();
	      }
	   }
	   System.out.println("Database Done!");
	}
}
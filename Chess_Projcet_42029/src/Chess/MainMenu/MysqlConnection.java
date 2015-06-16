
package Chess.MainMenu;
import java.sql.*;
/**
 *Simple Mysql Connection Manager 
 */
public class MysqlConnection {

   public static Connection connectMysql(){      
       try{
           
           Class.forName("com.mysql.jdbc.Driver");          
           Connection connect = DriverManager.getConnection("jdbc:mysql://76.174.11.200/group","root","pachuco909;");
           return connect;
                
       }catch(ClassNotFoundException | SQLException e){
           return null;
       }
   }
}
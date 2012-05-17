import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 

public class MySQLConnector extends PluginListener
{
	
  private static Logger log = Logger.getLogger("Minecraft");

  static boolean useSql;
  static String SQLdriver = "com.mysql.jdbc.Driver";
  static String SQLusername = "root";
  static String SQLpassword = "root";
  static String SQLdb = "jdbc:mysql://localhost:3306/minecraft";


public static void loadSettings()
  {
    
    if (!new File("Example.properties").exists()) {
      FileWriter writer = null;
      try {
        writer = new FileWriter("Example.properties");
        writer.write("useHMsql=true\r\n");
        writer.write("SQLdriver=com.mysql.jdbc.Driver\r\n");
        writer.write("SQLuser=root\r\n");
        writer.write("SQLpass=root\r\n");
        writer.write("SQLdb=jdbc:mysql://localhost:3306/minecraft\r\n");
      } catch (Exception e) {
        log.log(Level.SEVERE, 
          "Exception while creating Example.properties", e);
        try {
          if (writer != null)
            writer.close();
        } catch (IOException ex) {
          log.log(Level.SEVERE, 
            "Exception while closing writer for MySQL.properties", 
            ex);
        }
        try
        {
          if (writer != null)
            writer.close();
        } catch (IOException ex) {
          log.log(Level.SEVERE, 
            "Exception while closing writer for MySQL.properties", 
            e);
        }
      }
      finally
      {
        try
        {
          if (writer != null)
            writer.close();
        } catch (IOException e) {
          log.log(Level.SEVERE, 
            "Exception while closing writer for MySQL.properties", 
            e);
        }
      }
    }
    PropertiesFile properties = new PropertiesFile("MySQL.properties");
    try {
      SQLdriver = properties.getString("SQLdriver", 
        "com.mysql.jdbc.Driver");
      SQLusername = properties.getString("SQLuser", "root");
      SQLpassword = properties.getString("SQLpass", "root");
      SQLdb = properties.getString("SQLdb", 
        "jdbc:mysql://localhost:3306/minecraft");
      useSql = properties.getBoolean("useSql", true);
    }
    catch (Exception e) {
      log.log(Level.SEVERE, 
        "Exception while reading from MySQL.properties", e);
    }
  }
}
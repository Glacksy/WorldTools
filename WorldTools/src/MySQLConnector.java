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
    
    if (!new File("/plugins/config/WorldTools/MySQL.properties").exists()) {
      FileWriter writer = null;
      try {
        writer = new FileWriter("/plugins/config/WorldTools/MySQL.properties");
        writer.write("############################");
        writer.write("# THIS IS CURRENTLY UNUSED #");
        writer.write("############################");
        writer.write("useCanarySQL=true\r\n");
        writer.write("SQLdriver=com.mysql.jdbc.Driver\r\n");
        writer.write("SQLuser=root\r\n");
        writer.write("SQLpass=root\r\n");
        writer.write("SQLdb=jdbc:mysql://localhost:3306/minecraft\r\n");
      } catch (Exception e) {
        log.log(Level.SEVERE, 
          "Exception while creating the properties file", e);
        try {
          if (writer != null)
            writer.close();
        } catch (IOException ex) {
          log.log(Level.SEVERE, 
            "Exception while closing writer for the mysql properties", 
            ex);
        }
        try
        {
          if (writer != null)
            writer.close();
        } catch (IOException ex) {
          log.log(Level.SEVERE, 
            "Exception while closing writer for the mysql properties", 
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
            "Exception while closing writer for the mysql properties", 
            e);
        }
      }
    }
    PropertiesFile properties = new PropertiesFile("/plugins/config/WorldTools/MySQL.properties");
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
        "Exception while reading from the mysql properties", e);
    }
  }
}
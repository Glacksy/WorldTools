/*
 * WorldTools
 * Copyright (C) 2012
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
 

public class MySQLConnector extends PluginListener
{
	
  private static Logger log = Logger.getLogger("Minecraft");

  static boolean useSql;
  static boolean enabled;
  static String SQLdriver = "com.mysql.jdbc.Driver";
  static String SQLusername = "root";
  static String SQLpassword = "root";
  static String SQLdb = "jdbc:mysql://localhost:3306/minecraft";


public static void loadSettings()
  {
    
    if (!new File("/plugins/config/WorldTools/MySQL.properties").exists()) {
      try {
		File f = new File("plugins/config/WorldTools/MySQL.properties");
		BufferedWriter out = new BufferedWriter(new FileWriter(f));
        out.write("############################");out.newLine();
        out.write("# THIS IS CURRENTLY UNUSED #");out.newLine();
        out.write("############################");out.newLine();
        out.write("useCanarySQL=true");out.newLine();
        out.newLine();
        out.write("SQLdriver=com.mysql.jdbc.Driver");out.newLine();
        out.newLine();
        out.write("SQLuser=root");out.newLine();
        out.newLine();
        out.write("SQLpass=root");out.newLine();
        out.newLine();
	    out.write("SQLdb=jdbc:mysql://localhost:3306/minecraft");out.newLine();
		out.newLine();
		} catch (IOException e) {
			log.info("[WorldTools] - Error during creating SQL propertiesfile!");
			e.printStackTrace();
		}
    }
    PropertiesFile properties = new PropertiesFile("/plugins/config/WorldTools/MySQL.properties");
    try {
      SQLdriver = properties.getProperty("SQLdriver");
      SQLusername = properties.getProperty("SQLuser");
      SQLpassword = properties.getProperty("SQLpass");
      SQLdb = properties.getProperty("SQLdb");
      useSql = Boolean.parseBoolean(properties.getProperty("UseCanarySQL"));
    }
    catch (Exception e) {
      log.log(Level.SEVERE, 
        "Exception while reading from the mysql properties", e);
    }
    getConnection();
  }

private static Connection getConnection(){
        try {
                if (useSql)
                        return etc.getConnection().getConnection();
                return DriverManager.getConnection(SQLdb + "?autoReconnect=true&user=" + SQLusername + "&password=" + SQLpassword);
        } catch (SQLException ex) {
                log.info("[WorldTools] exception while connection to database");
        }
        enabled = false;
        return null;
}
}
//end of class
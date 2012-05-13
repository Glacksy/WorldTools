import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

/**
 * This is the main class file for WorldTools
 * @author Glacksy
 */

public class WorldTools extends Plugin {

	  static final WorldToolsListener listener = new WorldToolsListener();
	  
	  private static Logger log = Logger.getLogger("Minecraft");
	  private static Object logger;
	  
	  static String pluginName = "WorldTools";
	  static String version = "2.0 Beta 1";
	  static String Author = "Glacksy";
	  static String Updatr = "Updatr";
	  public static String Ver = "2.0";
	  
	  private final static String Dir = "plugins/config/WorldTools/"; 
	  private final static String Set = "WorldTools.properties";
	  
	//  private static final int SPAWN_RADIUS = 12;
	  
	  private static Location exactSpawn = null;
	  private static PropertiesFile Settings;
	  
	  public static int explosionRad = 4;
	  Server server = etc.getServer();


public void enable()
{
	log.info(pluginName + " " + version + " by " + Author + " Enabled");
	if(Listener.isLatest()){
	log.info("There is an update available for WorldTools ");}
    Listener.LoadAll();
}

public void disable()
{
	log.info(pluginName + " " + version + " by " + Author + " Disabled");
	Listener.UnLoadAll();
}

public void initialize()
{
  PluginLoader loader = etc.getLoader();
  loader.addListener(PluginLoader.Hook.COMMAND, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.EXPLODE, listener, this, PluginListener.Priority.CRITICAL);
  loader.addListener(PluginLoader.Hook.ITEM_USE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.ITEM_PICK_UP, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.ITEM_DROP, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.HEALTH_CHANGE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.LOGIN, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.DISCONNECT, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.BLOCK_RIGHTCLICKED, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.BLOCK_PLACE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.BLOCK_DESTROYED, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.BLOCK_CREATED, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.BLOCK_PHYSICS, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.BLOCK_UPDATE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.DAMAGE, listener, this, PluginListener.Priority.HIGH);
  loader.addListener(PluginLoader.Hook.IGNITE, listener, this, PluginListener.Priority.HIGH);
  loader.addListener(PluginLoader.Hook.FLOW, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.PORTAL_CREATE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.PORTAL_DESTROY, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.LEAF_DECAY, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.COW_MILK, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.EAT, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.DISPENSE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.ENTITY_DESPAWN, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.LIGHTNING_STRIKE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.WEATHER_CHANGE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.THUNDER_CHANGE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.TIME_CHANGE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.OPEN_INVENTORY, listener, this, PluginListener.Priority.CRITICAL);
  loader.addListener(PluginLoader.Hook.PLAYER_MOVE, listener, this, PluginListener.Priority.MEDIUM);
  
  Plugin loaded = etc.getLoader().getPlugin("Updatr");
  if (loaded != null) {
	  log.info(pluginName + " " + version + " by " + Author + " initialized");
  	  log.info(Updatr + "Succesfully loaded");
    }
    else {
      log.info(pluginName + " " + version + " by " + Author + " initialized");
      etc.getLoader().disablePlugin("Updatr");
    }
 
}

public static class Listener extends PluginListener {
    
	// Get Folder and Dir
	public static String getDir() {
		return Dir;
	}
	// Get Properties file
    public static String getSet() {
	    return Set;
    }
    // Return both Folder and Props
    public static String getDirSet() { 
    	return Dir+Set;
    }
    // Return pluginName
    public static String pluginName() { 
    	return pluginName;
    }
    // Return Updatr logger
    public static Object logger() { 
    	return logger;
    }
    // Return settings
    public static PropertiesFile Settings() {  
    	return Settings;
    }
    public static Location exactSpawn() {  
    	return exactSpawn;
    }
    public static void LoadAll() {
    	updatr.createUpdatrFile();
    	exactspawn.EnableExactSpawn();
    	listener.createfile();
    	WorldToolsVoids.EnableHelp();
    }
    public static void UnLoadAll() {
    	WorldToolsVoids.EnableHelp();
    	exactspawn.DisableExactSpawn();
    }
    
    
 /**
  * Check if your running latest version
  * @author darkdiplomat
  * @return
  */
    public static boolean isLatest(){
	String address = "http://www.topica-rp.com/Download/version.html";
	URL url = null;
	try {
		url = new URL(address);
	} catch (MalformedURLException e) {
		return true;
	}
	String[] Vpre = new String[1]; 
	BufferedReader in;
	try {
		in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			if (inputLine.contains("WorldTools=")){
				Vpre = inputLine.split("=");
				Ver = Vpre[1].replace("</p>", "");
			}
		}
		in.close();
	} catch (IOException e) {
		return true;
	}
	return (version.equals(Ver));
} 
}
}

/* public class radiuss extends PluginListener{
        public boolean onCommand(Player player,String[] split){
                if (split[0].equalsIgnoreCase("/wReplace")){
                        if (split.length <4 || split.length >4){
                                player.notify("§cThe correct usage is '/wreplace fromid toid radius'");
                                return true;
                        }
                    try 
                        {
                        Integer.parseInt(split[1]); Integer.parseInt(split[2]);Integer.parseInt(split[3]);}catch(NumberFormatException nfe){player.notify("§cThe correct usage is '/wreplace fromid toid radius'"); return true;}
                        int fromid = Integer.parseInt(split[1]);
                        int toid = Integer.parseInt(split[2]);
                        int radius = Integer.parseInt(split[3]);
                        replace(player,fromid,toid,radius);
                        
                        player.sendMessage("§aBlocks Replaced.");
                        return true;
                }
                return false;
        }
        

        
*/


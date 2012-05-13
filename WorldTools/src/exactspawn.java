


    public class exactspawn extends PluginListener{

	private static Location exactSpawn = null;
	private static PropertiesFile properties;
	private static boolean ExactSpawn;
	
	/**
	 * Load and enable ExactSpawn feature
	 * This load onEnable
	 */
	public static void EnableExactSpawn() {
		
		properties = new PropertiesFile(WorldTools.Listener.getDirSet());
		   ExactSpawn = Boolean.parseBoolean(properties.getProperty("enable-exact-spawn"));
		PropertiesFile props = new PropertiesFile(WorldTools.Listener.getDirSet());
		  if ((ExactSpawn) && (props.keyExists("exact-spawn"))) {
		    String[] data = props.getString("exact-spawn").split(",");
		    exactSpawn = new Location();
		    exactSpawn.x = Double.parseDouble(data[0]);
		    exactSpawn.y = Double.parseDouble(data[1]);
		    exactSpawn.z = Double.parseDouble(data[2]);
		    exactSpawn.rotX = Float.parseFloat(data[3]);
		    exactSpawn.rotY = Float.parseFloat(data[4]);
		  }
	}
	
	/**
	 * Disable ExactSpawn feature
	 * This load onDisable to disable it
	 */
	public static void DisableExactSpawn() {
		exactSpawn = null;
	}
	
	
	public void onLogin(Player player)
    {
      Location spawn = null;
      if (exactSpawn != null)
        spawn = exactSpawn;
      else {
        spawn = etc.getServer().getWorld(0).getSpawnLocation();
      }

      if ((Math.abs(player.getX() - spawn.x) <= 12.0D) && (Math.abs(player.getZ() - spawn.z) <= 12.0D))
        player.teleportTo(spawn);
    }

    public boolean onHealthChange(Player player, int oldValue, int newValue) {
      Location spawn = null;
      if (exactSpawn != null)
        spawn = exactSpawn;
      else {
        spawn = etc.getServer().getWorld(0).getSpawnLocation();
      }

      if ((oldValue <= 0) && (newValue == 20) && 
        (Math.abs(player.getX() - spawn.x) <= 12.0D) && (Math.abs(player.getZ() - spawn.z) <= 12.0D)) {
        player.teleportTo(spawn);
      }

      return false;
    }
    
    public boolean onCommand(Player Player, String[] cmd) 
    {
    if ((cmd[0].equalsIgnoreCase("/setspawn")) && (Player.canUseCommand("/setspawn"))) {
        exactSpawn = new Location(Player.getX(), Player.getY(), Player.getZ(), Player.getRotation(), Player.getPitch());
        PropertiesFile props = new PropertiesFile("worldtools.properties");
        props.setString("exact-spawn", exactSpawn.x + "," + exactSpawn.y + "," + exactSpawn.z + "," + exactSpawn.rotX + "," + exactSpawn.rotY);
        return false;
      }if ((cmd[0].equalsIgnoreCase("/spawn")) && (Player.canUseCommand("/spawn")) && (exactSpawn != null)) {
        Player.teleportTo(exactSpawn);
        return true;
      }
    return false;
    }

}

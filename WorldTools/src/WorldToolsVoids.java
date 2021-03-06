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

public class WorldToolsVoids extends PluginListener {

	static Player player;
	private static Location exactSpawn = null;
	private static PropertiesFile properties;
	private static boolean ExactSpawn;
	
	/**
     * Enable/add help commands onDisable
     */
    public static void EnableHelp() 
    {
   	  etc.getInstance().addCommand("/melt <radius>", "Melt snow/ice in a custom radius");
   	  etc.getInstance().addCommand("/snow <radius>", "Place snow and ice in a custom radius");
   	  etc.getInstance().addCommand("/kill <player>", "Kill yourself or another player!");
   	  etc.getInstance().addCommand("/suicide", "Kill yourself");
   	  etc.getInstance().addCommand("/heal <player>", "Heal another player!");
   	  etc.getInstance().addCommand("/heal", "Heal yourself to full health!");
   	  etc.getInstance().addCommand("/wreplace <from> <to> <radius>", "Replace blocks in a custom radius");
   	  etc.getInstance().addCommand("/killmobs", "Kill all mobs");
   	  etc.getInstance().addCommand("/cmob <radius>", "Kill all mobs in a custom radius");
   	  etc.getInstance().addCommand("/waterfix <radius>", "Fix water in a custom radius");
   	  etc.getInstance().addCommand("/lavafix <radius>", "Fix lava in a custom radius");
   	  etc.getInstance().addCommand("/ext <radius>", "Extinguish fire in a custom radius");
   	  etc.getInstance().addCommand("/drain <radius>", "Drain water and lava in a custom radius");
   	  etc.getInstance().addCommand("/drainwater <radius>", "Drain water in a custom radius");
   	  etc.getInstance().addCommand("/drainlava <radius>", "Drain lava in a custom radius");
      etc.getInstance().addCommand("/save-inv", "Save all inventories!");
      etc.getInstance().addCommand("/freeze <player>", "Freeze a player.");
      etc.getInstance().addCommand("/switchworld <world>", "Switch to another world!");
      etc.getInstance().addCommand("/forcewarp <player> <warp>", "Force a player to a warp location!");
      etc.getInstance().addCommand("/getip <player>", "Get the ip of a player.");
      etc.getInstance().addCommand("/feed <player>", "Feed another player!");
      etc.getInstance().addCommand("/lighter", "Give yourself a lighter!");
    }
    
    /**
     * Disable help commands onDisable
     */
    public static void DisableHelp() 
    {
   		etc.getInstance().removeCommand("/melt <radius>");
   		etc.getInstance().removeCommand("/snow <radius>");
   		etc.getInstance().removeCommand("/kill <player>");
   		etc.getInstance().removeCommand("/suicide");
   		etc.getInstance().removeCommand("/heal <player>");
   		etc.getInstance().removeCommand("/wreplace <from> <to> <radius>");
   		etc.getInstance().removeCommand("/killmobs");
   		etc.getInstance().removeCommand("/waterfix");
   		etc.getInstance().removeCommand("/lavafix <radius>");
   		etc.getInstance().removeCommand("/ext <radius>");
   		etc.getInstance().removeCommand("/drain <radius>");
   		etc.getInstance().removeCommand("/drainwater <radius>");
   		etc.getInstance().removeCommand("/drainlava <radius>");
   		etc.getInstance().removeCommand("/heal");
   		etc.getInstance().removeCommand("/save-inv");
   		etc.getInstance().removeCommand("/cmob <radius>");
   		etc.getInstance().removeCommand("/switchworld <world>");
   		etc.getInstance().removeCommand("/forcewarp <player> <warp>");
   		etc.getInstance().removeCommand("/getip <player>");
   		etc.getInstance().removeCommand("/feed <player>");
   		etc.getInstance().removeCommand("/freeze <player>");
   		etc.getInstance().removeCommand("/save-inv");
   		etc.getInstance().removeCommand("/lighter");
   		
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
        spawn = player.getWorld().getSpawnLocation();
      }

      if ((Math.abs(player.getX() - spawn.x) <= 12.0D) && (Math.abs(player.getZ() - spawn.z) <= 12.0D))
        player.teleportTo(spawn);
    }
    
    public boolean onHealthChange(Player player, int oldValue, int newValue) {
        Location spawn = null;
        if (exactSpawn != null)
          spawn = exactSpawn;
        else {
          spawn = player.getWorld().getSpawnLocation();
        }

        if ((oldValue <= 0) && (newValue == 20) && 
          (Math.abs(player.getX() - spawn.x) <= 12.0D) && (Math.abs(player.getZ() - spawn.z) <= 12.0D)) {
          player.teleportTo(spawn);
        }

        return false;
      }
    
    
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
	 * Changed it to use the new and powerful code, so only players will be hurt while world wont!
	 * @author benni1601
	 *
	 * @param a
	 * @return
	 */
	public static int getArmour(Player a) {
		int armour = 0;
		int id;
		Item item;
		
		// Helmet
		item = a.getInventory().getItemFromSlot(39);
		id = (item != null) ? item.getItemId() : -1;
		if (id == 306) { // Iron
			armour += 2;
		}
		else if (id == 298) { // Leather
			armour += 1;
		}
		else if (id == 310) { // Diamond
			armour += 3;
		}
		else if (id == 302) { // Chainmail
			armour += 2;
		}
		else if (id == 314) { // Golden
			armour += 2;
		}
		
		// Chestplate
		item = a.getInventory().getItemFromSlot(38);
		id = (item != null) ? item.getItemId() : -1;
		if (id == 307) { // Iron
			armour += 6;
		}
		else if (id == 299) { // Leather
			armour += 3;
		}
		else if (id == 311) { // Diamond
			armour += 8;
		}
		else if (id == 303) { // Chainmail
			armour += 5;
		}
		else if (id == 315) { // Golden
			armour += 5;
		}
		
		// Leggings
		item = a.getInventory().getItemFromSlot(37);
		id = (item != null) ? item.getItemId() : -1;
		if (id == 308) { // Iron
			armour += 5;
		}
		else if (id == 300) { // Leather
			armour += 2;
		}
		else if (id == 312) { // Diamond
			armour += 6;
		}
		else if (id == 304) { // Chainmail
			armour += 4;
		}
		else if (id == 316) { // Golden
			armour += 3;
		}
		
		// Boots
		item = a.getInventory().getItemFromSlot(36);
		id = (item != null) ? item.getItemId() : -1;
		if (id == 309) { // Iron
			armour += 2;
		}
		else if (id == 301) { // Leather
			armour += 1;
		}
		else if (id == 313) { // Diamonds
			armour += 3;
		}
		else if (id == 305) { // Chainmail
			armour += 1;
		}
		else if (id == 317) { // Golden
			armour += 1;
		}
		
		return armour;
	}
	
	public static int calculateDistance(Player a, Block b) {
		return (int)Math.round(Math.sqrt(Math.pow(a.getX() - b.getX(), 2.0D) + Math.pow(a.getY() - b.getY(), 2.0D) + Math.pow(a.getZ() - b.getZ(), 2.0D)));
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int calculateDamage(Player a, Block b) {
		double damage = -1.75 * getArmour(a) + 42;
		int distance = calculateDistance(a, b);
		
		if (distance == 0 || distance == 1) {
			damage *= 1.00; // 100 %
		}
		else if (distance == 2) {
			damage *= 0.75; // 75 %
		}
		else if (distance == 3) {
			damage *= 0.50; // 50 %
		}
		else if (distance == 4) {
			damage *= 0.25; // 25 %
		}
		else {
			damage *= 0.00; // 0 %
		}
		
		return (int)Math.round(damage);
	}
	 
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isInExplosionRadius(Player a, Block b)
	{
	    return calculateDistance(a, b) <= WorldTools.explosionRad;
	}
	
	public static void airout(Block b, int radius){
		int xmin = (int)b.getX()-radius;
		int xmax = (int)b.getX()+radius;
		int ymin = (int)b.getY()-radius;
		int ymax = (int)b.getY()+radius;
		int zmin = (int)b.getZ()-radius;
		int zmax = (int)b.getZ()+radius;
		for (int x = xmin; x <= xmax; x++) {
			for (int y = ymin; y <= ymax; y++) {
				for (int z = zmin; z <= zmax; z++) {
					if (b.getWorld().getBlockAt(x, y, z).getType() == 8 || b.getWorld().getBlockAt(x, y, z).getType() == 9){b.getWorld().setBlockAt(0, x, y, z);}
				}
			}
		}
	  }
	/**
	 *
	 * @param b
	 * @param radius
	 */
	public static void fillarea(Block b, int radius){
		int xmin = (int)b.getX()-radius;
		int xmax = (int)b.getX()+radius;
		int ymin = (int)b.getY()-radius;
		int ymax = (int)b.getY()+radius;
		int zmin = (int)b.getZ()-radius;
		int zmax = (int)b.getZ()+radius;
		for (int x = xmin; x <= xmax; x++) {
			for (int y = ymin; y <= ymax; y++) {
				for (int z = zmin; z <= zmax; z++) {
					if (b.getWorld().getBlockAt(x, y, z).getType() == 0){b.getWorld().setBlockAt(9, x, y, z);}
				}
			}
		}
	  }
	/**
	 * 
	 * @param b
	 * @param radius
	 */
	public static void replacewater(Block b, int radius){
		int radi = radius+1;
		int xmin = (int)b.getX()-radi;
		int xmax = (int)b.getX()+radi;
		int ymin = (int)b.getY()-radi;
		int ymax = (int)b.getY()+radi;
		int zmin = (int)b.getZ()-radi;
		int zmax = (int)b.getZ()+radi;
		for (int x = xmin; x <= xmax; x++) {
			for (int y = ymin; y <= ymax; y++) {
				for (int z = zmin; z <= zmax; z++) {
					if (b.getWorld().getBlockAt(x, y, z).getType() == 8 || b.getWorld().getBlockAt(x, y, z).getType() == 9){b.getWorld().setBlockAt(8, x, y, z);}
				}
			}
		}
	  }
	/**
	 * @param b
	 * @param radius
	 * @return
	 */
	public static boolean isinarea(Block b,int radius){
		int radi = radius+1;
		int xmin = (int)b.getX()-radi;
		int xmax = (int)b.getX()+radi;
		int ymin = (int)b.getY()-radi;
		int ymax = (int)b.getY()+radi;
		int zmin = (int)b.getZ()-radi;
		int zmax = (int)b.getZ()+radi;
		for (int x = xmin; x <= xmax; x++) {
			for (int y = ymin; y <= ymax; y++) {
				for (int z = zmin; z <= zmax; z++) {
					if (b.getWorld().getBlockAt(x, y, z).getType() == 19){return true;}
				}
			}
		}
		return false;
	}
/**
 * 
 * @param b
 * @param radius
 * @return
 */
	public boolean isinarea2(Block b,int radius){
		int radi = radius;
		int xmin = (int)b.getX()-radi;
		int xmax = (int)b.getX()+radi;
		int ymin = (int)b.getY()-radi;
		int ymax = (int)b.getY()+radi;
		int zmin = (int)b.getZ()-radi;
		int zmax = (int)b.getZ()+radi;
		for (int x = xmin; x <= xmax; x++) {
			for (int y = ymin; y <= ymax; y++) {
				for (int z = zmin; z <= zmax; z++) {
					if (b.getWorld().getBlockAt(x, y, z).getType() == 19){return true;}
				}
			}
		}
		return false;
	}
	/**
	 * 
	 * @param b
	 * @param radius
	 * @return
	 */
		public static boolean iswater(Block b, int radius){
			int xmin = (int)b.getX()-radius;
			int xmax = (int)b.getX()+radius;
			int ymin = (int)b.getY()-radius;
			int ymax = (int)b.getY()+radius;
			int zmin = (int)b.getZ()-radius;
			int zmax = (int)b.getZ()+radius;
			for (int x = xmin; x <= xmax; x++) {
				for (int y = ymin; y <= ymax; y++) {
					for (int z = zmin; z <= zmax; z++) {
						if (b.getWorld().getBlockAt(x, y, z).getType() == 8 || b.getWorld().getBlockAt(x, y, z).getType() == 9){return true;}
					}
				}
			}
		return false;
	  }
		
	    /**
	     * 
	     * Setup replace feature and radius
	     * @author Spenk
	     *
		 * @param player
		 * @param from
		 * @param to
		 * @param radius
		 */
	     public static void replace(Player player, int from, int to, int radius){
	         int xmin = (int)player.getX()-radius;
	         int xmax = (int)player.getX()+radius;
	         int ymin = (int)player.getY()-radius;
	         int ymax = (int)player.getY()+radius;
	         int zmin = (int)player.getZ()-radius;
	         int zmax = (int)player.getZ()+radius;
	        
	         for (int x = xmin; x <= xmax; x++) {
	                 for (int y = ymin; y <= ymax; y++) {
	                         for (int z = zmin; z <= zmax; z++) {    
	                                 if (player.getWorld().getBlockAt(x, y, z).getType() == from){player.getWorld().setBlockAt(to, x, y, z);}
	                         }
	                       }
	                     }
	                   }
	     
	     
	     /**
	      * Count mobs in the world the player perform the command
	      * @author Billyoyo
	      * @param r
	      */
	     public static void cMob(int r)
	     {
	       World world = player.getWorld();
	       for (int x = -r; x <= r; x++)
	         for (int z = -r; z <= r; z++)
	           for (int y = -r; y <= r; y++) {
	             Block check = world.getBlockAt((int)player.getX() + x, (int)player.getY() + y, (int)player.getZ() + z);
	             for (Mob m : world.getMobList()) {
	               if (((int)m.getX() == check.getX()) && ((int)m.getY() == check.getY()) && ((int)m.getZ() == check.getZ())) {
	                 m.setHealth(0);
	               }
	             }
	             for (Mob m : world.getMobList())
	               if (((int)m.getX() == check.getX()) && ((int)m.getY() == check.getY()) && ((int)m.getZ() == check.getZ()))
	                 m.setHealth(0);
	          }
	        }
	     /**
	      * @param coords1
	      * @param coords2
	      */
	     public static void savechunk(String coords1,String coords2){
	    	 PropertiesFile f = new PropertiesFile("plugins/config/WorldTools/WorldToolsChunks.properties");
	    	 f.getString(coords1,coords2);
	    	 }
	     
	     
	     }
//end of class
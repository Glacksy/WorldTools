
public class WorldToolsVoids extends WorldToolsListener {

	static Player player;
	
	
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
   		
    }
    
    
	/**
	 * Changed it to use the new and powerful code, so only players will be hurt while world wont!
	 * @author benni1601
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
	       int dimension = player.getLocation().dimension;
	       for (int x = -r; x <= r; x++)
	         for (int z = -r; z <= r; z++)
	           for (int y = -r; y <= r; y++) {
	             Block check = player.getWorld().getBlockAt((int)player.getX() + x, (int)player.getY() + y, (int)player.getZ() + z);
	             for (Mob m : etc.getServer().getWorld(dimension).getMobList()) {
	               if (((int)m.getX() == check.getX()) && ((int)m.getY() == check.getY()) && ((int)m.getZ() == check.getZ())) {
	                 m.setHealth(0);
	               }
	             }
	             for (Mob m : etc.getServer().getWorld(dimension).getAnimalList())
	               if (((int)m.getX() == check.getX()) && ((int)m.getY() == check.getY()) && ((int)m.getZ() == check.getZ()))
	                 m.setHealth(0);
	          }
	        }
	     
	     
}

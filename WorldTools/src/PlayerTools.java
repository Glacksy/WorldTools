import java.util.ArrayList;

/**
 * @author Spenk & Glacksy
 * @category Player Listener
 * @version 1.0
 * 
 * @description
 * tools for players
 * and admins
 *
 */
public class PlayerTools extends PluginListener{
	
	ArrayList<String> god = new ArrayList<String>();
	ArrayList<String> frozen = new ArrayList<String>();
	
	public boolean onCommand(Player Player, String[] split) {
			   if ((split[0].equalsIgnoreCase("/drain")) && (Player.canUseCommand("/worldtools"))) {
			       int dist = 0;
			       if (split.length == 2) try { dist = Integer.parseInt(split[1]); } catch (Throwable localThrowable) {
			         } if (dist == 0) {
			         Player.sendMessage("§9[§6-§8-§6-§8-§6-§9Drain Help§6-§8-§6-§8-§6-§9]");
			         Player.sendMessage("§a/drain <radius> - Drain water/lava");
			         Player.sendMessage("§a/drainwater <radius> - Drain water");
			         Player.sendMessage("§a/drainlava <radius>  - Drain lava");
			         Player.sendMessage("§a/ext <radius> - Remove fire"); return true;
			       }
			         int radius = 0;
			       try {radius = Integer.parseInt(split[1]);}catch(NumberFormatException nfe){Player.notify("The correct usage is /drain <radius>");return true;}
			       int xmin = (int)Player.getX()-radius;
			         int xmax = (int)Player.getX()+radius;
			         int ymin = (int)Player.getY()-radius;
			         int ymax = (int)Player.getY()+radius;
			         int zmin = (int)Player.getZ()-radius;
			         int zmax = (int)Player.getZ()+radius;
			        
			         for (int x = xmin; x <= xmax; x++) {
			                 for (int y = ymin; y <= ymax; y++) {
			                         for (int z = zmin; z <= zmax; z++) {    
			                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 8){Player.getWorld().setBlockAt(95, x, y, z);}
			                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 95){Player.getWorld().setBlockAt(9, x, y, z);}
			                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 10){Player.getWorld().setBlockAt(95, x, y, z);}
			                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 95){Player.getWorld().setBlockAt(11, x, y, z);}
			                         }
			                       }
			                     }
			         Player.sendMessage("§aLava & Water Successfully Drained!");
			         return true;
			                   }


		     if ((split[0].equalsIgnoreCase("/drainlava")) && (Player.canUseCommand("/worldtools")) && (Player.canUseCommand("/drainlava"))) {
		       int dist = 0;
		       if (split.length == 2) try { dist = Integer.parseInt(split[1]); } catch (Throwable localThrowable1) {
		         } if (dist == 0) { Player.sendMessage("§cWrong syntax! Usage: /drainlava <radius>"); return true; }
		         int radius = 0;
		         try {radius = Integer.parseInt(split[1]);}catch(NumberFormatException nfe){Player.notify("The correct usage is /drainlava <radius>");return true;}
		         int xmin = (int)Player.getX()-radius;
		         int xmax = (int)Player.getX()+radius;
		         int ymin = (int)Player.getY()-radius;
		         int ymax = (int)Player.getY()+radius;
		         int zmin = (int)Player.getZ()-radius;
		         int zmax = (int)Player.getZ()+radius;
		        
		         for (int x = xmin; x <= xmax; x++) {
		                 for (int y = ymin; y <= ymax; y++) {
		                         for (int z = zmin; z <= zmax; z++) {    
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 11){Player.getWorld().setBlockAt(95, x, y, z);}
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 95){Player.getWorld().setBlockAt(10, x, y, z);}
		                         }
		                       }
		                     }
		       Player.sendMessage("§aLava Successfully Removed!");
		       return true;
		     }

		     if ((split[0].equalsIgnoreCase("/drainwater")) && (Player.canUseCommand("/worldtools")) && (Player.canUseCommand("/drainwater"))) {
		       int dist = 0;
		       if (split.length == 2) try { dist = Integer.parseInt(split[1]); } catch (Throwable localThrowable2) {
		         } if (dist == 0) { Player.sendMessage("§cWrong syntax! Usage: /drainwater <radius>"); return true; }
		         int radius = 0;
		         try {radius = Integer.parseInt(split[1]);}catch(NumberFormatException nfe){Player.notify("The correct usage is /drainwater <radius>");return true;}
		         int xmin = (int)Player.getX()-radius;
		         int xmax = (int)Player.getX()+radius;
		         int ymin = (int)Player.getY()-radius;
		         int ymax = (int)Player.getY()+radius;
		         int zmin = (int)Player.getZ()-radius;
		         int zmax = (int)Player.getZ()+radius;
		        
		         for (int x = xmin; x <= xmax; x++) {
		                 for (int y = ymin; y <= ymax; y++) {
		                         for (int z = zmin; z <= zmax; z++) {    
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 9){Player.getWorld().setBlockAt(95, x, y, z);}
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 95){Player.getWorld().setBlockAt(8, x, y, z);}
		                         }
		                       }
		                     }
		       Player.sendMessage("§aWater Successfully Removed!");
		       return true;
		     }

		     if ((split[0].equalsIgnoreCase("/ext")) && (Player.canUseCommand("/worldtools")) && (Player.canUseCommand("/ext"))) {
		       int dist = 0;
		       if (split.length == 2) try { dist = Integer.parseInt(split[1]); } catch (Throwable localThrowable3) {
		         } if (dist == 0) { Player.sendMessage("§cWrong syntax! Usage: /ext <radius>"); return true; }
		         int radius = 0;
		         try {radius = Integer.parseInt(split[1]);}catch(NumberFormatException nfe){Player.notify("The correct usage is /ext <radius>");return true;}
		         int xmin = (int)Player.getX()-radius;
		         int xmax = (int)Player.getX()+radius;
		         int ymin = (int)Player.getY()-radius;
		         int ymax = (int)Player.getY()+radius;
		         int zmin = (int)Player.getZ()-radius;
		         int zmax = (int)Player.getZ()+radius;
		        
		         for (int x = xmin; x <= xmax; x++) {
		                 for (int y = ymin; y <= ymax; y++) {
		                         for (int z = zmin; z <= zmax; z++) {    
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 51){Player.getWorld().setBlockAt(0, x, y, z);}
		                         }
		                       }
		                     }
		       Player.sendMessage("§aFire Successfully Extinguished");
		       return true;
		     }

		     if ((split[0].equalsIgnoreCase("/melt")) && (Player.canUseCommand("/worldtools")) && (Player.canUseCommand("/melt"))) {
		       int dist = 0;
		       if (split.length == 2) try { dist = Integer.parseInt(split[1]); } catch (Throwable localThrowable4) {
		         } if (dist == 0) { Player.sendMessage("§cWrong syntax! Usage: /melt <radius>"); return true; }
		         int radius = 0;
		         try {radius = Integer.parseInt(split[1]);}catch(NumberFormatException nfe){Player.notify("The correct usage is /melt <radius>");return true;}
		         int xmin = (int)Player.getX()-radius;
		         int xmax = (int)Player.getX()+radius;
		         int ymin = (int)Player.getY()-radius;
		         int ymax = (int)Player.getY()+radius;
		         int zmin = (int)Player.getZ()-radius;
		         int zmax = (int)Player.getZ()+radius;
		        
		         for (int x = xmin; x <= xmax; x++) {
		                 for (int y = ymin; y <= ymax; y++) {
		                         for (int z = zmin; z <= zmax; z++) {    
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 78){Player.getWorld().setBlockAt(0, x, y, z);}
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 79){Player.getWorld().setBlockAt(8, x, y, z);}
		                         }
		                       }
		                     }
		       Player.sendMessage("§aThe Snow & Ice has been successfully melted!");
		       return true;
		     }

		     if ((split[0].equalsIgnoreCase("/snow")) && (Player.canUseCommand("/worldtools")) && (Player.canUseCommand("/snow"))) {
		       int dist = 0;
		       if (split.length == 2) try { dist = Integer.parseInt(split[1]); } catch (Throwable localThrowable5) {
		         } if (dist == 0) { Player.sendMessage("§cWrong syntax! Usage: /snow <radius>"); return true; }
		         int radius = 0;
		         try {radius = Integer.parseInt(split[1]);}catch(NumberFormatException nfe){Player.notify("The correct usage is /snow <radius>");return true;}
		         int xmin = (int)Player.getX()-radius;
		         int xmax = (int)Player.getX()+radius;
		         int ymin = (int)Player.getY()-radius;
		         int ymax = (int)Player.getY()+radius;
		         int zmin = (int)Player.getZ()-radius;
		         int zmax = (int)Player.getZ()+radius;
		        
		         for (int x = xmin; x <= xmax; x++) {
		                 for (int y = ymin; y <= ymax; y++) {
		                         for (int z = zmin; z <= zmax; z++) {    
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 0){Player.getWorld().setBlockAt(78, x, y, z);}
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 8){Player.getWorld().setBlockAt(79, x, y, z);}
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 9){Player.getWorld().setBlockAt(79, x, y, z);}
		                         }
		                       }
		                     }
		       Player.sendMessage("§a Snow placed & water frozen!");
		       return true;
		     }

		     if ((split[0].equalsIgnoreCase("/waterfix")) && (Player.canUseCommand("/worldtools")) && (Player.canUseCommand("/waterfix"))) {
		       int dist = 0;
		       if (split.length == 2) try { dist = Integer.parseInt(split[1]); } catch (Throwable localThrowable6) {
		         } if (dist == 0) { Player.sendMessage("§cWrong syntax! Usage: /waterfix <radius>"); return true; }
		         int radius = 0;
		         try {radius = Integer.parseInt(split[1]);}catch(NumberFormatException nfe){Player.notify("The correct usage is /waterfix <radius>");return true;}
		         int xmin = (int)Player.getX()-radius;
		         int xmax = (int)Player.getX()+radius;
		         int ymin = (int)Player.getY()-radius;
		         int ymax = (int)Player.getY()+radius;
		         int zmin = (int)Player.getZ()-radius;
		         int zmax = (int)Player.getZ()+radius;
		        
		         for (int x = xmin; x <= xmax; x++) {
		                 for (int y = ymin; y <= ymax; y++) {
		                         for (int z = zmin; z <= zmax; z++) {    
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 8){Player.getWorld().setBlockAt(95, x, y, z);}
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 9){Player.getWorld().setBlockAt(95, x, y, z);}
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 95){Player.getWorld().setBlockAt(9, x, y, z);}
		                         }
		                       }
		                     }
		       Player.sendMessage("§a Water Successfully Fixed!");
		       return true;
		     }

		     if ((split[0].equalsIgnoreCase("/lavafix")) && (Player.canUseCommand("/worldtool")) && (Player.canUseCommand("/lavafix"))) {
		       int dist = 0;
		       if (split.length == 2) try { dist = Integer.parseInt(split[1]); } catch (Throwable localThrowable7) {
		         } if (dist == 0) { Player.sendMessage("§cWrong syntax! Usage: /lavafix <radius>"); return true; }
		         int radius = 0;
		         try {radius = Integer.parseInt(split[1]);}catch(NumberFormatException nfe){Player.notify("The correct usage is /lavafix <radius>");return true;}
		         int xmin = (int)Player.getX()-radius;
		         int xmax = (int)Player.getX()+radius;
		         int ymin = (int)Player.getY()-radius;
		         int ymax = (int)Player.getY()+radius;
		         int zmin = (int)Player.getZ()-radius;
		         int zmax = (int)Player.getZ()+radius;
		        
		         for (int x = xmin; x <= xmax; x++) {
		                 for (int y = ymin; y <= ymax; y++) {
		                         for (int z = zmin; z <= zmax; z++) {    
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 10){Player.getWorld().setBlockAt(95, x, y, z);}
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 11){Player.getWorld().setBlockAt(95, x, y, z);}
		                    if (Player.getWorld().getBlockAt(x, y, z).getType() == 95){Player.getWorld().setBlockAt(9, x, y, z);}
		                         }
		                       }
		                     }
		       Player.sendMessage("§a Lava Successfully Fixed!");
		       return true;
		     }
		     
		     if ((split[0].equalsIgnoreCase("/lighter")) && (Player.canUseCommand("/lighter") || (Player.canUseCommand("/worldtools")))) {
		       int dist = 0;
		       if (split.length == 0) try { dist = Integer.parseInt(split[0]); } catch (Throwable localThrowable8) {
		         } if (dist == 0) { Player.sendMessage("§cWrong syntax! Usage: /lighter"); return true;
		       }
		       Player.giveItem(260, 1);
		       Player.sendMessage("§a No smoke without §6fire!"); 
		       return true;
		     }
		     
		     if (split[0].equalsIgnoreCase("/cmob") && (Player.canUseCommand("/cmob") || (Player.canUseCommand("/worldtools")))) {
		         try {
		           int r = Integer.valueOf(split[1]).intValue();
		           WorldToolsVoids.cMob(r);
		           Player.sendMessage("§aCleared mobs");
		           return true;
		         } catch (Exception e) {
		           Player.sendMessage("§cWrong syntax! Usage: /cmob <radius>");
		           return true;
		         }
		       }
		     
		     /**
		      * killmobs
		      */
		     if (split[0].equalsIgnoreCase("/killmobs") && (Player.canUseCommand("/killmobs") || (Player.canUseCommand("/worldtools")))) {
		         int mobcount = Player.getWorld().getMobList().size();
		         for (int i = 0; i < mobcount; i++) {
		           ((Mob)Player.getWorld().getMobList().get(i)).setHealth(0);
		         }
		         Player.sendMessage("§aYou Killed " + mobcount + " Mobs.");
		         return true;
		       }
		     
		     /**
		      * replace feature
		      * 
		      */ 
		     if (split[0].equalsIgnoreCase("/wreplace") && (Player.canUseCommand("/wreplace") || (Player.canUseCommand("/worldtools")))) {
		         if (split.length <4 || split.length >4){
		                 Player.notify("§cThe correct usage is '/wreplace fromid toid radius'");
		                 return true;
		         } 
		         Integer.parseInt(split[1]); Integer.parseInt(split[2]);Integer.parseInt(split[3]);
		     int fromid = 0;
		     try{fromid = Integer.parseInt(split[1]);}catch(NumberFormatException nfe){Player.notify("The correct usage is '/wreplace fromid toid radius");return true;}
		     int toid = 0;
		     try{fromid = Integer.parseInt(split[1]);}catch(NumberFormatException nfe){Player.notify("The correct usage is '/wreplace fromid toid radius");return true;}
		     int radius = 0;
		     try{fromid = Integer.parseInt(split[1]);}catch(NumberFormatException nfe){Player.notify("The correct usage is '/wreplace fromid toid radius");return true;}
		         WorldToolsVoids.replace(Player,fromid,toid,radius);
		         
		         Player.sendMessage("§aBlocks Replaced.");
		         return true;
		 }
		     
		     if ((split[0].equalsIgnoreCase("/worldtools")) && (Player.canUseCommand("/worldtools"))) {
		           Player.sendMessage("§6 WorldTools 2.0 Beta1 by Glacksy §8&§6 Spenk");
		      
		           return true;
		         }
		     
		     if ((split[0].equalsIgnoreCase("/suicide")) && (Player.canUseCommand("/suicide") && (Player.canUseCommand("/worldtool")))) 
		     {
		           Player.setHealth(0);
		           Player.sendMessage("§cYou committed suicide");
		           return true;
		     }
		     
		     /**
		      * kill code
		      * @author spenk
		      */
		           if ((split[0].equalsIgnoreCase("/kill")) && (Player.canUseCommand("/worldtools")) && (Player.canUseCommand("/kill")))           
		           {    
		        	   if (Player.canUseCommand("/kill")){
		        		   if (split.length <2 || split.length >2){
		        		   Player.notify("The correct usage is /kill <player>");
		        		   return true;
		        	   }else{
		        		   Player player = etc.getServer().matchPlayer(split[1]);
		        		   if (player == null){
		        			   Player.notify("§cThis Player Doesnt Exist or is currently not online!");
		        			   return true;
		        		   }
		        		   player.sendMessage("§4You got killed by §2"+Player.getName());
		        		   player.dropInventory(player.getLocation());
		        		   player.setHealth(0);
		        		   Player.sendMessage("§2Player sucsessfully killed!");
		        		   return true;
		        	   }
		        	   }else{
		        		   Player.sendMessage("§cYou cant use this command");
		        		   return true;
		        	   }
		           }
		           
		           if ((split[0].equalsIgnoreCase("/heal")) && (Player.canUseCommand("/worldtools")) && (Player.canUseCommand("/heal")))           
		           {            
		    		   if (Player.canUseCommand("/heal")){
		    			   if (split.length <2 || split.length >2){
		            		   Player.sendMessage("§cThe correct usage is /heal <player>");
		            		   return true; 
		    			   }else{
		        		   Player player = etc.getServer().matchPlayer(split[1]);
		        		   if (player == null){
		        			   Player.sendMessage("§cThis Player Doesnt Exist or is currently not online!");
		        			   return true;
		        		   }
		        		   player.sendMessage("§4You were healed by §2"+Player.getName());
		        		   player.setHealth(20);
		   				   player.setFoodLevel(20);
		        		   Player.sendMessage("§2Player sucsessfully healed!");
		        		   return true;
		    			   }
		        	   }else{
		        		   Player.sendMessage("§cYou cant use this command");
		        		   return true;
		           }
		           }
		           
		           if (split[0].equalsIgnoreCase("/save-inv") && Player.canUseCommand("/worldtools") && (Player.canUseCommand("/save-inv"))){
		        	   etc.getServer().saveInventories();
		        	   Player.sendMessage("§aInventories saved");
		               return true;
		           }
		           
		           if ((split[0].equalsIgnoreCase("/godmode")) && (Player.canUseCommand("/godmode")) && (Player.canUseCommand("/worldtools"))) {
		        	      if (!god.contains(Player.getName())) {
		        	        god.add(Player.getName());
		        	        Player.sendMessage("§3Godmode have been disabled");
		        	        return true;
		        	      }else{
		        	      god.remove(Player.getName());
		        	      Player.sendMessage("§3Godmode have been enabled");
		        	      return true;
		        	      }
		        	    }
		           if (split[0].equalsIgnoreCase("/feed") && Player.canUseCommand("/worldtools") && (Player.canUseCommand("/feed"))){
		        	   if (split.length <2 || split.length >2){
		        		   Player.notify("The correct usage is /feed player");
		        		   return true;
		        	   }
		        	   Player player2 = etc.getServer().matchPlayer(split[1]);
		        	   if (player2 == null) { Player.notify("This Player does not exist or is currently not logged in!"); return true;}
		        	   player2.setFoodLevel(20);
		        	   Player.sendMessage("§2"+player2.getName()+"'s foodlevel is restored!");
		        	   player2.sendMessage("§2"+Player.getName()+" Restored your foodlevel!");
		        	   return true;
		           }
		           if (split[0].equalsIgnoreCase("/getip") && Player.canUseCommand("/worldtools") && (Player.canUseCommand("/getip"))){
		        	   if (split.length <2 || split.length >2){
		        		   Player.notify("The correct usage is /getip <player>");
		        		   return true;
		        	   }
		        	   Player player2 = etc.getServer().matchPlayer(split[1]);
		        	   if (player2 == null){Player.notify("This player doesnt exist or is not logged in");return true;}
		        	   Player.sendMessage("§4"+player2.getName()+"§2 His IP is §4"+player2.getIP());
		        	   return true;
		           }
		           if (split[0].equalsIgnoreCase("/forcewarp") && Player.canUseCommand("/worldtools") && (Player.canUseCommand("/forcewarp"))){
		        	   if (split.length <3 || split.length >3){
		        		   Player.notify("The correct usage is /forcewarp player warpname");
		        		   return true;
		        	   }
		        	   Player player2 = etc.getServer().matchPlayer(split[1]);
		        	   if (player2 == null) { Player.notify("This Player does not exist or is currently not logged in!"); return true;}
		        	   Warp warp = etc.getDataSource().getWarp(split[2]);
		        	   if (warp == null){Player.notify("This warp doesnt exist!");return true;}
		        	   player2.teleportTo(warp.Location);
		        	   Player.sendMessage("§2"+player2.getName()+" is warped!");
		        	   player2.sendMessage("§2"+Player.getName()+" warped you!");
		        	   return true;
		           }
		           if (split[0].equalsIgnoreCase("/switchworlds") && Player.canUseCommand("/worldtools") && (Player.canUseCommand("/switchworlds"))){
		        	   if (split.length <3 || split.length >3){
		        		   Player.notify("The correct usage is /swichworlds player worldnumber");
		        		   Player.notify("-1 = nether, 0 = normal world , 1 = end");
		        		   return true;
		        	   }
		        	   Player player2 = etc.getServer().matchPlayer(split[1]);
		        	   if (player2 == null) { Player.notify("This Player does not exist or is currently not logged in!"); return true;}
		        	   
		        	   try {Integer.parseInt(split[2]);}catch(NumberFormatException nfe){Player.notify("The correct usage is /swichworlds player worldnumber");
	        		   Player.notify("-1 = nether, 0 = normal world , 1 = end");return true;}
		        	   
		        	   int derp = Integer.parseInt(split[2]);
		        	   
		        	   if (derp != 1 && derp != -1 && derp != 0){Player.notify("The correct usage is /swichworlds player worldnumber");
	        		   Player.notify("-1 = nether, 0 = normal world , 1 = end");return true;}
		        	   
		        	   player2.switchWorlds(Integer.parseInt(split[2]));
		        	   Player.sendMessage("§2"+player2.getName()+" Has swiched to world "+Integer.parseInt(split[2]));
		        	   player2.sendMessage("§2"+Player.getName()+" Has swiched you to world "+Integer.parseInt(split[2]));
		        	   return true;
		           }
		           try { if ((split[0].equalsIgnoreCase("/freeze")) && (Player.canUseCommand("/freeze")) && (Player.canUseCommand("/worldtools"))) {
		               Player offender = etc.getServer().matchPlayer(split[1]);
		               if (offender == null){
		            	   Player.notify("This Player does not exist or is currently not logged in!");
		            	   return true;
		               }
		               if ((!frozen.contains(offender.getName())) && (split[1] != null)) {
		                 offender.sendMessage("§2You have been frozen by §3" + Player.getName() + "§e!");
		                 Player.sendMessage("§2You froze §3" + offender.getName() + "§2!");
		                 frozen.add(offender.getName());
		                 return true;
		               }
		               offender.sendMessage("§2You have been thawed!");
		               Player.sendMessage("§2You unfroze §3" + Player.getName() + "§2!");
		               frozen.remove(offender.getName());
		               return true;
		             }
		           } catch (ArrayIndexOutOfBoundsException e) {
		             Player.sendMessage("§cWrong syntax! Usage: /freeze <Player>");
		             return true;
		           } catch (NullPointerException e) {
		             Player.sendMessage("§cPlayer not found!");
		             return true;
		           }
		           
		     return false;
		   }
public void onPlayerMove(Player player, Location from, Location to) {
    if (frozen.contains(player.getName()))
      player.teleportTo(from);
  }
public void onLogin(Player player) {
    if (god.contains(player.getName()))
    if (god.contains(player.getName()))
      god.remove(player.getName());
      god.remove(player.getName());
  }

public boolean onDamage(PluginLoader.DamageType type, BaseEntity attacker, BaseEntity defender, int amount)
{
if ((defender.isPlayer()) && 
	      (!god.contains(defender.getPlayer().getName()))) {
	      Player localplayer = defender.getPlayer();

	      if ((localplayer.canUseCommand("/godmode")) && 
	        (type.equals(PluginLoader.DamageType.ENTITY)) && 
	        (type.equals(PluginLoader.DamageType.CACTUS)) && 
	        (type.equals(PluginLoader.DamageType.FALL)) && 
	        (type.equals(PluginLoader.DamageType.FIRE)) && 
	        (type.equals(PluginLoader.DamageType.LAVA)) && 
	        (type.equals(PluginLoader.DamageType.SUFFOCATION)) && 
	        (type.equals(PluginLoader.DamageType.FIRE_TICK)) &&
	        (type.equals(PluginLoader.DamageType.CREEPER_EXPLOSION)) &&
	        (type.equals(PluginLoader.DamageType.EXPLOSION)) &&
	        (type.equals(PluginLoader.DamageType.POTION)) &&
	        (type.equals(PluginLoader.DamageType.STARVATION)) &&
	        (type.equals(PluginLoader.DamageType.WATER)) &&
	        (type.equals(PluginLoader.DamageType.LIGHTNING)))
	      {
	        return true;
	      }
	    }
return false;
}
}

/**
 * @commands
 * /drain
 * /drainlava
 * /drainwater
 * /ext
 * /melt
 * /snow
 * /lavafix
 * /waterfix
 * /lighter
 * /cmob
 * /wreplace
 * /killmobs
 * /suicide
 * /kill
 * /heal
 * /save-inv
 * /freeze
 * /godmode
 * /food
 * /swichworlds
 * /getip
 */

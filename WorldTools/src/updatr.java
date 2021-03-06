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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class updatr extends WorldTools {

	/**
	 * Generate updatr file
	 * This Does Only Generate If The updatr Folder Exist, so only if you use updatr this will be generated
	 */
	public static void createUpdatrFile() {
		  try {
		    File updatrDir = new File("Updatr");
		    
		    if (updatrDir.exists())
		    {
		      File updatrFile = new File("Updatr" + File.separator + Listener.pluginName() + ".updatr");
		      if (!updatrFile.exists())
		      {
		        updatrFile.createNewFile();

		        BufferedWriter writer = new BufferedWriter(new FileWriter(updatrFile));
		        writer.write("name = WorldTools"); writer.newLine();
		        writer.write("version = 2.2"); writer.newLine();
		        writer.write("url = dl.dropbox.com/s/mtrt3xgumok6lud/WorldTools.updatr"); writer.newLine();
		        writer.write("file = dl.dropbox.com/s/aqvi05eaziuh4z6/WorldTools.jar"); writer.newLine();
		        writer.write("notes = "); writer.newLine();
		        writer.close();
		      }
		    }
		  }
		  catch (IOException e) {
		    ((Logger)Listener.logger()).log(Level.SEVERE, null, e);
		  }
		}

}


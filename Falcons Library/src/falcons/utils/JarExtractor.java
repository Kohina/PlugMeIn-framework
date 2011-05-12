package falcons.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.zip.*;

import falcons.pluginmanager.PluginManager;

class JarExtractor {

	public List<File> getJarEntries(String filename) {
		
		List<File> listOfClassFiles = new ArrayList<File>();
		
		try {

			JarFile jarFile = new JarFile(filename);

			String destinationname = PluginManager.pluginPath;
			byte[] buf = new byte[1024];
			JarInputStream jarinputstream = null;
			JarEntry jarentry;
			jarinputstream = new JarInputStream(new FileInputStream(filename));

			jarentry = jarinputstream.getNextJarEntry();

			// Make the print easier to read.
			System.out
					.println("===============All File Entries===============");
			for (Enumeration em1 = jarFile.entries(); em1.hasMoreElements();) {
				System.out.println(em1.nextElement());
			}
			System.out.println("");

			while (jarentry != null) {
				// for each entry to be extracted
				String entryName = jarentry.getName();
				// System.out.println("entryname " + entryName);
				int n;
				FileOutputStream fileoutputstream;
				File newFile = new File(entryName);
				boolean newFileDirectory = true;
				boolean createdFile = false;

				// Logging-stuff
				System.out.println("=============== " + newFile
						+ " ===============");
				System.out.println("path: " + newFile.getAbsolutePath());

				// Check for parents and print the results
				if (newFile.getParent() != null) {
					System.out.println(newFile + " has a parent.");
					System.out.println("new file directory was created: "
							+ new File("plugins" + File.separator
									+ newFile.getParent()).mkdirs());
				} else if (newFile.getParent() == null) {
					System.out.println(newFile + " doesn't have a parent.");
				}

				// Check if the file currently being unzipped is a folder
				if (!newFile.isFile() && !newFile.toString().endsWith(".class")) {
					System.out.println(newFile + " is a directory.");
					boolean created = new File("plugins" + File.separator, newFile
							.toString()).mkdirs();
					System.out.println(newFile
							+ " was created: "
							+ created);
					if(created == false){
						break;
					}
				}

				if (!newFileDirectory || newFile.toString().endsWith(".class")) {
					fileoutputstream = new FileOutputStream(destinationname
							+ entryName);

					while ((n = jarinputstream.read(buf, 0, 1024)) > -1)
						fileoutputstream.write(buf, 0, n);

					fileoutputstream.close();
					jarinputstream.closeEntry();
					
					createdFile = true;
					listOfClassFiles.add(newFile);
					System.out.println("classfile was created: " + createdFile);

				}

				//Make the logging more easy to read.
				System.out.println("");
				
				newFile.deleteOnExit();
				jarentry = jarinputstream.getNextJarEntry();
			}// while
			jarinputstream.close();
		} catch (Exception e) { //TODO Nothing should be thrown here?
			e.printStackTrace();
		}
		return listOfClassFiles;
	}
}
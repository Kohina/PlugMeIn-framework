package falcons.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileScanner {
	
	/**
	 * This method gets all the Files in the folder given. If they are inside a jar-file
	 * they are exctracted
	 * @param path The path to the folder
	 * @return Returns the .class-files that was inside the folder.
	 */
	public static List<File> getFiles(File path) {
		List<File> files = new ArrayList<File>();
		JarExtractor extractor = new JarExtractor();
		File[] entries = path.listFiles();

		if(entries != null){
			// Clean up the folder and delete all files that isn't .jar or .class
			for(File f : entries){
				if(!f.getAbsolutePath().endsWith(".jar") && !f.getAbsolutePath().endsWith(".class")){
					deleteFile(f.getAbsolutePath());
				}
			}
			
			for (File f : entries) {
				if (!f.isDirectory()) {
					if (f.getAbsolutePath().endsWith(".jar")) {
						List<File> extractedFiles = new ArrayList<File>();
						extractedFiles = extractor.getJarEntries(f.getAbsolutePath());
						for (File g : extractedFiles) {
							files.add(g);
						}
					} else if (f.getAbsolutePath().endsWith(".class")) {
						files.add(f);
					}
				} else if (f.isDirectory()) {
					System.out.println(f + " was deleted: " + f.delete());
				} else {
					System.out.println("There were no files inside the plugins directory");
				}
			}
		}
		return files;
	}

	/**
	 * Delets the file given
	 * @param sFilePath The relative path to the file to be deleted
	 * @return Returns true if deletion was successful
	 */
	public static boolean deleteFile(String sFilePath)
	{
	  File oFile = new File(sFilePath);
	  if(oFile.isDirectory())
	  {
	    File[] aFiles = oFile.listFiles();
	    for(File oFileCur: aFiles)
	    {
	       deleteFile(oFileCur.getAbsolutePath());
	    }
	  }
	  return oFile.delete();
	}
}
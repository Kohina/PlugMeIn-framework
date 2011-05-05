package falcons.pluginmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import falcons.plugin.AbstractPlugin;

public class URLPluginManager {
	
	public static final String pluginPath = System.getProperty("user.dir")
	+ File.separator + "plugins" + File.separator;
	private static Scanner scanner;
	
	public static void main(String args[]){
		try {
			URLPluginManager manager = new URLPluginManager();
			manager.loadPlugins();
		} catch (FileNotFoundException e) {
			System.out.println("file wasnt found");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
			e.printStackTrace();
		} 
	}

	public URLPluginManager() throws FileNotFoundException{
		scanner = new Scanner(new File(pluginPath + "plugins.txt"));
	}
	
	public static List<AbstractPlugin> loadPlugins() throws MalformedURLException {
		
		String modPluginPath = pluginPath.replace(pluginPath, "file:" + pluginPath);
		System.out.println(modPluginPath);
		
		URL url[] = {new URL(modPluginPath)};
		
		List<AbstractPlugin> pluginList = new ArrayList<AbstractPlugin>();
		URLClassLoader loader = new URLClassLoader(url);
		while(scanner.hasNextLine()){
			try {
				Class<?> cl = loader.loadClass(scanner.nextLine());
				AbstractPlugin cls = (AbstractPlugin) cl.newInstance();
				pluginList.add(cls);
			} catch (ClassNotFoundException e) {
				System.out.println("The classloader could not find the class specified in plugins.txt");
				e.printStackTrace();
			} catch (InstantiationException e) {
				System.out.println("Could not instantiate the specified class.");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.out.println("Could not access the specified class.");
				e.printStackTrace();
			}
		}
		
		return null;
	}
}

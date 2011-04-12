package falcons.pluginmanager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.Plugin;

public class PluginManager {
	
	private File[] files;
	private ArrayList<AbstractPlugin> pluginList = new ArrayList<AbstractPlugin>();

	public ArrayList<AbstractPlugin> loadPlugins(String filePath){
		File PATH = new File(filePath);
		files = PATH.listFiles();
		
		
		for(File f : files){
			if(f.isFile() && f.getPath().endsWith(".class")){
				
				String pluginName = f.getPath().split(".class")[0];
				pluginName = pluginName.replace(filePath, "");
				
				try {
					URL url = new URL("file:/" + filePath.replace("\\", "/"));
					URL urls[] = new URL[]{url};
					
					URLClassLoader loader = new URLClassLoader(urls);
					Class<?> cls = loader.loadClass("falcons.plugin." + pluginName);

					
					if(cls.getAnnotation(Plugin.class) !=null){
						try {
							pluginList.add((AbstractPlugin) cls.newInstance());
						} catch (InstantiationException e) {
							System.out.println("Could not Instantiate plugin: " + pluginName);
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							System.out.println("Could not access plugin: " + pluginName);
							e.printStackTrace();
						}
					}
				} catch (MalformedURLException e) {
					System.out.println("THERE IS A WRONG IN A URL");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("Could not find class in PluginManager");
					e.printStackTrace();
				}				
			}
		}
		return pluginList;	
	}
}

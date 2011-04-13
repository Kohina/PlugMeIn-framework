package falcons.pluginmanager;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.Plugin;

public class PluginLoader {
	// TODO E3: Change this path to wherever your exported plugins are located.
	public static final String pluginPath = System.getProperty("user.dir") + "\\plugins\\";

	@SuppressWarnings("unchecked")
	private static List<Class<?>> getPluginClasses() {
		// TODO Ta bort utskrift
		System.out.println(pluginPath);
		List<File> files = FileScanner.getFiles(new File(pluginPath));
		System.out.println(files.toString());
		PluginClassLoader pluginLoader = new PluginClassLoader();
		List<Class<?>>  classList = new ArrayList<Class<?>>();

		// TODO E1: You should construct a for loop here and do the following:
		// Loop through the files opened above and strip the .class suffix
		// from the file name.
		// Using this stripped file name, call pluginLoader.loadClass(strippedName).
		// Add the opened class to classList ONLY IF the class has an annotation
		// of type annotationType attached to it. If you get the last part wrong,
		// you will get type errors later.


		
		for(File f : files){
			String pluginName = f.getPath().replace(".class", "");
			pluginName = pluginName.replace(pluginPath, "");
			Class<AbstractPlugin> c = (Class<AbstractPlugin>) pluginLoader.findClass(pluginName);
			classList.add(c);
			if(c.getClass().getAnnotation(Plugin.class) != null){
				classList.add(c);
			}
		}
		System.out.println(classList);
		return classList;
	}

	private static List<AbstractPlugin> getPluginsFromPluginClasses(List<Class<?>> classList) {
		List<AbstractPlugin> pluginList = new ArrayList<AbstractPlugin>();

		// TODO E2: You should construct a for loop here and do the following:
		// Loop through classList and create a new object instance based on that class.
		// Add that object to pluginList ONLY IF it is a valid instance of
		// the Pluggable<?> interface.
		
		for(Class<?> c : classList){
			try {
				AbstractPlugin cls = (AbstractPlugin) c.newInstance();
				pluginList.add(cls);
			} catch (InstantiationException e) {
				System.out.println("PluginLoader could not instantiate the plugin");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.out.println("PluginLoader could not access the plugin");
				e.printStackTrace();
			}
		}

		return pluginList;
	}

	public static List<AbstractPlugin> loadPlugins() {
		List<Class<?>> pluginClasses = getPluginClasses();
		List<AbstractPlugin> plugins = getPluginsFromPluginClasses(pluginClasses);

		return plugins;
	}
	
	private static class FileScanner {
		public static List<File> getFiles(File path) {
			List<File> files = new ArrayList<File>();
			File[] entries = path.listFiles();

			if (entries != null) {
				for (File f : entries) {
					if (!f.isDirectory())
						files.add(f);
				}
			}

			return files;
		}
	}

}

package falcons.plugin.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.Plugin;

public class PluginLoader {
	private static File dir = new File(System.getProperty("user.dir"));
	public static final String pluginPath = dir.toString() + "\\plugins\\";

	/*
	 * This method loads classes found in a given plugin directory using a plugin loader.
	 * The method then filters out those classes and only returns classes with
	 * annotationType.
	 *
	 * @return The returned list of classes sorted according to the given comparator.
	 */
	@SuppressWarnings("unchecked")
	private static List<Class<?>> getPluginClasses(Class annotationType) {
		System.out.println("The plugin path: " + pluginPath);
		List<File> files = FileScanner.getFiles(new File(pluginPath));
		PluginClassLoader pluginLoader = new PluginClassLoader();
		List<Class<?>>  classList = new ArrayList<Class<?>>();

		for(File f : files){
			try {
				Object c = pluginLoader.loadClass(f.getName().split(".class")[0]);
				if(((Class<?>) c).getAnnotation(Plugin.class) !=null){
					classList.add((Class<?>) c);
				}
			} catch (ClassNotFoundException e) {
				System.out.println("PluginLoader can't find the class");
				e.printStackTrace();
			}
		}

		return classList;
	}

	/*
	 * This method filters a list of classes and only adds them to the pluginList if
	 * they are a valid instance of the AbstractPlugin<?> interface.
	 *
	 * @return List of classes being a valid instance of AbstractPlugin<?>.
	 */
	private static List<AbstractPlugin<?>> getPluginsFromPluginClasses(List<Class<?>> classList) {
		List<AbstractPlugin<?>> pluginList = new ArrayList<AbstractPlugin<?>>();
		
		for(AbstractPlugin<?> p : pluginList){
			Object o;
			try {
				o = p.getClass().newInstance();
				if(o instanceof AbstractPlugin<?>){
					pluginList.add((AbstractPlugin<?>) o);
				}
			} catch (InstantiationException e) {
				System.out.println("PluginLoader could not instantiate plugin.");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.out.println("PluginLoader could not access the plugin.");
				e.printStackTrace();
			}
		}

		return pluginList;
	}

	public List<AbstractPlugin<?>> loadPlugins() {
		List<Class<?>> pluginClasses = getPluginClasses(AbstractPlugin.class);
		List<AbstractPlugin<?>> plugins = getPluginsFromPluginClasses(pluginClasses);

		return plugins;
	}
	
	private static class FileScanner {
		private static List<File> getFiles(File path) {
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

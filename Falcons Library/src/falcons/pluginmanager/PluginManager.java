package falcons.pluginmanager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.Pluggable;
import falcons.plugin.Plugin;
import falcons.utils.FileScanner;

public class PluginManager {
	public static final String pluginPath = System.getProperty("user.dir")
			+ File.separator + "plugins" + File.separator;

	@SuppressWarnings("unchecked")
	private static List<Class<?>> getPluginClasses() {
		List<File> files = FileScanner.getFiles(new File(pluginPath));
		PluginClassLoader pluginLoader = new PluginClassLoader();
		List<Class<?>> classList = new ArrayList<Class<?>>();

		for (File f : files) {
			String pluginName = f.getPath().replace(".class", "");
			pluginName = pluginName.replace(pluginPath, "");
			Class<Pluggable> c = (Class<Pluggable>) pluginLoader
					.findClass(pluginName);
			if (c.getAnnotation(Plugin.class) != null) {
				classList.add(c);
			}
		}
		return classList;
	}

	private static List<Pluggable> getPluginsFromPluginClasses(
			List<Class<?>> classList) {
		List<Pluggable> pluginList = new ArrayList<Pluggable>();

		for (Class<?> c : classList) {
			try {
				Pluggable cls = (Pluggable) c.newInstance();
					pluginList.add(cls);
			} catch (InstantiationException e) {
				System.out
						.println("PluginLoader could not instantiate the plugin");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.out.println("PluginLoader could not access the plugin");
				e.printStackTrace();
			}
		}

		return pluginList;
	}

	public static List<Pluggable> loadPlugins() {
		List<Class<?>> pluginClasses = getPluginClasses();
		List<Pluggable> plugins = getPluginsFromPluginClasses(pluginClasses);

		return plugins;
	}
}

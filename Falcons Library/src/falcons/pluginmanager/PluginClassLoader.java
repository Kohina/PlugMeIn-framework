package falcons.pluginmanager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PluginClassLoader extends ClassLoader {
	private static final String exportedPackage = "falcons.plugin";

	@Override
	public Class<?> findClass(String name) {
		byte[] data = loadClassData(name);
		return defineClass(exportedPackage + "." + name, data, 0, data.length);
	}

	private byte[] loadClassData (String name) {
		File f = new File(PluginLoader.pluginPath + name + ".class");
		ByteArrayOutputStream classBuffer = new ByteArrayOutputStream();
		
		try {
			FileInputStream a = new FileInputStream(f);
			while(a.available()>0){
				classBuffer.write(a.read());
			}
		} catch (FileNotFoundException e) {
			System.out.println("PluginClassLoader could not find the file.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("PluginClassLoader could not find the inputstream for the filestream.");
			e.printStackTrace();
		}

		return classBuffer.toByteArray();
	}
}

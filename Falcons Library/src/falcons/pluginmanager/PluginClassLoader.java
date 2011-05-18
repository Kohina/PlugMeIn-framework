package falcons.pluginmanager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PluginClassLoader extends ClassLoader {
	private static final String exportedPackage = "falcons.plugin.exported";

	@Override
	public Class<?> findClass(String name) {
		String fileName = name.replace(File.separator, ".");
		byte[] data = loadClassData(name);

		System.out.println(fileName);

		if (fileName.contains(exportedPackage)) {
			return defineClass(fileName, data, 0, data.length);
		} else {
			return defineClass(exportedPackage + "." + fileName, data, 0,
					data.length);
		}
	}

	private byte[] loadClassData(String name) {
		File f = new File(PluginManager.pluginPath + name + ".class");
		ByteArrayOutputStream classBuffer = new ByteArrayOutputStream();

		try {
			FileInputStream a = new FileInputStream(f);
			while (a.available() > 0) {
				classBuffer.write(a.read());
			}
			a.close();
		} catch (FileNotFoundException e) {
			System.out.println("PluginClassLoader could not find the file.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out
					.println("PluginClassLoader could not find the inputstream for the filestream.");
			e.printStackTrace();
		}

		return classBuffer.toByteArray();
	}
}

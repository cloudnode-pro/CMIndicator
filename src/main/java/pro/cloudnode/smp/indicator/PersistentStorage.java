package pro.cloudnode.smp.indicator;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PersistentStorage
{
	public static void Save(String string, String path)
	{
		try (FileWriter writer = new FileWriter(path)) {
			writer.write(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String Load(String path)
	{
		if (!Exists(path)) return null;
		File file = new File(path);
		try {
			return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean Exists(String path)
	{
		File file = new File(path);
		return file.exists();
	}
}

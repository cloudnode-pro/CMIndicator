package pro.cloudnode.smp.indicator;

import java.io.*;

public class PersistentStorage
{
	private static PersistentStorage instance = new PersistentStorage();

	public static PersistentStorage getInstance()
	{
		return instance;
	}

	public boolean Save(Object clazz, String path)
	{
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream outputStream = new ObjectOutputStream(fos);
			outputStream.writeObject(clazz);
			outputStream.close();
			fos.close();
			System.out.println("Written clazz to " + path);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public <T> T Load(String path, Class<T> clazz)
	{
		T obj = null;
		try (FileInputStream fis = new FileInputStream(path)) {
			ObjectInputStream objectIn = new ObjectInputStream(fis);
			obj = clazz.cast(objectIn.readObject());
			objectIn.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public boolean Exists(String path)
	{
		File file = new File(path);
		return file.exists();
	}
}

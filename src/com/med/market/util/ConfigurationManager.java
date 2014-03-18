package com.med.market.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConfigurationManager {

	private static Log log = LogFactory.getLog(ConfigurationManager.class);

	public static final String CONFIG = "conf/config.properties";

	public static Map<String, Properties> list = new HashMap<String, Properties>();

	public ConfigurationManager() {
	}

	private static Properties load() {
	    String file = CONFIG;
		if (!list.containsKey(file)) {
			Properties properties = new Properties();
			try {
				properties.load(ConfigurationManager.class.getClassLoader()
						.getResourceAsStream(file));
				list.put(file, properties);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list.get(file);
	}

	/*public static void update(String file, String key, String val) {
		Properties properties = load(file);
		properties.setProperty(key, val);
		try {
			properties.store(new FileOutputStream(ConfigurationManager.class
					.getClassLoader().getResource(file).getPath()), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		list.put(file, properties);
	}*/

	public static String getObUrl() {
		Properties properties = load();
		return properties.getProperty("ob.site.domain");
	}
	
	public static String getAsString(String name) {
		Properties properties = load();
		return properties.getProperty(name);
	}

	public static int getAsInt(String name) {
		return Integer.parseInt(getAsString(name));
	}

	public static boolean getAsBoolean(String name) {
		return Boolean.parseBoolean(getAsString(name));
	}

	public static boolean getAsBoolean(String name,
			boolean defaultValue) {
		try {
			return Boolean.parseBoolean(getAsString(name));
		} catch (IllegalArgumentException e) {
			return defaultValue;
		}
	}

}

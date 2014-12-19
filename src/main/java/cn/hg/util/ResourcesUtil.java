package cn.hg.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ResourcesUtil
{
	private static final String HG_CONFIG="HG_CONFIG";
	private static final String HG_PRO= "/hg.properties";
	
	private static Map<String,Properties> resMap = new HashMap<String,Properties>();
	
	static
	{
		try
		{
			Properties properties = new Properties();
			properties.load(ResourcesUtil.class.getResourceAsStream(HG_PRO));
			resMap.put(HG_CONFIG, properties);
		}
		catch(Exception e)
		{
			System.out.println("初始化配置文件出错！"+e.getMessage());
		}
	}
	
	public static String getSystemValue(String key)
	{
		return resMap.get(HG_CONFIG).getProperty(key);
	}
}

package com.open.ehcache;

import com.open.ehcache.dto.UserDto;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class Ehcache {

	public static void main(String[] args) {
		// 使用静态方法create()根据ehcache.xml配置文件创建Cache管理器。
		CacheManager manager=CacheManager.create("./src/main/resources/ehcache.xml");
		/*
		* newInstance()方法是一个工厂方法，以默认配置创建一个新的CacheManager实例。
		* 此外，newInstance()还有几个重载函数，分别可以通过传入String、URL、InputStream参数来加载配置文件，然后创建CacheManager实例。
		* */
		//CacheManager manager=CacheManager.newInstance("./src/main/resources/ehcache.xml");
		UserDto dto1 = new UserDto(1,"name1");
		UserDto dto2 = new UserDto(21,"name21");
		Cache c=manager.getCache("a1"); // 获取指定cache
		Element e1=new Element("南京1",dto1);
		Element e2=new Element("南京2",dto2);
		c.put(e1); // 把一个元素添加到Cache中
		c.put(e2); // 把一个元素添加到Cache中

		Element e=c.get("南京1"); // 根据key获取缓存元素
		System.out.println(e);
		System.out.println(e.getObjectValue());

		c.flush(); // 刷新缓存
		manager.shutdown(); // 关闭缓存管理器
	}
}

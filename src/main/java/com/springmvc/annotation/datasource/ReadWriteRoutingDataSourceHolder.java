package com.springmvc.annotation.datasource;

public class ReadWriteRoutingDataSourceHolder {
	private static final ThreadLocal<String> holder = new ThreadLocal<String>();

	public static void put(String value) {
		holder.set(value);
	}

	public static String get() {
		return (String) holder.get();
	}

	public static void clear() {
		holder.remove();
	}
}


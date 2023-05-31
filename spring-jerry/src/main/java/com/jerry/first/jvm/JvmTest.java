package com.jerry.first.jvm;


import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

/**
 * @author fanc
 */
public class JvmTest {


	public static void main(String[] args) {
		List<MemoryPoolMXBean> mxb = ManagementFactory.getMemoryPoolMXBeans();
		for (MemoryPoolMXBean memoryPoolMXBean : mxb) {
				System.out.println("Name:" + memoryPoolMXBean.getName());
				System.out.println("Usage:" + memoryPoolMXBean.getUsage());
				System.out.println("Manager:" + String.join(",", memoryPoolMXBean.getMemoryManagerNames()));
				System.out.println("Type:" + memoryPoolMXBean.getType());
				System.out.println("--------------------------");
		}
	}



}

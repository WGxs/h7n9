package com.itheima.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import com.itheima.utils.FastDFSClient;

public class FastDFSTest {
	// 测试上传图片
	public void fun1() throws Exception {

		// 加载配置文件
		ClientGlobal
				.init("D:/Itcast20170421Web核心阶段/Workspace_Mars_32/h7n9_manager_web/src/main/resources/lib/client.conf");

		// 创建一个trackerclient'对象
		TrackerClient client = new TrackerClient();

		// 使用trackerclient获取连接得到一个trackerserver对象
		TrackerServer server = client.getConnection();

		// 创建storeage的空值引用
		StorageServer server2 = null;

		// 创建一个storageserver的引用,需要两个参数
		StorageClient client2 = new StorageClient(server, server2);

		// 使用storegeClient对象上传图片
		String[] upload_file = client2.upload_file("F:/serverImage/aiyo.jpg", "jpg", null);

		// 将结果遍历打印在控制台
		for (String string : upload_file) {

			System.out.println(string);
		}

	}

	// 使用工具类完成图片的上传
	public void fun2() throws Exception {

		//创建文件上传对象
		FastDFSClient dfsClient = new FastDFSClient("D:/Itcast20170421Web核心阶段/Workspace_Mars_32/h7n9_manager_web/src/main/resources/lib/client.conf");
		
		//上传图片,返回图片的分组和路径
		String string = dfsClient.uploadFile("F:/imge/凯文乐福.jpg");
		System.out.println(string);
	}
}

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

public class FastDFSTest02 {
	// 测试上传图片
	
	public static void main(String[] args) throws Exception
	{

		
/*//		2、创建一个配置文件。配置trackerServer所在的ip地址和端口号
//		3、加载配置文件。
		ClientGlobal.init("D:/Itcast20170421Web核心阶段/Workspace_Mars_32/h7n9_manager_web/src/main/resources/conf/client.conf");
		
//		4、创建一个TrackerClient对象，直接new，没有参数。
		TrackerClient client = new TrackerClient();
//		5、通过TrackerClient对象获得TrackerServer对象。
		TrackerServer server = client.getConnection();
//		6、创建一个StorageClinet对象，需要两个参数TrackerServer、StorageServer（null）
		StorageServer storageServer = null;
//		7、使用StorageClient上传文件，返回文件的路径及文件名。
		StorageClient client2 = new StorageClient(server, storageServer);
		
		String[] upload_file = client2.upload_file("F:/imge/61.jpg", "jpg", null);
//		8、打印结果
		for (String string : upload_file) {
			System.out.println(string);
		}*/
		
		
		/**
		 * 使用工具类上传
		 */
		FastDFSClient client = new FastDFSClient("D:/Itcast20170421Web核心阶段/Workspace_Mars_32/h7n9_manager_web/src/main/resources/conf/client.conf");
		
		String uploadFile = client.uploadFile("F:/imge/61.jpg");
		
		System.out.println(uploadFile);
		
		
	}
}

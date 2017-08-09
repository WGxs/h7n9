package com.itheima.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.itheima.utils.FastDFSClient;

/**
 * 文件上传
 * 
 * @author Administrator
 *
 */
public class PictureController {

	// 定义访问图片服务器的地址
	@Value(value = "${image.server.url}")
	private String address;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public Map upLoadFile(MultipartFile uploadFile) {

		try {
			// 4、把文件上传到图片服务器
			// 1）取文件原始名称
			String filename = uploadFile.getOriginalFilename();
			// 2）取文件扩展名
			String ext_name = filename.substring(filename.lastIndexOf(".") + 1);
			// 3）创建一个FastDFSClient对象
			FastDFSClient dfsClient;

			dfsClient = new FastDFSClient("classpath:conf/client.conf");

			// 4）上传文件，返回url
			String url = dfsClient.uploadFile(uploadFile.getBytes(), ext_name);
			// 5、把返回的url拼接成完成的url。
			String url_all = address + url;
			// 6、创建一个map
			Map map = new HashMap<>();
			// 7、把返回的结果添加到map中
			map.put("erro", "0");
			map.put("url", url_all);
			
			// 8、返回map
			return map;

		} catch (Exception e) {

			// 6、创建一个map
			Map map = new HashMap<>();
			// 7、把返回的结果添加到map中
			map.put("erro", "1");
			map.put("message", "上传图片失败!!");
			
			// 8、返回map
			return map;

		}

	}

}

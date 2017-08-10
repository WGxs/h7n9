package com.itheima.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
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
@Controller
public class PictureController {

	@Value(value = "${image.server.url}")
	private String address;

	/**
	 * @param uploadFile
	 * @return
	 */
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public Map upload(MultipartFile uploadFile) {
		try {
			// 1/接收页面传递的图片信息uploadFile,去文件的扩展名
			String filename = uploadFile.getOriginalFilename();

			// 2、把图片上传到图片服务器。使用封装的工具类实现。需要取文件的内容和扩展名。
			String ext_name = filename.substring(filename.lastIndexOf(".") + 1);

			// 使用工具类上传图片
		
			 FastDFSClient dfsClient = new FastDFSClient("classpath:conf/client.conf");

			// 3、图片服务器返回图片的url
			String path = dfsClient.uploadFile(uploadFile.getBytes(), ext_name);
			// 4、将图片的url补充完整，返回一个完整的url。
			String url = address + path;
			// 5、把返回结果封装到一个Map对象中返回。
			Map map = new HashMap<>();
			map.put("error", 0);
			map.put("url", url);

			return map;

		} catch (Exception e) {
			Map map = new HashMap<>();
			map.put("error", 1);
			map.put("message", "图片上传失败!!");

			return map;
		}

	}

}

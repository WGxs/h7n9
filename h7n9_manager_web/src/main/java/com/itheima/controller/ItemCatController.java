package com.itheima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.pojo.TreeNode;
import com.itheima.service.ItemCatService;

@Controller
public class ItemCatController {

	//service层引用
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<TreeNode> getItemCatList(@RequestParam(value="id", defaultValue="0") Long parentId) {
		
		//调用业务方法
		List<TreeNode> carList = itemCatService.getCarList(parentId);
		
		//返回值
		return carList;
	}
	
}

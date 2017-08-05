package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.pojo.TbItem;
import com.itheima.service.ItemService;

@Controller
public class ItemController {
	
	//注入业务层
	@Autowired
	private ItemService itemService;
	
	//根据id获取item
	@RequestMapping("/item/{id}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long id) {

		//调用业务层方法
		TbItem itemById = itemService.getItemById(id);
		
		//将结果返回
		return itemById;
	}
}

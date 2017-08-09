package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.pojo.EasyUIDataGridResult;
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
	
	/**
	 * 显示页面
	 * 
	 * 返回的数据格式
	 * {total:”2”,rows:[{“id”:”1”,”name”:”张三”},{“id”:”2”,”name”:”李四”}]}
	 * 
	 */
	@RequestMapping("/{pageUrl}")
	public String showPages(@PathVariable String pageUrl)
	{
		return pageUrl;
	}
	
	/**
	 * 显示首页
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex()
	{
		return "index";
	}
	
	/**
	 * 查询数据列表
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getResult(Integer page, Integer rows)
	{
		//调用业务层方法
		EasyUIDataGridResult result = itemService.getResult(page, rows);
		
		return result;
	}
}

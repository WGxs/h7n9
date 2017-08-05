package com.itheima.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.mapper.TbItemMapper;
import com.itheima.pojo.TbItem;
import com.itheima.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	//注入mapper
	@Autowired
	private TbItemMapper tbItemMapper;
	
	public TbItem getItemById(Long id) {
		
		//调用mapper层方法
		TbItem selectByPrimaryKey = tbItemMapper.selectByPrimaryKey(id);
		
		//将查询的结果返回
		return selectByPrimaryKey;
		
	}

}

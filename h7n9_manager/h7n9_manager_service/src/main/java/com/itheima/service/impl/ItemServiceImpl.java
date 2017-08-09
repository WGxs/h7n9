package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.mapper.TbItemMapper;
import com.itheima.pojo.EasyUIDataGridResult;
import com.itheima.pojo.TbItem;
import com.itheima.pojo.TbItemExample;
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

	/**
	 * 分页查询数据
	 */
	public EasyUIDataGridResult getResult(Integer page, Integer rows) {
		
		//设置分页参数
		PageHelper.startPage(page, rows);
		
		//创建tbitem对象
		TbItemExample example = new TbItemExample();
		//调用dao层方法
		List<TbItem> list = tbItemMapper.selectByExample(example);
		
		//返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		
		//获取分页总记录数
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		
		//将result返回
		return result;
	}

	

}

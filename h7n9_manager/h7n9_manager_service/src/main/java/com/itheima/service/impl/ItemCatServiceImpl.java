package com.itheima.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.mapper.TbItemCatMapper;
import com.itheima.pojo.TbItemCat;
import com.itheima.pojo.TbItemCatExample;
import com.itheima.pojo.TbItemCatExample.Criteria;
import com.itheima.pojo.TreeNode;
import com.itheima.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	// 定义mapper的引用
	@Autowired
	private TbItemCatMapper tbItemCatMapper;

	/**
	 * 获取所有的类目列表
	 */
	public List<TreeNode> getCarList(Long parentId) {

		// 创建treenodes的集合
		List<TreeNode> list = new ArrayList<>();

		// 调用业务层方法
		TbItemCatExample example = new TbItemCatExample();
		// 添加条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);

		// 调用方法
		List<TbItemCat> selectByExample = tbItemCatMapper.selectByExample(example);
		for (TbItemCat tbItemCat : selectByExample) {
			//创建TreeNode对象
			TreeNode treeNode = new TreeNode();
			treeNode.setId(tbItemCat.getId());
			treeNode.setText(tbItemCat.getName());
			treeNode.setState(tbItemCat.getIsParent()?"closed":"open");
			
			//将treeNode添加到list中
			list.add(treeNode);
		}
		
		//将结果返回
		return list;
	}

}

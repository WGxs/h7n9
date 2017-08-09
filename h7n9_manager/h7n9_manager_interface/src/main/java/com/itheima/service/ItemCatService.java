package com.itheima.service;

import java.util.List;

import com.itheima.pojo.TbItemCat;
import com.itheima.pojo.TreeNode;

public interface ItemCatService {

	List<TreeNode> getCarList(Long id);
	
}

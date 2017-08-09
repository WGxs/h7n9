package com.itheima.service;

import java.util.List;

import com.itheima.pojo.EasyUIDataGridResult;
import com.itheima.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(Long id);

	EasyUIDataGridResult getResult(Integer total, Integer rows);
}

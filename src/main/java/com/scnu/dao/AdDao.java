package com.scnu.dao;

import java.util.List;

import com.scnu.bean.Ad;

public interface AdDao {
	// 返回影响的条数
	int insert(Ad ad);

	List<Ad> selectByPage(Ad condition);
	// 统计总条数
	Long selectCount(Ad condition);
	
	int delete(Long id);
	
	Ad selectById(Long id);
	
	int update(Ad ad);
}

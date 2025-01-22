package com.dao;

import com.entity.DiscussgerenfenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussgerenfenxiangVO;
import com.entity.view.DiscussgerenfenxiangView;


/**
 * 个人分享评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-06 10:33:31
 */
public interface DiscussgerenfenxiangDao extends BaseMapper<DiscussgerenfenxiangEntity> {
	
	List<DiscussgerenfenxiangVO> selectListVO(@Param("ew") Wrapper<DiscussgerenfenxiangEntity> wrapper);
	
	DiscussgerenfenxiangVO selectVO(@Param("ew") Wrapper<DiscussgerenfenxiangEntity> wrapper);
	
	List<DiscussgerenfenxiangView> selectListView(@Param("ew") Wrapper<DiscussgerenfenxiangEntity> wrapper);

	List<DiscussgerenfenxiangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgerenfenxiangEntity> wrapper);
	
	DiscussgerenfenxiangView selectView(@Param("ew") Wrapper<DiscussgerenfenxiangEntity> wrapper);
	

}

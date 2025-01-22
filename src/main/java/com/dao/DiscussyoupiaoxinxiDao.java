package com.dao;

import com.entity.DiscussyoupiaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyoupiaoxinxiVO;
import com.entity.view.DiscussyoupiaoxinxiView;


/**
 * 邮票信息评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
public interface DiscussyoupiaoxinxiDao extends BaseMapper<DiscussyoupiaoxinxiEntity> {
	
	List<DiscussyoupiaoxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussyoupiaoxinxiEntity> wrapper);
	
	DiscussyoupiaoxinxiVO selectVO(@Param("ew") Wrapper<DiscussyoupiaoxinxiEntity> wrapper);
	
	List<DiscussyoupiaoxinxiView> selectListView(@Param("ew") Wrapper<DiscussyoupiaoxinxiEntity> wrapper);

	List<DiscussyoupiaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyoupiaoxinxiEntity> wrapper);
	
	DiscussyoupiaoxinxiView selectView(@Param("ew") Wrapper<DiscussyoupiaoxinxiEntity> wrapper);
	

}

package com.dao;

import com.entity.GerenfenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GerenfenxiangVO;
import com.entity.view.GerenfenxiangView;


/**
 * 个人分享
 * 
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
public interface GerenfenxiangDao extends BaseMapper<GerenfenxiangEntity> {
	
	List<GerenfenxiangVO> selectListVO(@Param("ew") Wrapper<GerenfenxiangEntity> wrapper);
	
	GerenfenxiangVO selectVO(@Param("ew") Wrapper<GerenfenxiangEntity> wrapper);
	
	List<GerenfenxiangView> selectListView(@Param("ew") Wrapper<GerenfenxiangEntity> wrapper);

	List<GerenfenxiangView> selectListView(Pagination page,@Param("ew") Wrapper<GerenfenxiangEntity> wrapper);
	
	GerenfenxiangView selectView(@Param("ew") Wrapper<GerenfenxiangEntity> wrapper);
	

}

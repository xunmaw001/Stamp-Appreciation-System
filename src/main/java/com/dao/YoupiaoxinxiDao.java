package com.dao;

import com.entity.YoupiaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YoupiaoxinxiVO;
import com.entity.view.YoupiaoxinxiView;


/**
 * 邮票信息
 * 
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
public interface YoupiaoxinxiDao extends BaseMapper<YoupiaoxinxiEntity> {
	
	List<YoupiaoxinxiVO> selectListVO(@Param("ew") Wrapper<YoupiaoxinxiEntity> wrapper);
	
	YoupiaoxinxiVO selectVO(@Param("ew") Wrapper<YoupiaoxinxiEntity> wrapper);
	
	List<YoupiaoxinxiView> selectListView(@Param("ew") Wrapper<YoupiaoxinxiEntity> wrapper);

	List<YoupiaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YoupiaoxinxiEntity> wrapper);
	
	YoupiaoxinxiView selectView(@Param("ew") Wrapper<YoupiaoxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<YoupiaoxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YoupiaoxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YoupiaoxinxiEntity> wrapper);
}

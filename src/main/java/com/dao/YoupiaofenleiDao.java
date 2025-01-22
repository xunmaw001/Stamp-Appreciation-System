package com.dao;

import com.entity.YoupiaofenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YoupiaofenleiVO;
import com.entity.view.YoupiaofenleiView;


/**
 * 邮票分类
 * 
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
public interface YoupiaofenleiDao extends BaseMapper<YoupiaofenleiEntity> {
	
	List<YoupiaofenleiVO> selectListVO(@Param("ew") Wrapper<YoupiaofenleiEntity> wrapper);
	
	YoupiaofenleiVO selectVO(@Param("ew") Wrapper<YoupiaofenleiEntity> wrapper);
	
	List<YoupiaofenleiView> selectListView(@Param("ew") Wrapper<YoupiaofenleiEntity> wrapper);

	List<YoupiaofenleiView> selectListView(Pagination page,@Param("ew") Wrapper<YoupiaofenleiEntity> wrapper);
	
	YoupiaofenleiView selectView(@Param("ew") Wrapper<YoupiaofenleiEntity> wrapper);
	

}

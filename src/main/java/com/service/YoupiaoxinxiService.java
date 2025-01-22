package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YoupiaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YoupiaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YoupiaoxinxiView;


/**
 * 邮票信息
 *
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
public interface YoupiaoxinxiService extends IService<YoupiaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YoupiaoxinxiVO> selectListVO(Wrapper<YoupiaoxinxiEntity> wrapper);
   	
   	YoupiaoxinxiVO selectVO(@Param("ew") Wrapper<YoupiaoxinxiEntity> wrapper);
   	
   	List<YoupiaoxinxiView> selectListView(Wrapper<YoupiaoxinxiEntity> wrapper);
   	
   	YoupiaoxinxiView selectView(@Param("ew") Wrapper<YoupiaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YoupiaoxinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YoupiaoxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YoupiaoxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YoupiaoxinxiEntity> wrapper);
}


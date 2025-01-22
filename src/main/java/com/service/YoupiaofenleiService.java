package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YoupiaofenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YoupiaofenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YoupiaofenleiView;


/**
 * 邮票分类
 *
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
public interface YoupiaofenleiService extends IService<YoupiaofenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YoupiaofenleiVO> selectListVO(Wrapper<YoupiaofenleiEntity> wrapper);
   	
   	YoupiaofenleiVO selectVO(@Param("ew") Wrapper<YoupiaofenleiEntity> wrapper);
   	
   	List<YoupiaofenleiView> selectListView(Wrapper<YoupiaofenleiEntity> wrapper);
   	
   	YoupiaofenleiView selectView(@Param("ew") Wrapper<YoupiaofenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YoupiaofenleiEntity> wrapper);
   	

}


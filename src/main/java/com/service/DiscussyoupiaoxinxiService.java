package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyoupiaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyoupiaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyoupiaoxinxiView;


/**
 * 邮票信息评论表
 *
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
public interface DiscussyoupiaoxinxiService extends IService<DiscussyoupiaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyoupiaoxinxiVO> selectListVO(Wrapper<DiscussyoupiaoxinxiEntity> wrapper);
   	
   	DiscussyoupiaoxinxiVO selectVO(@Param("ew") Wrapper<DiscussyoupiaoxinxiEntity> wrapper);
   	
   	List<DiscussyoupiaoxinxiView> selectListView(Wrapper<DiscussyoupiaoxinxiEntity> wrapper);
   	
   	DiscussyoupiaoxinxiView selectView(@Param("ew") Wrapper<DiscussyoupiaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyoupiaoxinxiEntity> wrapper);
   	

}


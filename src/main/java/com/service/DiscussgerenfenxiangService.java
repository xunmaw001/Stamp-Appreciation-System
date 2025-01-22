package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussgerenfenxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussgerenfenxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussgerenfenxiangView;


/**
 * 个人分享评论表
 *
 * @author 
 * @email 
 * @date 2022-04-06 10:33:31
 */
public interface DiscussgerenfenxiangService extends IService<DiscussgerenfenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussgerenfenxiangVO> selectListVO(Wrapper<DiscussgerenfenxiangEntity> wrapper);
   	
   	DiscussgerenfenxiangVO selectVO(@Param("ew") Wrapper<DiscussgerenfenxiangEntity> wrapper);
   	
   	List<DiscussgerenfenxiangView> selectListView(Wrapper<DiscussgerenfenxiangEntity> wrapper);
   	
   	DiscussgerenfenxiangView selectView(@Param("ew") Wrapper<DiscussgerenfenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussgerenfenxiangEntity> wrapper);
   	

}


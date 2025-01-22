package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GerenfenxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GerenfenxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GerenfenxiangView;


/**
 * 个人分享
 *
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
public interface GerenfenxiangService extends IService<GerenfenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GerenfenxiangVO> selectListVO(Wrapper<GerenfenxiangEntity> wrapper);
   	
   	GerenfenxiangVO selectVO(@Param("ew") Wrapper<GerenfenxiangEntity> wrapper);
   	
   	List<GerenfenxiangView> selectListView(Wrapper<GerenfenxiangEntity> wrapper);
   	
   	GerenfenxiangView selectView(@Param("ew") Wrapper<GerenfenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GerenfenxiangEntity> wrapper);
   	

}


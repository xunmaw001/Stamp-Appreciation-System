package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YoupiaofenleiDao;
import com.entity.YoupiaofenleiEntity;
import com.service.YoupiaofenleiService;
import com.entity.vo.YoupiaofenleiVO;
import com.entity.view.YoupiaofenleiView;

@Service("youpiaofenleiService")
public class YoupiaofenleiServiceImpl extends ServiceImpl<YoupiaofenleiDao, YoupiaofenleiEntity> implements YoupiaofenleiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YoupiaofenleiEntity> page = this.selectPage(
                new Query<YoupiaofenleiEntity>(params).getPage(),
                new EntityWrapper<YoupiaofenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YoupiaofenleiEntity> wrapper) {
		  Page<YoupiaofenleiView> page =new Query<YoupiaofenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YoupiaofenleiVO> selectListVO(Wrapper<YoupiaofenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YoupiaofenleiVO selectVO(Wrapper<YoupiaofenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YoupiaofenleiView> selectListView(Wrapper<YoupiaofenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YoupiaofenleiView selectView(Wrapper<YoupiaofenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

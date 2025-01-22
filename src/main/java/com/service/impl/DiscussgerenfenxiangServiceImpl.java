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


import com.dao.DiscussgerenfenxiangDao;
import com.entity.DiscussgerenfenxiangEntity;
import com.service.DiscussgerenfenxiangService;
import com.entity.vo.DiscussgerenfenxiangVO;
import com.entity.view.DiscussgerenfenxiangView;

@Service("discussgerenfenxiangService")
public class DiscussgerenfenxiangServiceImpl extends ServiceImpl<DiscussgerenfenxiangDao, DiscussgerenfenxiangEntity> implements DiscussgerenfenxiangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussgerenfenxiangEntity> page = this.selectPage(
                new Query<DiscussgerenfenxiangEntity>(params).getPage(),
                new EntityWrapper<DiscussgerenfenxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussgerenfenxiangEntity> wrapper) {
		  Page<DiscussgerenfenxiangView> page =new Query<DiscussgerenfenxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussgerenfenxiangVO> selectListVO(Wrapper<DiscussgerenfenxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussgerenfenxiangVO selectVO(Wrapper<DiscussgerenfenxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussgerenfenxiangView> selectListView(Wrapper<DiscussgerenfenxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussgerenfenxiangView selectView(Wrapper<DiscussgerenfenxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

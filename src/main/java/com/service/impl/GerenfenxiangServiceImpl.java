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


import com.dao.GerenfenxiangDao;
import com.entity.GerenfenxiangEntity;
import com.service.GerenfenxiangService;
import com.entity.vo.GerenfenxiangVO;
import com.entity.view.GerenfenxiangView;

@Service("gerenfenxiangService")
public class GerenfenxiangServiceImpl extends ServiceImpl<GerenfenxiangDao, GerenfenxiangEntity> implements GerenfenxiangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GerenfenxiangEntity> page = this.selectPage(
                new Query<GerenfenxiangEntity>(params).getPage(),
                new EntityWrapper<GerenfenxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GerenfenxiangEntity> wrapper) {
		  Page<GerenfenxiangView> page =new Query<GerenfenxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GerenfenxiangVO> selectListVO(Wrapper<GerenfenxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GerenfenxiangVO selectVO(Wrapper<GerenfenxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GerenfenxiangView> selectListView(Wrapper<GerenfenxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GerenfenxiangView selectView(Wrapper<GerenfenxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

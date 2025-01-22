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


import com.dao.DiscussyoupiaoxinxiDao;
import com.entity.DiscussyoupiaoxinxiEntity;
import com.service.DiscussyoupiaoxinxiService;
import com.entity.vo.DiscussyoupiaoxinxiVO;
import com.entity.view.DiscussyoupiaoxinxiView;

@Service("discussyoupiaoxinxiService")
public class DiscussyoupiaoxinxiServiceImpl extends ServiceImpl<DiscussyoupiaoxinxiDao, DiscussyoupiaoxinxiEntity> implements DiscussyoupiaoxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyoupiaoxinxiEntity> page = this.selectPage(
                new Query<DiscussyoupiaoxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussyoupiaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyoupiaoxinxiEntity> wrapper) {
		  Page<DiscussyoupiaoxinxiView> page =new Query<DiscussyoupiaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussyoupiaoxinxiVO> selectListVO(Wrapper<DiscussyoupiaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyoupiaoxinxiVO selectVO(Wrapper<DiscussyoupiaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyoupiaoxinxiView> selectListView(Wrapper<DiscussyoupiaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyoupiaoxinxiView selectView(Wrapper<DiscussyoupiaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

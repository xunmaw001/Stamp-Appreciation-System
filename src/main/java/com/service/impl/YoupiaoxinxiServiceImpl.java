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


import com.dao.YoupiaoxinxiDao;
import com.entity.YoupiaoxinxiEntity;
import com.service.YoupiaoxinxiService;
import com.entity.vo.YoupiaoxinxiVO;
import com.entity.view.YoupiaoxinxiView;

@Service("youpiaoxinxiService")
public class YoupiaoxinxiServiceImpl extends ServiceImpl<YoupiaoxinxiDao, YoupiaoxinxiEntity> implements YoupiaoxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YoupiaoxinxiEntity> page = this.selectPage(
                new Query<YoupiaoxinxiEntity>(params).getPage(),
                new EntityWrapper<YoupiaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YoupiaoxinxiEntity> wrapper) {
		  Page<YoupiaoxinxiView> page =new Query<YoupiaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YoupiaoxinxiVO> selectListVO(Wrapper<YoupiaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YoupiaoxinxiVO selectVO(Wrapper<YoupiaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YoupiaoxinxiView> selectListView(Wrapper<YoupiaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YoupiaoxinxiView selectView(Wrapper<YoupiaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YoupiaoxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YoupiaoxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YoupiaoxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}

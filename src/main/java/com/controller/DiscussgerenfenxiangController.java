package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussgerenfenxiangEntity;
import com.entity.view.DiscussgerenfenxiangView;

import com.service.DiscussgerenfenxiangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 个人分享评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-06 10:33:31
 */
@RestController
@RequestMapping("/discussgerenfenxiang")
public class DiscussgerenfenxiangController {
    @Autowired
    private DiscussgerenfenxiangService discussgerenfenxiangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussgerenfenxiangEntity discussgerenfenxiang, 
		HttpServletRequest request){

        EntityWrapper<DiscussgerenfenxiangEntity> ew = new EntityWrapper<DiscussgerenfenxiangEntity>();
		PageUtils page = discussgerenfenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussgerenfenxiang), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussgerenfenxiangEntity discussgerenfenxiang, 
		HttpServletRequest request){
        EntityWrapper<DiscussgerenfenxiangEntity> ew = new EntityWrapper<DiscussgerenfenxiangEntity>();
		PageUtils page = discussgerenfenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussgerenfenxiang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussgerenfenxiangEntity discussgerenfenxiang){
       	EntityWrapper<DiscussgerenfenxiangEntity> ew = new EntityWrapper<DiscussgerenfenxiangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussgerenfenxiang, "discussgerenfenxiang")); 
        return R.ok().put("data", discussgerenfenxiangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussgerenfenxiangEntity discussgerenfenxiang){
        EntityWrapper< DiscussgerenfenxiangEntity> ew = new EntityWrapper< DiscussgerenfenxiangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussgerenfenxiang, "discussgerenfenxiang")); 
		DiscussgerenfenxiangView discussgerenfenxiangView =  discussgerenfenxiangService.selectView(ew);
		return R.ok("查询个人分享评论表成功").put("data", discussgerenfenxiangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussgerenfenxiangEntity discussgerenfenxiang = discussgerenfenxiangService.selectById(id);
        return R.ok().put("data", discussgerenfenxiang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussgerenfenxiangEntity discussgerenfenxiang = discussgerenfenxiangService.selectById(id);
        return R.ok().put("data", discussgerenfenxiang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussgerenfenxiangEntity discussgerenfenxiang, HttpServletRequest request){
    	discussgerenfenxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussgerenfenxiang);

        discussgerenfenxiangService.insert(discussgerenfenxiang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussgerenfenxiangEntity discussgerenfenxiang, HttpServletRequest request){
    	discussgerenfenxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussgerenfenxiang);

        discussgerenfenxiangService.insert(discussgerenfenxiang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussgerenfenxiangEntity discussgerenfenxiang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussgerenfenxiang);
        discussgerenfenxiangService.updateById(discussgerenfenxiang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussgerenfenxiangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussgerenfenxiangEntity> wrapper = new EntityWrapper<DiscussgerenfenxiangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussgerenfenxiangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}

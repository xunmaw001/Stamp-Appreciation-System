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

import com.entity.YoupiaofenleiEntity;
import com.entity.view.YoupiaofenleiView;

import com.service.YoupiaofenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 邮票分类
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
@RestController
@RequestMapping("/youpiaofenlei")
public class YoupiaofenleiController {
    @Autowired
    private YoupiaofenleiService youpiaofenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YoupiaofenleiEntity youpiaofenlei, 
		HttpServletRequest request){

        EntityWrapper<YoupiaofenleiEntity> ew = new EntityWrapper<YoupiaofenleiEntity>();
		PageUtils page = youpiaofenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youpiaofenlei), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YoupiaofenleiEntity youpiaofenlei, 
		HttpServletRequest request){
        EntityWrapper<YoupiaofenleiEntity> ew = new EntityWrapper<YoupiaofenleiEntity>();
		PageUtils page = youpiaofenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youpiaofenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YoupiaofenleiEntity youpiaofenlei){
       	EntityWrapper<YoupiaofenleiEntity> ew = new EntityWrapper<YoupiaofenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youpiaofenlei, "youpiaofenlei")); 
        return R.ok().put("data", youpiaofenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YoupiaofenleiEntity youpiaofenlei){
        EntityWrapper< YoupiaofenleiEntity> ew = new EntityWrapper< YoupiaofenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youpiaofenlei, "youpiaofenlei")); 
		YoupiaofenleiView youpiaofenleiView =  youpiaofenleiService.selectView(ew);
		return R.ok("查询邮票分类成功").put("data", youpiaofenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YoupiaofenleiEntity youpiaofenlei = youpiaofenleiService.selectById(id);
        return R.ok().put("data", youpiaofenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YoupiaofenleiEntity youpiaofenlei = youpiaofenleiService.selectById(id);
        return R.ok().put("data", youpiaofenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YoupiaofenleiEntity youpiaofenlei, HttpServletRequest request){
    	youpiaofenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youpiaofenlei);

        youpiaofenleiService.insert(youpiaofenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YoupiaofenleiEntity youpiaofenlei, HttpServletRequest request){
    	youpiaofenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youpiaofenlei);

        youpiaofenleiService.insert(youpiaofenlei);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YoupiaofenleiEntity youpiaofenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youpiaofenlei);
        youpiaofenleiService.updateById(youpiaofenlei);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youpiaofenleiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<YoupiaofenleiEntity> wrapper = new EntityWrapper<YoupiaofenleiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = youpiaofenleiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}

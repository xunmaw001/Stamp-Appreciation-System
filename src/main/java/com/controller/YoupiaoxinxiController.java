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

import com.entity.YoupiaoxinxiEntity;
import com.entity.view.YoupiaoxinxiView;

import com.service.YoupiaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 邮票信息
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
@RestController
@RequestMapping("/youpiaoxinxi")
public class YoupiaoxinxiController {
    @Autowired
    private YoupiaoxinxiService youpiaoxinxiService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YoupiaoxinxiEntity youpiaoxinxi, 
		HttpServletRequest request){

        EntityWrapper<YoupiaoxinxiEntity> ew = new EntityWrapper<YoupiaoxinxiEntity>();
		PageUtils page = youpiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youpiaoxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YoupiaoxinxiEntity youpiaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<YoupiaoxinxiEntity> ew = new EntityWrapper<YoupiaoxinxiEntity>();
		PageUtils page = youpiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youpiaoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YoupiaoxinxiEntity youpiaoxinxi){
       	EntityWrapper<YoupiaoxinxiEntity> ew = new EntityWrapper<YoupiaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youpiaoxinxi, "youpiaoxinxi")); 
        return R.ok().put("data", youpiaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YoupiaoxinxiEntity youpiaoxinxi){
        EntityWrapper< YoupiaoxinxiEntity> ew = new EntityWrapper< YoupiaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youpiaoxinxi, "youpiaoxinxi")); 
		YoupiaoxinxiView youpiaoxinxiView =  youpiaoxinxiService.selectView(ew);
		return R.ok("查询邮票信息成功").put("data", youpiaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YoupiaoxinxiEntity youpiaoxinxi = youpiaoxinxiService.selectById(id);
		youpiaoxinxi.setClicktime(new Date());
		youpiaoxinxiService.updateById(youpiaoxinxi);
        return R.ok().put("data", youpiaoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YoupiaoxinxiEntity youpiaoxinxi = youpiaoxinxiService.selectById(id);
		youpiaoxinxi.setClicktime(new Date());
		youpiaoxinxiService.updateById(youpiaoxinxi);
        return R.ok().put("data", youpiaoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YoupiaoxinxiEntity youpiaoxinxi, HttpServletRequest request){
    	youpiaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youpiaoxinxi);

        youpiaoxinxiService.insert(youpiaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YoupiaoxinxiEntity youpiaoxinxi, HttpServletRequest request){
    	youpiaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youpiaoxinxi);

        youpiaoxinxiService.insert(youpiaoxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YoupiaoxinxiEntity youpiaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youpiaoxinxi);
        youpiaoxinxiService.updateById(youpiaoxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youpiaoxinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<YoupiaoxinxiEntity> wrapper = new EntityWrapper<YoupiaoxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = youpiaoxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YoupiaoxinxiEntity youpiaoxinxi, HttpServletRequest request,String pre){
        EntityWrapper<YoupiaoxinxiEntity> ew = new EntityWrapper<YoupiaoxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        
        params.put("order", "desc");
		PageUtils page = youpiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youpiaoxinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,YoupiaoxinxiEntity youpiaoxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "youpiaofenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "youpiaoxinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<YoupiaoxinxiEntity> youpiaoxinxiList = new ArrayList<YoupiaoxinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                youpiaoxinxiList.addAll(youpiaoxinxiService.selectList(new EntityWrapper<YoupiaoxinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<YoupiaoxinxiEntity> ew = new EntityWrapper<YoupiaoxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = youpiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youpiaoxinxi), params), params));
        List<YoupiaoxinxiEntity> pageList = (List<YoupiaoxinxiEntity>)page.getList();
        if(youpiaoxinxiList.size()<limit) {
            int toAddNum = (limit-youpiaoxinxiList.size())<=pageList.size()?(limit-youpiaoxinxiList.size()):pageList.size();
            for(YoupiaoxinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(YoupiaoxinxiEntity o2 : youpiaoxinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    youpiaoxinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        }
        page.setList(youpiaoxinxiList);
        return R.ok().put("data", page);
    }





    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<YoupiaoxinxiEntity> ew = new EntityWrapper<YoupiaoxinxiEntity>();
        List<Map<String, Object>> result = youpiaoxinxiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<YoupiaoxinxiEntity> ew = new EntityWrapper<YoupiaoxinxiEntity>();
        List<Map<String, Object>> result = youpiaoxinxiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<YoupiaoxinxiEntity> ew = new EntityWrapper<YoupiaoxinxiEntity>();
        List<Map<String, Object>> result = youpiaoxinxiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }
}

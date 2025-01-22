package com.entity.view;

import com.entity.YoupiaofenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 邮票分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
@TableName("youpiaofenlei")
public class YoupiaofenleiView  extends YoupiaofenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YoupiaofenleiView(){
	}
 
 	public YoupiaofenleiView(YoupiaofenleiEntity youpiaofenleiEntity){
 	try {
			BeanUtils.copyProperties(this, youpiaofenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

package com.entity.view;

import com.entity.DiscussgerenfenxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 个人分享评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-06 10:33:31
 */
@TableName("discussgerenfenxiang")
public class DiscussgerenfenxiangView  extends DiscussgerenfenxiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussgerenfenxiangView(){
	}
 
 	public DiscussgerenfenxiangView(DiscussgerenfenxiangEntity discussgerenfenxiangEntity){
 	try {
			BeanUtils.copyProperties(this, discussgerenfenxiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

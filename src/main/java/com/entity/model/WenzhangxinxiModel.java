package com.entity.model;

import com.entity.WenzhangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 文章信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
public class WenzhangxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 文章封面
	 */
	
	private String wenzhangfengmian;
		
	/**
	 * 邮票分类
	 */
	
	private String youpiaofenlei;
		
	/**
	 * 文章简介
	 */
	
	private String wenzhangjianjie;
		
	/**
	 * 文章内容
	 */
	
	private String wenzhangneirong;
		
	/**
	 * 发布日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date faburiqi;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
				
	
	/**
	 * 设置：文章封面
	 */
	 
	public void setWenzhangfengmian(String wenzhangfengmian) {
		this.wenzhangfengmian = wenzhangfengmian;
	}
	
	/**
	 * 获取：文章封面
	 */
	public String getWenzhangfengmian() {
		return wenzhangfengmian;
	}
				
	
	/**
	 * 设置：邮票分类
	 */
	 
	public void setYoupiaofenlei(String youpiaofenlei) {
		this.youpiaofenlei = youpiaofenlei;
	}
	
	/**
	 * 获取：邮票分类
	 */
	public String getYoupiaofenlei() {
		return youpiaofenlei;
	}
				
	
	/**
	 * 设置：文章简介
	 */
	 
	public void setWenzhangjianjie(String wenzhangjianjie) {
		this.wenzhangjianjie = wenzhangjianjie;
	}
	
	/**
	 * 获取：文章简介
	 */
	public String getWenzhangjianjie() {
		return wenzhangjianjie;
	}
				
	
	/**
	 * 设置：文章内容
	 */
	 
	public void setWenzhangneirong(String wenzhangneirong) {
		this.wenzhangneirong = wenzhangneirong;
	}
	
	/**
	 * 获取：文章内容
	 */
	public String getWenzhangneirong() {
		return wenzhangneirong;
	}
				
	
	/**
	 * 设置：发布日期
	 */
	 
	public void setFaburiqi(Date faburiqi) {
		this.faburiqi = faburiqi;
	}
	
	/**
	 * 获取：发布日期
	 */
	public Date getFaburiqi() {
		return faburiqi;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
			
}

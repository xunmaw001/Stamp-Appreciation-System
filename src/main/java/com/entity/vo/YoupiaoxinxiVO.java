package com.entity.vo;

import com.entity.YoupiaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 邮票信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
public class YoupiaoxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 邮票封面
	 */
	
	private String youpiaofengmian;
		
	/**
	 * 邮票分类
	 */
	
	private String youpiaofenlei;
		
	/**
	 * 作者
	 */
	
	private String zuozhe;
		
	/**
	 * 发布年限
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabunianxian;
		
	/**
	 * 材质
	 */
	
	private String caizhi;
		
	/**
	 * 尺寸
	 */
	
	private String chicun;
		
	/**
	 * 面值
	 */
	
	private String mianzhi;
		
	/**
	 * 印刷单位
	 */
	
	private String yinshuadanwei;
		
	/**
	 * 邮票详情
	 */
	
	private String youpiaoxiangqing;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
				
	
	/**
	 * 设置：邮票封面
	 */
	 
	public void setYoupiaofengmian(String youpiaofengmian) {
		this.youpiaofengmian = youpiaofengmian;
	}
	
	/**
	 * 获取：邮票封面
	 */
	public String getYoupiaofengmian() {
		return youpiaofengmian;
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
	 * 设置：作者
	 */
	 
	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}
	
	/**
	 * 获取：作者
	 */
	public String getZuozhe() {
		return zuozhe;
	}
				
	
	/**
	 * 设置：发布年限
	 */
	 
	public void setFabunianxian(Date fabunianxian) {
		this.fabunianxian = fabunianxian;
	}
	
	/**
	 * 获取：发布年限
	 */
	public Date getFabunianxian() {
		return fabunianxian;
	}
				
	
	/**
	 * 设置：材质
	 */
	 
	public void setCaizhi(String caizhi) {
		this.caizhi = caizhi;
	}
	
	/**
	 * 获取：材质
	 */
	public String getCaizhi() {
		return caizhi;
	}
				
	
	/**
	 * 设置：尺寸
	 */
	 
	public void setChicun(String chicun) {
		this.chicun = chicun;
	}
	
	/**
	 * 获取：尺寸
	 */
	public String getChicun() {
		return chicun;
	}
				
	
	/**
	 * 设置：面值
	 */
	 
	public void setMianzhi(String mianzhi) {
		this.mianzhi = mianzhi;
	}
	
	/**
	 * 获取：面值
	 */
	public String getMianzhi() {
		return mianzhi;
	}
				
	
	/**
	 * 设置：印刷单位
	 */
	 
	public void setYinshuadanwei(String yinshuadanwei) {
		this.yinshuadanwei = yinshuadanwei;
	}
	
	/**
	 * 获取：印刷单位
	 */
	public String getYinshuadanwei() {
		return yinshuadanwei;
	}
				
	
	/**
	 * 设置：邮票详情
	 */
	 
	public void setYoupiaoxiangqing(String youpiaoxiangqing) {
		this.youpiaoxiangqing = youpiaoxiangqing;
	}
	
	/**
	 * 获取：邮票详情
	 */
	public String getYoupiaoxiangqing() {
		return youpiaoxiangqing;
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

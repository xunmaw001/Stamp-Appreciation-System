package com.entity.vo;

import com.entity.GerenfenxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 个人分享
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
public class GerenfenxiangVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 分享封面
	 */
	
	private String fenxiangfengmian;
		
	/**
	 * 分享简介
	 */
	
	private String fenxiangjianjie;
		
	/**
	 * 分享内容
	 */
	
	private String fenxiangneirong;
		
	/**
	 * 分享日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fenxiangriqi;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
				
	
	/**
	 * 设置：分享封面
	 */
	 
	public void setFenxiangfengmian(String fenxiangfengmian) {
		this.fenxiangfengmian = fenxiangfengmian;
	}
	
	/**
	 * 获取：分享封面
	 */
	public String getFenxiangfengmian() {
		return fenxiangfengmian;
	}
				
	
	/**
	 * 设置：分享简介
	 */
	 
	public void setFenxiangjianjie(String fenxiangjianjie) {
		this.fenxiangjianjie = fenxiangjianjie;
	}
	
	/**
	 * 获取：分享简介
	 */
	public String getFenxiangjianjie() {
		return fenxiangjianjie;
	}
				
	
	/**
	 * 设置：分享内容
	 */
	 
	public void setFenxiangneirong(String fenxiangneirong) {
		this.fenxiangneirong = fenxiangneirong;
	}
	
	/**
	 * 获取：分享内容
	 */
	public String getFenxiangneirong() {
		return fenxiangneirong;
	}
				
	
	/**
	 * 设置：分享日期
	 */
	 
	public void setFenxiangriqi(Date fenxiangriqi) {
		this.fenxiangriqi = fenxiangriqi;
	}
	
	/**
	 * 获取：分享日期
	 */
	public Date getFenxiangriqi() {
		return fenxiangriqi;
	}
				
	
	/**
	 * 设置：账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
			
}

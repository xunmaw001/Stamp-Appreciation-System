package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 个人分享
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-06 10:33:30
 */
@TableName("gerenfenxiang")
public class GerenfenxiangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GerenfenxiangEntity() {
		
	}
	
	public GerenfenxiangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 分享标题
	 */
					
	private String fenxiangbiaoti;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：分享标题
	 */
	public void setFenxiangbiaoti(String fenxiangbiaoti) {
		this.fenxiangbiaoti = fenxiangbiaoti;
	}
	/**
	 * 获取：分享标题
	 */
	public String getFenxiangbiaoti() {
		return fenxiangbiaoti;
	}
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

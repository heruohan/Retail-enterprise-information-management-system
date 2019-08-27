package com.lzw.dao.model;

import java.io.*;

public class TbRukuDetail implements Serializable{
	
	private String id;    //流水号
	private String tbSpinfo;    //商品信息,对应tb_ruku_detail中的spid
	private String tbRukuMain;    //入库主表
	private Double dj;    //单价
	private Integer sl;    //数量
	
	
	//构造函数
	public TbRukuDetail()
	{
		
	}
	
	public TbRukuDetail(String tbSpinfo,String tbRukuMain,Double dj,Integer sl)
	{
		this.tbSpinfo=tbSpinfo;
		this.tbRukuMain=tbRukuMain;
		this.dj=dj;
		this.sl=sl;
	}
	
	
	
	//将入库明细类的私有属性进行封装
	
	//String:id
	public void setId(String id)
	{
		this.id=id;
	}
	public String getId()
	{
		return id;
	}
	
	
	//String:tbSpinfo
	public void setTbSpinfo(String tbSpinfo)
	{
		this.tbSpinfo=tbSpinfo;
	}
	public String getTbSpinfo()
	{
		return tbSpinfo;
	}
	
	
	//String:tbRukuMain
	public void setTbRukuMain(String tbRukuMain)
	{
		this.tbRukuMain=tbRukuMain;
	}
	public String getTbRukuMain()
	{
		return tbRukuMain;
	}
	
	
	//Double:dj
	public void setDj(Double dj)
	{
		this.dj=dj;
	}
	
	public Double getDj()
	{
		return dj;
	}
	
	
	//Integer:sl
	public void setSl(Integer sl)
	{
		this.sl=sl;
	}
	
	public Integer getSl()
	{
		return sl;
	}

}

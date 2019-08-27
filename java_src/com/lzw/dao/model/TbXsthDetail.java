package com.lzw.dao.model;

import java.io.Serializable;

public class TbXsthDetail implements Serializable{
	
	private Integer id;    //销售退货编号
	private String tbXsthMain;    //销售退货主表
	private String spid;    //商品编号
	private Double dj;    //单价
	private Integer sl;    //数量
	
	
	
	//构造函数
	public TbXsthDetail()
	{
		
	}
	
	public TbXsthDetail(String tbXsthMain,String spid,Double dj,Integer sl)
	{
		this.tbXsthMain=tbXsthMain;
		this.spid=spid;
		this.dj=dj;
		this.sl=sl;
	}
	
	
	
	//将销售退货详细信息类的私有属性进行封装
	
	//Integer:id
	public void setId(Integer id)
	{
		this.id=id;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	
	
	//String tbXsthMain
	public void setTbXsthMain(String tbXsthMain)
	{
		this.tbXsthMain=tbXsthMain;
	}
	
	public String getTbXsthMain()
	{
		return tbXsthMain;
	}
	
	
	
	//String:spid
	public void setSpid(String spid)
	{
		this.spid=spid;
	}
	
	public String getSpid()
	{
		return spid;
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
	
	
	
	//Integer sl
	public void setSl(Integer sl)
	{
		this.sl=sl;
	}
	
	public Integer getSl()
	{
		return sl;
	}

}

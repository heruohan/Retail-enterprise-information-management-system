package com.lzw.dao.model;

import java.io.Serializable;

public class TbSellDetail implements Serializable{
	
	private Integer id;    //流水号
	private String tbSellMain;    //销售主表
	private String spid;    //商品编号
	private Double dj;    //销售单价
	private Integer sl;    //销售数量
	
	
	
	//构造函数
	public TbSellDetail()
	{
		
	}
	
	public TbSellDetail(String tbSellMain,String spid,Double dj,Integer sl)
	{
		this.tbSellMain=tbSellMain;
		this.spid=spid;
		this.dj=dj;
		this.sl=sl;
	}
	
	
	//将销售明细类的私有属性进行封装
	
	//Integer:id
	public void setId(Integer id)
	{
		this.id=id;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	
	
	//String tbSellMain
	public void setTbSellMain(String tbSellMain)
	{
		this.tbSellMain=tbSellMain;
	}
	
	public String getTbSellMain()
	{
		return tbSellMain;
	}
	
	
	
	//String spid
	public void setSpid(String spid)
	{
		this.spid=spid;
	}
	
	public String getSpid()
	{
		return spid;
	}
	
	
	
	//Double dj
	public void setDj(Double dj)
	{
		this.dj=dj;
	}
	
	public Double getDj()
	{
		return dj;
	}
	
	
	
	//Integer  sl
	public void setSl(Integer sl)
	{
		this.sl=sl;
	}
	
	public Integer getSl()
	{
		return sl;
	}

}

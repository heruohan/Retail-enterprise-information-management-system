package com.lzw.dao.model;

import java.io.*;

public class TbRkthDetail implements Serializable{
	
	private Integer id;    //进货退货编号
	private String tbRkthMain;    //进货退货主表
	private String spid;    //商品编号
	private Double dj;    //单价
	private Integer sl;    //数量
	
	
	
	//Construct Method
	public TbRkthDetail()
	{
		
	}
	
	public TbRkthDetail(String tbRkthMain,String spid,Double dj,Integer sl)
	{
		this.tbRkthMain=tbRkthMain;
		this.spid=spid;
		this.dj=dj;
		this.sl=sl;
	}
	
	
	
	//将进货退货详细信息类的私有属性进行封装
	//id
	public void setId(Integer id)
	{
		this.id=id;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	
	//tbRkthMain
	public void setTbRkthMain(String tbRkthMain)
	{
		this.tbRkthMain=tbRkthMain;
	}
	
	public String getTbRkthMain()
	{
		return tbRkthMain;
	}
	
	
	//spid
	public void setSpid(String spid)
	{
		this.spid=spid;
	}
	
	public String getSpid()
	{
		return spid;
	}
	
	
	//dj
	public void setDj(Double dj)
	{
		this.dj=dj;
	}
	
	public Double getDj()
	{
		return dj;
	}
	
	
	//sl
	public void setSl(Integer sl)
	{
		this.sl=sl;
	}
	
	public Integer getSl()
	{
		return sl;
	}

}

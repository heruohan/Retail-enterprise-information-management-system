package com.lzw.dao.model;

import java.io.*;


public class TbKucun implements Serializable{
	
	private String id;    //商品编号
	private String spname;    //商品名称
	private String jc;    //商品简称
	private String cd;    //商品产地
	private String gg;    //商品规格
	private String bz;    //商品包装
	private String dw;    //商品计量单位
	private Double dj;    //单价
	private Integer kcsl;    //库存数量
	
	
	
	//Construct method
	public TbKucun()
	{
		
	}
	
	public TbKucun(String id)
	{
		this.id=id;
	}
	
	public TbKucun(String id,String spname,String jc,String cd,String gg,String bz,String dw,
			       Double dj,Integer kcsl)
	{
		this.id=id;
		this.spname=spname;
		this.jc=jc;
		this.cd=cd;
		this.gg=gg;
		this.bz=bz;
		this.dw=dw;
		this.dj=dj;
		this.kcsl=kcsl;
	}
	
	
	
	//id
	public void setId(String id)
	{
		this.id=id;
	}
	
	public String getId()
	{
		return id;
	}
	
	
	//spname
	public void setSpname(String spname)
	{
		this.spname=spname;
	}
	
	public String getSpname()
	{
		return spname;
	}
	
	
	//jc
	public void setJc(String jc)
	{
		this.jc=jc;
	}
	
	public String getJc()
	{
		return jc;
	}
	
	
	//cd
	public void setCd(String cd)
	{
		this.cd=cd;
	}
	
	public String getCd()
	{
		return cd;
	}
	
	
	//gg
	public void setGg(String gg)
	{
		this.gg=gg;
	}
	
	public String getGg()
	{
		return gg;
	}
	
	
	//bz
	public void setBz(String bz)
	{
		this.bz=bz;
	}
	
	public String getBz()
	{
		return bz;
	}
	
	
	//dw
	public void setDw(String dw)
	{
		this.dw=dw;
	}
	
	public String getDw()
	{
		return dw;
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
	
	
	//kcsl
	public void setKcsl(Integer kcsl)
	{
		this.kcsl=kcsl;
	}
	
	public Integer getKcsl()
	{
		return kcsl;
	}
	
	
	//Overrider toString() method
	public String toString()
	{
		return getSpname();
	}

}

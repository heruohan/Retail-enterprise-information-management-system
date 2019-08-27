package com.lzw.dao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class TbSellMain implements Serializable{
	
	private String sellId;    //销售编号
	private String pzs;    //销售品种数
	private String je;    //总计金额
	private String ysjl;    //验收结论
	private String khname;    //客户名称
	private String xsdate;    //销售日期
	private String czy;    //操作员
	private String jsr;    //经手人
	private String jsfs;    //结算方式
	private Set<TbSellDetail> tbSellDetails=new HashSet<>(0);    //销售明细
	
	
	
	//构造函数
	public TbSellMain()
	{
		
	}
	
	public TbSellMain(String sellId,String pzs,String je,String ysjl,String khname,String xsdate,
			           String czy,String jsr,String jsfs)
	{
		this.sellId=sellId;
		this.pzs=pzs;
		this.je=je;
		this.ysjl=ysjl;
		this.khname=khname;
		this.xsdate=xsdate;
		this.czy=czy;
		this.jsr=jsr;
		this.jsfs=jsfs;
	}
	
	
	
	//将销售主表类的私有属性进行封装
	
	//String:sellId
	public void setSellId(String sellId)
	{
		this.sellId=sellId;
	}
	
	public String getSellId()
	{
		return sellId;
	}
	
	
	
	//String:pzs
	public void setPzs(String pzs)
	{
		this.pzs=pzs;
	}
	
	public String getPzs()
	{
		return pzs;
	}
	
	
	
	//String:je
	public void setJe(String je)
	{
		this.je=je;
	}
	
	public String getJe()
	{
		return je;
	}
	
	
	
	//String:ysjl
	public void setYsjl(String ysjl)
	{
		this.ysjl=ysjl;
	}
	
	public String getYsjl()
	{
		return ysjl;
	}
	
	
	
	//String:khname
	public void setKhname(String khname)
	{
		this.khname=khname;
	}
	
	public String getKhname()
	{
		return khname;
	}
	
	
	
	//String:xsdate
	public void setXsdate(String xsdate)
	{
		this.xsdate=xsdate;
	}
	
	public String getXsdate()
	{
		return xsdate;
	}
	
	
	
	//String:czy
	public void setCzy(String czy)
	{
		this.czy=czy;
	}
	
	public String getCzy()
	{
		return czy;
	}
	
	
	
	//String:jsr
	public void setJsr(String jsr)
	{
		this.jsr=jsr;
	}
	
	public String getJsr()
	{
		return jsr;
	}
	
	
	
	//Sring:jsfs
	public void setJsfs(String jsfs)
	{
		this.jsfs=jsfs;
	}
	
	public String getJsfs()
	{
		return jsfs;
	}
	
	
	
	//Set<TbSellDetail>:tbSellDetails
	public void setTbSellDetails(Set<TbSellDetail> tbSellDetails)
	{
		this.tbSellDetails=tbSellDetails;
	}
	
	public Set<TbSellDetail> getTbSellDetails()
	{
		return tbSellDetails;
	}
	
}

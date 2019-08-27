package com.lzw.dao.model;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;


public class TbXsthMain implements Serializable{
	
	private String xsthId;    //销售退货编号
	private String pzs;    //品种数
	private String je;    //总计金额
	private String ysjl;    //验收结论
	private String khname;    //客户名称
	private String thdate;    //退货日期
	private String czy;    //操作员
	private String jsr;    //经手人
	private String jsfs;    //结算方式
	private Set<TbXsthDetail> tbXsthDetails=new HashSet<>(0);
	
	
	
	//构造函数
	public TbXsthMain()
	{
		
	}
	
	public TbXsthMain(String xsthId,String pzs,String je,String ysjl,String khname,
			         String thdate,String czy,String jsr,String jsfs)
	{
		this.xsthId=xsthId;
		this.pzs=pzs;
		this.je=je;
		this.ysjl=ysjl;
		this.khname=khname;
		this.thdate=thdate;
		this.czy=czy;
		this.jsr=jsr;
		this.jsfs=jsfs;
	}
	
	
	
	//将销售退货主表信息类的私有属性进行封装
	
	//String xsthId
	public void setXsthId(String xsthId)
	{
		this.xsthId=xsthId;
	}
	public String getXsthId()
	{
		return xsthId;
	}
	
	
	
	//String pzs
	public void setPzs(String pzs)
	{
		this.pzs=pzs;
	}
	public String getPzs()
	{
		return pzs;
	}
	
	
	
	//String je
	public void setJe(String je)
	{
		this.je=je;
	}
	public String getJe()
	{
		return je;
	}
	
	
	
	//String ysjl
	public void setYsjl(String ysjl)
	{
		this.ysjl=ysjl;
	}
	public String getYsjl()
	{
		return ysjl;
	}
	
	
	
	//String khname
	public void setKhname(String khname)
	{
		this.khname=khname;
	}
	public String getKhname()
	{
		return khname;
	}
	
	
	
	//String thdate
	public void setThdate(String thdate)
	{
		this.thdate=thdate;
	}
	public String getThdate()
	{
		return thdate;
	}
	
	
	
	//String czy
	public void setCzy(String czy)
	{
		this.czy=czy;
	}
	public String getCzy()
	{
		return czy;
	}
	
	
	
	//String jsr
	public void setJsr(String jsr)
	{
		this.jsr=jsr;
	}
	public String getJsr()
	{
		return jsr;
	}
	
	
	
	//String jsfs
	public void setJsfs(String jsfs)
	{
		this.jsfs=jsfs;
	}
	public String getJsfs()
	{
		return jsfs;
	}
	
	
	
	//Set<TbXsthDetail> tbXsthDetails
	public void setTbXsthDetails(Set<TbXsthDetail> tbXsthDetails)
	{
		this.tbXsthDetails=tbXsthDetails;
	}
	public Set<TbXsthDetail> getTbXsthDetails()
	{
		return tbXsthDetails;
	}
	
}

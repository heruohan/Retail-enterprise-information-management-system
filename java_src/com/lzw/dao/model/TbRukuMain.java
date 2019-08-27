package com.lzw.dao.model;

import java.io.*;
import java.util.HashSet;
import java.util.Set;


public class TbRukuMain implements Serializable{
	
	private String rkId;    //�����
	private String pzs;    //Ʒ����
	private String je;    //�ܼƽ��
	private String ysjl;    //���ս���
	private String gysname;    //��Ӧ������
	private String rkdate;    //���ʱ��
	private String czy;    //����Ա
	private String jsr;    //������
	private String jsfs;    //���㷽ʽ
	private Set<TbRukuDetail> tabRukuDetails=new HashSet<>(0);    //�����ϸ
	
	
	
	//���캯��
	public TbRukuMain()
	{
		
	}
	
	public TbRukuMain(String rkId,String pzs,String je,String ysjl,String gysname,
			         String rkdate,String czy,String jsr,String jsfs)
	{
		this.rkId=rkId;
		this.pzs=pzs;
		this.je=je;
		this.ysjl=ysjl;
		this.gysname=gysname;
		this.rkdate=rkdate;
		this.czy=czy;
		this.jsr=jsr;
		this.jsfs=jsfs;
	}
	
	
	
	//������������˽�����Խ��з�װ
	
	//String:rkId
	public void setRkId(String rkId)
	{
		this.rkId=rkId;
	}
	public String getRkId()
	{
		return rkId;
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
	
	
	//String gysname
	public void setGysname(String gysname)
	{
		this.gysname=gysname;
	}
	public String getGysname()
	{
		return gysname;
	}
	
	
	//String rkdate
	public void setRkdate(String rkdate)
	{
		this.rkdate=rkdate;
	}
	public String getRkdate()
	{
		return rkdate;
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
	
	
	//Set<TbRukuDetail>:tabRukuDetails
	public void setTabRukuDetail(Set<TbRukuDetail> tabRukuDetails)
	{
		this.tabRukuDetails=tabRukuDetails;
	}
	
	public Set<TbRukuDetail> getTabRukuDetails()
	{
		return tabRukuDetails;
	}

}

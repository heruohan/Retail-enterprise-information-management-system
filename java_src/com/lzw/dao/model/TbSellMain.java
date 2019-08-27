package com.lzw.dao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class TbSellMain implements Serializable{
	
	private String sellId;    //���۱��
	private String pzs;    //����Ʒ����
	private String je;    //�ܼƽ��
	private String ysjl;    //���ս���
	private String khname;    //�ͻ�����
	private String xsdate;    //��������
	private String czy;    //����Ա
	private String jsr;    //������
	private String jsfs;    //���㷽ʽ
	private Set<TbSellDetail> tbSellDetails=new HashSet<>(0);    //������ϸ
	
	
	
	//���캯��
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
	
	
	
	//�������������˽�����Խ��з�װ
	
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

package com.lzw.dao.model;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;


public class TbXsthMain implements Serializable{
	
	private String xsthId;    //�����˻����
	private String pzs;    //Ʒ����
	private String je;    //�ܼƽ��
	private String ysjl;    //���ս���
	private String khname;    //�ͻ�����
	private String thdate;    //�˻�����
	private String czy;    //����Ա
	private String jsr;    //������
	private String jsfs;    //���㷽ʽ
	private Set<TbXsthDetail> tbXsthDetails=new HashSet<>(0);
	
	
	
	//���캯��
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
	
	
	
	//�������˻�������Ϣ���˽�����Խ��з�װ
	
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

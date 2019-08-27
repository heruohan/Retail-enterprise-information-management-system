package com.lzw.dao.model;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class TbRkthMain implements Serializable{
	
	private String rkthId;    //�����˻����
	private String pzs;    //����Ʒ����
	private String je;    //�ܼƽ��
	private String ysjl;    //���ս���
	private String gysname;    //��Ӧ������
	private String rtdate;    //�����˻�ʱ��
	private String czy;    //����Ա
	private String jsr;    //������
	private String jsfs;    //���㷽ʽ
	private Set<TbRkthDetail> tbRkthDetails=new HashSet<>(0);    //�����˻���ϸ��Ϣ
	
	
	
	//���캯��
	public TbRkthMain()
	{
		
	}
	
	public TbRkthMain(String rkthId,String pzs,String je,String ysjl,String gysname,
			          String rtdate,String czy,String jsr,String jsfs)
	{
		this.rkthId=rkthId;
		this.pzs=pzs;
		this.je=je;
		this.ysjl=ysjl;
		this.gysname=gysname;
		this.rtdate=rtdate;
		this.czy=czy;
		this.jsr=jsr;
		this.jsfs=jsfs;
	}
	
	
	
	//�������˻���������Ϣ���˽�����Խ��з�װ
	
	//String:rkthId
	public void setRkthId(String rkthId)
	{
		this.rkthId=rkthId;
	}
	
	public String getRkthId()
	{
		return rkthId;
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
	
	
	//String:gysname
	public void setGysname(String gysname)
	{
		this.gysname=gysname;
	}
	
	public String getGysname()
	{
		return gysname;
	}
	
	
	//String:rtdate
	public void setRtdate(String rtdate)
	{
		this.rtdate=rtdate;
	}
	
	public String getRtdate()
	{
		return rtdate;
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
	
	
	//String:jsfs
	public void setJsfs(String jsfs)
	{
		this.jsfs=jsfs;
	}
	
	public String getJsfs()
	{
		return jsfs;
	}
	
	
	//Set:tbRkthDetails
	public void setTbRkthDetail(Set tbRkthDetail)
	{
		this.tbRkthDetails=tbRkthDetail;
	}
	
	public Set getTbRkthDetail()
	{
		return tbRkthDetails;
	}
	
}

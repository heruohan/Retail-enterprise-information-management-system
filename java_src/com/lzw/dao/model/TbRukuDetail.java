package com.lzw.dao.model;

import java.io.*;

public class TbRukuDetail implements Serializable{
	
	private String id;    //��ˮ��
	private String tbSpinfo;    //��Ʒ��Ϣ,��Ӧtb_ruku_detail�е�spid
	private String tbRukuMain;    //�������
	private Double dj;    //����
	private Integer sl;    //����
	
	
	//���캯��
	public TbRukuDetail()
	{
		
	}
	
	public TbRukuDetail(String tbSpinfo,String tbRukuMain,Double dj,Integer sl)
	{
		this.tbSpinfo=tbSpinfo;
		this.tbRukuMain=tbRukuMain;
		this.dj=dj;
		this.sl=sl;
	}
	
	
	
	//�������ϸ���˽�����Խ��з�װ
	
	//String:id
	public void setId(String id)
	{
		this.id=id;
	}
	public String getId()
	{
		return id;
	}
	
	
	//String:tbSpinfo
	public void setTbSpinfo(String tbSpinfo)
	{
		this.tbSpinfo=tbSpinfo;
	}
	public String getTbSpinfo()
	{
		return tbSpinfo;
	}
	
	
	//String:tbRukuMain
	public void setTbRukuMain(String tbRukuMain)
	{
		this.tbRukuMain=tbRukuMain;
	}
	public String getTbRukuMain()
	{
		return tbRukuMain;
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
	
	
	//Integer:sl
	public void setSl(Integer sl)
	{
		this.sl=sl;
	}
	
	public Integer getSl()
	{
		return sl;
	}

}

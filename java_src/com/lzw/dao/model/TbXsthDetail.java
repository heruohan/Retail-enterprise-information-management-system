package com.lzw.dao.model;

import java.io.Serializable;

public class TbXsthDetail implements Serializable{
	
	private Integer id;    //�����˻����
	private String tbXsthMain;    //�����˻�����
	private String spid;    //��Ʒ���
	private Double dj;    //����
	private Integer sl;    //����
	
	
	
	//���캯��
	public TbXsthDetail()
	{
		
	}
	
	public TbXsthDetail(String tbXsthMain,String spid,Double dj,Integer sl)
	{
		this.tbXsthMain=tbXsthMain;
		this.spid=spid;
		this.dj=dj;
		this.sl=sl;
	}
	
	
	
	//�������˻���ϸ��Ϣ���˽�����Խ��з�װ
	
	//Integer:id
	public void setId(Integer id)
	{
		this.id=id;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	
	
	//String tbXsthMain
	public void setTbXsthMain(String tbXsthMain)
	{
		this.tbXsthMain=tbXsthMain;
	}
	
	public String getTbXsthMain()
	{
		return tbXsthMain;
	}
	
	
	
	//String:spid
	public void setSpid(String spid)
	{
		this.spid=spid;
	}
	
	public String getSpid()
	{
		return spid;
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
	
	
	
	//Integer sl
	public void setSl(Integer sl)
	{
		this.sl=sl;
	}
	
	public Integer getSl()
	{
		return sl;
	}

}

package com.lzw.dao.model;

import java.io.*;

public class TbRkthDetail implements Serializable{
	
	private Integer id;    //�����˻����
	private String tbRkthMain;    //�����˻�����
	private String spid;    //��Ʒ���
	private Double dj;    //����
	private Integer sl;    //����
	
	
	
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
	
	
	
	//�������˻���ϸ��Ϣ���˽�����Խ��з�װ
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

package com.lzw.dao.model;

import java.io.Serializable;

public class TbSellDetail implements Serializable{
	
	private Integer id;    //��ˮ��
	private String tbSellMain;    //��������
	private String spid;    //��Ʒ���
	private Double dj;    //���۵���
	private Integer sl;    //��������
	
	
	
	//���캯��
	public TbSellDetail()
	{
		
	}
	
	public TbSellDetail(String tbSellMain,String spid,Double dj,Integer sl)
	{
		this.tbSellMain=tbSellMain;
		this.spid=spid;
		this.dj=dj;
		this.sl=sl;
	}
	
	
	//��������ϸ���˽�����Խ��з�װ
	
	//Integer:id
	public void setId(Integer id)
	{
		this.id=id;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	
	
	//String tbSellMain
	public void setTbSellMain(String tbSellMain)
	{
		this.tbSellMain=tbSellMain;
	}
	
	public String getTbSellMain()
	{
		return tbSellMain;
	}
	
	
	
	//String spid
	public void setSpid(String spid)
	{
		this.spid=spid;
	}
	
	public String getSpid()
	{
		return spid;
	}
	
	
	
	//Double dj
	public void setDj(Double dj)
	{
		this.dj=dj;
	}
	
	public Double getDj()
	{
		return dj;
	}
	
	
	
	//Integer  sl
	public void setSl(Integer sl)
	{
		this.sl=sl;
	}
	
	public Integer getSl()
	{
		return sl;
	}

}

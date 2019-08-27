package com.lzw.dao.model;

import java.io.*;


public class TbKhinfo implements Serializable{
	
	private String id;  //�ͻ����
	private String khname;   //�ͻ�����
	private String jian;    //�ͻ����
	private String address;    //�ͻ���ַ
	private String bianma;    //�ʱ�
	private String tel;    //�绰
	private String fax;    //����
	private String lian;    //��ϵ��
	private String ltel;    //��ϵ�绰
	private String mail;    //��������
	private String xinhang;    //��������
	private String hao;    //�����˺�
	
	
	
	//Construct Method
	public TbKhinfo()
	{
		
	}
	
	public TbKhinfo(String id)
	{
		this.id=id;
	}
	
	public TbKhinfo(String id,String khname,String jian,String address,String bianma,String tel,
			        String fax,String lian,String ltel,String mail,String xinhang,String hao)
	{
		this.id=id;
		this.khname=khname;
		this.jian=jian;
		this.address=address;
		this.bianma=bianma;
		this.tel=tel;
		this.fax=fax;
		this.lian=lian;
		this.ltel=ltel;
		this.mail=mail;
		this.xinhang=xinhang;
		this.hao=hao;
	}
	
	
	//���ͻ���Ϣ���˽�����Խ��з�װ
	
	//id
	public void setId(String id)
	{
		this.id=id;
	}
	
	public String getId()
	{
		return id;
	}
	
	
	//khname
	public void setKhname(String khname)
	{
		this.khname=khname;
	}
	
	public String getKhname()
	{
		return khname;
	}
	
	
	//jian
	public void setJian(String jian)
	{
		this.jian=jian;
	}
	
	public String getJian()
	{
		return jian;
	}
	
	
	//address
	public void setAddress(String address)
	{
		this.address=address;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	
	//bianma
	public void setBianma(String bianma)
	{
		this.bianma=bianma;
	}
	
	public String getBianma()
	{
		return bianma;
	}
	
	
	//tel
	public void setTel(String tel)
	{
		this.tel=tel;
	}
	
	public String getTel()
	{
		return tel;
	}
	
	
	//fax
	public void setFax(String fax)
	{
		this.fax=fax;
	}
	
	public String getFax()
	{
		return fax;
	}
	
	
	//lian
	public void setLian(String lian)
	{
		this.lian=lian;
	}
	
	public String getLian()
	{
		return lian;
	}
	
	
	//ltel
	public void setLtel(String ltel)
	{
		this.ltel=ltel;
	}
	
	public String getLtel()
	{
		return ltel;
	}
	
	
	//mail
	public void setMail(String mail)
	{
		this.mail=mail;
	}
	
	public String getMail()
	{
		return mail;
	}
	
	
	//xinhang
	public void setXinhang(String xinhang)
	{
		this.xinhang=xinhang;
	}
	
	public String getXinhang()
	{
		return xinhang;
	}
	
	
	//hao
	public void setHao(String hao)
	{
		this.hao=hao;
	}
	
	public String getHao()
	{
		return hao;
	}
	
}

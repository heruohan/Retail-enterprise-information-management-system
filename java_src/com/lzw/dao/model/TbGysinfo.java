package com.lzw.dao.model;


import java.io.*;

public class TbGysinfo implements Serializable{
	
	private String id;  //��Ӧ�̱��
	private String name;  //��Ӧ������
	private String jc;   //��Ӧ�̼��
	private String address; //��Ӧ�̵�ַ
	private String bianma;  //��Ӧ����������
	private String tel;   //��Ӧ�̵绰
	private String fax;   //��Ӧ�̴���
	private String lian;  //��Ӧ����ϵ��
	private String ltel;  //��ϵ�˵���ϵ�绰
	private String yh;    //��������
	private String mail;  //����
	
	
	//Construct Method
	public TbGysinfo()
	{
		
	}
	
	public TbGysinfo(String id)
	{
		this.id=id;
	}
	
	public TbGysinfo(String id,String name,String jc,String address,String bianma,String tel,
			           String fax,String lian,String ltel,String yh,String mail)
	{
		this.id=id;
		this.name=name;
		this.jc=jc;
		this.address=address;
		this.bianma=bianma;
		this.tel=tel;
		this.fax=fax;
		this.lian=lian;
		this.ltel=ltel;
		this.yh=yh;
		this.mail=mail;
	}
	
	
	
	//����Ӧ�̵�˽�����Խ��з�װ
	//id
	public void setId(String id)
	{
		this.id=id;
	}
	public String getId()
	{
		return id;
	}
	
	
	//name
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	
	//jc
	public void setJc(String jc)
	{
		this.jc=jc;
	}
	public String getJc()
	{
		return jc;
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
	
	
	//yh
	public void setYh(String yh)
	{
		this.yh=yh;
	}
	public String getYh()
	{
		return yh;
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
}

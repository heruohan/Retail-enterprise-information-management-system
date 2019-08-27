package com.lzw.dao.model;


import java.io.*;

public class TbGysinfo implements Serializable{
	
	private String id;  //供应商编号
	private String name;  //供应商姓名
	private String jc;   //供应商简称
	private String address; //供应商地址
	private String bianma;  //供应商邮政编码
	private String tel;   //供应商电话
	private String fax;   //供应商传真
	private String lian;  //供应商联系人
	private String ltel;  //联系人的联系电话
	private String yh;    //开户银行
	private String mail;  //邮箱
	
	
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
	
	
	
	//将供应商的私有属性进行封装
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

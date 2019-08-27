package com.lzw.dao.model;

import java.io.*;


public class TbKhinfo implements Serializable{
	
	private String id;  //客户编号
	private String khname;   //客户名称
	private String jian;    //客户简称
	private String address;    //客户地址
	private String bianma;    //邮编
	private String tel;    //电话
	private String fax;    //传真
	private String lian;    //联系人
	private String ltel;    //联系电话
	private String mail;    //电子邮箱
	private String xinhang;    //开户银行
	private String hao;    //银行账号
	
	
	
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
	
	
	//将客户信息类的私有属性进行封装
	
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

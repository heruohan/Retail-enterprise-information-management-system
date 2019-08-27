package com.lzw.dao.model;


public class TbUserlist {
	
	private String name;    //用户名字
	private String pass;    //用户密码
	
	
	//构造方法
	public TbUserlist()
	{
		
	}
	
	public TbUserlist(String name ,String pass)
	{
		this.name=name;
		this.pass=pass;
		
	}
	
	
	
	//将用户类的私有属性进行封装
	
	//String:name
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	
	
	
	//String:pass
	public void setPass(String pass)
	{
		this.pass=pass;
	}
	public String getPass()
	{
		return pass;
	}

}

package com.lzw.dao.model;


public class TbUserlist {
	
	private String name;    //�û�����
	private String pass;    //�û�����
	
	
	//���췽��
	public TbUserlist()
	{
		
	}
	
	public TbUserlist(String name ,String pass)
	{
		this.name=name;
		this.pass=pass;
		
	}
	
	
	
	//���û����˽�����Խ��з�װ
	
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

package com.lzw.dao.model;


public class TbJsr {
	
	private String name;
	private String sex;
	private String age;
	private String tel;
	
	
	//����������Ϣ���˽�����Խ��з�װ
	//name
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	
	//sex
	public void setSex(String sex)
	{
		this.sex=sex;
	}
	public String getSex()
	{
		return sex;
	}
	
	
	//age
	public void setAge(String age)
	{
		this.age=age;
	}
	public String getAge()
	{
		return age;
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

}

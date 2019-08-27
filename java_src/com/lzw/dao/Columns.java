package com.lzw.dao;


public class Columns {
	
	private String name;    //列名
	private String type;    //字段类型
	private boolean isNull;    //是否可以为null
	private boolean isKey;    //是否是主键
	private boolean isIncrement;    //是否自增

	
	
	//构造函数
	public Columns()
	{
		
	}
	
	public Columns(String name,String type,boolean isNull,boolean isKey,boolean isIncrement)
	{
		this.name=name;
		this.type=type;
		this.isNull=isNull;
		this.isKey=isKey;
		this.isIncrement=isIncrement;
	}
	
	
	
	//将类Columns的私有属性进行封装
	
	//String:name
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	
	//String:type
	public void setType(String type)
	{
		this.type=type;
	}
	
	public String getType()
	{
		return type;
	}
	
	
	
	//boolean:isNull
	public void setIsNull(boolean isNull)
	{
		this.isNull=isNull;
	}
	
	public boolean getIsNull()
	{
		return isNull;
	}
	
	
	
	//boolean:isKey
	public void setIsKey(boolean isKey)
	{
		this.isKey=isKey;
	}
	
	public boolean getIsKey()
	{
		return isKey;
	}
	
	
	
	//boolean:isIncrement
	public void setIsIncrement(boolean isIncrement)
	{
		this.isIncrement=isIncrement;
	}
	
	public boolean getIsIncrement()
	{
		return isIncrement;
	}
	
	
	//重写toString()方法
	public String toString()
	{
		return "Columns[name=" + name + ",type=" + type + ",isNull=" + isNull +
				",isKey=" + isKey + ",isIncrement=" + isIncrement +"]";
	}
	
}

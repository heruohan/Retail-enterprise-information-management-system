package com.lzw.dao;

import java.util.ArrayList;

public class Tables {
	
	private String name;    //表名
	private ArrayList<Columns> columns=new ArrayList<>();    //表中的列集合
	
	
	//构造函数
	public Tables()
	{
		
	}
	
	
	public Tables(String name,ArrayList<Columns> columns)
	{
		this.name=name;
		this.columns=columns;
	}
	
	
	//将Tables类中的私有属性进行封装
	//String:name
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	
	
	//ArrayList<Columns>:columns
	public void setColumns(ArrayList<Columns> columns)
	{
		this.columns=columns;
	}
	
	public ArrayList<Columns> getColumns()
	{
		return columns;
	}
	
}

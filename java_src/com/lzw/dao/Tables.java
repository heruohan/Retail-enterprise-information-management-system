package com.lzw.dao;

import java.util.ArrayList;

public class Tables {
	
	private String name;    //����
	private ArrayList<Columns> columns=new ArrayList<>();    //���е��м���
	
	
	//���캯��
	public Tables()
	{
		
	}
	
	
	public Tables(String name,ArrayList<Columns> columns)
	{
		this.name=name;
		this.columns=columns;
	}
	
	
	//��Tables���е�˽�����Խ��з�װ
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

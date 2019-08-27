package com.lzw.dao;


public class Columns {
	
	private String name;    //����
	private String type;    //�ֶ�����
	private boolean isNull;    //�Ƿ����Ϊnull
	private boolean isKey;    //�Ƿ�������
	private boolean isIncrement;    //�Ƿ�����

	
	
	//���캯��
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
	
	
	
	//����Columns��˽�����Խ��з�װ
	
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
	
	
	//��дtoString()����
	public String toString()
	{
		return "Columns[name=" + name + ",type=" + type + ",isNull=" + isNull +
				",isKey=" + isKey + ",isIncrement=" + isIncrement +"]";
	}
	
}

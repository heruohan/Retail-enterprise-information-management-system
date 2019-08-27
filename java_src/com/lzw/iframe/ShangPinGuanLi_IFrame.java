package com.lzw.iframe;

import javax.swing.*;
import com.lzw.iframe.ShangPinGuanLi.*;
import javax.swing.event.*;


public class ShangPinGuanLi_IFrame extends JInternalFrame{
	
	private JTabbedPane tabPane=null;    //选项卡面板
	private ShangPinTianJiaPanel sptjPane=null;    //商品添加面板
	
	
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		ShangPinGuanLi_IFrame inFrame=new ShangPinGuanLi_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	
	
	//商品管理内部窗体的构造函数
	public ShangPinGuanLi_IFrame()
	{
		init();
	}
	
	
	//初始化内部窗体
	private void init()
	{
		//内部窗体的属性
		this.setTitle("商品管理");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setBounds(50, 50, 600, 400);
		
		this.getContentPane().add(this.getTabPane());
		
		this.addInternalFrameListener(new InternalFrameAdapter()
				{
			public void internalFrameActivated(InternalFrameEvent e)
			{
				sptjPane.updateGysComboBox();
				System.out.println(123);
			}
				});
		
		
		
	}
	
	
	
	//初始化选项卡面板：tabPane
	private JTabbedPane getTabPane()
	{
		if(tabPane==null)
		{
			tabPane=new JTabbedPane();
			
			
			//商品添加面板
			sptjPane=new ShangPinTianJiaPanel();
			//sptjPane.setBounds(50, 50, 300, 300);
			
			
			//商品信息修改与删除面板
			ShangPinXiuGaiPanel spxgPane=new ShangPinXiuGaiPanel();
			
			//给选项卡面板添加组件
			tabPane.addTab("商品信息添加", null, sptjPane, "信息添加");
			tabPane.addTab("商品信息修改与删除", null, spxgPane, "信息修改与删除");
			
			//添加监控器
			tabPane.addChangeListener(new ChangeListener()
					{
				public void stateChanged(ChangeEvent e)
				{
					if(((JTabbedPane)e.getSource()).getSelectedIndex()==1)
					{
						System.out.println("ok");
						spxgPane.updateSpComboBox();
						spxgPane.updateGysComboBox();
					}
					
				}
					});
		}
		return tabPane;
	}
	
	
	

}

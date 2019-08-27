package com.lzw.iframe;

import java.awt.Color;

import javax.swing.*;
import com.lzw.iframe.KeHuGuanLi.*;
import javax.swing.event.*;


public class KeHuGuanLi_IFrame extends JInternalFrame{
	
	private JTabbedPane tabPane=null;    //客户管理选项卡面板
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		KeHuGuanLi_IFrame inFrame=new KeHuGuanLi_IFrame();
		
		deskpane.add(inFrame);
		//inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	//构造函数
	public KeHuGuanLi_IFrame()
	{
		init();
	}
	
	
	//初始化客户管理内部窗体
	private void init()
	{
		//设置内部窗体的属性
		this.setTitle("客户管理");
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setBounds(50, 50, 600, 400);
		
		//添加选项卡面板
		this.getContentPane().add(this.getTabPane());
		
		this.setVisible(true);
		
	}
	
	
	//初始化客户管理选项卡面板：tabPane
	private JTabbedPane getTabPane()
	{
		if(tabPane==null)
		{
			tabPane=new JTabbedPane();
			//tabPane.setBorder(BorderFactory.createLineBorder(Color.RED));
			
			//客户添加面板
			KeHuTianJiaPanel khtjPanel=new KeHuTianJiaPanel();
			
			//客户信息删除与修改面板
			KeHuXiuGaiPanel khxgPanel=new KeHuXiuGaiPanel();
			//
			tabPane.addTab("客户信息添加", null, khtjPanel, "信息添加");
			tabPane.addTab("客户信息删除与修改", null, khxgPanel, "信息修改与删除");
			
			//添加监控器
			tabPane.addChangeListener(new ChangeListener()
					{
				public void stateChanged(ChangeEvent e)
				{
					if(((JTabbedPane)e.getSource()).getSelectedIndex()==1)
					{
						System.out.println(123);
						khxgPanel.initKhComboBox();
					}
				}
					});
		}
		return tabPane;
	}

}

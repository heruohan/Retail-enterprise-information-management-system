package com.lzw.iframe;

import javax.swing.*;
import com.lzw.iframe.JsrGuanLi.*;
import javax.swing.event.*;


public class JsrGuanLi_IFrame extends JInternalFrame{
	
	private JTabbedPane tabPane=null;    //选项卡面板
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		JsrGuanLi_IFrame inFrame=new JsrGuanLi_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	
	//构造函数
	public JsrGuanLi_IFrame()
	{
		init();
	}
	
	
	//初始化经手人内部窗体
	private void init()
	{
		this.setTitle("经手人管理");
		this.setBounds(50, 50, 600, 350);
		
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		
		this.getContentPane().add(this.getTabPane());
		
	}
	
	
	//初始化选项卡面板
	private JTabbedPane getTabPane()
	{
		if(tabPane==null)
		{
			tabPane=new JTabbedPane();
			
			//添加面板
			JsrTianJiaPanel jsrtjPanel=new JsrTianJiaPanel();
			
			//设置面板
			JsrSheZhiPanel jsrszPanel=new JsrSheZhiPanel();
			
			
			tabPane.addTab("经手人信息添加", null, jsrtjPanel, "信息添加");
			tabPane.addTab("经手人信息设置", null, jsrszPanel, "信息设置");
			
			//添加监控器
			tabPane.addChangeListener(new ChangeListener()
					{
				public void stateChanged(ChangeEvent e)
				{
					if(((JTabbedPane)e.getSource()).getSelectedIndex()==1)
					{
						jsrszPanel.updateTable();
					}
				}
					});
		}
		return tabPane;
	}

}

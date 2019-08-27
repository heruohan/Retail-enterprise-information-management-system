package com.lzw.iframe;

import javax.swing.*;
import com.lzw.iframe.gysGuanLi.*;
import javax.swing.event.*;


public class GysGuanLi_IFrame extends JInternalFrame{
	
	private JTabbedPane tabPane=null;    //供应商选项卡面板
	
	
	
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		GysGuanLi_IFrame inFrame=new GysGuanLi_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	//构造函数
	public GysGuanLi_IFrame()
	{
		init();
	}
	
	
	//初始化供应商内部窗体
	private void init()
	{
		this.setTitle("供应商管理");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setBounds(50, 50, 600, 400);
		
		//添加组件
		this.getContentPane().add(this.getTabPane());
		
		
		
	}
	
	
	//初始化供应商选项卡面板
	private JTabbedPane getTabPane()
	{
		if(tabPane==null)
		{
			tabPane=new JTabbedPane();
			
			//供应商添加面板
			GysTianJiaPanel gystjPane=new GysTianJiaPanel();
			
			//供应商删除与修改面板
			GysXiuGaiPanel gysxgPane=new GysXiuGaiPanel();
			
			//添加进选项卡面板
			tabPane.addTab("供应商信息添加", null, gystjPane, "信息添加");
			tabPane.addTab("供应商信息删除与修改", null, gysxgPane, "信息删除与修改");
			
			//添加监控器
			tabPane.addChangeListener(new ChangeListener()
					{
				public void stateChanged(ChangeEvent e)
				{
					if(((JTabbedPane)e.getSource()).getSelectedIndex()==1)
					{
						System.out.println(123);
						gysxgPane.updateComboBox();
					}
				}
					});
			
		}
		return tabPane;
	}

}

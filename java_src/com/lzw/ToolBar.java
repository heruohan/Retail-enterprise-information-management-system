package com.lzw;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.event.*;
import java.awt.*;

public class ToolBar extends JToolBar{
	
	private MenuBar menuBar;    //创建菜单栏，复用其上面的菜单项
	
	//创建构造函数
	private ToolBar()
	{
		
	}
	
	public ToolBar(MenuBar menuBar)
	{
		this.menuBar=menuBar;
		init();
	}
	
	
	//初始化工具栏
	private void init()
	{
		this.setSize(new Dimension(600,24));
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));    //设置工具条的边框
		//添加相关按钮
		//进货单按钮
		this.add(createToolButton(menuBar.getJinhuoItem()));
		//销售单按钮
		this.add(createToolButton(menuBar.getXiaoshou_danItem()));
		//库存盘点按钮
		this.add(createToolButton(menuBar.getKucun_pandianItem()));
		//价格调整按钮
		this.add(createToolButton(menuBar.getJiage_tiaozhengItem()));
		//商品查询按钮
		this.add(createToolButton(menuBar.getShangpin_chaxunItem()));
		//商品资料管理按钮
		this.add(createToolButton(menuBar.getShangpin_guanliItem()));
		//客户资料管理按钮
		this.add(createToolButton(menuBar.getKehu_guanliItem()));
		//供应商资料管理按钮
		this.add(createToolButton(menuBar.getGys_guanliItem()));
		//退出按钮
		this.add(createToolButton(menuBar.getExitItem()));
		
	}
	
	//创建工具栏上的常用按钮键
	private JButton createToolButton(final JMenuItem item)
	{
		JButton button=new JButton();    //工具栏按钮
		button.setText(item.getText());    //设置按钮的文本内容
		button.setToolTipText(item.getText());
		button.setIcon(item.getIcon());    //设置按钮图标
		button.setFocusable(false);
		button.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				item.doClick();
			}
				});
		return button;
	}
	
	
	//设置菜单栏
	public void setMenuBar(MenuBar menuBar)
	{
		this.menuBar=menuBar;
	}
}

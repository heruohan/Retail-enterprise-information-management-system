package com.lzw.iframe;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.List;
import com.lzw.dao.*;
import java.util.*;
import com.lzw.*;
import com.lzw.dao.model.*;
import java.awt.*;


public class ShangPinChaXun_IFrame extends JInternalFrame{
	
	/*
	 * 内部窗体上的各个组件
	 */
	private JComboBox tiaojianComboBox=null;    //查询条件下拉列表框
	private JComboBox jingqueComboBox=null;    //精确度设置下拉列表框
	private JTextField contentField=null;    //查询内容文本框
	
	private JButton chaxunButton=null;    //查询按钮
	private JButton showAllButton=null;    //显示全部数据按钮
	
	private JScrollPane tablePane=null;    //表格面板
	private JTable table=null;    //表格
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		ShangPinChaXun_IFrame inFrame=new ShangPinChaXun_IFrame();
		
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	//构造函数
	public ShangPinChaXun_IFrame()
	{
		init();
	}
	
	
	//初始化商品查询内部窗体
	private void init()
	{
		//设置内部窗体的属性
		this.setTitle("商品信息查询");
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setClosable(true);
		this.getContentPane().setLayout(new GridBagLayout());
		this.setBounds(50, 50, 600, 320);
		
		
		//设置窗体的组件
		final JLabel label=new JLabel("请选择查询条件：");
		this.setupComponent(label, 0, 0, 1, 0, false);
		
		//查询条件下拉列表框：tiaojianComboBox
		this.setupComponent(this.getTiaojianComboBox(), 1, 0, 1, 0, true);
		
		//精确度条件下拉列表框：jingqueComboBox
		jingqueComboBox=this.getJingqueComboBox();
		//jingqueComboBox.setPreferredSize(new Dimension(60,28));
		this.setupComponent(this.getJingqueComboBox(), 2, 0, 1, 0, true);
		
		//内容文本框：contentField
		contentField=this.getContentField();
		contentField.setPreferredSize(new Dimension(120,21));
		this.setupComponent(this.getContentField(), 3, 0, 1, 0, true);
		
		//查询按钮：chaxunButton
		this.setupComponent(this.getChaxunButton(), 4, 0, 1, 0, false);
		
		//显示全部数据按钮：showAllButton
		this.setupComponent(this.getShowAllButton(), 5, 0, 1, 0, false);
		
		
		//表格面板组件：tablePane
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(570,240));
		this.setupComponent(this.getTablePane(), 0, 1, 6, 0, true);
		
	}
	
	
	//设置组件在内部窗体上的位置
	private void setupComponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill)
	{
		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=gridx;
		constraint.gridy=gridy;
		constraint.insets=new Insets(2,2,2,2);
		
		if(gridwidth>1)
		{
			constraint.gridwidth=gridwidth;
		}
		
		if(ipadx>0)
		{
			constraint.ipadx=ipadx;
		}
		
		if(fill)
		{
			constraint.fill=GridBagConstraints.HORIZONTAL;
		}
		
		this.getContentPane().add(component, constraint);
		
		
	}
	
	
	
	//初始化查询条件下拉列表框：tiaojianComboBox
	private JComboBox getTiaojianComboBox()
	{
		if(tiaojianComboBox==null)
		{
			tiaojianComboBox=new JComboBox();
			tiaojianComboBox.addItem("商品名称");
			tiaojianComboBox.addItem("供应商名称");
			tiaojianComboBox.addItem("产地");
			tiaojianComboBox.addItem("规格");
		}
		return tiaojianComboBox;
	}
	
	
	//初始化精确度设置下拉列表框：jingqueComboBox
	private JComboBox getJingqueComboBox()
	{
		if(jingqueComboBox==null)
		{
			jingqueComboBox=new JComboBox();
			jingqueComboBox.addItem("等于");
			jingqueComboBox.addItem("包含");
			
		}
		return jingqueComboBox;
	}
	
	
	//初始化内容文本框：contentField
	private JTextField getContentField()
	{
		if(contentField==null)
		{
			contentField=new JTextField();
			//添加监控器
			contentField.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					chaxunButton.doClick();
				}
					});
		}
		return contentField;
	}
	
	
	//初始化查询按钮：chaxunButton
	private JButton getChaxunButton()
	{
		if(chaxunButton==null)
		{
			chaxunButton=new JButton("查询");
			
			//添加执行查询操作的监控器
			chaxunButton.addActionListener(new MyListener());
			
		}
		return chaxunButton;
	}
	
	
	//初始化显示全部数据按钮：showAllButton
	private JButton getShowAllButton()
	{
		if(showAllButton==null)
		{
			showAllButton=new JButton("显示全部数据");
			//添加监控器
			
			showAllButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					contentField.setText("");
					List lst=Dao.getSpinfos();
					updateTable(lst);
				}
					});
		}
		return showAllButton;
	}
	
	
	
	//初始化表格面板：tablePane
	private JScrollPane getTablePane()
	{
		if(tablePane==null)
		{
			tablePane=new JScrollPane();
			tablePane.setViewportView(this.getTable());
		}
		return tablePane;
	}
	
	
	//初始化表格：table
	private JTable getTable()
	{
		if(table==null)
		{
			table=new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setEnabled(false);
			table.setShowGrid(true);
			
			//添加列名
			String[] columnname= {"商品编号", "商品名称", "简称", "产地", "单位","规格", "包装", "批号", "批准文号", "供应商全称", "备注"};
			((DefaultTableModel)table.getModel()).setColumnIdentifiers(columnname);
		}
		return table;
	}
	
	
	
	//设置查询的执行操作监控器
	private final class MyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String tiaojian_str=tiaojianComboBox.getSelectedItem().toString();    //查询条件
			String jingque_str=jingqueComboBox.getSelectedItem().toString();    //查询精确度
			
			String content=contentField.getText();
			if(content.isEmpty())
			{
				JOptionPane.showMessageDialog(ShangPinChaXun_IFrame.this, "请输入查询内容");
				return;
			}
			
			//根据查询条件构造SQL语句，及返回商品的查询二维数组结果
			List res=null;
			String sql="select * from tb_spinfo where ";
			/*
			 * 以下res的返回值必定不为null，即使为空列表
			 */
			if(jingque_str.equals("等于"))
			{
				if(tiaojian_str.equals("商品名称"))
				{
					res=Dao.findForList(sql + "spname='" + content + "'");
				}
				else if(tiaojian_str.equals("供应商名称"))
				{
					res=Dao.findForList(sql + "gysname='" + content + "'");
				}
				else if(tiaojian_str.equals("产地"))
				{
					res=Dao.findForList(sql + "cd='" + content + "'");
				}
				else if(tiaojian_str.equals("规格"))
				{
					res=Dao.findForList(sql + "gg='" + content + "'");
				}
			}
			else
			{
				if(tiaojian_str.equals("商品名称"))
				{
					res=Dao.findForList(sql + "spname like '%" + content + "%'");
				}
				else if(tiaojian_str.equals("供应商名称"))
				{
					res=Dao.findForList(sql + "gysname like '%" + content + "%'");
				}
				else if(tiaojian_str.equals("产地"))
				{
					res=Dao.findForList(sql + "cd like '%" + content + "%'");
				}
				else if(tiaojian_str.equals("规格"))
				{
					res=Dao.findForList(sql + "gg like '%" + content + "%'");
				}
			}
			
			//根据结果，更新表格
			updateTable(res);
		}
	}
	
	
	//更新表格方法
	private void updateTable(List lst)
	{
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		//清空表格
		int row=table.getRowCount();
		for(int i=0;i<row;i++)
		{
			model.removeRow(0);
		}
		
		Iterator iter=lst.iterator();
		while(iter.hasNext())
		{
			List<String> tmp=(List<String>)iter.next();
			Item item=new Item();
			item.setId(tmp.get(0));
			item.setName(tmp.get(1));
			TbSpinfo info=Dao.getSpinfo(item);
			
			//构造向量
			Vector v=new Vector();
			v.add(info.getId());
			v.add(info.getSpname());
			v.add(info.getJc());
			v.add(info.getCd());
			v.add(info.getDw());
			v.add(info.getGg());
			v.add(info.getBz());
			v.add(info.getPh());
			v.add(info.getPzwh());
			v.add(info.getGysname());
			v.add(info.getMemo());
			
			//将其加入到表格模型中
			model.addRow(v);
		}
	}
}

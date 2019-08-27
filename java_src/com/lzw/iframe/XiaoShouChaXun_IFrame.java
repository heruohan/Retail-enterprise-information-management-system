package com.lzw.iframe;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.dao.*;
import java.util.List;
import java.util.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.event.*;



public class XiaoShouChaXun_IFrame extends JInternalFrame{
	
	//查询条件设置组件
	private JComboBox tiaojianComboBox=null;    //查询条件选择下拉列表框
	private JComboBox jingqueComboBox=null;    //查询精确条件下拉列表框
	
	private JTextField contentField=null;    //查询条件内容文本框
	
	private JButton chaxunButton=null;    //查询按钮
	
	private JCheckBox dateSelectBox=null;    //时间选择复选框
	
	private JTextField startDateField=null;     //开始时间文本框
	private JTextField endDateField=null;    //结束时间文本框
	
	private JButton showAllButton=null;    //显示全部数据按钮
	
	private JScrollPane tablePane=null;    //表格面板
	private JTable table=null;    //表格
	
	//private Date date=new Date();    //日期
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		XiaoShouChaXun_IFrame inFrame=new XiaoShouChaXun_IFrame();
		
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	
	//构造函数
	public XiaoShouChaXun_IFrame()
	{
		init();
	}

	
	//初始化销售查询内部窗体
	private void init()
	{
		//给内部窗体添加监控器，在窗体聚焦后，执行初始化开始和结束时间
		this.addInternalFrameListener(new InternalFrameAdapter()
				{
			public void internalFrameActivated(InternalFrameEvent e)
			{
				Calendar calendar=Calendar.getInstance();
				//结束时间
				String end_date=String.format("%tF", calendar);
				endDateField.setText(end_date);
				
				//开始时间
				calendar.set(Calendar.MONTH, 0);
				calendar.set(Calendar.DATE, 1);
				String start_date=String.format("%tF", calendar);
				startDateField.setText(start_date);
			}
				});
		
		
		//设置内部窗体的属性
		this.setTitle("销售信息查询");
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.getContentPane().setLayout(new GridBagLayout());
		this.setBounds(50, 50, 600,320);
		
		
		/*
		 * 设置布局组件
		 */
		//查询标签
		JLabel tiaojianLabel=new JLabel("请选择查询条件：");
		this.setupComponent(tiaojianLabel, 0, 0, 1, 0, false);
		
		//查询条件选择下拉列表框：tiaojianComboBox
		tiaojianComboBox=this.getTiaojianComboBox();
		tiaojianComboBox.setPreferredSize(new Dimension(80,21));
		this.setupComponent(this.getTiaojianComboBox(), 1, 0, 1, 0, true);
		
		//精确条件下拉列表框：jingqueComboBox
		jingqueComboBox=this.getJingqueComboBox();
		jingqueComboBox.setPreferredSize(new Dimension(60,21));
		this.setupComponent(this.getJingqueComboBox(), 2, 0, 1, 0, true);
		
		//查询条件内容文本框：contentField
		contentField=this.getContentField();
		contentField.setPreferredSize(new Dimension(150,21));
		this.setupComponent(this.getContentField(), 3, 0,3, 0, true);
		
		//查询按钮：chaxunButton
		chaxunButton=this.getChaXunButton();
		chaxunButton.setPreferredSize(new Dimension(60,21));
		this.setupComponent(this.getChaXunButton(), 6, 0, 1, 0, false);
		
		
		//时间选择复选框组件：dateSelectBox
		dateSelectBox=new JCheckBox();
		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=0;
		constraint.gridy=1;
		constraint.anchor=GridBagConstraints.EAST;
		this.getContentPane().add(dateSelectBox, constraint);
		//this.setupComponent(dateSelectBox, 0, 1, 1, 0, false);
		
		//指定查询日期标签：zhidingLabel
		JLabel zhidingLabel=new JLabel("指定查询日期       从");
		this.setupComponent(zhidingLabel, 1, 1, 1, 0, false);
		
		
		//开始时间文本框：startDateField
		startDateField=new JTextField();
		startDateField.setPreferredSize(new Dimension(80,21));
		this.setupComponent(startDateField, 2, 1, 1, 0, true);
		
		//标签：daoLabel
		JLabel daoLabel=new JLabel("到");
		this.setupComponent(daoLabel, 3, 1, 1, 0, false);
		
		
		//结束时间文本框：endDateField
		endDateField=new JTextField();
		endDateField.setPreferredSize(new Dimension(80,21));
		this.setupComponent(endDateField, 4, 1, 1, 0, true);
		
		//显示全部数据按钮：showAllButton
		showAllButton=this.getShowAllButton();
		showAllButton.setPreferredSize(new Dimension(110,22));
		this.setupComponent(this.getShowAllButton(), 6, 1, 1, 0, false);
		
		//添加表格面板：tablePane
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(580,210));
		this.setupComponent(this.getTablePane(), 0, 2, 7, 0, true);
		
	
	}
	
	
	
	//设置组件在布局管理器中的位置
	private void setupComponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill)
	{
		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=gridx;
		constraint.gridy=gridy;
		constraint.insets=new Insets(4,2,4,2);
		
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
	
	
	
	//初始化条件选择下拉列表框：tiaojianComboBox
	private JComboBox getTiaojianComboBox()
	{
		if(tiaojianComboBox==null)
		{
			tiaojianComboBox=new JComboBox();
			tiaojianComboBox.setEditable(false);
			tiaojianComboBox.addItem("客户全称");
			tiaojianComboBox.addItem("销售票号");
		}
		return tiaojianComboBox;
	}
	
	
	//初始化精确下拉列表框：jingqueComboBox
	private JComboBox getJingqueComboBox()
	{
		if(jingqueComboBox==null)
		{
			jingqueComboBox=new JComboBox();
			jingqueComboBox.setEditable(false);
			jingqueComboBox.addItem("等于");
			jingqueComboBox.addItem("包含");
			
		}
		return jingqueComboBox;
	}
	
	
	//初始化查询条件内容文本框：contentField
	private JTextField getContentField()
	{
		if(contentField==null)
		{
			contentField=new JTextField();
			
			//添加监控器，当输入回车时，执行查询
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
	private JButton getChaXunButton()
	{
		if(chaxunButton==null)
		{
			chaxunButton=new JButton("查询");
			
			//添加监控器
			chaxunButton.addActionListener(new MyListener());
		}
		return chaxunButton;
	}
	
	
	//时间选择复选框：dateSelectBox
	
	//开始时间文本框：startDateField
	//结束时间文本框：endDateField
	
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
					List all_list=Dao.findForList("select * from v_sellview");
					Iterator iter=all_list.iterator();
					//更新表格
					updateTable(iter);
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
			table.setShowGrid(true);
			table.setEnabled(false);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			//设置列名
			String[] columnname= {"销售票号", "商品名称", "商品编号", "规格", "单价","数量", "金额", "客户全称", "销售日期", "操作员", "经手人", "结算方式"};
			((DefaultTableModel)table.getModel()).setColumnIdentifiers(columnname);
		}
		return table;
	}
	
	
	
	//查询按钮监控器实现：ActionListener
	private final class MyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			boolean selectDate=dateSelectBox.isSelected();
			
			//判断查询内容是否为空
			if(contentField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(XiaoShouChaXun_IFrame.this, "请输入查询条件");
				return;
			}
			
			
			//判断是否输入查询开始日期及结束日期
			if(selectDate)
			{
				if(startDateField.getText()==null || startDateField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(XiaoShouChaXun_IFrame.this, "请输入开始日期");
					return;
				}
				
				if(endDateField.getText()==null || endDateField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(XiaoShouChaXun_IFrame.this, "请输入结束日期");
					return;
				}
			}
			
			
			//根据条件设置，在销售视图中获取查询结果
			//查询条件
			int tiaojian_index=tiaojianComboBox.getSelectedIndex();
			String tiaojian_str=(tiaojian_index==0) ? "khname" : "sellID";
			
			//精确度条件
			int jingque_index=jingqueComboBox.getSelectedIndex();
			String jingque_str=(jingque_index==0) ? "=" : "LIKE";
			
			String content_str=contentField.getText();    //查询内容
			
			
			
			//查询的SQL语句
			String sql="select * from v_sellview where " + tiaojian_str + jingque_str + 
					   (jingque_index==0 ? "'" + content_str  + "'" : ("'%" + content_str + "%'")) +
					   (selectDate ? "and xsdate>'" + startDateField.getText() + "' and xsdate<='" + 
					   endDateField.getText() + " 23:59:59'" : "");
			
			List res=Dao.findForList(sql);
			//更新表格
			Iterator iter=res.iterator();
			updateTable(iter);
		}
	}
	
	
	
	//根据查询出来的二维数组，更新表格的方法
	private void updateTable(Iterator iter)
	{
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		//每次更新表格的时候，需要首先删除所有行
		int row=table.getRowCount();
		for(int i=0;i<row;i++)
		{
			model.removeRow(0);
		}
		
		
		
		while(iter.hasNext())
		{
			Vector vector=new Vector();
			List<String> tmp=(List<String>)iter.next();
			
			vector.addAll(tmp);
			model.addRow(vector);
		}
	}
}

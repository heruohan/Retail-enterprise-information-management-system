package com.lzw.iframe;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.util.*;
import javax.swing.table.*;
import java.awt.event.*;
import com.lzw.dao.*;
import java.awt.*;
import java.util.List;


public class XiaoShouPaiHang_IFrame extends JInternalFrame{
	
	//内部窗体上的各个组件
	private JComboBox yearComboBox=null;    //年下拉列表框
	private JComboBox monthComboBox=null;    //月下拉列表框
	
	private JComboBox tiaojianComboBox=null;    //选择排行条件下拉列表框
	private JComboBox paixuComboBox=null;    //排序下拉列表框
	
	private JButton quedingButton=null;    //确定按钮
	
	private JScrollPane tablePane=null;    //表格面板
	private JTable table=null;    //表格
	
	
	//时间日期
	private Calendar calendar=Calendar.getInstance();
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		XiaoShouPaiHang_IFrame inFrame=new XiaoShouPaiHang_IFrame();
		
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	
	//构造函数
	public XiaoShouPaiHang_IFrame()
	{
		init();
	}
	
	
	//初始化内部窗体的函数
	private void init()
	{
		//设置内部窗体的属性
		this.setTitle("销售排行");
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setResizable(true);
		this.getContentPane().setLayout(new GridBagLayout());
		this.setBounds(50, 50, 620, 320);
		
		
		//设置组件
		//label1
		JLabel label1=new JLabel("对");
		this.setupComponent(label1, 0, 0, 1, 0, false);
		
		
		//年下拉列表框：yearComboBox
		this.setupComponent(this.getYearComboBox(), 1, 0, 1, 0, true);
		
		
		//lable2
		JLabel label2=new JLabel("年");
		this.setupComponent(label2, 2, 0, 1, 0, false);
		
		
		//月下拉列表框：monthComboBox
		this.setupComponent(this.getMonthComboBox(), 3, 0, 1, 0, true);
		
		
		//label3
		JLabel label3=new JLabel("月份的销售信息，按");
		this.setupComponent(label3, 4, 0, 1, 0, true);
		
		
		//条件下拉列表框：tiaojianComboBox
		this.setupComponent(this.getTiaojianComboBox(), 5, 0, 1, 0, true);
		
		
		//label4
		JLabel label4=new JLabel("进行");
		this.setupComponent(label4, 6, 0, 1, 0, false);
		
		
		//排序下拉列表框：paixuComboBox
		this.setupComponent(this.getPaixuComboBox(), 7, 0, 1, 0, true);
		
		
		//确定按钮：quedingButton
		this.setupComponent(this.getQuedingButton(), 8, 0, 1, 0, false);
		
		
		//表格面板：tablePane
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(580,240));
		this.setupComponent(this.getTablePane(), 0, 1, 9, 0, true);
		
	}
	
	
	//布置组件的方法
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
	
	
	//初始化年下拉列表框：yearComboBox
	private JComboBox getYearComboBox()
	{
		if(yearComboBox==null)
		{
			yearComboBox=new JComboBox();
			yearComboBox.setEditable(false);
			
			//添加年,1980年截至到现在的各个年份
			for(int i=1980,j=0;i<calendar.get(Calendar.YEAR)+1;i++,j++)
			{
				yearComboBox.addItem(i);
				if(i==calendar.get(Calendar.YEAR))
				{
					yearComboBox.setSelectedIndex(j);
				}
			}
		}
		return yearComboBox;
	}
	
	
	//初始化月下拉列表框：monthComboBox
	private JComboBox getMonthComboBox()
	{
		if(monthComboBox==null)
		{
			monthComboBox=new JComboBox();
			monthComboBox.setEditable(false);
			//添加月份
			for(int i=1;i<=12;i++)
			{
				monthComboBox.addItem(String.format("%02d", i));
				if(i==calendar.get(Calendar.MONTH)+1)
				{
					monthComboBox.setSelectedIndex(i-1);
				}
			}
		}
		return monthComboBox;
	}
	
	
	//初始化条件下拉列表框：tiaojianComboBox
	private JComboBox getTiaojianComboBox()
	{
		if(tiaojianComboBox==null)
		{
			tiaojianComboBox=new JComboBox();
			tiaojianComboBox.setEditable(false);
			//添加条件选项
			tiaojianComboBox.addItem("金额");
			tiaojianComboBox.addItem("数量");
		}
		return tiaojianComboBox;
	}
	
	
	//初始化排序下拉列表框：paixuComboBox
	private JComboBox getPaixuComboBox()
	{
		if(paixuComboBox==null)
		{
			
			paixuComboBox=new JComboBox();
			paixuComboBox.setEditable(false);
			//添加选项
			paixuComboBox.addItem("升序排列");
			paixuComboBox.addItem("降序排列");
		}
		return paixuComboBox;
	}
	
	
	//初始化确定按钮：quedingButton
	private JButton getQuedingButton()
	{
		if(quedingButton==null)
		{
			quedingButton=new JButton("确定");
			
			//添加监控器
			quedingButton.addActionListener(new MyListener());
			
		}
		return quedingButton;
		
	}
	
	
	/*
	 * 初始化表格面板和表格组件
	 */
	//表格面板：tablePane
	private JScrollPane getTablePane()
	{
		if(tablePane==null)
		{
			tablePane=new JScrollPane();
			tablePane.setViewportView(this.getTable());
		}
		return tablePane;
	}
	
	
	
	//表格：table
	private JTable getTable()
	{
		if(table==null)
		{
			String[] columnName= {"商品编号", "商品名称", "销售金额", "销售数量","简称", "产地", "单位", "规格", "包装", "批号", "批准文号","简介","供应商"};
			
			table=new JTable();
			table.setEnabled(false);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setShowGrid(true);
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			
			//给表格添加列名
			((DefaultTableModel)table.getModel()).setColumnIdentifiers(columnName);	
		}
		return table;
	}
	
	
	//更新表格方法
	private void updateTable(Iterator iter)
	{
		//删除表格中的原有数据
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		int row=table.getRowCount();
		for(int i=0;i<row;i++)
		{
			model.removeRow(0);
		}
		
		//添加数据
		while(iter.hasNext())
		{
			Vector vector=new Vector();
			List tmp=(List)iter.next();
			
			int len=tmp.size();
			for(int i=0;i<len-3;i++)
			{
				vector.add(tmp.get(i));
			}
			
			for(int i=len-2;i<len;i++)
			{
				vector.insertElementAt(tmp.get(i), 2);
			}
			
			model.addRow(vector);
		}
	}
	
	
	//实现确定按钮的监控器接口方法
	private final class MyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String month_str=(String)monthComboBox.getSelectedItem();
			int year=(int)yearComboBox.getSelectedItem();
			
			String date=year + "-" + month_str;
			
			//在视图表里面选出销售日期等于当前年月，且以商品编号进行分组
			String sql="select spid , sum(sl) as sl , sum(sl*dj) as je from v_sellview " + 
			          "where substring(xsdate,1,7) = '" + date + "' group by spid";
			
			//
			int tiaojian=tiaojianComboBox.getSelectedIndex();
			String tiaojian_str=tiaojian==0 ? "sl" : "je";
			
			int paixu=paixuComboBox.getSelectedIndex();
			String paixu_str=paixu==0 ? "asc" : "desc";
			
			List res=Dao.findForList("select * from tb_spinfo as s inner join (" + sql + 
					                ") as sp on s.id = sp.spid order by " + tiaojian_str + paixu_str);
			//更新表格
			Iterator iter=res.iterator();
			updateTable(iter);
			
		}
	}
	

}

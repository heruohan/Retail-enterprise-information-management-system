
package com.lzw.iframe;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.util.*;
import java.util.Date;
import com.lzw.dao.*;
import java.util.List;
import com.lzw.*;
import com.lzw.dao.model.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.*;


public class XiaoShouDan_IFrame extends JInternalFrame{
	
	/*
	 * 顶部组件
	 */
	private JLabel idLabel=null;    //销售票号标签
	private JTextField idField=null;    //销售票号文本框
	
	private JLabel khLabel=null;    //客户标签
	private JComboBox khComboBox=null;    //客户下拉文本框
	
	private JLabel lxrLabel=null;    //联系人标签
	private JTextField lxrField=null;    //联系人文本框
	
	private JLabel jsfsLabel=null;    //结算方式标签
	private JComboBox jsfsComboBox=null;    //结算方式下拉文本框
	
	private JLabel xssjLabel=null;    //销售时间标签
	private JTextField xssjField=null;    //销售时间文本框
	
	private JLabel jsrLabel=null;    //经手人标签
	private JComboBox jsrComboBox=null;    //经手人下拉文本框
	
	
	/*
	 * 底部组件
	 */
	private JLabel pzslLabel=null;    //品种数量标签
	private JTextField pzslField=null;    //品种数量文本框
	
	private JLabel hpzsLabel=null;    //货品总数标签
	private JTextField hpzsField=null;    //货品总数文本框
	
	private JLabel hjjeLabel=null;     //合计金额标签
	private JTextField hjjeField=null;    //合计金额文本框
	
	private JLabel ysjlLabel=null;    //验收结论标签
	private JTextField ysjlField=null;    //验收结论文本框
	
	private JLabel czyLabel=null;    //操作员标签
	private JTextField czyField=null;    //操作员文本框
	
	private JButton tjButton=null;    //添加按钮
	private JButton xsButton=null;    //销售按钮
	
	
	/*
	 * 表格及相关组件
	 */
	//表格面板：tablePane
	private JScrollPane tablePane=null;
	//表格：table
	private JTable table=null;
	//商品下拉列表框
	private JComboBox spComboBox=null;
	
	
	//销售时间:精确到时，分，秒
	private Date xsdate=null;
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		XiaoShouDan_IFrame inFrame=new XiaoShouDan_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	//构造函数
	public XiaoShouDan_IFrame()
	{
		init();
	}
	
	
	//初始化销售单内部窗体
	private void init()
	{
		this.setTitle("销售单");
		this.setMaximizable(true);    //最大化
		this.setIconifiable(true);    //可图标化
		this.setResizable(true);    //可调整大小
		this.setClosable(true);    //可关闭
		this.getContentPane().setLayout(new GridBagLayout());    //设置内部窗体的布局管理器为网格组布局管理器
		this.setBounds(50, 50, 600, 320);    //设置内部窗体的位置和大小
		
		
		/*
		 * 在网格组布局管理器中添加各个组件
		 */
		//销售票号标签：idLabel
		idLabel=new JLabel("销售票号：");
		this.setupComponent(idLabel, 0, 0, 1, 0, false);
		
		idField=this.getIdField();
		idField.setPreferredSize(new Dimension(120,21));
		this.setupComponent(this.getIdField(), 1, 0, 1, 0, true);
		
		
		//客户标签：khLabel
		khLabel=new JLabel("客户：");
		this.setupComponent(khLabel, 2, 0, 1, 0, false);
		
		khComboBox=this.getKhComboBox();
		khComboBox.setPreferredSize(new Dimension(130,21));
		this.setupComponent(this.getKhComboBox(), 3, 0, 1, 0, true);
		
		
		//联系人标签：lxrLabel
		lxrLabel=new JLabel("联系人：");
		this.setupComponent(lxrLabel, 4, 0, 1, 0, false);
		this.setupComponent(this.getLxrField(), 5, 0, 2, 0, true);
		
		
		//结算方式标签：jsfsLabel
		jsfsLabel=new JLabel("结算方式：");
		this.setupComponent(jsfsLabel, 0, 1, 1, 0, false);
		this.setupComponent(this.getJsfsComboBox(), 1, 1, 1, 0, true);
		
		
		//销售时间标签：xssjLabel
		xssjLabel=new JLabel("销售时间：");
		this.setupComponent(xssjLabel, 2, 1, 1, 0, false);
		this.setupComponent(this.getXssjField(), 3, 1, 1, 0, true);
		
		
		//经手人标签：jsrLabel
		jsrLabel=new JLabel("经手人：");
		this.setupComponent(jsrLabel, 4, 1, 1, 0, false);
		this.setupComponent(this.getJsrComboBox(), 5, 1, 2, 0, true);
		
		
		//表格面板：tablePane
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(580,170));
		this.setupComponent(this.getTablePane(), 0, 2, 7, 0, true);
		
		
		//品种数量标签：pzslLabel
		pzslLabel=new JLabel("品种数量：");
		this.setupComponent(pzslLabel, 0, 3, 1, 0, false);
		this.setupComponent(this.getPzslField(), 1, 3, 1, 0, true);
		
		
		//货品总数标签：hpzsLabel
		hpzsLabel=new JLabel("货品总数：");
		this.setupComponent(hpzsLabel, 2, 3, 1, 0, false);
		this.setupComponent(this.getHpzsField(), 3, 3, 1, 0, true);
		
		
		//合计金额标签：hjjeLabel
		hjjeLabel=new JLabel("合计金额：");
		this.setupComponent(hjjeLabel, 4, 3, 1, 0, false);
		this.setupComponent(this.getHjjeField(), 5, 3, 2, 0, true);
		
		
		//验收结论标签：ysjlLabel
		ysjlLabel=new JLabel("验收结论：");
		this.setupComponent(ysjlLabel, 0, 4, 1, 0, false);
		this.setupComponent(this.getYsjlField(), 1, 4, 1, 0, true);
		
		
		//操作员标签：czyLabel
		czyLabel=new JLabel("操作员：");
		this.setupComponent(czyLabel, 2, 4, 1, 0, false);
		this.setupComponent(this.getCzyField(), 3, 4, 1, 0, true);
		
		
		//添加按钮：tjButton
		this.setupComponent(this.getTjButton(), 5, 4, 1, 0, false);
		
		//销售按钮：xsButton
		this.setupComponent(this.getXsButton(), 6, 4, 1, 0, false);
	}
	
	
	//设置组件在窗体的位置
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
	
	
	/*
	 * 初始化顶部组件
	 */
	//销售票号文本框：idField
	private JTextField getIdField()
	{
		if(idField==null)
		{
			idField=new JTextField();
			idField.setEditable(false);
		}
		return idField;
	}
	
	
	
	//客户下拉列表框：khComboBox
	private JComboBox getKhComboBox()
	{
		if(khComboBox==null)
		{
			khComboBox=new JComboBox();
			List kehuinfos=Dao.getKhInfos();
			for(Iterator iter=kehuinfos.iterator();iter.hasNext();)
			{
				List<String> tmp=(List<String>)iter.next();
				Item item=new Item();
				item.setId(tmp.get(0).trim());
				item.setName(tmp.get(1).trim());
				khComboBox.addItem(item);
			}
			
			//添加更新联系人文本框的监视器
			khComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Item item=(Item)khComboBox.getSelectedItem();
					TbKhinfo kehu=Dao.getKhInfo(item);
					lxrField.setText(kehu.getLian());
				}
					});
		}
		return khComboBox;
	}
	
	
	
	//联系人文本框：lxrField
	private JTextField getLxrField()
	{
		if(lxrField==null)
		{
			lxrField=new JTextField();
			lxrField.setEditable(false);
		}
		return lxrField;
	}
	
	
	
	//结算方式下拉列表框：jsfsComboBox
	private JComboBox getJsfsComboBox()
	{
		if(jsfsComboBox==null)
		{
			jsfsComboBox=new JComboBox();
			jsfsComboBox.setEditable(true);
			jsfsComboBox.addItem("现金");
			jsfsComboBox.addItem("支票");
		}
		return jsfsComboBox;
	}
	
	
	//销售时间文本框：xssjField
	private JTextField getXssjField()
	{
		if(xssjField==null)
		{
			xssjField=new JTextField();
			xssjField.setEditable(false);
		}
		return xssjField;
	}
	
	
	//经手人下拉列表框：jsrComboBox
	private JComboBox getJsrComboBox()
	{
		if(jsrComboBox==null)
		{
			jsrComboBox=new JComboBox();
			List jsr=Dao.getJsrs();
			for(Iterator iter=jsr.iterator();iter.hasNext();)
			{
				List<String> tmp=(List<String>)iter.next();
				Item item=new Item();
				item.setId(tmp.get(0).trim());
				item.setName(tmp.get(1).trim());
				jsrComboBox.addItem(item);
			}
		}
		return jsrComboBox;
	}
	
	
	
	
	/*
	 * 底部组件
	 */
	//品种数量文本框：pzslField
	private JTextField getPzslField()
	{
		if(pzslField==null)
		{
			pzslField=new JTextField();
			pzslField.setEditable(false);
		}
		return pzslField;
	}
	
	
	//货品总数文本框：hpzsField
	private JTextField getHpzsField()
	{
		if(hpzsField==null)
		{
			hpzsField=new JTextField();
			hpzsField.setEditable(false);
		}
		return hpzsField;
	}
	
	
	//合计金额文本框：hjjeField
	private JTextField getHjjeField()
	{
		if(hjjeField==null)
		{
			hjjeField=new JTextField();
			hjjeField.setEditable(false);
		}
		return hjjeField;
	}
	
	
	//验收结论文本框：ysjlField
	private JTextField getYsjlField()
	{
		if(ysjlField==null)
		{
			ysjlField=new JTextField();
			ysjlField.setEditable(false);
		}
		return ysjlField;
	}
	
	
	//操作人员文本框：czyField
	private JTextField getCzyField()
	{
		if(czyField==null)
		{
			czyField=new JTextField();
			czyField.setEditable(false);
			//初始化的时候同步更新
			czyField.setText(MainFrame.getCzyLabel().getText());
		}
		return czyField;
	}
	
	
	
	//添加按钮：tjButton
	private JButton getTjButton()
	{
		if(tjButton==null)
		{
			tjButton=new JButton("添加");
			//添加监控器
			tjButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//更新销售票号
					xsdate=new Date();
					long time=xsdate.getTime();
					java.sql.Date sql_date=new java.sql.Date(time);
					String id=Dao.getSellMainMaxId(sql_date);
					idField.setText(id);
					
					//判断表格中是否有空行
					for(int i=0;i<table.getRowCount();i++)
					{
						TbSpinfo info=(TbSpinfo)table.getValueAt(i, 0);
						if(info==null || info.getId()==null || info.getId().isEmpty())
						{
							return;
						}
					}
					
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					model.addRow(new Object[] {});
				}
					});
		}
		return tjButton;
	}
	
	
	
	//销售按钮：xsButton
	private JButton getXsButton()
	{
		if(xsButton==null)
		{
			xsButton=new JButton("销售");
			
			//添加监控器
			xsButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//更新销售时间文本框
					xsdate=new Date();
					String s=String.format("%1$tF %1$tT", xsdate);
					xssjField.setText(s);
					
					//更新销售主表，销售详细表，库存表
					stopTableCellEditing();
					clearEmptyRow();
					
					String sellID=idField.getText();    //销售票号
					String pzs=pzslField.getText();    //品种数
					String je=hjjeField.getText();    //金额
					String ysjl=ysjlField.getText();    //验收结论
					String khname=(String)khComboBox.getSelectedItem();    //客户名称
					
					
					String xsdate=xssjField.getText();    //销售时间
					String czy=czyField.getText();    //操作员
					String jsr=(String)jsrComboBox.getSelectedItem();    //经手人
					String jsfs=(String)jsfsComboBox.getSelectedItem();    //结算方式
					
					if(khname==null || khname.isEmpty())
					{
						JOptionPane.showMessageDialog(XiaoShouDan_IFrame.this, "请添加客户");
						return;
					}
					
					if(jsr==null || jsr.isEmpty())
					{
						JOptionPane.showMessageDialog(XiaoShouDan_IFrame.this, "请填写经手人");
						return;
					}
					
					if(ysjl==null || ysjl.isEmpty())
					{
						JOptionPane.showMessageDialog(XiaoShouDan_IFrame.this, "请填写验收结论");
						return;
					}
					
					if(table.getRowCount()<=0)
					{
						JOptionPane.showMessageDialog(XiaoShouDan_IFrame.this, "请添加销售商品");
						return;
					}
					
					
					TbSellMain sellMain=new TbSellMain(sellID,pzs,je,ysjl,khname,xsdate,czy,jsr,jsfs);
					Set<TbSellDetail> details=sellMain.getTbSellDetails();
					for(int i=0;i<table.getRowCount();i++)
					{
						TbSpinfo tmp=(TbSpinfo)table.getValueAt(i, 0);
						
						String dj_str=(String)table.getValueAt(i, 6);
						String sl_str=(String)table.getValueAt(i, 7);
						
						Double dj=Double.valueOf(dj_str);
						Integer sl=Integer.valueOf(sl_str);
						//销售详细类
						TbSellDetail detail=new TbSellDetail();
						detail.setTbSellMain(sellID);
						detail.setSpid(tmp.getId());
						detail.setDj(dj);
						detail.setSl(sl);
						details.add(detail);
					}
					
					boolean re=Dao.insertSellInfo(sellMain);    //将销售信息添加到数据库
					if(re)
					{
						JOptionPane.showMessageDialog(XiaoShouDan_IFrame.this, "销售完成");
						//清空表格内容
						DefaultTableModel model=(DefaultTableModel)table.getModel();
						int rows=table.getRowCount();
						for(int i=rows-1;i>=0;i--)
						{
							model.removeRow(i);
						}
						pzslField.setText("0");
						hpzsField.setText("0");
						hjjeField.setText("0.0");
					}
				}
					});
		}
		return xsButton;
	}
	
	
	
	/*
	 * 表格面板，及相关组件
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
			String[] columnName={ "商品名称", "商品编号", "供应商", "产地", "单位", "规格", "单价", "数量", "包装", "批号", "批准文号" };
			table=new JTable();
			table.setShowGrid(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    //关闭自动调整模式
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			
			//添加列名
			((DefaultTableModel)table.getModel()).setColumnIdentifiers(columnName);
			
			
			
			//构建单元编辑器
			DefaultCellEditor editor=new DefaultCellEditor(this.getSpcomBox());
			//设置商品名称列的编辑器为下拉列表框
			TableColumn column=table.getColumnModel().getColumn(0);
			column.setCellEditor(editor);
			
			
			//添加实时更新货品总数，品种数量，合计金额文本框的监控器
			table.addContainerListener(new ContainerListener()
					{
				public void componentAdded(ContainerEvent e)
				{
					computeInfos();
				}
				
				public void componentRemoved(ContainerEvent e)
				{
					
				}
					});
		}
		return table;
	}
	
	
	//商品下拉列表框：spComboBox
	private JComboBox getSpcomBox()
	{
		if(spComboBox==null)
		{
			spComboBox=new JComboBox();
			spComboBox.addItem(new TbSpinfo());
			
			//添加监控器
			spComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					ResultSet rs=Dao.query("select * from tb_spinfo where id in (select id from kucun where kcsl>0)");
					//更新商品下拉列表框
					updateSpcomboBox(rs);
				}
					});
			
			//添加监控器，更新当前行的内容
			spComboBox.addItemListener(new ItemListener()
					{
				public void itemStateChanged(ItemEvent e)
				{
					TbSpinfo spinfo=(TbSpinfo)spComboBox.getSelectedItem();
					if(spinfo!=null && spinfo.getId()!=null && !spinfo.getId().isEmpty())
					{
						updateTable();
					}
				}
					});	
		}
		return spComboBox;
	}
	
	
	
	//更新商品下拉列表框方法
	private void updateSpcomboBox(ResultSet rs)
	{
		//每次更新时，都清空下拉列表框
		spComboBox.removeAll();
		List<String> lst=new ArrayList<>();
		for(int i=0;table!=null && i<table.getRowCount();i++)
		{
			TbSpinfo info=(TbSpinfo)table.getValueAt(i, 0);
			if(info!=null && info.getId()!=null)
			{
				lst.add(info.getId());
			}
		}
		
		try
		{
		while(rs.next())
		{
			TbSpinfo spinfo=new TbSpinfo();
			String id=rs.getString("id").trim();
			if(lst.contains(id))
				continue;
			spinfo.setId(id);    //商品编号
			spinfo.setSpname(rs.getString("spname").trim());    //商品名称
			spinfo.setJc(rs.getString("jc").trim());    //简称
			spinfo.setCd(rs.getString("cd").trim());    //产地
			spinfo.setDw(rs.getString("dw").trim());    //单位
			spinfo.setGg(rs.getString("gg").trim());    //规格
			spinfo.setBz(rs.getString("bz").trim());    //包装
			spinfo.setPh(rs.getString("ph").trim());    //批号
			spinfo.setPzwh(rs.getString("pzwh").trim());    //批准文号
			spinfo.setMemo(rs.getString("meno").trim());    //备注
			spinfo.setGysname(rs.getString("gysname").trim());    //供应商名称
			spComboBox.addItem(spinfo);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//当选中商品时，更新表格的当前行方法
	private synchronized void updateTable()
	{
		TbSpinfo sp=(TbSpinfo)spComboBox.getSelectedItem();
		
		int row=table.getSelectedRow();
		Item item=new Item();
		item.setId(sp.getId());
		TbKucun kucun=Dao.getKucun(item);
		if(row>=0)
		{
			table.setValueAt(sp.getId(), row, 1);
			table.setValueAt(sp.getGysname(), row, 2);
			table.setValueAt(sp.getCd(), row, 3);
			table.setValueAt(sp.getDw(), row, 4);
			table.setValueAt(sp.getGg(), row, 5);
			table.setValueAt(kucun.getDj()+"", row, 6);    //销售时的最低单价
			table.setValueAt(kucun.getKcsl()+"", row, 7);    //销售时的现有库存数量
			table.setValueAt(sp.getBz(), row, 8);
			table.setValueAt(sp.getPh(), row, 9);
			table.setValueAt(sp.getPzwh(), row, 10);
			table.editCellAt(row, 6);
		}
	}
	
	
	
	
	
	//实时计算品种数量，货品总数，合计金额的方法
	private void computeInfos()
	{
		int pzsl=0;    //品种数量
		int hpzs=0;    //货品总数
		Double hjje=0.0;    //合计金额
		
		int row=table.getRowCount();
		TbSpinfo sp=null;
		Object info=table.getValueAt(row-1, 0);
		//如果为null，则直接返回
		if(!(info instanceof TbSpinfo))
		{
			return;
		}
		
		sp=(TbSpinfo)info;
		if(row>0 && (sp.getId()==null || sp.getId().isEmpty()))
		{
			row--;
		}
		
		for(int i=0;i<row;i++)
		{
			String djStr=(String)table.getValueAt(i, 6);
			String slStr=(String)table.getValueAt(i, 7);
			
			Double dj=Double.valueOf(djStr);
			Integer sl=Integer.valueOf(slStr);
			
			hpzs+=sl;
			hjje+=(dj*sl);
		}
		
		pzslField.setText(row+"");
		hpzsField.setText(hpzs+"");
		hjjeField.setText(String.valueOf(hjje));	
	}
	
	
	//清空空行
	private synchronized void clearEmptyRow()
	{
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		for(int i=0;i<table.getRowCount();i++)
		{
			TbSpinfo info=(TbSpinfo)table.getValueAt(i, 0);
			if(info==null || info.getId()==null || info.getId().isEmpty())
			{
				model.removeRow(i);
			}
		}
	}
	
	//停止编辑表格
	private void stopTableCellEditing()
	{
		TableCellEditor editor=table.getCellEditor();
		if(editor!=null)
		{
			editor.stopCellEditing();
		}
	}

}

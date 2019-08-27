package com.lzw.iframe;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import com.lzw.dao.*;
import com.lzw.*;
import com.lzw.dao.model.*;
import java.util.List;
import java.util.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.table.*;
import java.sql.*;
import java.awt.*;



public class XiaoShouTuiHuo_IFrame extends JInternalFrame{
	
	/*
	 * 顶部组件
	 */
	private JLabel idLabel=null;    //销退票号标签
	private JTextField idField=null;    //销退文本框
	
	private JLabel khLabel=null;    //客户标签
	private JComboBox khComboBox=null;    //客户下拉列表框
	
	private JLabel lxrLabel=null;    //联系人标签
	private JTextField lxrField=null;    //联系人文本框
	
	private JLabel jsfsLabel=null;    //结算方式标签
	private JComboBox jsfsComboBox=null;    //结算方式下拉列表框
	
	private JLabel thsjLabel=null;    //退货时间标签
	private JTextField thsjField=null;    //退货文本框
	
	private JLabel jsrLabel=null;    //经手人标签
	private JComboBox jsrComboBox=null;    //经手人下拉列表框
	
	
	/*
	 * 底部组件
	 */
	private JLabel pzslLabel=null;    //品种数量标签
	private JTextField pzslField=null;    //品种数量文本框
	
	private JLabel hpzsLabel=null;    //货品总数标签
	private JTextField hpzsField=null;    //货品总数文本框
	
	private JLabel hjjeLabel=null;    //合计金额标签
	private JTextField hjjeField=null;    //合计金额文本框
	
	private JLabel ysjlLabel=null;    //验收结论标签
	private JTextField ysjlField=null;    //验收结论文本框
	
	private JLabel czyLabel=null;    //操作员标签
	private JTextField czyField=null;    //操作员文本框
	
	private JButton tjButton=null;    //添加按钮
	private JButton thButton=null;    //退货按钮
	
	/*
	 * 表格面板，及相关组件
	 */
	private JScrollPane tablePane=null;    //表格面板
	private JTable table=null;    //表格
	private JComboBox spComboBox=null;    //商品下拉列表框
	
	//退货时间
	private Date thdate=new Date();
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		XiaoShouTuiHuo_IFrame inFrame=new XiaoShouTuiHuo_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	
	//构造函数
	public XiaoShouTuiHuo_IFrame()
	{
		init();
	}
	
	
	//初始化销售退货内部窗体
	private void init()
	{
		//设置内部窗体的属性
		this.setTitle("销售-退货");
		this.setMaximizable(true);    //最大化
		this.setIconifiable(true);    //最小化
		this.setResizable(true);    //可调整大小
		this.setClosable(true);    //可关闭
		this.getContentPane().setLayout(new GridBagLayout());   //设置内部窗体的布局管理器
		this.setBounds(50, 50, 600, 320);
		
		
		//添加组件
		//销退票号：idLabel
		idLabel=new JLabel("销退票号：");
		this.setupComponent(idLabel, 0, 0, 1, 0, false);
		this.setupComponent(this.getIdField(), 1, 0, 1, 0, true);
		
		
		//客户：khLabel
		khLabel=new JLabel("客户：");
		this.setupComponent(khLabel, 2, 0, 1, 0, false);
		khComboBox=this.getKhComboBox();
		khComboBox.setPreferredSize(new Dimension(150,21));
		this.setupComponent(this.getKhComboBox(), 3, 0, 1, 0, true);
		
		
		//联系人：lxrLabel
		lxrLabel=new JLabel("联系人：");
		this.setupComponent(lxrLabel, 4, 0, 1, 0, false);
		this.setupComponent(this.getLxrField(), 5, 0, 2, 0, true);
		
		
		//结算方式：jsfsLabel
		jsfsLabel=new JLabel("结算方式：");
		this.setupComponent(jsfsLabel, 0, 1, 1, 0, false);
		this.setupComponent(this.getJsfsComboBox(), 1, 1, 1, 0, true);
		
		
		
		//退货时间：thsjLabel
		thsjLabel=new JLabel("退货时间：");
		this.setupComponent(thsjLabel, 2, 1, 1, 0, false);
		this.setupComponent(this.getThsjField(), 3, 1, 1, 0, true);
		
		
		//经手人：jsrLabel
		jsrLabel=new JLabel("经手人：");
		this.setupComponent(jsrLabel, 4, 1, 1, 0, false);
		this.setupComponent(this.getJsrComboBox(), 5, 1, 2, 0, true);
		
		
		
		/*
		 * 添加表格面板：tablePane
		 */
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(580,170));
		this.setupComponent(this.getTablePane(), 0, 2, 7, 0, true);
		
		
		
		//品种数量：pzslLabel
		pzslLabel=new JLabel("品种数量：");
		this.setupComponent(pzslLabel, 0, 3, 1, 0, false);
		this.setupComponent(this.getPzslField(), 1, 3, 1, 0, true);
		
		
		//货品总数：hpzsLabel
		hpzsLabel=new JLabel("货品总数：");
		this.setupComponent(hpzsLabel, 2, 3, 1, 0, false);
		this.setupComponent(this.getHpzsField(), 3, 3, 1, 0, true);
		
		
		//合计金额：hjjeLabel
		hjjeLabel=new JLabel("合计金额：");
		this.setupComponent(hjjeLabel, 4, 3, 1, 0, false);
		this.setupComponent(this.getHjjeField(), 5, 3, 2, 0, true);
		
		
		//验收结论：ysjlLabel
		ysjlLabel=new JLabel("验收结论：");
		this.setupComponent(ysjlLabel, 0, 4, 1, 0, false);
		this.setupComponent(this.getYsjlField(), 1, 4, 1, 0, true);
		
		
		//操作员：czyLabel
		czyLabel=new JLabel("操作员：");
		this.setupComponent(czyLabel, 2, 4, 1, 0, false);
		this.setupComponent(this.getCzyField(), 3, 4, 1, 0, true);
		
		
		//添加按钮：tjButton
		this.setupComponent(this.getTjButton(), 5, 4, 1, 0, false);
		
		
		//退货按钮：thButton
		this.setupComponent(this.getThButton(), 6, 4, 1, 0, false);
		
	}
	

	//设置内部窗体各个组件在给定布局管理器下的位置
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
	 * 顶部组件
	 */
	//销退票号文本框：idField
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
			khComboBox.addItem("请选择");
			List khList=Dao.getKhInfos();
			for(Iterator iter=khList.iterator();iter.hasNext();)
			{
				Item item=new Item();
				List<String> tmp=(List<String>)iter.next();
				item.setId(tmp.get(0).trim());
				item.setName(tmp.get(1).trim());
		
				khComboBox.addItem(item);
			}
			
			//添加同步更新联系人的监控器
			khComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Item item=null;
					Object obj=khComboBox.getSelectedItem();
					if(obj instanceof Item)
					{
						item=(Item)obj;
						TbKhinfo kehu=Dao.getKhInfo(item);
						lxrField.setText(kehu.getLian());
					}
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
			jsfsComboBox.addItem("现金");
			jsfsComboBox.addItem("支票");
			jsfsComboBox.setEditable(true);
		}
		return jsfsComboBox;
	}
	
	
	//退货时间文本框：thsjField
	private JTextField getThsjField()
	{
		if(thsjField==null)
		{
			thsjField=new JTextField();
			thsjField.setEditable(false);
		}
		return thsjField;
	}
	
	
	//经手人下拉列表框：jsrComboBox
	private JComboBox getJsrComboBox()
	{
		if(jsrComboBox==null)
		{
			jsrComboBox=new JComboBox();
			jsrComboBox.addItem("请选择");
			List jsrList=Dao.getJsrs();
			for(Iterator iter=jsrList.iterator();iter.hasNext();)
			{
				Item item=new Item();
				List<String> lst=(List<String>)iter.next();
				item.setId(lst.get(0).trim());
				item.setName(lst.get(1).trim());
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
	
	
	//操作员文本框：czyField
	private JTextField getCzyField()
	{
		if(czyField==null)
		{
			czyField=new JTextField();
			czyField.setEditable(false);
			
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
			
			//
			tjButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//更新销退票号
					thdate=new Date();
					long time=thdate.getTime();
					java.sql.Date sql_date=new java.sql.Date(time);
					String max_id=Dao.getXsthMainMaxId(sql_date);
					idField.setText(max_id);
					
					//
					for(int i=0;i<table.getRowCount();i++)
					{
						TbSpinfo sp=(TbSpinfo)table.getValueAt(i, 0);
						if(sp==null || sp.getId()==null || sp.getId().isEmpty())
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
	
	
	//退货按钮：thButton
	private JButton getThButton()
	{
		if(thButton==null)
		{
			thButton=new JButton("退货");
			//监控器
			thButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					stopTableCellEditing();
					clearEmptyRow();
					
					//更新退货时间
					thdate=new Date();
					String s=String.format("%1$tF %1$tT", thdate);
					thsjField.setText(s);
					
					//构造销售退货主类及详细类
					String xsthID=idField.getText();    //销售退货ID
					String pzs=pzslField.getText();    //品种数
					String je=hjjeField.getText();    //金额
					String ysjl=ysjlField.getText();    //验收结论
					String khname=khComboBox.getSelectedItem().toString();    //客户名称
					String thdate=thsjField.getText();    //退货时间
					String czy=czyField.getText();    //操作员
					String jsr=jsrComboBox.getSelectedItem().toString();    //经手人
					String jsfs=jsfsComboBox.getSelectedItem().toString();    //结算方式
					
					if(jsr.equals("请选择") || jsr.isEmpty())
					{
						JOptionPane.showMessageDialog(XiaoShouTuiHuo_IFrame.this, "请添加经手人");
						return;
					}
					
					if(ysjl==null || ysjl.isEmpty())
					{
						JOptionPane.showMessageDialog(XiaoShouTuiHuo_IFrame.this, "请填写验收结论");
						return;
					}
					
					if(table.getRowCount()<=0)
					{
						JOptionPane.showMessageDialog(XiaoShouTuiHuo_IFrame.this, "请添加退货商品");
						return;
					}
					
					
					//构建销售退货主表
					TbXsthMain xsthMain=new TbXsthMain(xsthID,pzs,je,ysjl,khname,thdate,czy,jsr,jsfs);
					Set<TbXsthDetail> details=xsthMain.getTbXsthDetails();
					for(int i=0;i<table.getRowCount();i++)
					{
						TbSpinfo spinfo=(TbSpinfo)table.getValueAt(i, 0);
						
						String dj_str=(String)table.getValueAt(i, 6);
						String sl_str=(String)table.getValueAt(i, 7);
						
						Double dj=Double.valueOf(dj_str);
						Integer sl=Integer.valueOf(sl_str);
						
						//初始化销售退货详细类
						TbXsthDetail detail=new TbXsthDetail();
						detail.setDj(dj);
						detail.setSl(sl);
						detail.setSpid(spinfo.getId());
						detail.setTbXsthMain(xsthID);
						details.add(detail);
					}
					
					boolean rs=Dao.insertXsthInfo(xsthMain);
					if(rs)
					{
						JOptionPane.showMessageDialog(XiaoShouTuiHuo_IFrame.this, "退货成功");
						//清空表格的行
						DefaultTableModel model=(DefaultTableModel)table.getModel();
						for(int i=table.getRowCount()-1;i>=0;i--)
						{
							model.removeRow(i);
						}
						
						//初始化底部文本框内容
						pzslField.setText("0");
						hpzsField.setText("0");
						hjjeField.setText("0.0");
					}
				}
					});
		}
		return thButton;
	}
	
	
	
	
	/*
	 * 初始化表格面板及相关组件
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
			
			String[] columnName= { "商品名称", "商品编号", "供应商", "产地", "单位", "规格", "单价", "数量", "包装", "批号", "批准文号" };
			
			table=new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setShowGrid(true);
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			
			//为表格添加列名
			((DefaultTableModel)table.getModel()).setColumnIdentifiers(columnName);
			
			//设置表格第一列的编辑器为下拉列表框
			TableColumn column=table.getColumnModel().getColumn(0);
			DefaultCellEditor editor=new DefaultCellEditor(this.getSpComboBox());
			column.setCellEditor(editor);
			
			//添加监控器，更新品种数量，货品总数及合计金额等文本框
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
	
	
	
	//更新品种数量，货品总数及合计金额文本框内容
	private void computeInfos()
	{
		int hpzs=0;
		Double hjje=0.0;
		
		int row=table.getRowCount();
		TbSpinfo spinfo=null;
		Object obj=table.getValueAt(row-1, 0);
		if(!(obj instanceof TbSpinfo))
		{
			return;
		}
		
		spinfo=(TbSpinfo)obj;
		if(row>0 && (spinfo==null || spinfo.getId()==null || spinfo.getId().isEmpty()))
		{
			row--;
		}
		
		for(int i=0;i<row;i++)
		{
			String dj_str=(String)table.getValueAt(i, 6);
			String sl_str=(String)table.getValueAt(i, 7);
			
			
			Double dj=Double.valueOf(dj_str);
			Integer sl=Integer.valueOf(sl_str);
			
			hpzs+=sl;
			hjje+=(dj*sl);
		}
		
		pzslField.setText(String.valueOf(row));
		hpzsField.setText(String.valueOf(hpzs));
		hjjeField.setText(String.valueOf(hjje));
	}
	
	
	//商品下拉列表框：spComboBox
	private JComboBox getSpComboBox()
	{
		if(spComboBox==null)
		{
			spComboBox=new JComboBox();
			
			//添加更新商品下拉列表框的监视器
			spComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//添加商品类到商品下拉列表框
					spComboBox.addItem(new TbSpinfo());
					ResultSet rs=Dao.query("select * from tb_spinfo where id in (select id from tb_kucun)");
					updateSpcomboBox(rs);
				}
					});
			
			
			//当选中商品时，添加更新当前行的监控器
			spComboBox.addItemListener(new ItemListener()
					{
				public void itemStateChanged(ItemEvent e)
				{
					//更新表格的当前行
					TbSpinfo sp=(TbSpinfo)spComboBox.getSelectedItem();
					if(sp!=null && sp.getId()!=null && !sp.getId().isEmpty())
					{
						updateTable();
					}
				}
					});
		}
		return spComboBox;
	}
	
	
	

	//更新商品下拉列表框
	private void updateSpcomboBox(ResultSet rs)
	{
		spComboBox.removeAllItems();
		List<String> lst=new ArrayList<>();
		for(int i=0;table!=null && i<table.getRowCount();i++)
		{
			TbSpinfo sp=(TbSpinfo)table.getValueAt(i, 0);
			if(sp!=null && sp.getId()!=null)
			{
				lst.add(sp.getId());
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
				spinfo.setId(id);
				spinfo.setSpname(rs.getString("spname").trim());
				spinfo.setJc(rs.getString("jc").trim());
				spinfo.setCd(rs.getString("cd").trim());
				spinfo.setDw(rs.getString("dw").trim());
				spinfo.setGg(rs.getString("gg").trim());
				spinfo.setBz(rs.getString("bz").trim());
				spinfo.setPh(rs.getString("ph").trim());
				spinfo.setPzwh(rs.getString("pzwh").trim());
				spinfo.setMemo(rs.getString("meno").trim());
				spinfo.setGysname(rs.getString("gysname").trim());
				
				spComboBox.addItem(spinfo);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	//更新表格的当前行方法
	private void updateTable()
	{
		int row=table.getSelectedRow();
		TbSpinfo spinfo=(TbSpinfo)spComboBox.getSelectedItem();
		
		if(row>=0 && spinfo!=null)
		{
			table.setValueAt(spinfo.getId(), row, 1);
			table.setValueAt(spinfo.getGysname(), row, 2);
			table.setValueAt(spinfo.getCd(), row, 3);
			table.setValueAt(spinfo.getDw(), row, 4);
			table.setValueAt(spinfo.getGg(), row, 5);
			table.setValueAt("请填写退货单价",row, 6);
			table.setValueAt("请填写退货数量", row, 7);
			table.setValueAt(spinfo.getBz(), row, 8);
			table.setValueAt(spinfo.getPh(), row, 9);
			table.setValueAt(spinfo.getPzwh(), row, 10);
		}
		
	}
	
	
	
	//清空空行
	private synchronized void clearEmptyRow()
	{
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		for(int i=0;i<table.getRowCount();i++)
		{
			TbSpinfo sp=(TbSpinfo)table.getValueAt(i, 0);
			if(sp==null || sp.getId()==null || sp.getId().isEmpty())
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

package com.lzw.iframe;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.util.*;
import java.util.Date;
import java.util.List;
import com.lzw.dao.*;
import com.lzw.*;
import com.lzw.dao.model.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.ResultSet;
import java.beans.*;



public class JinHuoDan_IFrame extends JInternalFrame{
	/*
	 * 初始化进货单内部窗体的各个组件属性：
	 * 1、首先创建整个窗体的内容面板对象jContentPane,在其上添加3个子面板，分别为：
	 * 顶部面板topPanel,底部面板bottomPanel,以及放置表格模型JTable组件；
	 * 2、然后在3个子面板上添加各个子组件；
	 */
	
	//内容面板:jContentPane
	private JPanel jContentPane=null;
	
	
	/*
	 * 顶部面板：topPanel，及其子组件
	 */
	private JPanel topPanel=null;    //顶部面板
	
	private JLabel idLabel=null;    //进货票号标签
	private JTextField idField=null;    //进货票号文本框
	
	private JLabel gysLabel=null;    //供应商标签
	private JComboBox gysComboBox=null;    //供应商下拉列表框
	
	private JLabel lxrLabel=null;    //联系人标签
	private JTextField lxrField=null;    //联系人文本框
	
	private JLabel jsfsLabel=null;    //结算方式标签
	private JComboBox jsfsComboBox=null;    //结算方式下拉列表框
	
	private JLabel jhsjLabel=null;    //进货时间标签
	private JTextField jhsjField=null;    //进货时间文本框
	
	private JLabel jsrLabel=null;    //经手人标签
	private JComboBox jsrComboBox=null;    //经手人下拉列表框
	
	//当前时间
	private Date date=new Date();
	
	
	/*
	 * 底部面板：bottomPanel,及其子组件
	 */
	private JPanel bottomPanel=null;    //底部面板
	
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
	private JButton rukuButton=null;    //入库按钮
	
	
	/*
	 * 表格模型：JTable，及滚动面板
	 */
	private JTable table=null;    //表格模型
	private JScrollPane tablePane=null;    //放置表格的滚动面板
	private JComboBox spComboBox=null;    //商品名称下拉列表框
	
	
	
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		JinHuoDan_IFrame inFrame=new JinHuoDan_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	
	
	//构造函数
	public JinHuoDan_IFrame()
	{
		init();
	}
	
	//初始化内部窗体
	private void init()
	{
		this.setSize(600, 320);    //内部窗体的大小
		this.setIconifiable(true);    //内部窗体是否可以被最小化
		this.setResizable(true);    //内部窗体是否可以调整大小
		this.setMaximizable(true);    //内部窗体是否可以最大化
		this.setTitle("进货单");    //设置内部窗体的标题
		this.setClosable(true);    //内部窗体是否可以最大化
		this.setContentPane(this.getJContentPane());    //添加内容面板
		
	}
	
	//初始化内容面板：jContentPane
	private JPanel getJContentPane()
	{
		//添加3个子面板
		if(jContentPane==null)
		{
			jContentPane=new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(this.getTopPanel(),BorderLayout.NORTH);
			jContentPane.add(this.getTablePane());
			jContentPane.add(this.getBottomPanel(),BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	
	
	
	//该方法用于停止表格单元的编辑
	private void stopTableCellEditing()
	{
		TableCellEditor cellEditor=table.getCellEditor();
		if(cellEditor!=null)
		{
			cellEditor.stopCellEditing();
		}
	}
	
	
	/*
	 * 初始化顶部面板：topPanel，及其子组件
	 */
	//顶部面板：topPanel
	private JPanel getTopPanel()
	{
		if(topPanel==null)
		{
			//进货票号标签：idLabel
			idLabel=new JLabel("进货票号：");
			GridBagConstraints constraint_id1=new GridBagConstraints();
			constraint_id1.gridx=0;
			constraint_id1.gridy=0;
			constraint_id1.weightx=1.0;
			constraint_id1.weighty=1.0;
			
			
			idField=this.getIdField();
			idField.setPreferredSize(new Dimension(100,21));
			GridBagConstraints constraint_id2=new GridBagConstraints();
			constraint_id2.gridx=1;
			constraint_id2.gridy=0;
			constraint_id2.weightx=1.0;
			constraint_id2.fill=GridBagConstraints.HORIZONTAL;
			
			
			
			
			
			//供应商标签：gysLabel
			gysLabel=new JLabel("供应商：");
			GridBagConstraints constraint_gys1=new GridBagConstraints();
			constraint_gys1.gridx=2;
			constraint_gys1.gridy=0;
			constraint_gys1.insets=new Insets(0,1,0,0);
			constraint_gys1.weightx=1.0;
			
			
			GridBagConstraints constraint_gys2=new GridBagConstraints();
			gysComboBox=this.getGysComboBox();
			gysComboBox.setPreferredSize(new Dimension(160,21));
			constraint_gys2.gridx=3;
			constraint_gys2.gridy=0;
			constraint_gys2.insets=new Insets(0,0,0,1);
			constraint_gys2.weightx=1.0;
			constraint_gys2.fill=GridBagConstraints.HORIZONTAL;
			
			
			//联系人标签：lxrLabel
			lxrLabel=new JLabel("联系人：");
			GridBagConstraints constraint_lxr1=new GridBagConstraints();
			constraint_lxr1.gridx=4;
			constraint_lxr1.gridy=0;
			constraint_lxr1.insets=new Insets(0,1,0,0);
			constraint_lxr1.weightx=1.0;
			
			lxrField=this.getLxrField();
			lxrField.setPreferredSize(new Dimension(80,21));
			GridBagConstraints constraint_lxr2=new GridBagConstraints();
			constraint_lxr2.gridx=5;
			constraint_lxr2.gridy=0;
			constraint_lxr2.weightx=1.0;
			constraint_lxr2.fill=GridBagConstraints.HORIZONTAL;
			
			
			//结算方式标签：jsfsLabel
			jsfsLabel=new JLabel("结算方式：");
			GridBagConstraints constraint_jsfs1=new GridBagConstraints();
			constraint_jsfs1.gridx=0;
			constraint_jsfs1.gridy=1;
			constraint_jsfs1.weighty=1.0;
			
			GridBagConstraints constraint_jsfs2=new GridBagConstraints();
			constraint_jsfs2.gridx=1;
			constraint_jsfs2.gridy=1;
			constraint_jsfs2.insets=new Insets(0,0,0,1);
			constraint_jsfs2.fill=GridBagConstraints.HORIZONTAL;
			
			
			//进货时间标签：jhsjLabel
			jhsjLabel=new JLabel("进货时间：");
			GridBagConstraints constraints_jhsj1=new GridBagConstraints();
			constraints_jhsj1.gridx=2;
			constraints_jhsj1.gridy=1;
			constraints_jhsj1.insets=new Insets(0,1,0,0);
			
			GridBagConstraints constraint_jhsj2=new GridBagConstraints();
			constraint_jhsj2.gridx=3;
			constraint_jhsj2.gridy=1;
			constraint_jhsj2.insets=new Insets(0,0,0,1);
			constraint_jhsj2.fill=GridBagConstraints.HORIZONTAL;
			
			
			
			//经手人标签：jsrLabel
			jsrLabel=new JLabel("经手人：");
			GridBagConstraints constraint_jsr1=new GridBagConstraints();
			constraint_jsr1.gridx=4;
			constraint_jsr1.gridy=1;
			constraint_jsr1.insets=new Insets(0,1,0,0);
			
			GridBagConstraints constraint_jsr2=new GridBagConstraints();
			constraint_jsr2.gridx=5;
			constraint_jsr2.gridy=1;
			constraint_jsr2.fill=GridBagConstraints.BOTH;
			
			
			//初始化顶部面板，并添加子组件
			topPanel=new JPanel();
			topPanel.setLayout(new GridBagLayout());
			//进货票号
			topPanel.add(idLabel, constraint_id1);
			topPanel.add(this.getIdField(),constraint_id2);
			
			//供应商
			topPanel.add(gysLabel, constraint_gys1);
			topPanel.add(this.getGysComboBox(), constraint_gys2);
			
			//联系人
			topPanel.add(lxrLabel, constraint_lxr1);
			topPanel.add(this.getLxrField(), constraint_lxr2);
			
			//结算方式
			topPanel.add(jsfsLabel, constraint_jsfs1);
			topPanel.add(this.getJsfsComboBox(), constraint_jsfs2);
			
			//进货时间
			topPanel.add(jhsjLabel, constraints_jhsj1);
			topPanel.add(this.getJhsjField(), constraint_jhsj2);
			
			//经手人
			topPanel.add(jsrLabel, constraint_jsr1);
			topPanel.add(this.getJsrComboBox(), constraint_jsr2);	
		}
		return topPanel;
	}
	
	//进货票号标签：idLabel
	//进货票号文本框：idField
	private JTextField getIdField()
	{
		if(idField==null)
		{
			idField=new JTextField();
			idField.setEditable(false);
		}
		return idField;
	}
	
	//供应商标签：gysLabel
	//供应商下拉列表框：gysComboBox
	private JComboBox getGysComboBox()
	{
		if(gysComboBox==null)
		{
			gysComboBox=new JComboBox();
			List gysinfos=Dao.getGysInfos();    //以二维数组的形式返回此时数据库中所有的供应商
			for(Iterator iter=gysinfos.iterator();iter.hasNext();)
			{
				List tmp=(List)iter.next();
				Item item=new Item();
				item.setId(tmp.get(0).toString().trim());
				item.setName(tmp.get(1).toString().trim());
				gysComboBox.addItem(item);
			}
			
			//Item item=(Item)gysComboBox.getSelectedItem();
			//TbGysinfo info=Dao.getGysinfo(item);
			//lxrField.setText(info.getLian());
			
			//添加监控器
			gysComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Item item=(Item)gysComboBox.getSelectedItem();
					TbGysinfo info=Dao.getGysinfo(item);
					lxrField.setText(info.getLian());
				}
					});
		}
		return gysComboBox;
	}
	
	
	//联系人标签：lxrLabel
	//联系人文本框：lxrField
	private JTextField getLxrField()
	{
		if(lxrField==null)
		{
			lxrField=new JTextField();
		}
		return lxrField;
	}
	
	//结算方式标签：jsfsLabel
	//结算方式下拉列表框：jsfsComboBox
	private JComboBox getJsfsComboBox()
	{
		if(jsfsComboBox==null)
		{
			jsfsComboBox=new JComboBox();
			jsfsComboBox.addItem("现金结算");
			jsfsComboBox.addItem("支票结算");
		}
		return jsfsComboBox;
	}
	
	
	//进货时间标签：jhsjLabel
	//进货时间文本框：jhsjField
	private JTextField getJhsjField()
	{
		if(jhsjField==null)
		{
			jhsjField=new JTextField();
		}
		return jhsjField;
	}
	
	//经手人标签：jsrLabel
	//经手人下拉列表框：jsrComboBox
	private JComboBox getJsrComboBox()
	{
		if(jsrComboBox==null)
		{
			jsrComboBox=new JComboBox();
			List<List> jsrList=Dao.getJsrs();
			for(List<String> list : jsrList)
			{
				Item item=new Item();
				item.setId(list.get(0).trim());
				item.setName(list.get(1).trim());
				jsrComboBox.addItem(item);
			}
		}
		return jsrComboBox;
	}
	
	
	
	/*
	 * 初始化底部面板：bottomPanel,及其子组件
	 */
	
	//底部面板：bottomPanel
	private JPanel getBottomPanel()
	{
		if(bottomPanel==null)
		{
			pzslLabel=new JLabel("品种数量：");    //品种数量标签
			GridBagConstraints constraint_pzsl1=new GridBagConstraints();
			constraint_pzsl1.gridx=0;
			constraint_pzsl1.gridy=0;
			constraint_pzsl1.weightx=1.0;
			constraint_pzsl1.weighty=1.0;
			
			pzslField=this.getPzslField();
			pzslField.setPreferredSize(new Dimension(100,21));
			GridBagConstraints constraint_pzsl2=new GridBagConstraints();
			constraint_pzsl2.gridx=1;
			constraint_pzsl2.gridy=0;
			constraint_pzsl2.weightx=1.0;
			constraint_pzsl2.fill=GridBagConstraints.HORIZONTAL;
			
			
			hpzsLabel=new JLabel("货品总数：");    //货品总数标签
			GridBagConstraints constraint_hpzs1=new GridBagConstraints();
			constraint_hpzs1.gridx=2;
			constraint_hpzs1.gridy=0;
			constraint_hpzs1.weightx=1.0;
			
			
			hpzsField=this.getHpzsField();
			hpzsField.setPreferredSize(new Dimension(160,21));
			GridBagConstraints constraint_hpzs2=new GridBagConstraints();
			constraint_hpzs2.gridx=3;
			constraint_hpzs2.gridy=0;
			constraint_hpzs2.weightx=1.0;
			constraint_hpzs2.fill=GridBagConstraints.HORIZONTAL;
			
			
			hjjeLabel=new JLabel("合计金额：");    //合计金额标签
			GridBagConstraints constraint_hjje1=new GridBagConstraints();
			constraint_hjje1.gridx=4;
			constraint_hjje1.gridy=0;
			constraint_hjje1.weightx=1.0;
			
			hjjeField=this.getHjjeField();
			hjjeField.setPreferredSize(new Dimension(80,21));
			GridBagConstraints constraint_hjje2=new GridBagConstraints();
			constraint_hjje2.gridx=5;
			constraint_hjje2.gridy=0;
			constraint_hjje2.gridwidth=4;
			constraint_hjje2.weightx=1.0;
			constraint_hjje2.fill=GridBagConstraints.HORIZONTAL;
			
			
			ysjlLabel=new JLabel("验收结论：");    //验收结论标签
			GridBagConstraints constraint_ysjl1=new GridBagConstraints();
			constraint_ysjl1.gridx=0;
			constraint_ysjl1.gridy=1;
			constraint_ysjl1.weighty=1.0;
			
			
			GridBagConstraints constraint_ysjl2=new GridBagConstraints();
			constraint_ysjl2.gridx=1;
			constraint_ysjl2.gridy=1;
			constraint_ysjl2.fill=GridBagConstraints.HORIZONTAL;
			
			
			
			czyLabel=new JLabel("操作员：");    //操作员标签
			GridBagConstraints constraint_czy1=new GridBagConstraints();
			constraint_czy1.gridx=2;
			constraint_czy1.gridy=1;
			
			GridBagConstraints constraint_czy2=new GridBagConstraints();
			constraint_czy2.gridx=3;
			constraint_czy2.gridy=1;
			constraint_czy2.fill=GridBagConstraints.HORIZONTAL;
			
			
			//添加按钮
			GridBagConstraints constraint_tjButton=new GridBagConstraints();
			constraint_tjButton.gridx=7;
			constraint_tjButton.gridy=1;
			constraint_tjButton.insets=new Insets(0,0,0,5);
			
			//入库按钮
			GridBagConstraints constraint_rkButton=new GridBagConstraints();
			constraint_rkButton.gridx=8;
			constraint_rkButton.gridy=1;
			constraint_rkButton.insets=new Insets(0,5,0,0);
			
			//占位网格
			
			
			//初始化底部面板
			bottomPanel=new JPanel();
			bottomPanel.setLayout(new GridBagLayout());
			bottomPanel.add(pzslLabel, constraint_pzsl1);
			bottomPanel.add(this.getPzslField(), constraint_pzsl2);
			
			bottomPanel.add(hpzsLabel, constraint_hpzs1);
			bottomPanel.add(this.getHpzsField(), constraint_hpzs2);
			
			bottomPanel.add(hjjeLabel, constraint_hjje1);
			bottomPanel.add(this.getHjjeField(), constraint_hjje2);
			
			bottomPanel.add(ysjlLabel, constraint_ysjl1);
			bottomPanel.add(this.getYsjlField(), constraint_ysjl2);
			
			bottomPanel.add(czyLabel, constraint_czy1);
			bottomPanel.add(this.getCzyField(), constraint_czy2);
			
			bottomPanel.add(this.getTjButton(), constraint_tjButton);
			bottomPanel.add(this.getRukuButton(), constraint_rkButton);
		}
		return bottomPanel;
	}
	
	
	
	//品种数量标签：pzslLabel
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
	
	//货品总数标签：hpzsLabel
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
	
	//合计金额标签：hjjeLabel
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
	
	//验收结论标签：ysjlLabel
	//验收结论文本框：ysjlField
	private JTextField getYsjlField()
	{
		if(ysjlField==null)
		{
			ysjlField=new JTextField();
		}
		return ysjlField;
	}
	
	//操作员标签：czyLabel
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
	
	//添加按钮:tjButton
	private JButton getTjButton()
	{
		if(tjButton==null)
		{
			tjButton=new JButton("添加");
			tjButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					java.sql.Date sql_date=new java.sql.Date(date.getTime());
					jhsjField.setText(sql_date.toString());    //将其格式化为yyyy-mm-dd
					String maxId=Dao.getRuKuMainMaxId(sql_date);    //获取当天的最大ID
					idField.setText(maxId);
					
					//
					for(int i=0;i<table.getRowCount();i++)
					{
						if(table.getValueAt(i, 0)==null)
							return;
					}
					
					
					/*
					 * 解决同一个表需要相同的供应商问题
					 * 解决方法：在添加新行的时候，判断是否与前一个供应商相同
					 */
						
					DefaultTableModel tablemodel=(DefaultTableModel)table.getModel();
					tablemodel.addRow(new Object[] {});
				}
					});
		}
		return tjButton;
	}
	
	
	
	//入库按钮：rukuButton
	private JButton getRukuButton()
	{
		if(rukuButton==null)
		{
			rukuButton=new JButton();
			rukuButton.setText("入库");
			rukuButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					stopTableCellEditing();    //结束表格中没有编写的单元
					//列出入库主表中的各个属性
					String rkID=idField.getText();    //入库编号
					String pzs=pzslField.getText();    //品种数
					String je=hjjeField.getText();    //金额
					String ysjl=ysjlField.getText().trim();    //验收结论
					//String gysname=(String)gysComboBox.getSelectedItem();    //供应商
					String rkDate=jhsjField.getText();    //进货时间
					String czy=czyField.getText();    //操作员
					String jsr=(String)jsrComboBox.getSelectedItem();    //经手人
					String jsfs=(String)jsfsComboBox.getSelectedItem();    //结算方式
					
					if(jsr==null || jsr.isEmpty())
					{
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "请填写经手人");
						return;
					}
					
					if(ysjl==null || ysjl.isEmpty())
					{
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "请填写验收结论");
						return;
					}
					
					if(table.getRowCount()<=0)
					{
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "请添加入库商品");
						return;
					}
					
					
					/*
					 * 入库时，判断表格中的所有商品是否是由同一个供应商提供
					 */
					TbSpinfo sp=(TbSpinfo)table.getValueAt(0, 0);
					String gysname=sp.getGysname();
					for(int i=0;i<table.getRowCount();i++)
					{
						TbSpinfo tmp=(TbSpinfo)table.getValueAt(i, 0);
						if(tmp!=null && tmp.getGysname()!=null)
						{
							if(!gysname.equals(tmp.getGysname()))
							{
								JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "表格中存在不属于同一供应商的商品，请修改");
								return;
							}
						}
					}
					
					
					
					//创建入库主表类
					TbRukuMain rukuMain=new TbRukuMain(rkID,pzs,je,ysjl,gysname,rkDate,czy,jsr,jsfs);
					Set<TbRukuDetail> details=rukuMain.getTabRukuDetails();
					
					int row=table.getRowCount();
					for(int i=0;i<row;i++)
					{
						TbSpinfo Spinfo=(TbSpinfo)table.getValueAt(i, 0);    //商品类
						if(Spinfo==null || Spinfo.getId()==null || Spinfo.getId().isEmpty())
						{
							continue;
						}
						
						TbRukuDetail detail=new TbRukuDetail();    //入库详细类
						String djStr=(String)table.getValueAt(i, 6);    //单价
						String slStr=(String)table.getValueAt(i, 7);    //数量
						Double dj=Double.valueOf(djStr);
						Integer sl=Integer.valueOf(slStr);
						
						detail.setTbRukuMain(rkID);
						detail.setDj(dj);
						detail.setSl(sl);
						detail.setTbSpinfo(Spinfo.getId());
						details.add(detail);    //将入库详细类加入列表
					}
					
					boolean re=Dao.insertRuKuInfo(rukuMain);    //将主表类中的信息加入数据库
					if(re)
					{
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "入库成功");
						//清空表格中的数据
						
						/*
						 * 错误：（1）因此这样把列表也移除了，修改如（2）
						 */
						/*
						 * （1）
						DefaultTableModel tablemodel=new DefaultTableModel();
						table.setModel(tablemodel);
						*/
						
						//（2）
						DefaultTableModel model=(DefaultTableModel)table.getModel();
						for(int i=model.getRowCount()-1;i>=0;i--)
						{
							model.removeRow(i);
						}
						pzslField.setText("0");
						hpzsField.setText("0");
						hjjeField.setText("0");
					}	
				}
					});
		}
		return rukuButton;
	}
	//
	
	
	
	/*
	 * 表格模型：JTable，及滚动面板
	 */
	//滚动面板：tablePane
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
			
			String[] columnName= {"商品名称","商品编号","产地","单位","规格","包装","单价","数量","批号", "批准文号"};
			table=new JTable();
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			table.setShowGrid(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    //关闭自动调整，在使用滚动条时
			
			
			
			
			
			//添加列名
			DefaultTableModel tablemodel=(DefaultTableModel)table.getModel();
			tablemodel.setColumnIdentifiers(columnName);
			
			
			
			//构造单元的编辑器
			DefaultCellEditor editor=new DefaultCellEditor(this.getSpComboBox());
			TableColumn spcolumn=table.getColumnModel().getColumn(0);
			spcolumn.setCellEditor(editor);
			
			/*
			 * 当商品名称下拉框发生ActionEvent和ItemEvent事件的时候，表格都会引发此监视器，除非表格为空
			 */
			table.addPropertyChangeListener(new PropertyChangeListener()
			{
				public void propertyChange(PropertyChangeEvent e)
				{
					if(e.getPropertyName().equals("tableCellEditor"))
					{
						computeInfos();
					}
				}
				});
		}
		return table;
	}
	
	
	/*
	 * 1、入库的一个表格中的商品信息，必须要是同一个供应商
	 * 2、如果表格中存在单价等相同的商品，在原有商品上进行数量修改
	 */
	
	
	//商品名称的下拉列表框：spComboBox
	private JComboBox getSpComboBox()
	{
		if(spComboBox==null)
		{
			spComboBox=new JComboBox();
			//spComboBox.addItem(new TbSpinfo());
			spComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					
					ResultSet rs=Dao.query("select * from tb_spinfo where gysname=" + "'" + gysComboBox.getSelectedItem() +"'");
					updateSpComboBox(rs);
				}
					});
			
			spComboBox.addItemListener(new ItemListener()
					{
				public void itemStateChanged(ItemEvent e)
				{
					TbSpinfo spinfo=(TbSpinfo)spComboBox.getSelectedItem();
					
					//判断是否在表格已经存在此商品类
					int rows=table.getRowCount();
					List<String> lst=new ArrayList<>();
					if(rows>1)
					{
						for(int i=0;i<rows-1;i++)
						{
							TbSpinfo info=(TbSpinfo)table.getValueAt(i, 0);
							if(info!=null && info.getId()!=null)
							{
								lst.add(info.getId());
							}
						}
						
						if(lst.contains(spinfo.getId()))
								{
							JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "此表中已经包含此商品");
							return;
								}
					}
					
					
					if(spinfo!=null && spinfo.getId()!=null)
					{
						
						updateTable();
					}
				}
					});
		}
		return spComboBox;
	}
	
	
	//更新商品下拉列表框的方法
	private void updateSpComboBox(ResultSet rs)
	{
		try
		{
		while(rs.next())
		{
			//初始化商品信息类
			TbSpinfo spinfo=new TbSpinfo();
			spinfo.setId(rs.getString("id").trim());
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
			
			DefaultComboBoxModel model=(DefaultComboBoxModel)spComboBox.getModel();
			if(model.getIndexOf(spinfo)<0)
			{
				spComboBox.addItem(spinfo);    //因为所有行的下拉列表框都时同一个，防止下拉列表框有重复项
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	//根据商品下拉列表框中的选择项，更新表格
	private synchronized void updateTable()
	{
		TbSpinfo spinfo=(TbSpinfo)spComboBox.getSelectedItem();
		int row=table.getSelectedRow();
		if(row>=0 && spinfo!=null)
		{
			table.setValueAt(spinfo.getId(), row, 1);
			table.setValueAt(spinfo.getCd(), row, 2);
			table.setValueAt(spinfo.getDw(), row, 3);
			table.setValueAt(spinfo.getGg(), row, 4);
			table.setValueAt(spinfo.getBz(), row, 5);
			table.setValueAt("0", row, 6);    //单价
			table.setValueAt("0", row, 7);    //数量
			table.setValueAt(spinfo.getPh(), row, 8);
			table.setValueAt(spinfo.getPzwh(), row, 9);
			table.editCellAt(row, 6);
		}
	}
	

	
	//根据表格信息，计算品种数量（即表格的行数），货品总数（所有商品的的单价），合计金额（每个商品的数量乘以单价）
	private void computeInfos()
	{
		int pzs=0;    //品种数
		int hpzs=0;    //货品总数
		Double hjje=0.0;    //合计金额
		
		TbSpinfo column=null;
		int rows=table.getRowCount();
		Object value=table.getValueAt(rows-1, 0);    //因为添加按钮是只能商品列表项不为空时才能添加新的空行
		if(!(value instanceof TbSpinfo))    //当value为null时，直接返回
			return;
		if(rows>0)
		{
			column=(TbSpinfo)value;
		}
		
		if(rows>0 && (column==null || column.getId().isEmpty()))
		{
			rows--;
		}
		
		for(int i=0;i<rows;i++)
		{
			String slStr=(String)table.getValueAt(i, 7);
			String djStr=(String)table.getValueAt(i, 6);
			
			int sl= (slStr==null || slStr.isEmpty()) ? 0 : Integer.parseInt(slStr);     //单个商品数量
			Double dj= (djStr==null || djStr.isEmpty()) ? 0 : Double.parseDouble(djStr);    //单价
			
			hpzs+=sl;
			hjje+=sl*dj;
		}
		
		pzslField.setText(String.valueOf(rows));
		hpzsField.setText(String.valueOf(hpzs));
		hjjeField.setText(String.valueOf(hjje));	
	}
}

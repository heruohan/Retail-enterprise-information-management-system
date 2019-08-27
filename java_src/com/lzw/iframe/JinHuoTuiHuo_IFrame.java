package com.lzw.iframe;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import com.lzw.dao.*;
import java.util.*;
import java.util.Date;
import com.lzw.*;
import java.awt.event.*;
import com.lzw.dao.model.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.*;
import java.util.List;




public class JinHuoTuiHuo_IFrame extends JInternalFrame{
	
	/*
	 * 顶部组件
	 */
	private JLabel idLabel=null;    //退货票号标签
	private JTextField idField=null;    //退货票号文本框
	
	private JLabel gysLabel=null;    //供应商标签
	private JComboBox gysComboBox=null;    //供应商下拉列表框
	
	private JLabel lxrLabel=null;    //联系人标签
	private JTextField lxrField=null;    //联系人文本框
	
	private JLabel jsfsLabel=null;    //结算方式标签
	private JComboBox jsfsComboBox=null;    //结算方式下拉列表框
	
	private JLabel thsjLabel=null;    //退货时间标签
	private JTextField thsjField=null;    //退货时间文本框
	
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
	 * 表格及其相关组件
	 */
	private JTable table=null;    //表格
	private JScrollPane tablePane=null;    //表格面板
	private JComboBox spComboBox=null;    //商品下拉列表框
	
	private Date thdate=new Date();    //退货时间
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		JinHuoTuiHuo_IFrame inFrame=new JinHuoTuiHuo_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	
	//构造函数
	public JinHuoTuiHuo_IFrame()
	{
		init();
	}
	
	
	//初始化进货退货内部窗体
	private void init()
	{
		this.setTitle("进货-退货");
		this.setMaximizable(true);
		this.setResizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.getContentPane().setLayout(new GridBagLayout());    //设置内部窗体的布局管理器为网格组布局管理器
		setBounds(50, 50, 600, 320);    // 设置进货-退货内部窗体的位置和宽高
		
		//初始化各个项目的标签
		//退货票号标签
		idLabel=new JLabel("退货票号："); 
		this.setupComponent(idLabel, 0, 0, 1, 0, false);
		idField=this.getIdField();
		idField.setPreferredSize(new Dimension(100,21));
		this.setupComponent(this.getIdField(), 1, 0, 1, 0, true);
		
		//供应商标签
		gysLabel=new JLabel("供应商：");
		this.setupComponent(gysLabel, 2, 0, 1,0, false);
		gysComboBox=this.getGysComboBox();
		gysComboBox.setPreferredSize(new Dimension(160,21));
		this.setupComponent(gysComboBox, 3, 0, 2, 0, true);
		
		
		
		//联系人标签
		lxrLabel=new JLabel("联系人：");
		this.setupComponent(lxrLabel, 5, 0, 1,0, false);
		lxrField=this.getLxrField();
		lxrField.setPreferredSize(new Dimension(80,21));
		this.setupComponent(this.getLxrField(), 6, 0, 1, 0, true);
		
		
		//结算方式标签
		jsfsLabel=new JLabel("结算方式：");
		this.setupComponent(jsfsLabel, 0, 1, 1, 0, false);
		this.setupComponent(this.getJsfsComboBox(), 1, 1, 1, 0, true);
		
		
		//退货时间标签
		thsjLabel=new JLabel("退货时间：");
		this.setupComponent(thsjLabel, 2, 1, 1,0, false);
		this.setupComponent(this.getThsjField(), 3, 1, 2, 0, true);
		
		
		//经手人标签
		jsrLabel=new JLabel("经手人：");
		this.setupComponent(jsrLabel, 5, 1, 1, 0, false);
		this.setupComponent(this.getJsrComboBox(), 6, 1, 1, 0, true);
		
		
		/*
		 * 添加表格面板：tablePane
		 */
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(580,148));
		this.setupComponent(tablePane, 0, 2, 7, 1, true);
		
		
		
		//品种数量标签
		pzslLabel=new JLabel("品种数量：");
		this.setupComponent(pzslLabel, 0, 3, 1, 0, false);
		pzslField=this.getPzslField();
		pzslField.setPreferredSize(new Dimension(100,21));
		this.setupComponent(this.getPzslField(), 1, 3, 1, 0, true);
		
		
		//货品总数标签
		hpzsLabel=new JLabel("货品总数：");
		this.setupComponent(hpzsLabel, 2, 3, 1, 0, false);
		hpzsField=this.getHpzsField();
		hpzsField.setPreferredSize(new Dimension(150,21));
		this.setupComponent(this.getHpzsField(), 3, 3, 1, 0, true);
		//System.out.println(hpzsField.getPreferredSize().height + ":" + hpzsField.getPreferredSize().width);
		
		
		//合计金额标签
		hjjeLabel=new JLabel("合计金额：");
		this.setupComponent(hjjeLabel, 4, 3, 1, 0, false);
		this.setupComponent(this.getHjjeField(), 5, 3, 3, 0, true);
		
		
		//验收结论标签
		ysjlLabel=new JLabel("验收结论：");
		this.setupComponent(ysjlLabel, 0, 4, 1, 0, false);
		this.setupComponent(this.getYsjlField(), 1, 4, 1, 0, true);
		
		
		//操作员标签
		czyLabel=new JLabel("操作员：");
		this.setupComponent(czyLabel, 2, 4, 1, 0, false);
		this.setupComponent(this.getCzyField(), 3, 4, 1, 1, true);
		
		
		//添加按钮
		this.setupComponent(this.getTjButton(), 5, 4, 1, 1, false);
		this.setupComponent(this.getThButton(), 6, 4, 1, 1, false);
		
		
	}
	
	
	/*
	 * 顶部组件
	 */
	//退货票号文本框：idField
	private JTextField getIdField()
	{
		if(idField==null)
		{
			idField=new JTextField();
			idField.setEditable(false);
			
		}
		return idField;
	}
	
	
	//供应商下拉列表框：gysComboBox
	private JComboBox getGysComboBox()
	{
		if(gysComboBox==null)
		{
			gysComboBox=new JComboBox();
			
			List gysinfos=Dao.getGysInfos();
			for(Iterator iter=gysinfos.iterator();iter.hasNext();)
			{
				List<String> tmp=(List<String>)iter.next();
				Item item=new Item();
				item.setId(tmp.get(0).trim());
				item.setName(tmp.get(1).trim());
				gysComboBox.addItem(item);
			}
			
			//添加自动更新联系人文本框的监视器
			gysComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Item item=(Item)gysComboBox.getSelectedItem();
					TbGysinfo selectGys=Dao.getGysinfo(item);
					lxrField.setText(selectGys.getLian());
				}
					});
		}
		return gysComboBox;
	}
	
	
	//初始化联系人文本框：lxrField
	private JTextField getLxrField()
	{
		if(lxrField==null)
		{
			lxrField=new JTextField();
			lxrField.setEditable(false);
		}
		return lxrField;
	}
	
	
	//初始化结算方式下拉列表框：jsfsComboBox
	private JComboBox getJsfsComboBox()
	{
		if(jsfsComboBox==null)
		{
			jsfsComboBox=new JComboBox();
			jsfsComboBox.addItem("现金结算");
			jsfsComboBox.addItem("支票结算");
			jsfsComboBox.setEditable(true);    //使其可以编辑，即有出这两种之外的结算方式
		}
		return jsfsComboBox;
	}
	
	
	//初始化退货时间文本框：thsjField
	private JTextField getThsjField()
	{
		if(thsjField==null)
		{
			thsjField=new JTextField();
			thsjField.setEditable(false);
		}
		return thsjField;
	}
	
	
	//初始化经手人下拉列表框：jsrComboBox
	private JComboBox getJsrComboBox()
	{
		if(jsrComboBox==null)
		{
			jsrComboBox=new JComboBox();
			List jsrinfos=Dao.getJsrs();
			for(Iterator iter=jsrinfos.iterator();iter.hasNext();)
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
			hpzsField=new JTextField();
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
	
	
	//初始化添加按钮：tjButton
	private JButton getTjButton()
	{
		if(tjButton==null)
		{
			tjButton=new JButton();
			tjButton.setText("添加");
			
			//添加空行
			tjButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					
					//同步更新退货票号和退货时间文本框
					long time=thdate.getTime();
					java.sql.Date sql_date=new java.sql.Date(time);
					thsjField.setText(sql_date.toString());
					
					//获取入库退货最大ID
					String thid=Dao.getRkthMainMaxId(sql_date);
					idField.setText(thid);
					
					
					for(int i=0;i<table.getRowCount();i++)
					{
						TbKucun info=(TbKucun)table.getValueAt(i, 0);
						
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
	
	
	/*
	 * 退货时，必须要求所有商品的供应商都为同一个。。。。（怎么解决？）（未解决）
	 */
	
	//问题?（2019.7.15 1:32)


	//初始化退货按钮：thButton
	private JButton getThButton()
	{
		if(thButton==null)
		{
			thButton=new JButton("退货");
			//添加监控器
			thButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					stopTableCellEditing();
					clearEmptyRow();    //清除空行
					
					String rkthID=idField.getText();    //入库退货ID
					String pzs=pzslField.getText();    //品种数量
					String je=hjjeField.getText();    //金额
					String ysjl=ysjlField.getText();    //验收结论
					//String gysname=gysComboBox.getSelectedItem().toString();    //供应商名字
					String rtdate=thsjField.getText();    //退货时间
					String czy=czyField.getText();    //操作员
					String jsr=jsrComboBox.getSelectedItem().toString();    //经手人
					String jsfs=jsfsComboBox.getSelectedItem().toString();    //结算方式
					
					
					if(jsr==null || jsr.isEmpty())
					{
						JOptionPane.showMessageDialog(JinHuoTuiHuo_IFrame.this, "请填写经手人");
						return;
					}
					
					if(ysjl==null || ysjl.isEmpty())
					{
						JOptionPane.showMessageDialog(JinHuoTuiHuo_IFrame.this, "请填写验收结论");
						return;
					}
					
					
					if(table.getRowCount()<=0)
					{
						JOptionPane.showMessageDialog(JinHuoTuiHuo_IFrame.this, "请添加退货商品");
						return;
					}
					
					
					/*
					 * 退货时，判断表格中的所有库存商品是否时由同一个供应商提供
					 */
					TbKucun kucun=(TbKucun)table.getValueAt(0, 0);
					String gysname=null;
					if(kucun!=null && kucun.getId()!=null && kucun.getSpname()!=null)
					{
						Item item=new Item();
						item.setId(kucun.getId());
						item.setName(kucun.getSpname());
						TbSpinfo spinfo=Dao.getSpinfo(item);
						gysname=spinfo.getGysname();
					}
					
					for(int i=0;i<table.getRowCount();i++)
					{
						TbKucun tmp=(TbKucun)table.getValueAt(i, 0);
						if(tmp!=null && tmp.getSpname()!=null && tmp.getId()!=null)
						{
							Item item=new Item();
							item.setId(tmp.getId());
							item.setName(tmp.getSpname());
							TbSpinfo t_sp=Dao.getSpinfo(item);
							if(!gysname.equals(t_sp.getGysname()))
							{
								JOptionPane.showMessageDialog(JinHuoTuiHuo_IFrame.this, "表格中存在不属于同一供应商的商品，请修改");
								return;
							}
						}	
					}
					
					
					//创建TbRkthMain类
					TbRkthMain rkthMain=new TbRkthMain(rkthID,pzs,je,ysjl,gysname,rtdate,czy,jsr,jsfs);
					Set<TbRkthDetail> details=rkthMain.getTbRkthDetail();
					
					int row=table.getRowCount();
					for(int i=0;i<row;i++)
					{
						TbKucun tmp=(TbKucun)table.getValueAt(i, 0);
						String djStr=(String)table.getValueAt(i, 6);
						String slStr=(String)table.getValueAt(i, 7);
						
						Double dj=Double.valueOf(djStr);
						Integer sl=Integer.valueOf(slStr);
						
						//初始化入库退货详细信息类
						TbRkthDetail detail=new TbRkthDetail();
						detail.setDj(dj);
						detail.setSl(sl);
						detail.setTbRkthMain(rkthID);
						detail.setSpid(tmp.getId());
						details.add(detail);
				    }
					
					//将信息添加进数据库
					boolean rs=Dao.insertRkthInfo(rkthMain);
					if(rs)
					{
						JOptionPane.showMessageDialog(JinHuoTuiHuo_IFrame.this, "退货成功");
						//清空表格的行
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
		return thButton;
	}
	
	
	
	
	/*
	 * 初始化表格及相关组件
	 */
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
			String[] columnName= { "商品名称", "商品编号", "产地", "单位", "规格", "包装", "单价", "数量" };
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			model.setColumnIdentifiers(columnName);    //设置表头
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			table.setShowGrid(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    //取消自动调整模式
			
			
			//设置表的商品列的编辑器为下拉列表框
			TableColumn column=table.getColumnModel().getColumn(0);
			DefaultCellEditor editor=new DefaultCellEditor(this.getSpComboBox());
			column.setCellEditor(editor);
			
			//添加随时，自动更新品种数量、货品总数、合计金额的监控器
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
	
	
	//初始化商品下拉列表框：spComboBox
	private JComboBox getSpComboBox()
	{
		if(spComboBox==null)
		{
			spComboBox=new JComboBox();
			spComboBox.addItem(new TbKucun());
			//添加监控器，跟新商品下拉列表框
			spComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					ResultSet rs=Dao.findForResultSet("select * from tb_kucun where id in (select id from tb_spinfo where gysname='" + gysComboBox.getSelectedItem() + "')");
					updatespComboBox(rs);
				}
					});
			
			
			//添加监控器，当选中商品列表框中的项时，自动更新本行表格其他内容
			spComboBox.addItemListener(new ItemListener()
					{
				public void itemStateChanged(ItemEvent e)
				{
					TbKucun kucun=(TbKucun)spComboBox.getSelectedItem();
					if(kucun!=null && kucun.getId()!=null)
					{
						updateTable();
					}
				}
					});
		}
		return spComboBox;
	}
	
	
	
	
	
	//更新商品下拉列表框
	/*
	 * 库存数据库里面，商品的编号都是唯一的，单价根据最新的进行更新，即，如果是同一个商品
	 * ，其价格是最新的价格；
	 */
	
	private void updatespComboBox(ResultSet rs)    
	{
		List<String> lst=new ArrayList<>();
		for(int i=0;table!=null && i<table.getRowCount();i++)
		{
			TbKucun kucun=(TbKucun)table.getValueAt(i, 0);
			if(kucun!=null && kucun.getId()!=null)
			{
				lst.add(kucun.getId());
			}
		}
		
		spComboBox.removeAllItems();
		try
		{
			while(rs.next())
			{
				TbKucun tmp=new TbKucun();
				String id=rs.getString("id").trim();
				if(lst.contains(id))
					continue;
				tmp.setId(id);
				tmp.setSpname(rs.getString("spname").trim());
				tmp.setJc(rs.getString("jc").trim());
				tmp.setCd(rs.getString("cd").trim());
				tmp.setGg(rs.getString("gg").trim());
				tmp.setBz(rs.getString("bz").trim());
				tmp.setDw(rs.getString("dw").trim());
				tmp.setDj(Double.valueOf(rs.getString("dj").trim()));
				tmp.setKcsl(Integer.valueOf(rs.getString("kcsl").trim()));
				spComboBox.addItem(tmp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	//当选中商品下拉列表框后，更新表格中内容的方法
	private synchronized void updateTable()
	{
		TbKucun kucun=(TbKucun)spComboBox.getSelectedItem();
		int row=table.getSelectedRow();
		if(row>=0 && kucun!=null)
		{
			table.setValueAt(kucun.getId(), row, 1);
			table.setValueAt(kucun.getCd(), row, 2);
			table.setValueAt(kucun.getDw(), row, 3);
			table.setValueAt(kucun.getGg(), row, 4);
			table.setValueAt(kucun.getBz(), row, 5);
			table.setValueAt(kucun.getDj().toString(), row, 6);
			table.setValueAt(kucun.getKcsl().toString(), row, 7);
			table.editCellAt(row, 7);
		}
	}
	
	
	
	//计算货品总数，合计金额等内容
	private void computeInfos()
	{
		int hpzs=0;
		Double hjje=0.0;
		
		//表格中必有行，因为没有行的话，此方法所属表格的监视器就不会发生
		int row=table.getRowCount();
		
		//根据添加按钮，表格最后一行的商品内容可能为空，其余行必定不为空
		TbKucun kucun=null;
		Object obj=table.getValueAt(row-1, 0);
		if(!(obj instanceof TbKucun))    //如果最后一行为空，则直接返回，不更新底部相关文本框
			return;
		
		kucun=(TbKucun)obj;    //否则其为TbKucun类
		if(row>0 && (kucun==null || kucun.getId().isEmpty()))
			row--;
		
		for(int i=0;i<row;i++)
		{
			String djStr=(String)table.getValueAt(i, 6);
			String slStr=(String)table.getValueAt(i, 7);
			
			Double dj=Double.valueOf(djStr);
			Integer sl=Integer.valueOf(slStr);
			
			hpzs+=sl;
			hjje+=(dj*sl);
		}
		
		pzslField.setText(String.valueOf(row));
		hpzsField.setText(String.valueOf(hpzs));
		hjjeField.setText(String.valueOf(hjje));
	}
	
	
	//停止编辑表格
	private void stopTableCellEditing()
	{
		TableCellEditor celleditor=table.getCellEditor();
		if(celleditor!=null)
		{
			celleditor.stopCellEditing();
		}
	}
	
	//清空空行
	private synchronized void clearEmptyRow()
	{
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		for(int i=0;i<table.getRowCount();i++)
		{
			TbKucun tmp=(TbKucun)table.getValueAt(i, 0);
			if(tmp==null || tmp.getId()==null || tmp.getId().isEmpty())
			{
				model.removeRow(i);
			}
		}
	}
	
	
	//设置组件位置，并添加到容器中
	private void setupComponent(JComponent component,int gridx,int gridy,int gridwidth, int ipadx,boolean fill)
	{
		final GridBagConstraints constraint=new GridBagConstraints();
		//设置组件位置
		constraint.gridx=gridx;
		constraint.gridy=gridy;
		constraint.insets=new Insets(5,1,3,1);
		
		if(gridwidth>1)
		{
			constraint.gridwidth=gridwidth;
		}

		constraint.ipadx=ipadx;

		
		
		if(fill)
		{
			constraint.fill=GridBagConstraints.HORIZONTAL;
		}
		this.getContentPane().add(component, constraint);
	}
}

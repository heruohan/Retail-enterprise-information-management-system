package com.lzw.iframe.ShangPinGuanLi;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.dao.*;
import java.sql.*;
import com.lzw.dao.model.*;
import java.util.List;
import java.util.*;
import com.lzw.*;
import java.awt.*;


public class ShangPinTianJiaPanel extends JPanel{
	
	/*
	 * 各组件
	 */
	private JTextField spnameField=null;    //商品名称文本框
	private JTextField jcField=null;    //简称文本框
	private JTextField cdField=null;    //产地文本框
	private JTextField dwField=null;    //单位文本框
	private JTextField ggField=null;    //规格文本框
	private JTextField bzField=null;    //包装文本框
	private JTextField phField=null;    //批号文本框
	private JTextField pzwhField=null;    //批准文号文本框
	private JComboBox gysComboBox=null;    //供应商下拉列表框
	private JTextField memoField=null;    //备注文本框
	
	private JButton tjButton=null;    //添加按钮
	private JButton resetButton=null;    //重置按钮
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(600,400);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JDesktopPane deskpane=new JDesktopPane();
		ShangPinTianJiaPanel inFrame=new ShangPinTianJiaPanel();
		
		
		
		//t.getContentPane().setLayout(null);
		t.getContentPane().add(inFrame);
		//t.pack();
		t.setVisible(true);
	}
	*/
	
	
	//构造函数
	public ShangPinTianJiaPanel()
	{
		init();
	}
	
	
	//初始化商品添加面板
	private void init()
	{
		this.setLayout(new GridBagLayout());
		//this.setBounds(50, 50, 450, 300);
		//this.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		//商品名称文本框：spnameField
		JLabel spnameLabel=new JLabel("商品名称：");
		this.setupComponent(spnameLabel, 0, 0, 1, 0, false);
		
		spnameField=new JTextField();
		spnameField.setPreferredSize(new Dimension(450,21));
		this.setupComponent(spnameField, 1, 0, 3, 0, true);
		
		
		//简称文本框：jcField
		JLabel jcLabel=new JLabel("简称：");
		this.setupComponent(jcLabel, 0, 1, 1, 0, false);
		
		jcField=new JTextField();
		this.setupComponent(jcField, 1, 1, 3, 0, true);
		
		
		
		//产地文本框：cdField
		JLabel cdLabel=new JLabel("产地：");
		this.setupComponent(cdLabel, 0, 2, 1, 0, false);
		
		cdField=new JTextField();
		this.setupComponent(cdField, 1, 2, 3, 0, true);
		
		
		//单位文本框：dwField
		JLabel dwLabel=new JLabel("单位：");
		this.setupComponent(dwLabel, 0, 3, 1, 0, false);
		
		dwField=new JTextField();
		dwField.setPreferredSize(new Dimension(200,21));
		this.setupComponent(dwField, 1, 3, 1, 0, true);
		
		
		//规格文本框：ggField
		JLabel ggLabel=new JLabel("规格：");
		this.setupComponent(ggLabel, 2, 3, 1, 0, false);
		
		ggField=new JTextField();
		this.setupComponent(ggField, 3, 3, 1, 0, true);
		
		
		//包装文本框：bzField
		JLabel bzLabel=new JLabel("包装：");
		this.setupComponent(bzLabel, 0, 4, 1, 0, false);
		
		bzField=new JTextField();
		this.setupComponent(bzField, 1, 4, 1, 0, true);
		
		
		//批号文本框：phField
		JLabel phLabel=new JLabel("批号：");
		this.setupComponent(phLabel, 2, 4, 1, 0, false);
		
		phField=new JTextField();
		this.setupComponent(phField, 3, 4, 1, 0, true);
		
		
		//批准文号文本框：pzwhField
		JLabel pzwhLabel=new JLabel("批准文号：");
		this.setupComponent(pzwhLabel, 0, 5, 1, 0, false);
		
		pzwhField=new JTextField();
		this.setupComponent(pzwhField, 1, 5, 3, 0, true);
		
		//供应商下拉列表框：gysComboBox
		JLabel gysComboBoxLabel=new JLabel("供应商全称：");
		this.setupComponent(gysComboBoxLabel, 0, 6, 1, 0, false);
		
		this.setupComponent(this.getGysComboBox(),1, 6, 3, 0, true);
		
		//备注文本框：memoField
		JLabel memoLabel=new JLabel("备注：");
		this.setupComponent(memoLabel, 0, 7, 1, 0, false);
		
		memoField=new JTextField();
		
		this.setupComponent(memoField, 1, 7, 3, 0, true);
		
		//添加按钮：tjButton
		this.setupComponent(this.getTjButton(), 1, 8, 1, 0, false);
		
		//重置按钮：resetButton
		this.setupComponent(this.getResetButton(), 2, 8, 1, 0, false);
		
		
	}
	
	
	
	//布局各组件在添加面板的位置方法
	private void setupComponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill)
	{
		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=gridx;
		constraint.gridy=gridy;
		constraint.insets=new Insets(5,3,5,3);
		
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
		
		this.add(component, constraint);
		
	}
	
	
	//商品名称文本框：spnameField
	//简称文本框：jcField
	//产地文本框：cdField
	//单位文本框：dwField
	//规格文本框：ggField
	//包装文本框：bzField
	//批号文本框：phField
	//批准文号文本框：pzwhField
	//供应商下拉列表框：gysComboBox
	private JComboBox getGysComboBox()
	{
		if(gysComboBox==null)
		{
			gysComboBox=new JComboBox();
			gysComboBox.setEditable(false);
			gysComboBox.setMaximumRowCount(5);
			
		}
		return gysComboBox;
	}
	
	//备注文本框：memoField
	
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
					//判断商品属性文本框是否为空，备注可以为空
					if(spnameField.getText().isEmpty() || jcField.getText().isEmpty() || cdField.getText().isEmpty()
					   || dwField.getText().isEmpty() || ggField.getText().isEmpty() || bzField.getText().isEmpty()
					   || phField.getText().isEmpty() || pzwhField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "请填写未完成信息", "商品添加", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					
					//判断数据库中是否存在同名商品
					ResultSet rs=Dao.query("select * from tb_spinfo where spname='" + spnameField.getText().trim() + "'");
					
					try
					{
						//如果数据库存在相同的商品
						if(rs.next())
						{
							JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "商品信息添加失败，存在同名商品");
							return;
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					
					//找出商品数据库中的最大id
					//此结果必定有一行数据，即使数据为null
					ResultSet re=Dao.query("select max(id) from tb_spinfo");
					String id=null;
					try
					{
						if(re.next())
						{
							String id1=re.getString(1);
							if(id1==null)
							{
								id="sp1001";
							}
							else
							{
								String s=id1.substring(2);
								id="sp" +  (Integer.parseInt(s)+1);
							}
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					//初始化TbSpinfo类，并将其添加到商品信息数据库中
					TbSpinfo spinfo=new TbSpinfo();
					spinfo.setId(id);
					spinfo.setSpname(spnameField.getText().trim());
					spinfo.setJc(jcField.getText().trim());
					spinfo.setCd(cdField.getText().trim());
					spinfo.setDw(dwField.getText().trim());
					spinfo.setGg(ggField.getText().trim());
					spinfo.setBz(bzField.getText().trim());
					spinfo.setPh(phField.getText().trim());
					spinfo.setPzwh(pzwhField.getText().trim());
					spinfo.setMemo(memoField.getText().trim());
					spinfo.setGysname(gysComboBox.getSelectedItem().toString());
					
					Dao.addSp(spinfo);
					JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "商品添加成功");
					resetButton.doClick();
					
				}
					});
		}
		return tjButton;
	}
	
	
	//重置按钮：resetButton
	private JButton getResetButton()
	{
		if(resetButton==null)
		{
			resetButton=new JButton("重置");
			
			//添加监控器
			resetButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					spnameField.setText("");
					jcField.setText("");
					cdField.setText("");
					dwField.setText("");
					ggField.setText("");
					bzField.setText("");
					phField.setText("");
					pzwhField.setText("");
					memoField.setText("");
				}
					});
		}
		return resetButton;
	}
	
	
	
	//更新供应商下拉列表框的方法
	public void updateGysComboBox()
	{
		List gysList=Dao.getGysInfos();
		
		//清空下拉列表框
		gysComboBox.removeAllItems();
		
		for(Iterator iter=gysList.iterator();iter.hasNext();)
		{
			List element=(List)iter.next();
			Item item=new Item();
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			
			//给供应商下拉列表框添加项
			gysComboBox.addItem(item);
		}
		System.out.println("更新供应商");
	}

}

package com.lzw.iframe.KeHuGuanLi;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.dao.*;
import java.sql.*;
import com.lzw.dao.model.*;
import java.awt.*;



public class KeHuTianJiaPanel extends JPanel{
	
	/*
	 * 各子组件
	 */
	private JTextField khnameField=null;    //客户全称文本框
	private JTextField khdzField=null;    //客户地址文本框
	private JTextField khjcField=null;    //客户简称文本框
	private JTextField yzbmField=null;    //邮政编码文本框
	private JTextField dhField=null;    //电话文本框
	private JTextField czField=null;    //传真文本框
	private JTextField lxrField=null;    //联系人文本框
	private JTextField lxdhField=null;    //联系电话文本框
	private JTextField emailField=null;    //E-Mail文本框
	private JTextField khyhField=null;    //开户银行文本框
	private JTextField yhzhField=null;    //银行账号文本框
	
	private JButton tjButton=null;    //添加按钮
	private JButton resetButton=null;    //重置按钮
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(600,350);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JDesktopPane deskpane=new JDesktopPane();
		KeHuTianJiaPanel inFrame=new KeHuTianJiaPanel();
		
		
		
		//t.getContentPane().setLayout(null);
		t.getContentPane().add(inFrame);
		//t.pack();
		t.setVisible(true);
	}
	*/
	
	//构造函数
	public KeHuTianJiaPanel()
	{
		init();
	}
	
	
	//初始化客户添加面板
	private void init()
	{
		this.setLayout(new GridBagLayout());
		
		//客户全称
		JLabel khnameLabel=new JLabel("客户全称：");
		this.setupComponent(khnameLabel, 0, 0, 1, 0, false);
		
		khnameField=new JTextField();
		khnameField.setPreferredSize(new Dimension(500,21));
		this.setupComponent(khnameField, 1, 0, 3, 0, true);
		
		//客户地址
		JLabel khdzLabel=new JLabel("客户地址：");
		this.setupComponent(khdzLabel, 0, 1, 1, 0, false);
		
		khdzField=new JTextField();
		this.setupComponent(khdzField, 1, 1, 3, 0, true);
		
		
		//客户简称
		JLabel khjcLabel=new JLabel("客户简称：");
		this.setupComponent(khjcLabel, 0, 2, 1, 0, false);
		
		khjcField=new JTextField();
		khjcField.setPreferredSize(new Dimension(200,21));
		this.setupComponent(khjcField, 1, 2, 1, 0, true);
		
		//邮政编码
		JLabel yzbmLabel=new JLabel("邮政编码：");
		this.setupComponent(yzbmLabel, 2, 2, 1, 0, false);
		
		yzbmField=new JTextField();
		this.setupComponent(yzbmField, 3, 2, 1, 0, true);
		
		//电话
		JLabel dhLabel=new JLabel("电话：");
		this.setupComponent(dhLabel, 0, 3, 1, 0, false);
		
		dhField=new JTextField();
		this.setupComponent(dhField, 1, 3, 1, 0, true);
		
		
		//传真
		JLabel czLabel=new JLabel("传真：");
		this.setupComponent(czLabel, 2, 3, 1, 0, false);
		
		czField=new JTextField();
		this.setupComponent(czField, 3, 3, 1, 0, true);
		
		
		//联系人
		JLabel lxrLabel=new JLabel("联系人：");
		this.setupComponent(lxrLabel, 0, 4, 1, 0, false);
		
		lxrField=new JTextField();
		this.setupComponent(lxrField, 1, 4, 1, 0, true);
		
		//联系电话
		JLabel lxdhLabel=new JLabel("联系电话：");
		this.setupComponent(lxdhLabel, 2, 4, 1, 0, false);
		
		lxdhField=new JTextField();
		this.setupComponent(lxdhField, 3, 4, 1, 0, true);
		
		//E-Mail
		JLabel emailLabel=new JLabel("E-Mail：");
		this.setupComponent(emailLabel, 0, 5, 1, 0, false);
		
		emailField=new JTextField();
		this.setupComponent(emailField, 1, 5, 3, 0, true);
		
		//开户银行
		JLabel khyhLabel=new JLabel("开户银行：");
		this.setupComponent(khyhLabel, 0, 6, 1, 0, false);
		
		khyhField=new JTextField();
		this.setupComponent(khyhField, 1, 6, 1, 0, true);
		
		
		//银行账号
		JLabel yhzhLabel=new JLabel("银行账号：");
		this.setupComponent(yhzhLabel, 2, 6, 1, 0, false);
		
		yhzhField=new JTextField();
		this.setupComponent(yhzhField, 3, 6, 1, 0, true);
		
		
		//
		JPanel pane=new JPanel();
		FlowLayout layout=new FlowLayout();
		layout.setHgap(50);
		pane.setLayout(layout);
		pane.add(this.getTjButton());
		pane.add(this.getResetButton());
		this.setupComponent(pane, 0, 7, 4, 0, true);
		
		//添加按钮：tjButton
		//this.setupComponent(this.getTjButton(), 1, 7, 1, 0, false);
		
		//重置按钮：resetButton
		//this.setupComponent(this.getResetButton(), 2, 7, 1, 0, false);
		
		
	}
	
	
	//布局各组件
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
	
	
	
	//初始化添加按钮：tjButton
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
					//判断所有文本框中是否有为空的内容
					if(khnameField.getText().isEmpty() || khdzField.getText().isEmpty() ||
					   khjcField.getText().isEmpty() || yzbmField.getText().isEmpty() || 
					   dhField.getText().isEmpty() || czField.getText().isEmpty() || 
					   lxrField.getText().isEmpty() || lxdhField.getText().isEmpty() || 
					   emailField.getText().isEmpty() || khyhField.getText().isEmpty() ||
					   yhzhField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "请填写全部信息");
						return;
					}
					
					//判断当前客户是否已经在数据库中
					ResultSet rs=Dao.query("select * from tb_khinfo where khname='" + khnameField.getText().trim() + "'");
					
					try
					{
						if(rs.next())
						{
							JOptionPane.showMessageDialog(KeHuTianJiaPanel.this,"客户信息添加失败，存在同名客户", "客户信息添加", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					
					//找出数据库中的最大客户ID
					ResultSet re=Dao.query("select max(id) from tb_khinfo");
					String id=null;
					try
					{
						if(re.next())
						{
							String tmp=re.getString(1);
							if(tmp==null)
							{
								id="kh1000";
							}
							else
							{
								String sub_str=tmp.substring(2);
								id="kh" + (Integer.parseInt(sub_str) + 1);
							}	
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					
					//获取了客户ID后，构造TbKhinfo类
					TbKhinfo khinfo=new TbKhinfo();
					khinfo.setId(id);
					khinfo.setKhname(khnameField.getText().trim());
					khinfo.setJian(khjcField.getText().trim());
					khinfo.setAddress(khdzField.getText().trim());
					khinfo.setBianma(yzbmField.getText().trim());
					khinfo.setTel(dhField.getText().trim());
					khinfo.setFax(czField.getText().trim());
					khinfo.setLian(lxrField.getText().trim());
					khinfo.setLtel(lxdhField.getText().trim());
					khinfo.setMail(emailField.getText().trim());
					khinfo.setXinhang(khyhField.getText().trim());
					khinfo.setHao(yhzhField.getText().trim());
					
					//添加进数据集
					Dao.addKeHu(khinfo);
					JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "添加客户信息成功", "客户信息添加", JOptionPane.INFORMATION_MESSAGE);
					resetButton.doClick();
				}
					});
		}
		return tjButton;
	}
	
	
	
	//初始化重置按钮：resetButton
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
					khnameField.setText("");
					khdzField.setText("");
					khjcField.setText("");
					yzbmField.setText("");
					dhField.setText("");
					czField.setText("");
					lxrField.setText("");
					lxdhField.setText("");
					emailField.setText("");
					khyhField.setText("");
					yhzhField.setText("");
					
				}
					});
		}
		return resetButton;
	}
	

}

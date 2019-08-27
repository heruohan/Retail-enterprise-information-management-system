package com.lzw.iframe.gysGuanLi;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.dao.*;
import java.sql.*;
import com.lzw.dao.model.*;
import java.awt.*;



public class GysTianJiaPanel extends JPanel{
	
	/*
	 * 设置各组件
	 */
	private JTextField gysnameField=null;     //供应商名称
	private JTextField jcField=null;    //简称
	private JTextField yzbmField=null;    //邮政编码
	private JTextField dzField=null;    //地址
	private JTextField dhField=null;     //电话
	private JTextField czField=null;    //传真
	private JTextField lxrField=null;    //联系人
	private JTextField lxrdhField=null;    //联系电话
	private JTextField khyhField=null;    //开户银行
	private JTextField dzxxField=null;    //电子信箱
	
	private JButton tjButton=null;    //添加按钮
	private JButton resetButton=null;     //重置按钮
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(600,400);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JDesktopPane deskpane=new JDesktopPane();
		GysTianJiaPanel inFrame=new GysTianJiaPanel();
		
		
		
		//t.getContentPane().setLayout(null);
		t.getContentPane().add(inFrame);
		//t.pack();
		t.setVisible(true);
	}
	*/
	
	//构造函数
	public GysTianJiaPanel()
	{
		init();
	}
	
	
	//初始化供应商添加面板
	private void init()
	{
		this.setLayout(new GridBagLayout());
		
		//供应商全称
		JLabel gysnameLabel=new JLabel("供应商全称：");
		this.setupComponent(gysnameLabel, 0, 0, 1, 0, false);
		
		gysnameField=new JTextField();
		gysnameField.setPreferredSize(new Dimension(480,21));
		this.setupComponent(gysnameField, 1, 0, 3, 0, true);
		
		
		//简称
		JLabel jcLabel=new JLabel("简称：");
		this.setupComponent(jcLabel, 0, 1, 1, 0, false);
		
		jcField=new JTextField();
		jcField.setPreferredSize(new Dimension(200,21));
		this.setupComponent(jcField, 1, 1, 1, 0, true);
		
		//邮政编码
		JLabel yzbmLabel=new JLabel("邮政编码：");
		this.setupComponent(yzbmLabel, 2, 1, 1, 0, false);
		
		yzbmField=new JTextField();
		this.setupComponent(yzbmField, 3, 1, 1, 0, true);
		
		//地址
		JLabel dzLabel=new JLabel("地址：");
		this.setupComponent(dzLabel, 0, 2, 1, 0, false);
		
		dzField=new JTextField();
		this.setupComponent(dzField, 1, 2, 3, 0, true);
		
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
		
		
		//联系人电话
		JLabel lxrdhLabel=new JLabel("联系人电话：");
		this.setupComponent(lxrdhLabel, 2, 4, 1, 0, false);
		
		lxrdhField=new JTextField();
		this.setupComponent(lxrdhField, 3, 4, 1, 0, true);
		
		
		//开户银行
		JLabel khyhLabel=new JLabel("开户银行：");
		this.setupComponent(khyhLabel, 0, 5, 1, 0, false);
		
		khyhField=new JTextField();
		this.setupComponent(khyhField, 1, 5, 1, 0, true);
		
		//电子信箱
		JLabel dzxxLabel=new JLabel("电子信箱：");
		this.setupComponent(dzxxLabel, 2, 5, 1, 0, false);
		
		dzxxField=new JTextField();
		this.setupComponent(dzxxField, 3, 5, 1, 0, true);
		
		//添加按钮
		JPanel pane=new JPanel();
		FlowLayout layout=new FlowLayout();
		layout.setHgap(40);
		pane.setLayout(layout);
		pane.add(this.getTjButton());
		pane.add(this.getResetButton());
		
		this.setupComponent(pane, 0, 6, 4, 0, true);
		
	}
	
	
	//设置各个子组件的方法
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
	
	
	
	//初始化添加按钮:tjButton
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
					if(gysnameField.getText().isEmpty() || jcField.getText().isEmpty() ||
					  yzbmField.getText().isEmpty() || dzField.getText().isEmpty() || 
					  dhField.getText().isEmpty() || czField.getText().isEmpty() || 
					  lxrField.getText().isEmpty() || lxrdhField.getText().isEmpty() ||
					  khyhField.getText().isEmpty() || dzxxField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(GysTianJiaPanel.this, "请填写完整信息");
						return;
					}
					
					//判断供应商数据库中是否已经有此供应商
					ResultSet rs=Dao.query("select * from tb_gysinfo where name='" + gysnameField.getText().trim() + "'");
					
					try
					{
						if(rs.next())
						{
							JOptionPane.showMessageDialog(GysTianJiaPanel.this, "信息添加失败，存在同名供应商", "信息添加", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					
					//获取供应商的ID
					ResultSet re=Dao.query("select max(id) from tb_gysinfo");
					String id=null;
					try
					{
						if(re.next())
						{
							String tmp=re.getString(1);
							if(tmp==null)
							{
								id="gys1000";
							}
							else
							{
								String sub_tmp=tmp.substring(3);
								id="gys" + (Integer.parseInt(sub_tmp)+1);
							}
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					
					//构建TbGysinfo
					TbGysinfo gysinfo=new TbGysinfo();
					gysinfo.setId(id);
					gysinfo.setName(gysnameField.getText().trim());
					gysinfo.setJc(jcField.getText().trim());
					gysinfo.setAddress(dzField.getText().trim());
					gysinfo.setBianma(yzbmField.getText().trim());
					gysinfo.setTel(dhField.getText().trim());
					gysinfo.setFax(czField.getText().trim());
					gysinfo.setLian(lxrField.getText().trim());
					gysinfo.setLtel(lxrdhField.getText().trim());
					gysinfo.setYh(khyhField.getText().trim());
					gysinfo.setMail(dzxxField.getText().trim());
					
					//添加进数据库
					Dao.addGys(gysinfo);
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "供应商信息添加成功");
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
					gysnameField.setText("");
					jcField.setText("");
					yzbmField.setText("");
					dzField.setText("");
					dhField.setText("");
					czField.setText("");
					lxrField.setText("");
					lxrdhField.setText("");
					khyhField.setText("");
					dzxxField.setText("");
				}
					});
		}
		return resetButton;
	}
	

}

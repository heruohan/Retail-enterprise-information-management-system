package com.lzw.iframe.gysGuanLi;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.*;
import com.lzw.dao.model.*;
import com.lzw.dao.*;

import java.util.Iterator;
import java.util.List;
import java.awt.*;



public class GysXiuGaiPanel extends JPanel{
	
	/*
	 * 各个子组件
	 */
	private JTextField gysnameField=null;    //供应商全称
	private JTextField jcField=null;    //简称
	private JTextField yzbmField=null;    //邮政编码
	private JTextField dzField=null;    //地址
	private JTextField dhField=null;    //电话
	private JTextField czField=null;    //传真
	private JTextField lxrField=null;    //联系人
	private JTextField lxrdhField=null;    //联系人电话
	private JTextField khyhField=null;    //开户银行
	private JTextField dzxxField=null;    //电子信箱
	
	private JComboBox xzgysComboBox=null;    //选择供应商下拉列表框
	private JButton xgButton=null;    //修改按钮
	private JButton delButton=null;    //删除按钮
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(600,400);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JDesktopPane deskpane=new JDesktopPane();
		GysXiuGaiPanel inFrame=new GysXiuGaiPanel();
		
		
		
		//t.getContentPane().setLayout(null);
		t.getContentPane().add(inFrame);
		//t.pack();
		t.setVisible(true);
	}
	*/
	
	
	//构造函数
	public GysXiuGaiPanel()
	{
		init();
	}
	
	
	//初始化供应商修改与删除面板
	private void init()
	{
		this.setLayout(new GridBagLayout());
		
		//供应商全称
		JLabel gysnameLabel=new JLabel("供应商全称：");
		this.setupComponent(gysnameLabel, 0, 0, 1, 0, false);
		
		gysnameField=new JTextField();
		gysnameField.setEditable(false);
		gysnameField.setPreferredSize(new Dimension(490,24));
		this.setupComponent(gysnameField, 1, 0, 3, 0, true);
		
		
		//简称
		JLabel jcLabel=new JLabel("简称：");
		this.setupComponent(jcLabel, 0, 1, 1, 0, false);
		
		jcField=new JTextField();
		jcField.setPreferredSize(new Dimension(210,24));
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
		
		
		//选择供应商下拉列表框：xzgysComboBox
		JLabel xzgysLabel=new JLabel("选择供应商：");
		this.setupComponent(xzgysLabel, 0, 6, 1, 0, false);
		
		this.setupComponent(this.getXzgysComboBox(), 1, 6, 2, 0, true);
		
		
		//修改和删除按钮
		JPanel panel=new JPanel();
		FlowLayout layout=new FlowLayout();
		//layout.setHgap(60);
		panel.add(this.getXgButton());
		panel.add(this.getDelButton());
		this.setupComponent(panel, 3, 6, 1, 0, true);
	}
	
	
	
	//布局组件的方法
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
	
	
	
	//初始化选择供应商下拉列表框：xzgysComboBox
	private JComboBox getXzgysComboBox()
	{
		if(xzgysComboBox==null)
		{
			xzgysComboBox=new JComboBox();
			xzgysComboBox.setEditable(false);
			xzgysComboBox.setMaximumRowCount(5);
			xzgysComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					updateAllField();
				}
					});
		}
		return xzgysComboBox;
	}
	
	
	//初始化修改按钮：xgButton
	private JButton getXgButton()
	{
		if(xgButton==null)
		{
			xgButton=new JButton("修改");
			
			//添加监控器
			xgButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Object obj=xzgysComboBox.getSelectedItem();
					if(obj==null || !(obj instanceof Item))
					{
						JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "请正确填写供应商");
						return;
					}
					
					Item item=(Item)obj;
					//构造TbGysinfo
					TbGysinfo gysinfo=new TbGysinfo();
					gysinfo.setId(item.getId());
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
					
					if(Dao.updateGys(gysinfo)==1)
					{
						JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "信息修改成功");
					}
					else
					{
						JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "信息修改失败");
					}
					
				}
					});
		}
		return xgButton;
	}
	
	
	
	//初始化删除按钮：delButton
	private JButton getDelButton()
	{
		if(delButton==null)
		{
			delButton=new JButton("删除");
			
			//添加监控器
			delButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Object obj=xzgysComboBox.getSelectedItem();
					Item item=null;
					if(obj==null || !(obj instanceof Item) || (item=(Item)obj).getId()==null)
					{
						return;
					}
					
					
					int res=JOptionPane.showConfirmDialog(GysXiuGaiPanel.this, "确认删除此供应商吗？", "信息删除与修改", JOptionPane.YES_NO_CANCEL_OPTION);
					if(res==JOptionPane.YES_OPTION)
					{
						int rs=Dao.delete("delete from tb_gysinfo where id='" + item.getId() + "'");
						if(rs>0)
						{
							JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "信息删除成功");
							xzgysComboBox.removeItem(item);
						}
					}
				}
					});
		}
		return delButton;
	}
	
	
	
	//初始化选择供应商下拉列表框的方法
	public void updateComboBox()
	{
		List lst=Dao.getGysInfos();
		xzgysComboBox.removeAllItems();
		
		for(Iterator iter=lst.iterator();iter.hasNext();)
		{
			List tmp=(List)iter.next();
			Item item=new Item();
			item.setId(tmp.get(0).toString().trim());
			item.setName(tmp.get(1).toString().trim());
			xzgysComboBox.addItem(item);
		}
		this.updateAllField();
		
	}
	
	
	//当选择了供应商后，更新所有文本框的方法
	private void updateAllField()
	{
		Object obj=xzgysComboBox.getSelectedItem();
		if(obj==null || !(obj instanceof Item))
		{
			return;
		}
		
		Item item=(Item)obj;
		TbGysinfo gysinfo=Dao.getGysinfo(item);
		if(gysinfo.getId()!=null)
		{
			gysnameField.setText(gysinfo.getName());
			jcField.setText(gysinfo.getJc());
			yzbmField.setText(gysinfo.getBianma());
			dzField.setText(gysinfo.getAddress());
			dhField.setText(gysinfo.getTel());
			czField.setText(gysinfo.getFax());
			lxrField.setText(gysinfo.getLian());
			lxrdhField.setText(gysinfo.getLtel());
			khyhField.setText(gysinfo.getYh());
			dzxxField.setText(gysinfo.getMail());
			
		}
	}
}

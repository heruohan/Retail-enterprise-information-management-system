package com.lzw.iframe.ShangPinGuanLi;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.*;
import com.lzw.dao.*;
import com.lzw.dao.model.*;
import java.util.List;
import java.util.*;
import java.awt.*;



public class ShangPinXiuGaiPanel extends JPanel{
	
	/*
	 * 商品修改和删除面板的各个子组件
	 */
	private JTextField spnameField=null;    //商品名称文本框
	private JTextField jcField=null;     //简称文本框
	private JTextField cdField=null;    //产地文本框
	private JTextField dwField=null;    //单位文本框
	private JTextField ggField=null;    //规格文本框
	private JTextField bzField=null;    //包装文本框
	private JTextField phField=null;    //批号文本框
	private JTextField pzwhField=null;    //批准文号文本框
	private JComboBox gysComboBox=null;    //供应商下拉文本框
	private JTextField memoField=null;    //备注文本框
	private JComboBox spComboBox=null;    //商品下拉列表框
	
	private JButton xgButton=null;    //修改按钮
	private JButton delButton=null;    //删除按钮
	
	
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(600,400);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JDesktopPane deskpane=new JDesktopPane();
		ShangPinXiuGaiPanel inFrame=new ShangPinXiuGaiPanel();
		
		
		
		//t.getContentPane().setLayout(null);
		t.getContentPane().add(inFrame);
		//t.pack();
		t.setVisible(true);
	}
	
	
	
	//构造函数
	public ShangPinXiuGaiPanel()
	{
		init();
	}
	
	
	//初始化商品修改和删除内部窗体
	private void init()
	{
		this.setLayout(new GridBagLayout());
		//this.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		//添加组件
		//商品名称
		JLabel spnameLabel=new JLabel("商品名称：");
		this.setupComboBox(spnameLabel, 0, 0, 1, 0, false);
		
		
		spnameField=new JTextField();
		spnameField.setEditable(false);
		spnameField.setPreferredSize(new Dimension(490,21));
		this.setupComboBox(spnameField, 1, 0, 3, 0, true);
		
		//简称
		JLabel jcLabel=new JLabel("简称：");
		this.setupComboBox(jcLabel, 0, 1, 1, 0, false);
		
		jcField=new JTextField();
		this.setupComboBox(jcField, 1, 1, 3, 0, true);
		
		//产地
		JLabel cdLabel=new JLabel("产地：");
		this.setupComboBox(cdLabel, 0, 2, 1, 0, false);
		
		cdField=new JTextField();
		this.setupComboBox(cdField, 1, 2, 3, 0, true);
		
		//单位
		JLabel dwLabel=new JLabel("单位：");
		this.setupComboBox(dwLabel, 0, 3, 1, 0, false);
		
		dwField=new JTextField();
		dwField.setPreferredSize(new Dimension(240,21));
		this.setupComboBox(dwField, 1, 3, 1, 0, true);
		
		//规格
		JLabel ggLabel=new JLabel("规格：");
		this.setupComboBox(ggLabel, 2, 3, 1, 0, false);
		
		ggField=new JTextField();
		//ggField.setPreferredSize(new Dimension(140,21));
		this.setupComboBox(ggField, 3, 3, 1, 0, true);
		
		//包装
		JLabel bzLabel=new JLabel("包装：");
		this.setupComboBox(bzLabel, 0, 4, 1, 0, false);
		
		bzField=new JTextField();
		this.setupComboBox(bzField, 1, 4, 1, 0, true);
		
		//批号
		JLabel phLabel=new JLabel("批号：");
		this.setupComboBox(phLabel, 2, 4, 1, 0, false);
		
		phField=new JTextField();
		this.setupComboBox(phField, 3, 4, 1, 0, true);
		
		//批准文号
		JLabel pzwhLabel=new JLabel("批准文号：");
		this.setupComboBox(pzwhLabel, 0, 5, 1, 0, false);
		
		pzwhField=new JTextField();
		this.setupComboBox(pzwhField, 1, 5, 3, 0, true);
		
		//供应商下拉列表框
		JLabel gysLabel=new JLabel("供应商全称：");
		this.setupComboBox(gysLabel, 0, 6, 1, 0, false);
		
		this.setupComboBox(this.getGysComboBox(), 1, 6, 3, 0, true);
		
		//备注
		JLabel memoLabel=new JLabel("备注：");
		this.setupComboBox(memoLabel, 0, 7, 1, 0, false);
		
		memoField=new JTextField();
		this.setupComboBox(memoField, 1, 7, 3, 0, true);
		
		//选择商品
		JLabel spLabel=new JLabel("选择商品：");
		this.setupComboBox(spLabel, 0, 8, 1, 0, false);
		
		spComboBox=this.getSpComboBox();
		spComboBox.setPreferredSize(new Dimension(280,25));
		this.setupComboBox(this.getSpComboBox(), 1, 8, 2, 0, true);
		
		
		//修改按钮：xgButton
		
		JPanel panel=new JPanel();
		FlowLayout layout=new FlowLayout();
		layout.setHgap(18);
		panel.setLayout(layout);
		panel.add(this.getXgButton());
		panel.add(this.getDelButton());
		
		this.setupComboBox(panel, 3, 8, 1, 0, true);
		
		//this.setupComboBox(this.getXgButton(), 2, 8, 1, 0, false);
		
		
		//删除按钮：delButton
		//this.setupComboBox(this.getDelButton(), 3, 8, 1, 0, false);
		
	}
	
	
	
	//设置布局组件的方法
	private void setupComboBox(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill)
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
	
	
	//初始化商品下拉列表框：spComboBox
	private JComboBox getSpComboBox()
	{
		if(spComboBox==null)
		{
			spComboBox=new JComboBox();
			spComboBox.setMaximumRowCount(5);
			
			//添加监控器
			spComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					updateAllField();
				}
					});
		}
		return spComboBox;
	}
	
	
	
	//初始化供应商下拉列表框：gysComboBox
	private JComboBox getGysComboBox()
	{
		if(gysComboBox==null)
		{
			gysComboBox=new JComboBox();
			gysComboBox.setMaximumRowCount(5);
		}
		return gysComboBox;
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
					Item item=(Item)spComboBox.getSelectedItem();
					if(item==null || item.getId()==null)
					{
						JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "请正确填写商品");
						return;
					}
					
					//构造此时的TbSpinfo类
					TbSpinfo spinfo=new TbSpinfo();
					spinfo.setId(item.getId());
					spinfo.setSpname(spnameField.getText().trim());
					spinfo.setJc(jcField.getText().trim());
					spinfo.setCd(cdField.getText().trim());
					spinfo.setDw(dwField.getText().trim());
					spinfo.setGg(ggField.getText().trim());
					spinfo.setBz(bzField.getText().trim());
					spinfo.setPh(phField.getText().trim());
					spinfo.setPzwh(pzwhField.getText().trim());
					spinfo.setMemo(memoField.getText().trim());
					spinfo.setGysname(gysComboBox.getSelectedItem().toString().trim());
					
					if(Dao.updateSp(spinfo)==1)
					{
						JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "修改完成");
						
					}
					else
					{
						JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "修改失败");
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
					Item item=(Item)spComboBox.getSelectedItem();
					if(item==null || item.getId()==null || !(item instanceof Item))
					{
						return;
					}
					
					int confirm=JOptionPane.showConfirmDialog(ShangPinXiuGaiPanel.this, "确认删除商品吗？");
					if(confirm==JOptionPane.YES_OPTION)
					{
						int res=Dao.delete("delete from tb_spinfo where id='" + item.getId() + "'");
						if(res>0)
						{
							JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "商品：" + item.getName() + ",删除成功");
							spComboBox.removeItem(item);
						}
					}
				}
					});
		}
		return delButton;
	}
	
	
	//更新商品下拉列表框的方法，表中的项目是Item
	public void updateSpComboBox()
	{
		
		List lst=Dao.getSpinfos();
		spComboBox.removeAllItems();
		for(Iterator iter=lst.iterator();iter.hasNext();)
		{
			List tmp=(List)iter.next();
			Item item=new Item();
			item.setId(tmp.get(0).toString().trim());
			item.setName(tmp.get(1).toString().trim());
			
			spComboBox.addItem(item);
		}
		this.updateAllField();
		System.out.println("何聪聪");
		
	}
	
	
	
	//更新供应商下拉列表框的方法,表中的项是Item
	public void updateGysComboBox()
	{
		List lst=Dao.getGysInfos();
		gysComboBox.removeAllItems();
		for(Iterator iter=lst.iterator();iter.hasNext();)
		{
			List tmp=(List)iter.next();
			Item item=new Item();
			item.setId(tmp.get(0).toString().trim());
			item.setName(tmp.get(1).toString().trim());
			
			gysComboBox.addItem(item);
			
		}
		this.updateAllField();
		System.out.println("hcc2");
		
	}
	
	
	//当选择了商品后，更新各个文本框和供应商下拉列表框的方法
	private void updateAllField()
	{
		Object obj=spComboBox.getSelectedItem();
		if(!(obj instanceof Item))
		{
			return;
		}
		
		
		Item item=(Item)obj;    //商品的项
		TbSpinfo spinfo=Dao.getSpinfo(item);
		//判断
		if(spinfo.getId()!=null && !spinfo.getId().isEmpty())
		{
			spnameField.setText(spinfo.getSpname());
			jcField.setText(spinfo.getJc());
			cdField.setText(spinfo.getCd());
			dwField.setText(spinfo.getDw());
			ggField.setText(spinfo.getGg());
			bzField.setText(spinfo.getBz());
			phField.setText(spinfo.getPh());
			pzwhField.setText(spinfo.getPzwh());
			memoField.setText(spinfo.getMemo());
			
			
			//更新供应商下拉列表框
			/*
			 * 当更新商品的下拉列表框中的选中值为当前值时，一定要赋值，因为即使Item的属性都相同，
			 * 但是地址不相同，则认为不是一项；
			 */
			Item gysItem=new Item();
			gysItem.setName(spinfo.getGysname());
			
			TbGysinfo gysinfo=Dao.getGysinfo(gysItem);
			gysItem.setId(gysinfo.getId());
			gysItem.setName(gysinfo.getName());
			
			for(int i=0;i<gysComboBox.getItemCount();i++)
			{
				Item gys=(Item)gysComboBox.getItemAt(i);
				if(gys.getName().equals(gysItem.getName()))
				{
					gysItem=gys;
				}
			}
			
			//设置供应商下拉列表框的选中值
			gysComboBox.setSelectedItem(gysItem);
		}
		
	}
	

}

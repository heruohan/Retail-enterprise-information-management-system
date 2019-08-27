package com.lzw.iframe;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.Color;
import java.awt.event.*;
import com.lzw.dao.model.*;
import com.lzw.*;
import com.lzw.dao.*;
import java.util.List;
import java.util.*;
import java.awt.*;



public class JiaGeTiaoZheng_IFrame extends JInternalFrame{
	
	/*
	 * 内部窗体上的各个子组件
	 */
	private JLabel spnameLabel=null;    //商品名称标签
	private JComboBox spComboBox=null;    //商品下拉列表框
	
	private JLabel ggLabel=null;    //规格标签
	private JLabel ggField=null;    //规格内容
	
	private JLabel cdLabel=null;    //产地标签
	private JLabel cdField=null;    //产地内容
	
	private JLabel jcLabel=null;    //简称标签
	private JLabel jcField=null;    //简称内容
	
	private JLabel bzLabel=null;    //包装标签
	private JLabel bzField=null;    //包装内容
	
	private JLabel dwLabel=null;    //单位标签
	private JLabel dwField=null;    //单位内容
	
	private JLabel djLabel=null;    //单价标签
	private JTextField djField=null;    //单价文本框
	
	private JLabel kcslLabel=null;    //库存数量标签
	private JTextField kcslField=null;    //库存数量文本框
	
	private JLabel kcjeLabel=null;    //库存金额标签
	private JTextField kcjeField=null;    //库存金额文本框
	
	private JButton qdButton=null;    //确定按钮
	private JButton gbButton=null;    //关闭按钮
	
	private TbKucun kucuninfo;    //库存信息类
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		JiaGeTiaoZheng_IFrame inFrame=new JiaGeTiaoZheng_IFrame();
		
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	
	//构造函数
	public JiaGeTiaoZheng_IFrame()
	{
		init();
	}
	
	
	//初始化价格调整内部窗体
	private void init()
	{
		//给内部窗体添加监控器，当产生内部窗体的时候，同步初始化商品下拉列表框的内容
		//此监控器的内部窗体激活方法，在setVisible函数执行后，在执行；
		this.addInternalFrameListener(new InternalFrameAdapter()
				{
			public void internalFrameActivated(InternalFrameEvent e)
			{
				System.out.println(123);
				DefaultComboBoxModel model=(DefaultComboBoxModel)spComboBox.getModel();
				
				model.removeAllElements();
				List kucun=Dao.getKucunInfos();
				spComboBox.addItem("--请选择--");
				for(Iterator iter=kucun.iterator();iter.hasNext();)
				{
					List<String> tmp=(List<String>)iter.next();
					Item item=new Item();
					item.setId(tmp.get(0));
					item.setName(tmp.get(1));
					spComboBox.addItem(item);
				}	
			}
				});
		
		
		//内部窗体的属性
		this.setTitle("价格调整");
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setClosable(true);
		this.setBounds(50, 50, 570, 300);
		this.getContentPane().setLayout(new GridBagLayout());    //设置布局管理器
		
		
		//布局组件
		//商品名称：spnameLabel
		spnameLabel=new JLabel("商品名称：");
		this.setupComponent(spnameLabel, 0, 0, 1, 0, false);
		this.setupComponent(this.getSpComboBox(), 1, 0, 1, 0, true);
		
		
		
		//规格标签：ggLabel
		ggLabel=new JLabel("规    格：");
		this.setupComponent(ggLabel, 2, 0, 1, 0, false);
		this.setupComponent(this.getGgField(), 3, 0, 1, 0, false);
		
		
		//产地标签：cdLabel
		cdLabel=new JLabel("产    地：");
		this.setupComponent(cdLabel, 0, 1, 1, 0, false);
		this.setupComponent(this.getCdField(), 1, 1, 1, 0, false);
		
		
		//简称标签：jcLabel
		jcLabel=new JLabel("简    称：");
		this.setupComponent(jcLabel, 2, 1, 1, 0, false);
		this.setupComponent(this.getJcField(), 3, 1, 1, 0, false);
		
		
		//包装标签：bzLabel
		bzLabel=new JLabel("包    装：");
		this.setupComponent(bzLabel, 0, 2, 1, 0, false);
		this.setupComponent(this.getBzField(), 1, 2, 1, 0, false);
		
		
		//单位标签：dwLable
		dwLabel=new JLabel("单    位：");
		this.setupComponent(dwLabel, 2, 2, 1, 0, false);
		this.setupComponent(this.getDwField(), 3, 2, 1, 0, false);
		
		
		//单价标签：djLabel
		djLabel=new JLabel("单    价：");
		this.setupComponent(djLabel, 0, 3, 1, 0, false);
		djField=this.getDjField();
		djField.setPreferredSize(new Dimension(180,24));
		this.setupComponent(this.getDjField(), 1, 3, 1, 0, false);
		
		
		//库存数量：kcslLabel
		kcslLabel=new JLabel("库存数量：");
		this.setupComponent(kcslLabel, 2, 3, 1, 0, false);
		kcslField=this.getKcslField();
		kcslField.setPreferredSize(new Dimension(150,24));
		this.setupComponent(this.getKcslField(), 3, 3, 1, 0, false);
		
		
		//库存金额标签：kcjeLabel
		kcjeLabel=new JLabel("库存金额：");
		this.setupComponent(kcjeLabel, 0, 4, 1, 0, false);
		kcjeField=this.getKcjeField();
		kcjeField.setPreferredSize(new Dimension(180,24));
		this.setupComponent(this.getKcjeField(), 1, 4, 1, 0, false);
		
		
		//确定按钮：qdButton
		this.setupComponent(this.getQdButton(), 1, 5, 1, 0, false);
		
		//关闭按钮：gbButton
		this.setupComponent(this.getGbButton(), 2, 5, 1, 0, false);
		
		
		
		
	}
	
	
	
	//组件的布局位置方法
	private void setupComponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill)
	{
		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=gridx;
		constraint.gridy=gridy;
		constraint.insets=new Insets(4,6,4,6);
		
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
	
	
	
	
	//初始化商品下拉列表框：spComboBox
	private JComboBox getSpComboBox()
	{
		if(spComboBox==null)
		{
			spComboBox=new JComboBox();
			spComboBox.addItem("--请选择--");
			
			//添加监控器，当选中商品时，同步更新其他选项
			spComboBox.addItemListener(new ItemListener()
					{
				public void itemStateChanged(ItemEvent e)
				{
					Object obj=spComboBox.getSelectedItem();
					if(obj==null || obj.equals("--请选择--"))
					{
						reStore();
						return;
					}
					
					Item item=(Item)obj;
					kucuninfo=Dao.getKucun(item);
					if(kucuninfo.getId()==null)    //当执行SQL语句时，id可以为空字符串""，但不可以为null
					{
						reStore();
						return;
					}
					
					//同步更新其他文本框内容
					Double dj=kucuninfo.getDj();
					Integer kcsl=kucuninfo.getKcsl();
					
					ggField.setText(kucuninfo.getGg());    //规格
					cdField.setText(kucuninfo.getCd());    //产地
					jcField.setText(kucuninfo.getJc());    //简称
					bzField.setText(kucuninfo.getBz());    //包装
					dwField.setText(kucuninfo.getDw());    //单位
					djField.setText(dj + "");    //单价
					kcslField.setText(kcsl + "");    //库存数量
					kcjeField.setText((dj*kcsl) + "");    //库存金额
				}
					});
		}
		return spComboBox;
	}
	
	
	
	
	//当选择到"请选择"项时，重置所有内容为空
	private void reStore()
	{
		this.getGgField().setText("");
		this.getCdField().setText("");
		this.getJcField().setText("");
		this.getBzField().setText("");
		this.getDwField().setText("");
		this.getDjField().setText("");
		this.getKcslField().setText("");
		this.getKcjeField().setText("");
		
	}
	
	
	//规格内容：ggField
	private JLabel getGgField()
	{
		if(ggField==null)
		{
			ggField=new JLabel();
			ggField.setForeground(Color.BLUE);
		}
		return ggField;
	}
	
	
	//产地内容：cdField
	private JLabel getCdField()
	{
		if(cdField==null)
		{
			cdField=new JLabel();
			cdField.setForeground(Color.BLUE);
		}
		return cdField;
	}
	
	
	//简称内容：jcField
	private JLabel getJcField()
	{
		if(jcField==null)
		{
			jcField=new JLabel();
			jcField.setForeground(Color.BLUE);
		}
		return  jcField;
	}
	
	
	//包装内容：bzField
	private JLabel getBzField()
	{
		if(bzField==null)
		{
			bzField=new JLabel();
			bzField.setForeground(Color.BLUE);
		}
		return bzField;
	}
	
	
	//单位内容：dwField
	private JLabel getDwField()
	{
		if(dwField==null)
		{
			dwField=new JLabel();
			dwField.setForeground(Color.BLUE);
		}
		return dwField;
	}
	
	
	//单价文本框：djField
	private JTextField getDjField()
	{
		if(djField==null)
		{
			djField=new JTextField();
			
			//添加监控器，修改单价后，同步更新库存金额
			djField.addKeyListener(new KeyAdapter()
					{
				public void keyTyped(KeyEvent e)
				{
					if(("0123456789." + (char)8).indexOf((int)e.getKeyChar())<0)
					{
						e.consume();
					}
				}
				
				public void keyReleased(KeyEvent e)
				{
					String kcsl_str=kcslField.getText();
					String dj_str=djField.getText();
					
					try
					{
						int kcsl=Integer.parseInt(kcsl_str);
						Double dj=Double.parseDouble(dj_str);
						
						Double kcje=kcsl*dj;
						kcjeField.setText(kcje + "");
					}
					catch(NumberFormatException e1)
					{
						if(e.getKeyChar()!=(char)8)
						{
							JOptionPane.showMessageDialog(JiaGeTiaoZheng_IFrame.this, "请用正确格式修改商品单价");
						}
						return;
					}
				}
					});
			
		}
		return djField;
	}
	
	
	//库存数量文本框：kcslField
	private JTextField getKcslField()
	{
		if(kcslField==null)
		{
			kcslField=new JTextField();
			kcslField.setEditable(false);
		}
		return kcslField;
	}
	
	
	//库存金额文本框：kcjeField
	private JTextField getKcjeField()
	{
		if(kcjeField==null)
		{
			kcjeField=new JTextField();
			kcjeField.setEditable(false);
		}
		return kcjeField;
	}
	
	
	
	//确定按钮：qdButton
	private JButton getQdButton()
	{
		if(qdButton==null)
		{
			qdButton=new JButton("确定");
			
			//添加监控器，更新数据库的库存信息
			qdButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Object obj=spComboBox.getSelectedItem();
					if(obj==null || obj.equals("--请选择--"))
					{
						JOptionPane.showMessageDialog(JiaGeTiaoZheng_IFrame.this, "请选择商品");
						return;
					}
					
					//更新库存信息
					if(kucuninfo!=null || kucuninfo.getId()!=null)
					{
						kucuninfo.setDj(Double.valueOf(djField.getText()));    //重置库存单价
						int rs=Dao.updateKuCunDj(kucuninfo);
						if(rs>0)    //如果修改了多条库存表中的行条目
						{
							JOptionPane.showMessageDialog(JiaGeTiaoZheng_IFrame.this, "价格调整完毕", kucuninfo.getSpname() + "价格调整", JOptionPane.INFORMATION_MESSAGE);
							
						}
					}	
				}
					});
		}
		return qdButton;
	}
	
	
	
	//关闭按钮：gbButton
	private JButton getGbButton()
	{
		if(gbButton==null)
		{
			gbButton=new JButton();
			gbButton.setText("关闭");
			
			//
			gbButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					JiaGeTiaoZheng_IFrame.this.doDefaultCloseAction();
				}
					});
		}
		return gbButton;
	}
}

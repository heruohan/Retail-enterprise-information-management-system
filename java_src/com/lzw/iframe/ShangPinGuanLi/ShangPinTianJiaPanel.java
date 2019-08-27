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
	 * �����
	 */
	private JTextField spnameField=null;    //��Ʒ�����ı���
	private JTextField jcField=null;    //����ı���
	private JTextField cdField=null;    //�����ı���
	private JTextField dwField=null;    //��λ�ı���
	private JTextField ggField=null;    //����ı���
	private JTextField bzField=null;    //��װ�ı���
	private JTextField phField=null;    //�����ı���
	private JTextField pzwhField=null;    //��׼�ĺ��ı���
	private JComboBox gysComboBox=null;    //��Ӧ�������б��
	private JTextField memoField=null;    //��ע�ı���
	
	private JButton tjButton=null;    //��Ӱ�ť
	private JButton resetButton=null;    //���ð�ť
	
	
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
	
	
	//���캯��
	public ShangPinTianJiaPanel()
	{
		init();
	}
	
	
	//��ʼ����Ʒ������
	private void init()
	{
		this.setLayout(new GridBagLayout());
		//this.setBounds(50, 50, 450, 300);
		//this.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		//��Ʒ�����ı���spnameField
		JLabel spnameLabel=new JLabel("��Ʒ���ƣ�");
		this.setupComponent(spnameLabel, 0, 0, 1, 0, false);
		
		spnameField=new JTextField();
		spnameField.setPreferredSize(new Dimension(450,21));
		this.setupComponent(spnameField, 1, 0, 3, 0, true);
		
		
		//����ı���jcField
		JLabel jcLabel=new JLabel("��ƣ�");
		this.setupComponent(jcLabel, 0, 1, 1, 0, false);
		
		jcField=new JTextField();
		this.setupComponent(jcField, 1, 1, 3, 0, true);
		
		
		
		//�����ı���cdField
		JLabel cdLabel=new JLabel("���أ�");
		this.setupComponent(cdLabel, 0, 2, 1, 0, false);
		
		cdField=new JTextField();
		this.setupComponent(cdField, 1, 2, 3, 0, true);
		
		
		//��λ�ı���dwField
		JLabel dwLabel=new JLabel("��λ��");
		this.setupComponent(dwLabel, 0, 3, 1, 0, false);
		
		dwField=new JTextField();
		dwField.setPreferredSize(new Dimension(200,21));
		this.setupComponent(dwField, 1, 3, 1, 0, true);
		
		
		//����ı���ggField
		JLabel ggLabel=new JLabel("���");
		this.setupComponent(ggLabel, 2, 3, 1, 0, false);
		
		ggField=new JTextField();
		this.setupComponent(ggField, 3, 3, 1, 0, true);
		
		
		//��װ�ı���bzField
		JLabel bzLabel=new JLabel("��װ��");
		this.setupComponent(bzLabel, 0, 4, 1, 0, false);
		
		bzField=new JTextField();
		this.setupComponent(bzField, 1, 4, 1, 0, true);
		
		
		//�����ı���phField
		JLabel phLabel=new JLabel("���ţ�");
		this.setupComponent(phLabel, 2, 4, 1, 0, false);
		
		phField=new JTextField();
		this.setupComponent(phField, 3, 4, 1, 0, true);
		
		
		//��׼�ĺ��ı���pzwhField
		JLabel pzwhLabel=new JLabel("��׼�ĺţ�");
		this.setupComponent(pzwhLabel, 0, 5, 1, 0, false);
		
		pzwhField=new JTextField();
		this.setupComponent(pzwhField, 1, 5, 3, 0, true);
		
		//��Ӧ�������б��gysComboBox
		JLabel gysComboBoxLabel=new JLabel("��Ӧ��ȫ�ƣ�");
		this.setupComponent(gysComboBoxLabel, 0, 6, 1, 0, false);
		
		this.setupComponent(this.getGysComboBox(),1, 6, 3, 0, true);
		
		//��ע�ı���memoField
		JLabel memoLabel=new JLabel("��ע��");
		this.setupComponent(memoLabel, 0, 7, 1, 0, false);
		
		memoField=new JTextField();
		
		this.setupComponent(memoField, 1, 7, 3, 0, true);
		
		//��Ӱ�ť��tjButton
		this.setupComponent(this.getTjButton(), 1, 8, 1, 0, false);
		
		//���ð�ť��resetButton
		this.setupComponent(this.getResetButton(), 2, 8, 1, 0, false);
		
		
	}
	
	
	
	//���ָ�������������λ�÷���
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
	
	
	//��Ʒ�����ı���spnameField
	//����ı���jcField
	//�����ı���cdField
	//��λ�ı���dwField
	//����ı���ggField
	//��װ�ı���bzField
	//�����ı���phField
	//��׼�ĺ��ı���pzwhField
	//��Ӧ�������б��gysComboBox
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
	
	//��ע�ı���memoField
	
	//��Ӱ�ť��tjButton
	private JButton getTjButton()
	{
		if(tjButton==null)
		{
			tjButton=new JButton("���");
			
			//��Ӽ����
			tjButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//�ж���Ʒ�����ı����Ƿ�Ϊ�գ���ע����Ϊ��
					if(spnameField.getText().isEmpty() || jcField.getText().isEmpty() || cdField.getText().isEmpty()
					   || dwField.getText().isEmpty() || ggField.getText().isEmpty() || bzField.getText().isEmpty()
					   || phField.getText().isEmpty() || pzwhField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "����дδ�����Ϣ", "��Ʒ���", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					
					//�ж����ݿ����Ƿ����ͬ����Ʒ
					ResultSet rs=Dao.query("select * from tb_spinfo where spname='" + spnameField.getText().trim() + "'");
					
					try
					{
						//������ݿ������ͬ����Ʒ
						if(rs.next())
						{
							JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "��Ʒ��Ϣ���ʧ�ܣ�����ͬ����Ʒ");
							return;
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					
					//�ҳ���Ʒ���ݿ��е����id
					//�˽���ض���һ�����ݣ���ʹ����Ϊnull
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
					
					//��ʼ��TbSpinfo�࣬��������ӵ���Ʒ��Ϣ���ݿ���
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
					JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "��Ʒ��ӳɹ�");
					resetButton.doClick();
					
				}
					});
		}
		return tjButton;
	}
	
	
	//���ð�ť��resetButton
	private JButton getResetButton()
	{
		if(resetButton==null)
		{
			resetButton=new JButton("����");
			
			//��Ӽ����
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
	
	
	
	//���¹�Ӧ�������б��ķ���
	public void updateGysComboBox()
	{
		List gysList=Dao.getGysInfos();
		
		//��������б��
		gysComboBox.removeAllItems();
		
		for(Iterator iter=gysList.iterator();iter.hasNext();)
		{
			List element=(List)iter.next();
			Item item=new Item();
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			
			//����Ӧ�������б�������
			gysComboBox.addItem(item);
		}
		System.out.println("���¹�Ӧ��");
	}

}

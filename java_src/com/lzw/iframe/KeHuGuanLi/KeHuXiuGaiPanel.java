package com.lzw.iframe.KeHuGuanLi;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.*;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;
import com.lzw.iframe.ShangPinGuanLi.ShangPinXiuGaiPanel;

import java.util.Iterator;
import java.util.List;
import java.awt.*;



public class KeHuXiuGaiPanel extends JPanel{
	
	/*
	 * �������
	 */
	private JTextField khnameField=null;    //�ͻ�ȫ��
	private JTextField khdzField=null;    //�ͻ���ַ
	private JTextField khjcField=null;    //�ͻ����
	private JTextField yzbmField=null;    //��������
	private JTextField dhField=null;    //�绰
	private JTextField czField=null;    //����
	private JTextField lxrField=null;    //��ϵ��
	private JTextField lxdhField=null;    //��ϵ�绰
	private JTextField emailField=null;    //��������
	private JTextField khyhField=null;    //��������
	private JTextField yhzhField=null;    //�����˺�
	private JComboBox xzkhComboBox=null;    //ѡ��ͻ������б��
	
	private JButton delButton=null;    //ɾ����ť
	private JButton xgButton=null;    //�޸İ�ť
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(600,400);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JDesktopPane deskpane=new JDesktopPane();
		KeHuXiuGaiPanel inFrame=new KeHuXiuGaiPanel();
		
		
		
		//t.getContentPane().setLayout(null);
		t.getContentPane().add(inFrame);
		//t.pack();
		t.setVisible(true);
	}
	*/
	
	
	//���캯��
	public KeHuXiuGaiPanel()
	{
		init();
	}
	
	
	//��ʼ���ڲ��ͻ��޸���ɾ�����
	private void init()
	{
		this.setLayout(new GridBagLayout());
		
		//�ͻ�ȫ��
		JLabel khnameLabel=new JLabel("�ͻ�ȫ�ƣ�");
		this.setupComponent(khnameLabel, 0, 0, 1, 0, false);
		
		khnameField=new JTextField();
		khnameField.setEditable(false);
		khnameField.setPreferredSize(new Dimension(480,21));
		this.setupComponent(khnameField, 1, 0, 3, 0, true);
		
		
		//�ͻ���ַ
		JLabel khdzLabel=new JLabel("�ͻ���ַ��");
		this.setupComponent(khdzLabel, 0, 1, 1, 0, false);
		
		khdzField=new JTextField();
		this.setupComponent(khdzField, 1, 1, 3, 0, true);
		
		
		//�ͻ����
		JLabel khjcLabel=new JLabel("�ͻ���ƣ�");
		this.setupComponent(khjcLabel, 0, 2, 1, 0, false);
		
		khjcField=new JTextField();
		khjcField.setPreferredSize(new Dimension(200,21));
		this.setupComponent(khjcField, 1, 2, 1, 0, true);
		
		
		//��������
		JLabel yzbmLabel=new JLabel("�������룺");
		this.setupComponent(yzbmLabel, 2, 2, 1, 0, false);
		
		yzbmField=new JTextField();
		this.setupComponent(yzbmField, 3, 2, 1, 0, true);
		
		
		//�绰
		JLabel dhLabel=new JLabel("�绰��");
		this.setupComponent(dhLabel, 0, 3, 1, 0, false);
		
		dhField=new JTextField();
		this.setupComponent(dhField, 1, 3, 1, 0, true);
		
		
		//����
		JLabel czLabel=new JLabel("���棺");
		this.setupComponent(czLabel, 2, 3, 1, 0, false);
		
		czField=new JTextField();
		this.setupComponent(czField, 3, 3, 1, 0, true);
		
		
		//��ϵ��
		JLabel lxrLabel=new JLabel("��ϵ�ˣ�");
		this.setupComponent(lxrLabel, 0, 4, 1, 0, false);
		
		lxrField=new JTextField();
		this.setupComponent(lxrField, 1, 4, 1, 0, true);
		
		
		//��ϵ�绰
		JLabel lxdhLabel=new JLabel("��ϵ�绰��");
		this.setupComponent(lxdhLabel, 2, 4, 1, 0, false);
		
		lxdhField=new JTextField();
		this.setupComponent(lxdhField, 3, 4, 1, 0, true);
		
		
		//Email
		JLabel emailLabel=new JLabel("E-Mail��");
		this.setupComponent(emailLabel, 0, 5, 1, 0, false);
		
		emailField=new JTextField();
		this.setupComponent(emailField, 1, 5, 3, 0, true);
		
		
		//��������
		JLabel khyhLabel=new JLabel("�������У�");
		this.setupComponent(khyhLabel, 0, 6, 1, 0, false);
		
		khyhField=new JTextField();
		this.setupComponent(khyhField, 1, 6, 1, 0, true);
		
		
		//�����˺�
		JLabel yhzhLabel=new JLabel("�����˺ţ�");
		this.setupComponent(yhzhLabel, 2, 6, 1, 0, false);
		
		yhzhField=new JTextField();
		this.setupComponent(yhzhField, 3, 6, 1, 0, true);
		
		//ѡ��ͻ������б��xzkhComboBox
		JLabel xzkhLabel=new JLabel("ѡ��ͻ���");
		this.setupComponent(xzkhLabel, 0, 7, 1, 0, false);
		
		this.setupComponent(this.getXzkhComboBox(), 1, 7, 1, 0, true);
		
		
		
		//���ɾ����ť���޸İ�ť
		JPanel panel=new JPanel();
		FlowLayout layout=new FlowLayout();
		layout.setHgap(24);
		panel.setLayout(layout);
		panel.add(this.getDelButton());
		panel.add(this.getXgButton());
		
		this.setupComponent(panel, 2, 7, 2, 0, true);
		//ɾ����ť��delButton
		//this.setupComponent(this.getDelButton(), 2, 7, 1, 0, false);
		
		//�޸İ�ť��xgButton
		//this.setupComponent(this.getXgButton(), 3, 7, 1, 0, false);
		
		
		
	}
	
	
	//��������ķ�������
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
	
	
	
	//��ʼ��ѡ��ͻ������б��xzkhComboBox
	private JComboBox getXzkhComboBox()
	{
		if(xzkhComboBox==null)
		{
			xzkhComboBox=new JComboBox();
			xzkhComboBox.setMaximumRowCount(5);
			
			//��Ӽ����
			xzkhComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					updateAllField();
				}
					});
			
			
		}
		return xzkhComboBox;
	}
	
	
	//��ʼ��ɾ����ť��delButton
	private JButton getDelButton()
	{
		if(delButton==null)
		{
			delButton=new JButton("ɾ��");
			
			//��Ӽ����
			delButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Item item=(Item)xzkhComboBox.getSelectedItem();
					if(item==null || item.getId()==null || !(item instanceof Item))
					{
						return;
					}
					
					//ɾ���ͻ�
					int res=JOptionPane.showConfirmDialog(KeHuXiuGaiPanel.this, "ȷ��ɾ���ͻ���", "�ͻ���Ϣɾ��", JOptionPane.YES_NO_CANCEL_OPTION);
					if(res==JOptionPane.YES_OPTION)
					{
						int re=Dao.delete("delete from tb_khinfo where id='" + item.getId() + "'");
						if(re>0)
						{
							JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "�ͻ�ɾ���ɹ�");
							xzkhComboBox.removeItem(item);
						}
					}
					
				}
					});
		}
		return delButton;
	}
	
	
	
	//��ʼ���޸İ�ť��xgButton
	private JButton getXgButton()
	{
		if(xgButton==null)
		{
			xgButton=new JButton("�޸�");
			
			//��Ӽ����
			xgButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Object obj=xzkhComboBox.getSelectedItem();
					Item item=null;
					if(obj==null || !(obj instanceof Item) || (item=(Item)obj).getId()==null)
					{
						JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "����ȷ��д�ͻ�");
						return;
					}
					
					//����TbKhinfo
					TbKhinfo khinfo=new TbKhinfo();
					khinfo.setId(item.getId());
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
					
					if(Dao.updateKeHu(khinfo)==1)
					{
						JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "�ͻ���Ϣ�޸ĳɹ�");
						
					}
					else
					{
						JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "�ͻ���Ϣ�޸�ʧ��");
					}
					
				}
					});
		}
		return xgButton;
	}
	
	
	
	//��ѡ��ͻ��󣬸������е��ı���
	private void updateAllField()
	{
		Object obj=xzkhComboBox.getSelectedItem();
		
		if(obj==null || !(obj instanceof Item))
		{
			return;
		}
		
		Item item=(Item)obj;
		TbKhinfo khinfo=Dao.getKhInfo(item);
		if(khinfo.getId()!=null && !khinfo.getId().isEmpty())
		{
			khnameField.setText(khinfo.getKhname());
			khdzField.setText(khinfo.getAddress());
			khjcField.setText(khinfo.getJian());
			yzbmField.setText(khinfo.getBianma());
			dhField.setText(khinfo.getTel());
			czField.setText(khinfo.getFax());
			lxrField.setText(khinfo.getLian());
			lxdhField.setText(khinfo.getLtel());
			emailField.setText(khinfo.getMail());
			khyhField.setText(khinfo.getXinhang());
			yhzhField.setText(khinfo.getHao());
			
		}
	}
	
	
	//��ʼ���ͻ�ѡ�������б��
	public void initKhComboBox()
	{
		List lst=Dao.getKhInfos();
		
		//ɾ��������
		xzkhComboBox.removeAllItems();
		
		for(Iterator iter=lst.iterator();iter.hasNext();)
		{
			List tmp=(List)iter.next();
			Item item=new Item();
			item.setId(tmp.get(0).toString().trim());
			item.setName(tmp.get(1).toString().trim());
			xzkhComboBox.addItem(item);
		}
		
		updateAllField();
	}

}

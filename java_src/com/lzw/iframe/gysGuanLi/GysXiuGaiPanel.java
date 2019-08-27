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
	 * ���������
	 */
	private JTextField gysnameField=null;    //��Ӧ��ȫ��
	private JTextField jcField=null;    //���
	private JTextField yzbmField=null;    //��������
	private JTextField dzField=null;    //��ַ
	private JTextField dhField=null;    //�绰
	private JTextField czField=null;    //����
	private JTextField lxrField=null;    //��ϵ��
	private JTextField lxrdhField=null;    //��ϵ�˵绰
	private JTextField khyhField=null;    //��������
	private JTextField dzxxField=null;    //��������
	
	private JComboBox xzgysComboBox=null;    //ѡ��Ӧ�������б��
	private JButton xgButton=null;    //�޸İ�ť
	private JButton delButton=null;    //ɾ����ť
	
	
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
	
	
	//���캯��
	public GysXiuGaiPanel()
	{
		init();
	}
	
	
	//��ʼ����Ӧ���޸���ɾ�����
	private void init()
	{
		this.setLayout(new GridBagLayout());
		
		//��Ӧ��ȫ��
		JLabel gysnameLabel=new JLabel("��Ӧ��ȫ�ƣ�");
		this.setupComponent(gysnameLabel, 0, 0, 1, 0, false);
		
		gysnameField=new JTextField();
		gysnameField.setEditable(false);
		gysnameField.setPreferredSize(new Dimension(490,24));
		this.setupComponent(gysnameField, 1, 0, 3, 0, true);
		
		
		//���
		JLabel jcLabel=new JLabel("��ƣ�");
		this.setupComponent(jcLabel, 0, 1, 1, 0, false);
		
		jcField=new JTextField();
		jcField.setPreferredSize(new Dimension(210,24));
		this.setupComponent(jcField, 1, 1, 1, 0, true);
		
		
		//��������
		JLabel yzbmLabel=new JLabel("�������룺");
		this.setupComponent(yzbmLabel, 2, 1, 1, 0, false);
		
		yzbmField=new JTextField();
		this.setupComponent(yzbmField, 3, 1, 1, 0, true);
		
		//��ַ
		JLabel dzLabel=new JLabel("��ַ��");
		this.setupComponent(dzLabel, 0, 2, 1, 0, false);
		
		dzField=new JTextField();
		this.setupComponent(dzField, 1, 2, 3, 0, true);
		
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
		
		
		//��ϵ�˵绰
		JLabel lxrdhLabel=new JLabel("��ϵ�˵绰��");
		this.setupComponent(lxrdhLabel, 2, 4, 1, 0, false);
		
		lxrdhField=new JTextField();
		this.setupComponent(lxrdhField, 3, 4, 1, 0, true);
		
		
		//��������
		JLabel khyhLabel=new JLabel("�������У�");
		this.setupComponent(khyhLabel, 0, 5, 1, 0, false);
		
		khyhField=new JTextField();
		this.setupComponent(khyhField, 1, 5, 1, 0, true);
		
		
		//��������
		JLabel dzxxLabel=new JLabel("�������䣺");
		this.setupComponent(dzxxLabel, 2, 5, 1, 0, false);
		
		dzxxField=new JTextField();
		this.setupComponent(dzxxField, 3, 5, 1, 0, true);
		
		
		//ѡ��Ӧ�������б��xzgysComboBox
		JLabel xzgysLabel=new JLabel("ѡ��Ӧ�̣�");
		this.setupComponent(xzgysLabel, 0, 6, 1, 0, false);
		
		this.setupComponent(this.getXzgysComboBox(), 1, 6, 2, 0, true);
		
		
		//�޸ĺ�ɾ����ť
		JPanel panel=new JPanel();
		FlowLayout layout=new FlowLayout();
		//layout.setHgap(60);
		panel.add(this.getXgButton());
		panel.add(this.getDelButton());
		this.setupComponent(panel, 3, 6, 1, 0, true);
	}
	
	
	
	//��������ķ���
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
	
	
	
	//��ʼ��ѡ��Ӧ�������б��xzgysComboBox
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
					Object obj=xzgysComboBox.getSelectedItem();
					if(obj==null || !(obj instanceof Item))
					{
						JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "����ȷ��д��Ӧ��");
						return;
					}
					
					Item item=(Item)obj;
					//����TbGysinfo
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
						JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "��Ϣ�޸ĳɹ�");
					}
					else
					{
						JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "��Ϣ�޸�ʧ��");
					}
					
				}
					});
		}
		return xgButton;
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
					Object obj=xzgysComboBox.getSelectedItem();
					Item item=null;
					if(obj==null || !(obj instanceof Item) || (item=(Item)obj).getId()==null)
					{
						return;
					}
					
					
					int res=JOptionPane.showConfirmDialog(GysXiuGaiPanel.this, "ȷ��ɾ���˹�Ӧ����", "��Ϣɾ�����޸�", JOptionPane.YES_NO_CANCEL_OPTION);
					if(res==JOptionPane.YES_OPTION)
					{
						int rs=Dao.delete("delete from tb_gysinfo where id='" + item.getId() + "'");
						if(rs>0)
						{
							JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "��Ϣɾ���ɹ�");
							xzgysComboBox.removeItem(item);
						}
					}
				}
					});
		}
		return delButton;
	}
	
	
	
	//��ʼ��ѡ��Ӧ�������б��ķ���
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
	
	
	//��ѡ���˹�Ӧ�̺󣬸��������ı���ķ���
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

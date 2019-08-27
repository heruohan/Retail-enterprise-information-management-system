package com.lzw.iframe;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.util.*;
import java.util.Date;
import java.util.List;
import com.lzw.dao.*;
import com.lzw.*;
import com.lzw.dao.model.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.ResultSet;
import java.beans.*;



public class JinHuoDan_IFrame extends JInternalFrame{
	/*
	 * ��ʼ���������ڲ�����ĸ���������ԣ�
	 * 1�����ȴ����������������������jContentPane,���������3������壬�ֱ�Ϊ��
	 * �������topPanel,�ײ����bottomPanel,�Լ����ñ��ģ��JTable�����
	 * 2��Ȼ����3�����������Ӹ����������
	 */
	
	//�������:jContentPane
	private JPanel jContentPane=null;
	
	
	/*
	 * ������壺topPanel�����������
	 */
	private JPanel topPanel=null;    //�������
	
	private JLabel idLabel=null;    //����Ʊ�ű�ǩ
	private JTextField idField=null;    //����Ʊ���ı���
	
	private JLabel gysLabel=null;    //��Ӧ�̱�ǩ
	private JComboBox gysComboBox=null;    //��Ӧ�������б��
	
	private JLabel lxrLabel=null;    //��ϵ�˱�ǩ
	private JTextField lxrField=null;    //��ϵ���ı���
	
	private JLabel jsfsLabel=null;    //���㷽ʽ��ǩ
	private JComboBox jsfsComboBox=null;    //���㷽ʽ�����б��
	
	private JLabel jhsjLabel=null;    //����ʱ���ǩ
	private JTextField jhsjField=null;    //����ʱ���ı���
	
	private JLabel jsrLabel=null;    //�����˱�ǩ
	private JComboBox jsrComboBox=null;    //�����������б��
	
	//��ǰʱ��
	private Date date=new Date();
	
	
	/*
	 * �ײ���壺bottomPanel,���������
	 */
	private JPanel bottomPanel=null;    //�ײ����
	
	private JLabel pzslLabel=null;    //Ʒ��������ǩ
	private JTextField pzslField=null;    //Ʒ�������ı���
	
	private JLabel hpzsLabel=null;    //��Ʒ������ǩ
	private JTextField hpzsField=null;    //��Ʒ�����ı���
	
	private JLabel hjjeLabel=null;    //�ϼƽ���ǩ
	private JTextField hjjeField=null;    //�ϼƽ���ı���
	
	private JLabel ysjlLabel=null;    //���ս��۱�ǩ
	private JTextField ysjlField=null;    //���ս����ı���
	
	private JLabel czyLabel=null;    //����Ա��ǩ
	private JTextField czyField=null;    //����Ա�ı���
	
	private JButton tjButton=null;    //��Ӱ�ť
	private JButton rukuButton=null;    //��ⰴť
	
	
	/*
	 * ���ģ�ͣ�JTable�����������
	 */
	private JTable table=null;    //���ģ��
	private JScrollPane tablePane=null;    //���ñ��Ĺ������
	private JComboBox spComboBox=null;    //��Ʒ���������б��
	
	
	
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		JinHuoDan_IFrame inFrame=new JinHuoDan_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	
	
	//���캯��
	public JinHuoDan_IFrame()
	{
		init();
	}
	
	//��ʼ���ڲ�����
	private void init()
	{
		this.setSize(600, 320);    //�ڲ�����Ĵ�С
		this.setIconifiable(true);    //�ڲ������Ƿ���Ա���С��
		this.setResizable(true);    //�ڲ������Ƿ���Ե�����С
		this.setMaximizable(true);    //�ڲ������Ƿ�������
		this.setTitle("������");    //�����ڲ�����ı���
		this.setClosable(true);    //�ڲ������Ƿ�������
		this.setContentPane(this.getJContentPane());    //����������
		
	}
	
	//��ʼ��������壺jContentPane
	private JPanel getJContentPane()
	{
		//���3�������
		if(jContentPane==null)
		{
			jContentPane=new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(this.getTopPanel(),BorderLayout.NORTH);
			jContentPane.add(this.getTablePane());
			jContentPane.add(this.getBottomPanel(),BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	
	
	
	//�÷�������ֹͣ���Ԫ�ı༭
	private void stopTableCellEditing()
	{
		TableCellEditor cellEditor=table.getCellEditor();
		if(cellEditor!=null)
		{
			cellEditor.stopCellEditing();
		}
	}
	
	
	/*
	 * ��ʼ��������壺topPanel�����������
	 */
	//������壺topPanel
	private JPanel getTopPanel()
	{
		if(topPanel==null)
		{
			//����Ʊ�ű�ǩ��idLabel
			idLabel=new JLabel("����Ʊ�ţ�");
			GridBagConstraints constraint_id1=new GridBagConstraints();
			constraint_id1.gridx=0;
			constraint_id1.gridy=0;
			constraint_id1.weightx=1.0;
			constraint_id1.weighty=1.0;
			
			
			idField=this.getIdField();
			idField.setPreferredSize(new Dimension(100,21));
			GridBagConstraints constraint_id2=new GridBagConstraints();
			constraint_id2.gridx=1;
			constraint_id2.gridy=0;
			constraint_id2.weightx=1.0;
			constraint_id2.fill=GridBagConstraints.HORIZONTAL;
			
			
			
			
			
			//��Ӧ�̱�ǩ��gysLabel
			gysLabel=new JLabel("��Ӧ�̣�");
			GridBagConstraints constraint_gys1=new GridBagConstraints();
			constraint_gys1.gridx=2;
			constraint_gys1.gridy=0;
			constraint_gys1.insets=new Insets(0,1,0,0);
			constraint_gys1.weightx=1.0;
			
			
			GridBagConstraints constraint_gys2=new GridBagConstraints();
			gysComboBox=this.getGysComboBox();
			gysComboBox.setPreferredSize(new Dimension(160,21));
			constraint_gys2.gridx=3;
			constraint_gys2.gridy=0;
			constraint_gys2.insets=new Insets(0,0,0,1);
			constraint_gys2.weightx=1.0;
			constraint_gys2.fill=GridBagConstraints.HORIZONTAL;
			
			
			//��ϵ�˱�ǩ��lxrLabel
			lxrLabel=new JLabel("��ϵ�ˣ�");
			GridBagConstraints constraint_lxr1=new GridBagConstraints();
			constraint_lxr1.gridx=4;
			constraint_lxr1.gridy=0;
			constraint_lxr1.insets=new Insets(0,1,0,0);
			constraint_lxr1.weightx=1.0;
			
			lxrField=this.getLxrField();
			lxrField.setPreferredSize(new Dimension(80,21));
			GridBagConstraints constraint_lxr2=new GridBagConstraints();
			constraint_lxr2.gridx=5;
			constraint_lxr2.gridy=0;
			constraint_lxr2.weightx=1.0;
			constraint_lxr2.fill=GridBagConstraints.HORIZONTAL;
			
			
			//���㷽ʽ��ǩ��jsfsLabel
			jsfsLabel=new JLabel("���㷽ʽ��");
			GridBagConstraints constraint_jsfs1=new GridBagConstraints();
			constraint_jsfs1.gridx=0;
			constraint_jsfs1.gridy=1;
			constraint_jsfs1.weighty=1.0;
			
			GridBagConstraints constraint_jsfs2=new GridBagConstraints();
			constraint_jsfs2.gridx=1;
			constraint_jsfs2.gridy=1;
			constraint_jsfs2.insets=new Insets(0,0,0,1);
			constraint_jsfs2.fill=GridBagConstraints.HORIZONTAL;
			
			
			//����ʱ���ǩ��jhsjLabel
			jhsjLabel=new JLabel("����ʱ�䣺");
			GridBagConstraints constraints_jhsj1=new GridBagConstraints();
			constraints_jhsj1.gridx=2;
			constraints_jhsj1.gridy=1;
			constraints_jhsj1.insets=new Insets(0,1,0,0);
			
			GridBagConstraints constraint_jhsj2=new GridBagConstraints();
			constraint_jhsj2.gridx=3;
			constraint_jhsj2.gridy=1;
			constraint_jhsj2.insets=new Insets(0,0,0,1);
			constraint_jhsj2.fill=GridBagConstraints.HORIZONTAL;
			
			
			
			//�����˱�ǩ��jsrLabel
			jsrLabel=new JLabel("�����ˣ�");
			GridBagConstraints constraint_jsr1=new GridBagConstraints();
			constraint_jsr1.gridx=4;
			constraint_jsr1.gridy=1;
			constraint_jsr1.insets=new Insets(0,1,0,0);
			
			GridBagConstraints constraint_jsr2=new GridBagConstraints();
			constraint_jsr2.gridx=5;
			constraint_jsr2.gridy=1;
			constraint_jsr2.fill=GridBagConstraints.BOTH;
			
			
			//��ʼ��������壬����������
			topPanel=new JPanel();
			topPanel.setLayout(new GridBagLayout());
			//����Ʊ��
			topPanel.add(idLabel, constraint_id1);
			topPanel.add(this.getIdField(),constraint_id2);
			
			//��Ӧ��
			topPanel.add(gysLabel, constraint_gys1);
			topPanel.add(this.getGysComboBox(), constraint_gys2);
			
			//��ϵ��
			topPanel.add(lxrLabel, constraint_lxr1);
			topPanel.add(this.getLxrField(), constraint_lxr2);
			
			//���㷽ʽ
			topPanel.add(jsfsLabel, constraint_jsfs1);
			topPanel.add(this.getJsfsComboBox(), constraint_jsfs2);
			
			//����ʱ��
			topPanel.add(jhsjLabel, constraints_jhsj1);
			topPanel.add(this.getJhsjField(), constraint_jhsj2);
			
			//������
			topPanel.add(jsrLabel, constraint_jsr1);
			topPanel.add(this.getJsrComboBox(), constraint_jsr2);	
		}
		return topPanel;
	}
	
	//����Ʊ�ű�ǩ��idLabel
	//����Ʊ���ı���idField
	private JTextField getIdField()
	{
		if(idField==null)
		{
			idField=new JTextField();
			idField.setEditable(false);
		}
		return idField;
	}
	
	//��Ӧ�̱�ǩ��gysLabel
	//��Ӧ�������б��gysComboBox
	private JComboBox getGysComboBox()
	{
		if(gysComboBox==null)
		{
			gysComboBox=new JComboBox();
			List gysinfos=Dao.getGysInfos();    //�Զ�ά�������ʽ���ش�ʱ���ݿ������еĹ�Ӧ��
			for(Iterator iter=gysinfos.iterator();iter.hasNext();)
			{
				List tmp=(List)iter.next();
				Item item=new Item();
				item.setId(tmp.get(0).toString().trim());
				item.setName(tmp.get(1).toString().trim());
				gysComboBox.addItem(item);
			}
			
			//Item item=(Item)gysComboBox.getSelectedItem();
			//TbGysinfo info=Dao.getGysinfo(item);
			//lxrField.setText(info.getLian());
			
			//��Ӽ����
			gysComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Item item=(Item)gysComboBox.getSelectedItem();
					TbGysinfo info=Dao.getGysinfo(item);
					lxrField.setText(info.getLian());
				}
					});
		}
		return gysComboBox;
	}
	
	
	//��ϵ�˱�ǩ��lxrLabel
	//��ϵ���ı���lxrField
	private JTextField getLxrField()
	{
		if(lxrField==null)
		{
			lxrField=new JTextField();
		}
		return lxrField;
	}
	
	//���㷽ʽ��ǩ��jsfsLabel
	//���㷽ʽ�����б��jsfsComboBox
	private JComboBox getJsfsComboBox()
	{
		if(jsfsComboBox==null)
		{
			jsfsComboBox=new JComboBox();
			jsfsComboBox.addItem("�ֽ����");
			jsfsComboBox.addItem("֧Ʊ����");
		}
		return jsfsComboBox;
	}
	
	
	//����ʱ���ǩ��jhsjLabel
	//����ʱ���ı���jhsjField
	private JTextField getJhsjField()
	{
		if(jhsjField==null)
		{
			jhsjField=new JTextField();
		}
		return jhsjField;
	}
	
	//�����˱�ǩ��jsrLabel
	//�����������б��jsrComboBox
	private JComboBox getJsrComboBox()
	{
		if(jsrComboBox==null)
		{
			jsrComboBox=new JComboBox();
			List<List> jsrList=Dao.getJsrs();
			for(List<String> list : jsrList)
			{
				Item item=new Item();
				item.setId(list.get(0).trim());
				item.setName(list.get(1).trim());
				jsrComboBox.addItem(item);
			}
		}
		return jsrComboBox;
	}
	
	
	
	/*
	 * ��ʼ���ײ���壺bottomPanel,���������
	 */
	
	//�ײ���壺bottomPanel
	private JPanel getBottomPanel()
	{
		if(bottomPanel==null)
		{
			pzslLabel=new JLabel("Ʒ��������");    //Ʒ��������ǩ
			GridBagConstraints constraint_pzsl1=new GridBagConstraints();
			constraint_pzsl1.gridx=0;
			constraint_pzsl1.gridy=0;
			constraint_pzsl1.weightx=1.0;
			constraint_pzsl1.weighty=1.0;
			
			pzslField=this.getPzslField();
			pzslField.setPreferredSize(new Dimension(100,21));
			GridBagConstraints constraint_pzsl2=new GridBagConstraints();
			constraint_pzsl2.gridx=1;
			constraint_pzsl2.gridy=0;
			constraint_pzsl2.weightx=1.0;
			constraint_pzsl2.fill=GridBagConstraints.HORIZONTAL;
			
			
			hpzsLabel=new JLabel("��Ʒ������");    //��Ʒ������ǩ
			GridBagConstraints constraint_hpzs1=new GridBagConstraints();
			constraint_hpzs1.gridx=2;
			constraint_hpzs1.gridy=0;
			constraint_hpzs1.weightx=1.0;
			
			
			hpzsField=this.getHpzsField();
			hpzsField.setPreferredSize(new Dimension(160,21));
			GridBagConstraints constraint_hpzs2=new GridBagConstraints();
			constraint_hpzs2.gridx=3;
			constraint_hpzs2.gridy=0;
			constraint_hpzs2.weightx=1.0;
			constraint_hpzs2.fill=GridBagConstraints.HORIZONTAL;
			
			
			hjjeLabel=new JLabel("�ϼƽ�");    //�ϼƽ���ǩ
			GridBagConstraints constraint_hjje1=new GridBagConstraints();
			constraint_hjje1.gridx=4;
			constraint_hjje1.gridy=0;
			constraint_hjje1.weightx=1.0;
			
			hjjeField=this.getHjjeField();
			hjjeField.setPreferredSize(new Dimension(80,21));
			GridBagConstraints constraint_hjje2=new GridBagConstraints();
			constraint_hjje2.gridx=5;
			constraint_hjje2.gridy=0;
			constraint_hjje2.gridwidth=4;
			constraint_hjje2.weightx=1.0;
			constraint_hjje2.fill=GridBagConstraints.HORIZONTAL;
			
			
			ysjlLabel=new JLabel("���ս��ۣ�");    //���ս��۱�ǩ
			GridBagConstraints constraint_ysjl1=new GridBagConstraints();
			constraint_ysjl1.gridx=0;
			constraint_ysjl1.gridy=1;
			constraint_ysjl1.weighty=1.0;
			
			
			GridBagConstraints constraint_ysjl2=new GridBagConstraints();
			constraint_ysjl2.gridx=1;
			constraint_ysjl2.gridy=1;
			constraint_ysjl2.fill=GridBagConstraints.HORIZONTAL;
			
			
			
			czyLabel=new JLabel("����Ա��");    //����Ա��ǩ
			GridBagConstraints constraint_czy1=new GridBagConstraints();
			constraint_czy1.gridx=2;
			constraint_czy1.gridy=1;
			
			GridBagConstraints constraint_czy2=new GridBagConstraints();
			constraint_czy2.gridx=3;
			constraint_czy2.gridy=1;
			constraint_czy2.fill=GridBagConstraints.HORIZONTAL;
			
			
			//��Ӱ�ť
			GridBagConstraints constraint_tjButton=new GridBagConstraints();
			constraint_tjButton.gridx=7;
			constraint_tjButton.gridy=1;
			constraint_tjButton.insets=new Insets(0,0,0,5);
			
			//��ⰴť
			GridBagConstraints constraint_rkButton=new GridBagConstraints();
			constraint_rkButton.gridx=8;
			constraint_rkButton.gridy=1;
			constraint_rkButton.insets=new Insets(0,5,0,0);
			
			//ռλ����
			
			
			//��ʼ���ײ����
			bottomPanel=new JPanel();
			bottomPanel.setLayout(new GridBagLayout());
			bottomPanel.add(pzslLabel, constraint_pzsl1);
			bottomPanel.add(this.getPzslField(), constraint_pzsl2);
			
			bottomPanel.add(hpzsLabel, constraint_hpzs1);
			bottomPanel.add(this.getHpzsField(), constraint_hpzs2);
			
			bottomPanel.add(hjjeLabel, constraint_hjje1);
			bottomPanel.add(this.getHjjeField(), constraint_hjje2);
			
			bottomPanel.add(ysjlLabel, constraint_ysjl1);
			bottomPanel.add(this.getYsjlField(), constraint_ysjl2);
			
			bottomPanel.add(czyLabel, constraint_czy1);
			bottomPanel.add(this.getCzyField(), constraint_czy2);
			
			bottomPanel.add(this.getTjButton(), constraint_tjButton);
			bottomPanel.add(this.getRukuButton(), constraint_rkButton);
		}
		return bottomPanel;
	}
	
	
	
	//Ʒ��������ǩ��pzslLabel
	//Ʒ�������ı���pzslField
	private JTextField getPzslField()
	{
		if(pzslField==null)
		{
			pzslField=new JTextField();
			pzslField.setEditable(false);
		}
		return pzslField;
	}
	
	//��Ʒ������ǩ��hpzsLabel
	//��Ʒ�����ı���hpzsField
	private JTextField getHpzsField()
	{
		if(hpzsField==null)
		{
			hpzsField=new JTextField();
			hpzsField.setEditable(false);
		}
		return hpzsField;
	}
	
	//�ϼƽ���ǩ��hjjeLabel
	//�ϼƽ���ı���hjjeField
	private JTextField getHjjeField()
	{
		if(hjjeField==null)
		{
			hjjeField=new JTextField();
			hjjeField.setEditable(false);
		}
		return hjjeField;
	}
	
	//���ս��۱�ǩ��ysjlLabel
	//���ս����ı���ysjlField
	private JTextField getYsjlField()
	{
		if(ysjlField==null)
		{
			ysjlField=new JTextField();
		}
		return ysjlField;
	}
	
	//����Ա��ǩ��czyLabel
	//����Ա�ı���czyField
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
	
	//��Ӱ�ť:tjButton
	private JButton getTjButton()
	{
		if(tjButton==null)
		{
			tjButton=new JButton("���");
			tjButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					java.sql.Date sql_date=new java.sql.Date(date.getTime());
					jhsjField.setText(sql_date.toString());    //�����ʽ��Ϊyyyy-mm-dd
					String maxId=Dao.getRuKuMainMaxId(sql_date);    //��ȡ��������ID
					idField.setText(maxId);
					
					//
					for(int i=0;i<table.getRowCount();i++)
					{
						if(table.getValueAt(i, 0)==null)
							return;
					}
					
					
					/*
					 * ���ͬһ������Ҫ��ͬ�Ĺ�Ӧ������
					 * �����������������е�ʱ���ж��Ƿ���ǰһ����Ӧ����ͬ
					 */
						
					DefaultTableModel tablemodel=(DefaultTableModel)table.getModel();
					tablemodel.addRow(new Object[] {});
				}
					});
		}
		return tjButton;
	}
	
	
	
	//��ⰴť��rukuButton
	private JButton getRukuButton()
	{
		if(rukuButton==null)
		{
			rukuButton=new JButton();
			rukuButton.setText("���");
			rukuButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					stopTableCellEditing();    //���������û�б�д�ĵ�Ԫ
					//�г���������еĸ�������
					String rkID=idField.getText();    //�����
					String pzs=pzslField.getText();    //Ʒ����
					String je=hjjeField.getText();    //���
					String ysjl=ysjlField.getText().trim();    //���ս���
					//String gysname=(String)gysComboBox.getSelectedItem();    //��Ӧ��
					String rkDate=jhsjField.getText();    //����ʱ��
					String czy=czyField.getText();    //����Ա
					String jsr=(String)jsrComboBox.getSelectedItem();    //������
					String jsfs=(String)jsfsComboBox.getSelectedItem();    //���㷽ʽ
					
					if(jsr==null || jsr.isEmpty())
					{
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "����д������");
						return;
					}
					
					if(ysjl==null || ysjl.isEmpty())
					{
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "����д���ս���");
						return;
					}
					
					if(table.getRowCount()<=0)
					{
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "����������Ʒ");
						return;
					}
					
					
					/*
					 * ���ʱ���жϱ���е�������Ʒ�Ƿ�����ͬһ����Ӧ���ṩ
					 */
					TbSpinfo sp=(TbSpinfo)table.getValueAt(0, 0);
					String gysname=sp.getGysname();
					for(int i=0;i<table.getRowCount();i++)
					{
						TbSpinfo tmp=(TbSpinfo)table.getValueAt(i, 0);
						if(tmp!=null && tmp.getGysname()!=null)
						{
							if(!gysname.equals(tmp.getGysname()))
							{
								JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "����д��ڲ�����ͬһ��Ӧ�̵���Ʒ�����޸�");
								return;
							}
						}
					}
					
					
					
					//�������������
					TbRukuMain rukuMain=new TbRukuMain(rkID,pzs,je,ysjl,gysname,rkDate,czy,jsr,jsfs);
					Set<TbRukuDetail> details=rukuMain.getTabRukuDetails();
					
					int row=table.getRowCount();
					for(int i=0;i<row;i++)
					{
						TbSpinfo Spinfo=(TbSpinfo)table.getValueAt(i, 0);    //��Ʒ��
						if(Spinfo==null || Spinfo.getId()==null || Spinfo.getId().isEmpty())
						{
							continue;
						}
						
						TbRukuDetail detail=new TbRukuDetail();    //�����ϸ��
						String djStr=(String)table.getValueAt(i, 6);    //����
						String slStr=(String)table.getValueAt(i, 7);    //����
						Double dj=Double.valueOf(djStr);
						Integer sl=Integer.valueOf(slStr);
						
						detail.setTbRukuMain(rkID);
						detail.setDj(dj);
						detail.setSl(sl);
						detail.setTbSpinfo(Spinfo.getId());
						details.add(detail);    //�������ϸ������б�
					}
					
					boolean re=Dao.insertRuKuInfo(rukuMain);    //���������е���Ϣ�������ݿ�
					if(re)
					{
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "���ɹ�");
						//��ձ���е�����
						
						/*
						 * ���󣺣�1������������б�Ҳ�Ƴ��ˣ��޸��磨2��
						 */
						/*
						 * ��1��
						DefaultTableModel tablemodel=new DefaultTableModel();
						table.setModel(tablemodel);
						*/
						
						//��2��
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
		return rukuButton;
	}
	//
	
	
	
	/*
	 * ���ģ�ͣ�JTable�����������
	 */
	//������壺tablePane
	private JScrollPane getTablePane()
	{
		if(tablePane==null)
		{
			tablePane=new JScrollPane();
			tablePane.setViewportView(this.getTable());
			
		}
		return tablePane;
	}
	
	//���table
	private JTable getTable()
	{
		if(table==null)
		{
			
			String[] columnName= {"��Ʒ����","��Ʒ���","����","��λ","���","��װ","����","����","����", "��׼�ĺ�"};
			table=new JTable();
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			table.setShowGrid(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    //�ر��Զ���������ʹ�ù�����ʱ
			
			
			
			
			
			//�������
			DefaultTableModel tablemodel=(DefaultTableModel)table.getModel();
			tablemodel.setColumnIdentifiers(columnName);
			
			
			
			//���쵥Ԫ�ı༭��
			DefaultCellEditor editor=new DefaultCellEditor(this.getSpComboBox());
			TableColumn spcolumn=table.getColumnModel().getColumn(0);
			spcolumn.setCellEditor(editor);
			
			/*
			 * ����Ʒ������������ActionEvent��ItemEvent�¼���ʱ�򣬱�񶼻������˼����������Ǳ��Ϊ��
			 */
			table.addPropertyChangeListener(new PropertyChangeListener()
			{
				public void propertyChange(PropertyChangeEvent e)
				{
					if(e.getPropertyName().equals("tableCellEditor"))
					{
						computeInfos();
					}
				}
				});
		}
		return table;
	}
	
	
	/*
	 * 1������һ������е���Ʒ��Ϣ������Ҫ��ͬһ����Ӧ��
	 * 2���������д��ڵ��۵���ͬ����Ʒ����ԭ����Ʒ�Ͻ��������޸�
	 */
	
	
	//��Ʒ���Ƶ������б��spComboBox
	private JComboBox getSpComboBox()
	{
		if(spComboBox==null)
		{
			spComboBox=new JComboBox();
			//spComboBox.addItem(new TbSpinfo());
			spComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					
					ResultSet rs=Dao.query("select * from tb_spinfo where gysname=" + "'" + gysComboBox.getSelectedItem() +"'");
					updateSpComboBox(rs);
				}
					});
			
			spComboBox.addItemListener(new ItemListener()
					{
				public void itemStateChanged(ItemEvent e)
				{
					TbSpinfo spinfo=(TbSpinfo)spComboBox.getSelectedItem();
					
					//�ж��Ƿ��ڱ���Ѿ����ڴ���Ʒ��
					int rows=table.getRowCount();
					List<String> lst=new ArrayList<>();
					if(rows>1)
					{
						for(int i=0;i<rows-1;i++)
						{
							TbSpinfo info=(TbSpinfo)table.getValueAt(i, 0);
							if(info!=null && info.getId()!=null)
							{
								lst.add(info.getId());
							}
						}
						
						if(lst.contains(spinfo.getId()))
								{
							JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "�˱����Ѿ���������Ʒ");
							return;
								}
					}
					
					
					if(spinfo!=null && spinfo.getId()!=null)
					{
						
						updateTable();
					}
				}
					});
		}
		return spComboBox;
	}
	
	
	//������Ʒ�����б��ķ���
	private void updateSpComboBox(ResultSet rs)
	{
		try
		{
		while(rs.next())
		{
			//��ʼ����Ʒ��Ϣ��
			TbSpinfo spinfo=new TbSpinfo();
			spinfo.setId(rs.getString("id").trim());
			spinfo.setSpname(rs.getString("spname").trim());
			spinfo.setJc(rs.getString("jc").trim());
			spinfo.setCd(rs.getString("cd").trim());
			spinfo.setDw(rs.getString("dw").trim());
			spinfo.setGg(rs.getString("gg").trim());
			spinfo.setBz(rs.getString("bz").trim());
			spinfo.setPh(rs.getString("ph").trim());
			spinfo.setPzwh(rs.getString("pzwh").trim());
			spinfo.setMemo(rs.getString("meno").trim());
			spinfo.setGysname(rs.getString("gysname").trim());
			
			DefaultComboBoxModel model=(DefaultComboBoxModel)spComboBox.getModel();
			if(model.getIndexOf(spinfo)<0)
			{
				spComboBox.addItem(spinfo);    //��Ϊ�����е������б��ʱͬһ������ֹ�����б�����ظ���
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	//������Ʒ�����б���е�ѡ������±��
	private synchronized void updateTable()
	{
		TbSpinfo spinfo=(TbSpinfo)spComboBox.getSelectedItem();
		int row=table.getSelectedRow();
		if(row>=0 && spinfo!=null)
		{
			table.setValueAt(spinfo.getId(), row, 1);
			table.setValueAt(spinfo.getCd(), row, 2);
			table.setValueAt(spinfo.getDw(), row, 3);
			table.setValueAt(spinfo.getGg(), row, 4);
			table.setValueAt(spinfo.getBz(), row, 5);
			table.setValueAt("0", row, 6);    //����
			table.setValueAt("0", row, 7);    //����
			table.setValueAt(spinfo.getPh(), row, 8);
			table.setValueAt(spinfo.getPzwh(), row, 9);
			table.editCellAt(row, 6);
		}
	}
	

	
	//���ݱ����Ϣ������Ʒ������������������������Ʒ������������Ʒ�ĵĵ��ۣ����ϼƽ�ÿ����Ʒ���������Ե��ۣ�
	private void computeInfos()
	{
		int pzs=0;    //Ʒ����
		int hpzs=0;    //��Ʒ����
		Double hjje=0.0;    //�ϼƽ��
		
		TbSpinfo column=null;
		int rows=table.getRowCount();
		Object value=table.getValueAt(rows-1, 0);    //��Ϊ��Ӱ�ť��ֻ����Ʒ�б��Ϊ��ʱ��������µĿ���
		if(!(value instanceof TbSpinfo))    //��valueΪnullʱ��ֱ�ӷ���
			return;
		if(rows>0)
		{
			column=(TbSpinfo)value;
		}
		
		if(rows>0 && (column==null || column.getId().isEmpty()))
		{
			rows--;
		}
		
		for(int i=0;i<rows;i++)
		{
			String slStr=(String)table.getValueAt(i, 7);
			String djStr=(String)table.getValueAt(i, 6);
			
			int sl= (slStr==null || slStr.isEmpty()) ? 0 : Integer.parseInt(slStr);     //������Ʒ����
			Double dj= (djStr==null || djStr.isEmpty()) ? 0 : Double.parseDouble(djStr);    //����
			
			hpzs+=sl;
			hjje+=sl*dj;
		}
		
		pzslField.setText(String.valueOf(rows));
		hpzsField.setText(String.valueOf(hpzs));
		hjjeField.setText(String.valueOf(hjje));	
	}
}

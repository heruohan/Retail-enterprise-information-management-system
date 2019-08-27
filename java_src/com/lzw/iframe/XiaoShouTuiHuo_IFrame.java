package com.lzw.iframe;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import com.lzw.dao.*;
import com.lzw.*;
import com.lzw.dao.model.*;
import java.util.List;
import java.util.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.table.*;
import java.sql.*;
import java.awt.*;



public class XiaoShouTuiHuo_IFrame extends JInternalFrame{
	
	/*
	 * �������
	 */
	private JLabel idLabel=null;    //����Ʊ�ű�ǩ
	private JTextField idField=null;    //�����ı���
	
	private JLabel khLabel=null;    //�ͻ���ǩ
	private JComboBox khComboBox=null;    //�ͻ������б��
	
	private JLabel lxrLabel=null;    //��ϵ�˱�ǩ
	private JTextField lxrField=null;    //��ϵ���ı���
	
	private JLabel jsfsLabel=null;    //���㷽ʽ��ǩ
	private JComboBox jsfsComboBox=null;    //���㷽ʽ�����б��
	
	private JLabel thsjLabel=null;    //�˻�ʱ���ǩ
	private JTextField thsjField=null;    //�˻��ı���
	
	private JLabel jsrLabel=null;    //�����˱�ǩ
	private JComboBox jsrComboBox=null;    //�����������б��
	
	
	/*
	 * �ײ����
	 */
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
	private JButton thButton=null;    //�˻���ť
	
	/*
	 * �����壬��������
	 */
	private JScrollPane tablePane=null;    //������
	private JTable table=null;    //���
	private JComboBox spComboBox=null;    //��Ʒ�����б��
	
	//�˻�ʱ��
	private Date thdate=new Date();
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		XiaoShouTuiHuo_IFrame inFrame=new XiaoShouTuiHuo_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	
	//���캯��
	public XiaoShouTuiHuo_IFrame()
	{
		init();
	}
	
	
	//��ʼ�������˻��ڲ�����
	private void init()
	{
		//�����ڲ����������
		this.setTitle("����-�˻�");
		this.setMaximizable(true);    //���
		this.setIconifiable(true);    //��С��
		this.setResizable(true);    //�ɵ�����С
		this.setClosable(true);    //�ɹر�
		this.getContentPane().setLayout(new GridBagLayout());   //�����ڲ�����Ĳ��ֹ�����
		this.setBounds(50, 50, 600, 320);
		
		
		//������
		//����Ʊ�ţ�idLabel
		idLabel=new JLabel("����Ʊ�ţ�");
		this.setupComponent(idLabel, 0, 0, 1, 0, false);
		this.setupComponent(this.getIdField(), 1, 0, 1, 0, true);
		
		
		//�ͻ���khLabel
		khLabel=new JLabel("�ͻ���");
		this.setupComponent(khLabel, 2, 0, 1, 0, false);
		khComboBox=this.getKhComboBox();
		khComboBox.setPreferredSize(new Dimension(150,21));
		this.setupComponent(this.getKhComboBox(), 3, 0, 1, 0, true);
		
		
		//��ϵ�ˣ�lxrLabel
		lxrLabel=new JLabel("��ϵ�ˣ�");
		this.setupComponent(lxrLabel, 4, 0, 1, 0, false);
		this.setupComponent(this.getLxrField(), 5, 0, 2, 0, true);
		
		
		//���㷽ʽ��jsfsLabel
		jsfsLabel=new JLabel("���㷽ʽ��");
		this.setupComponent(jsfsLabel, 0, 1, 1, 0, false);
		this.setupComponent(this.getJsfsComboBox(), 1, 1, 1, 0, true);
		
		
		
		//�˻�ʱ�䣺thsjLabel
		thsjLabel=new JLabel("�˻�ʱ�䣺");
		this.setupComponent(thsjLabel, 2, 1, 1, 0, false);
		this.setupComponent(this.getThsjField(), 3, 1, 1, 0, true);
		
		
		//�����ˣ�jsrLabel
		jsrLabel=new JLabel("�����ˣ�");
		this.setupComponent(jsrLabel, 4, 1, 1, 0, false);
		this.setupComponent(this.getJsrComboBox(), 5, 1, 2, 0, true);
		
		
		
		/*
		 * ��ӱ����壺tablePane
		 */
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(580,170));
		this.setupComponent(this.getTablePane(), 0, 2, 7, 0, true);
		
		
		
		//Ʒ��������pzslLabel
		pzslLabel=new JLabel("Ʒ��������");
		this.setupComponent(pzslLabel, 0, 3, 1, 0, false);
		this.setupComponent(this.getPzslField(), 1, 3, 1, 0, true);
		
		
		//��Ʒ������hpzsLabel
		hpzsLabel=new JLabel("��Ʒ������");
		this.setupComponent(hpzsLabel, 2, 3, 1, 0, false);
		this.setupComponent(this.getHpzsField(), 3, 3, 1, 0, true);
		
		
		//�ϼƽ�hjjeLabel
		hjjeLabel=new JLabel("�ϼƽ�");
		this.setupComponent(hjjeLabel, 4, 3, 1, 0, false);
		this.setupComponent(this.getHjjeField(), 5, 3, 2, 0, true);
		
		
		//���ս��ۣ�ysjlLabel
		ysjlLabel=new JLabel("���ս��ۣ�");
		this.setupComponent(ysjlLabel, 0, 4, 1, 0, false);
		this.setupComponent(this.getYsjlField(), 1, 4, 1, 0, true);
		
		
		//����Ա��czyLabel
		czyLabel=new JLabel("����Ա��");
		this.setupComponent(czyLabel, 2, 4, 1, 0, false);
		this.setupComponent(this.getCzyField(), 3, 4, 1, 0, true);
		
		
		//��Ӱ�ť��tjButton
		this.setupComponent(this.getTjButton(), 5, 4, 1, 0, false);
		
		
		//�˻���ť��thButton
		this.setupComponent(this.getThButton(), 6, 4, 1, 0, false);
		
	}
	

	//�����ڲ������������ڸ������ֹ������µ�λ��
	private void setupComponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill)
	{
		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=gridx;
		constraint.gridy=gridy;
		constraint.insets=new Insets(2,2,2,2);
		
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
	
	
	/*
	 * �������
	 */
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
	
	
	//�ͻ������б��khComboBox
	private JComboBox getKhComboBox()
	{
		if(khComboBox==null)
		{
			khComboBox=new JComboBox();
			khComboBox.addItem("��ѡ��");
			List khList=Dao.getKhInfos();
			for(Iterator iter=khList.iterator();iter.hasNext();)
			{
				Item item=new Item();
				List<String> tmp=(List<String>)iter.next();
				item.setId(tmp.get(0).trim());
				item.setName(tmp.get(1).trim());
		
				khComboBox.addItem(item);
			}
			
			//���ͬ��������ϵ�˵ļ����
			khComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Item item=null;
					Object obj=khComboBox.getSelectedItem();
					if(obj instanceof Item)
					{
						item=(Item)obj;
						TbKhinfo kehu=Dao.getKhInfo(item);
						lxrField.setText(kehu.getLian());
					}
				}
					});
		}
		return khComboBox;
	}
	
	
	//��ϵ���ı���lxrField
	private JTextField getLxrField()
	{
		if(lxrField==null)
		{
			lxrField=new JTextField();
			lxrField.setEditable(false);
		}
		return lxrField;
	}
	
	
	//���㷽ʽ�����б��jsfsComboBox
	private JComboBox getJsfsComboBox()
	{
		if(jsfsComboBox==null)
		{
			jsfsComboBox=new JComboBox();
			jsfsComboBox.addItem("�ֽ�");
			jsfsComboBox.addItem("֧Ʊ");
			jsfsComboBox.setEditable(true);
		}
		return jsfsComboBox;
	}
	
	
	//�˻�ʱ���ı���thsjField
	private JTextField getThsjField()
	{
		if(thsjField==null)
		{
			thsjField=new JTextField();
			thsjField.setEditable(false);
		}
		return thsjField;
	}
	
	
	//�����������б��jsrComboBox
	private JComboBox getJsrComboBox()
	{
		if(jsrComboBox==null)
		{
			jsrComboBox=new JComboBox();
			jsrComboBox.addItem("��ѡ��");
			List jsrList=Dao.getJsrs();
			for(Iterator iter=jsrList.iterator();iter.hasNext();)
			{
				Item item=new Item();
				List<String> lst=(List<String>)iter.next();
				item.setId(lst.get(0).trim());
				item.setName(lst.get(1).trim());
				jsrComboBox.addItem(item);
			}
		}
		return jsrComboBox;
	}
	
	
	/*
	 * �ײ����
	 */
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
	
	
	//���ս����ı���ysjlField
	private JTextField getYsjlField()
	{
		if(ysjlField==null)
		{
			ysjlField=new JTextField();
			ysjlField.setEditable(false);
		}
		return ysjlField;
	}
	
	
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
	
	
	//��Ӱ�ť��tjButton
	private JButton getTjButton()
	{
		if(tjButton==null)
		{
			tjButton=new JButton("���");
			
			//
			tjButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��������Ʊ��
					thdate=new Date();
					long time=thdate.getTime();
					java.sql.Date sql_date=new java.sql.Date(time);
					String max_id=Dao.getXsthMainMaxId(sql_date);
					idField.setText(max_id);
					
					//
					for(int i=0;i<table.getRowCount();i++)
					{
						TbSpinfo sp=(TbSpinfo)table.getValueAt(i, 0);
						if(sp==null || sp.getId()==null || sp.getId().isEmpty())
						{
							return;
						}
					}
					
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					model.addRow(new Object[] {});
				}
					});
		}
		return tjButton;
	}
	
	
	//�˻���ť��thButton
	private JButton getThButton()
	{
		if(thButton==null)
		{
			thButton=new JButton("�˻�");
			//�����
			thButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					stopTableCellEditing();
					clearEmptyRow();
					
					//�����˻�ʱ��
					thdate=new Date();
					String s=String.format("%1$tF %1$tT", thdate);
					thsjField.setText(s);
					
					//���������˻����༰��ϸ��
					String xsthID=idField.getText();    //�����˻�ID
					String pzs=pzslField.getText();    //Ʒ����
					String je=hjjeField.getText();    //���
					String ysjl=ysjlField.getText();    //���ս���
					String khname=khComboBox.getSelectedItem().toString();    //�ͻ�����
					String thdate=thsjField.getText();    //�˻�ʱ��
					String czy=czyField.getText();    //����Ա
					String jsr=jsrComboBox.getSelectedItem().toString();    //������
					String jsfs=jsfsComboBox.getSelectedItem().toString();    //���㷽ʽ
					
					if(jsr.equals("��ѡ��") || jsr.isEmpty())
					{
						JOptionPane.showMessageDialog(XiaoShouTuiHuo_IFrame.this, "����Ӿ�����");
						return;
					}
					
					if(ysjl==null || ysjl.isEmpty())
					{
						JOptionPane.showMessageDialog(XiaoShouTuiHuo_IFrame.this, "����д���ս���");
						return;
					}
					
					if(table.getRowCount()<=0)
					{
						JOptionPane.showMessageDialog(XiaoShouTuiHuo_IFrame.this, "������˻���Ʒ");
						return;
					}
					
					
					//���������˻�����
					TbXsthMain xsthMain=new TbXsthMain(xsthID,pzs,je,ysjl,khname,thdate,czy,jsr,jsfs);
					Set<TbXsthDetail> details=xsthMain.getTbXsthDetails();
					for(int i=0;i<table.getRowCount();i++)
					{
						TbSpinfo spinfo=(TbSpinfo)table.getValueAt(i, 0);
						
						String dj_str=(String)table.getValueAt(i, 6);
						String sl_str=(String)table.getValueAt(i, 7);
						
						Double dj=Double.valueOf(dj_str);
						Integer sl=Integer.valueOf(sl_str);
						
						//��ʼ�������˻���ϸ��
						TbXsthDetail detail=new TbXsthDetail();
						detail.setDj(dj);
						detail.setSl(sl);
						detail.setSpid(spinfo.getId());
						detail.setTbXsthMain(xsthID);
						details.add(detail);
					}
					
					boolean rs=Dao.insertXsthInfo(xsthMain);
					if(rs)
					{
						JOptionPane.showMessageDialog(XiaoShouTuiHuo_IFrame.this, "�˻��ɹ�");
						//��ձ�����
						DefaultTableModel model=(DefaultTableModel)table.getModel();
						for(int i=table.getRowCount()-1;i>=0;i--)
						{
							model.removeRow(i);
						}
						
						//��ʼ���ײ��ı�������
						pzslField.setText("0");
						hpzsField.setText("0");
						hjjeField.setText("0.0");
					}
				}
					});
		}
		return thButton;
	}
	
	
	
	
	/*
	 * ��ʼ�������弰������
	 */
	//�����壺tablePane
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
			
			String[] columnName= { "��Ʒ����", "��Ʒ���", "��Ӧ��", "����", "��λ", "���", "����", "����", "��װ", "����", "��׼�ĺ�" };
			
			table=new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setShowGrid(true);
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			
			//Ϊ����������
			((DefaultTableModel)table.getModel()).setColumnIdentifiers(columnName);
			
			//���ñ���һ�еı༭��Ϊ�����б��
			TableColumn column=table.getColumnModel().getColumn(0);
			DefaultCellEditor editor=new DefaultCellEditor(this.getSpComboBox());
			column.setCellEditor(editor);
			
			//��Ӽ����������Ʒ����������Ʒ�������ϼƽ����ı���
			table.addContainerListener(new ContainerListener()
					{
				public void componentAdded(ContainerEvent e)
				{
					computeInfos();
				}
				
				public void componentRemoved(ContainerEvent e)
				{
					
				}
					});
		}
		return table;
	}
	
	
	
	//����Ʒ����������Ʒ�������ϼƽ���ı�������
	private void computeInfos()
	{
		int hpzs=0;
		Double hjje=0.0;
		
		int row=table.getRowCount();
		TbSpinfo spinfo=null;
		Object obj=table.getValueAt(row-1, 0);
		if(!(obj instanceof TbSpinfo))
		{
			return;
		}
		
		spinfo=(TbSpinfo)obj;
		if(row>0 && (spinfo==null || spinfo.getId()==null || spinfo.getId().isEmpty()))
		{
			row--;
		}
		
		for(int i=0;i<row;i++)
		{
			String dj_str=(String)table.getValueAt(i, 6);
			String sl_str=(String)table.getValueAt(i, 7);
			
			
			Double dj=Double.valueOf(dj_str);
			Integer sl=Integer.valueOf(sl_str);
			
			hpzs+=sl;
			hjje+=(dj*sl);
		}
		
		pzslField.setText(String.valueOf(row));
		hpzsField.setText(String.valueOf(hpzs));
		hjjeField.setText(String.valueOf(hjje));
	}
	
	
	//��Ʒ�����б��spComboBox
	private JComboBox getSpComboBox()
	{
		if(spComboBox==null)
		{
			spComboBox=new JComboBox();
			
			//��Ӹ�����Ʒ�����б��ļ�����
			spComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//�����Ʒ�ൽ��Ʒ�����б��
					spComboBox.addItem(new TbSpinfo());
					ResultSet rs=Dao.query("select * from tb_spinfo where id in (select id from tb_kucun)");
					updateSpcomboBox(rs);
				}
					});
			
			
			//��ѡ����Ʒʱ����Ӹ��µ�ǰ�еļ����
			spComboBox.addItemListener(new ItemListener()
					{
				public void itemStateChanged(ItemEvent e)
				{
					//���±��ĵ�ǰ��
					TbSpinfo sp=(TbSpinfo)spComboBox.getSelectedItem();
					if(sp!=null && sp.getId()!=null && !sp.getId().isEmpty())
					{
						updateTable();
					}
				}
					});
		}
		return spComboBox;
	}
	
	
	

	//������Ʒ�����б��
	private void updateSpcomboBox(ResultSet rs)
	{
		spComboBox.removeAllItems();
		List<String> lst=new ArrayList<>();
		for(int i=0;table!=null && i<table.getRowCount();i++)
		{
			TbSpinfo sp=(TbSpinfo)table.getValueAt(i, 0);
			if(sp!=null && sp.getId()!=null)
			{
				lst.add(sp.getId());
			}
		}
		
		try
		{
			while(rs.next())
			{
				TbSpinfo spinfo=new TbSpinfo();
				String id=rs.getString("id").trim();
				if(lst.contains(id))
					continue;
				spinfo.setId(id);
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
				
				spComboBox.addItem(spinfo);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	//���±��ĵ�ǰ�з���
	private void updateTable()
	{
		int row=table.getSelectedRow();
		TbSpinfo spinfo=(TbSpinfo)spComboBox.getSelectedItem();
		
		if(row>=0 && spinfo!=null)
		{
			table.setValueAt(spinfo.getId(), row, 1);
			table.setValueAt(spinfo.getGysname(), row, 2);
			table.setValueAt(spinfo.getCd(), row, 3);
			table.setValueAt(spinfo.getDw(), row, 4);
			table.setValueAt(spinfo.getGg(), row, 5);
			table.setValueAt("����д�˻�����",row, 6);
			table.setValueAt("����д�˻�����", row, 7);
			table.setValueAt(spinfo.getBz(), row, 8);
			table.setValueAt(spinfo.getPh(), row, 9);
			table.setValueAt(spinfo.getPzwh(), row, 10);
		}
		
	}
	
	
	
	//��տ���
	private synchronized void clearEmptyRow()
	{
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		for(int i=0;i<table.getRowCount();i++)
		{
			TbSpinfo sp=(TbSpinfo)table.getValueAt(i, 0);
			if(sp==null || sp.getId()==null || sp.getId().isEmpty())
			{
				model.removeRow(i);
			}
		}
	}
	
	
	//ֹͣ�༭���
	private void stopTableCellEditing()
	{
		TableCellEditor editor=table.getCellEditor();
		if(editor!=null)
		{
			editor.stopCellEditing();
		}
	}
}

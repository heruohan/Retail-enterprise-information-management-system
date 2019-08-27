package com.lzw.iframe;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import com.lzw.dao.*;
import java.util.*;
import java.util.Date;
import com.lzw.*;
import java.awt.event.*;
import com.lzw.dao.model.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.*;
import java.util.List;




public class JinHuoTuiHuo_IFrame extends JInternalFrame{
	
	/*
	 * �������
	 */
	private JLabel idLabel=null;    //�˻�Ʊ�ű�ǩ
	private JTextField idField=null;    //�˻�Ʊ���ı���
	
	private JLabel gysLabel=null;    //��Ӧ�̱�ǩ
	private JComboBox gysComboBox=null;    //��Ӧ�������б��
	
	private JLabel lxrLabel=null;    //��ϵ�˱�ǩ
	private JTextField lxrField=null;    //��ϵ���ı���
	
	private JLabel jsfsLabel=null;    //���㷽ʽ��ǩ
	private JComboBox jsfsComboBox=null;    //���㷽ʽ�����б��
	
	private JLabel thsjLabel=null;    //�˻�ʱ���ǩ
	private JTextField thsjField=null;    //�˻�ʱ���ı���
	
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
	 * �����������
	 */
	private JTable table=null;    //���
	private JScrollPane tablePane=null;    //������
	private JComboBox spComboBox=null;    //��Ʒ�����б��
	
	private Date thdate=new Date();    //�˻�ʱ��
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		JinHuoTuiHuo_IFrame inFrame=new JinHuoTuiHuo_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	
	//���캯��
	public JinHuoTuiHuo_IFrame()
	{
		init();
	}
	
	
	//��ʼ�������˻��ڲ�����
	private void init()
	{
		this.setTitle("����-�˻�");
		this.setMaximizable(true);
		this.setResizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.getContentPane().setLayout(new GridBagLayout());    //�����ڲ�����Ĳ��ֹ�����Ϊ�����鲼�ֹ�����
		setBounds(50, 50, 600, 320);    // ���ý���-�˻��ڲ������λ�úͿ��
		
		//��ʼ��������Ŀ�ı�ǩ
		//�˻�Ʊ�ű�ǩ
		idLabel=new JLabel("�˻�Ʊ�ţ�"); 
		this.setupComponent(idLabel, 0, 0, 1, 0, false);
		idField=this.getIdField();
		idField.setPreferredSize(new Dimension(100,21));
		this.setupComponent(this.getIdField(), 1, 0, 1, 0, true);
		
		//��Ӧ�̱�ǩ
		gysLabel=new JLabel("��Ӧ�̣�");
		this.setupComponent(gysLabel, 2, 0, 1,0, false);
		gysComboBox=this.getGysComboBox();
		gysComboBox.setPreferredSize(new Dimension(160,21));
		this.setupComponent(gysComboBox, 3, 0, 2, 0, true);
		
		
		
		//��ϵ�˱�ǩ
		lxrLabel=new JLabel("��ϵ�ˣ�");
		this.setupComponent(lxrLabel, 5, 0, 1,0, false);
		lxrField=this.getLxrField();
		lxrField.setPreferredSize(new Dimension(80,21));
		this.setupComponent(this.getLxrField(), 6, 0, 1, 0, true);
		
		
		//���㷽ʽ��ǩ
		jsfsLabel=new JLabel("���㷽ʽ��");
		this.setupComponent(jsfsLabel, 0, 1, 1, 0, false);
		this.setupComponent(this.getJsfsComboBox(), 1, 1, 1, 0, true);
		
		
		//�˻�ʱ���ǩ
		thsjLabel=new JLabel("�˻�ʱ�䣺");
		this.setupComponent(thsjLabel, 2, 1, 1,0, false);
		this.setupComponent(this.getThsjField(), 3, 1, 2, 0, true);
		
		
		//�����˱�ǩ
		jsrLabel=new JLabel("�����ˣ�");
		this.setupComponent(jsrLabel, 5, 1, 1, 0, false);
		this.setupComponent(this.getJsrComboBox(), 6, 1, 1, 0, true);
		
		
		/*
		 * ��ӱ����壺tablePane
		 */
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(580,148));
		this.setupComponent(tablePane, 0, 2, 7, 1, true);
		
		
		
		//Ʒ��������ǩ
		pzslLabel=new JLabel("Ʒ��������");
		this.setupComponent(pzslLabel, 0, 3, 1, 0, false);
		pzslField=this.getPzslField();
		pzslField.setPreferredSize(new Dimension(100,21));
		this.setupComponent(this.getPzslField(), 1, 3, 1, 0, true);
		
		
		//��Ʒ������ǩ
		hpzsLabel=new JLabel("��Ʒ������");
		this.setupComponent(hpzsLabel, 2, 3, 1, 0, false);
		hpzsField=this.getHpzsField();
		hpzsField.setPreferredSize(new Dimension(150,21));
		this.setupComponent(this.getHpzsField(), 3, 3, 1, 0, true);
		//System.out.println(hpzsField.getPreferredSize().height + ":" + hpzsField.getPreferredSize().width);
		
		
		//�ϼƽ���ǩ
		hjjeLabel=new JLabel("�ϼƽ�");
		this.setupComponent(hjjeLabel, 4, 3, 1, 0, false);
		this.setupComponent(this.getHjjeField(), 5, 3, 3, 0, true);
		
		
		//���ս��۱�ǩ
		ysjlLabel=new JLabel("���ս��ۣ�");
		this.setupComponent(ysjlLabel, 0, 4, 1, 0, false);
		this.setupComponent(this.getYsjlField(), 1, 4, 1, 0, true);
		
		
		//����Ա��ǩ
		czyLabel=new JLabel("����Ա��");
		this.setupComponent(czyLabel, 2, 4, 1, 0, false);
		this.setupComponent(this.getCzyField(), 3, 4, 1, 1, true);
		
		
		//��Ӱ�ť
		this.setupComponent(this.getTjButton(), 5, 4, 1, 1, false);
		this.setupComponent(this.getThButton(), 6, 4, 1, 1, false);
		
		
	}
	
	
	/*
	 * �������
	 */
	//�˻�Ʊ���ı���idField
	private JTextField getIdField()
	{
		if(idField==null)
		{
			idField=new JTextField();
			idField.setEditable(false);
			
		}
		return idField;
	}
	
	
	//��Ӧ�������б��gysComboBox
	private JComboBox getGysComboBox()
	{
		if(gysComboBox==null)
		{
			gysComboBox=new JComboBox();
			
			List gysinfos=Dao.getGysInfos();
			for(Iterator iter=gysinfos.iterator();iter.hasNext();)
			{
				List<String> tmp=(List<String>)iter.next();
				Item item=new Item();
				item.setId(tmp.get(0).trim());
				item.setName(tmp.get(1).trim());
				gysComboBox.addItem(item);
			}
			
			//����Զ�������ϵ���ı���ļ�����
			gysComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Item item=(Item)gysComboBox.getSelectedItem();
					TbGysinfo selectGys=Dao.getGysinfo(item);
					lxrField.setText(selectGys.getLian());
				}
					});
		}
		return gysComboBox;
	}
	
	
	//��ʼ����ϵ���ı���lxrField
	private JTextField getLxrField()
	{
		if(lxrField==null)
		{
			lxrField=new JTextField();
			lxrField.setEditable(false);
		}
		return lxrField;
	}
	
	
	//��ʼ�����㷽ʽ�����б��jsfsComboBox
	private JComboBox getJsfsComboBox()
	{
		if(jsfsComboBox==null)
		{
			jsfsComboBox=new JComboBox();
			jsfsComboBox.addItem("�ֽ����");
			jsfsComboBox.addItem("֧Ʊ����");
			jsfsComboBox.setEditable(true);    //ʹ����Ա༭�����г�������֮��Ľ��㷽ʽ
		}
		return jsfsComboBox;
	}
	
	
	//��ʼ���˻�ʱ���ı���thsjField
	private JTextField getThsjField()
	{
		if(thsjField==null)
		{
			thsjField=new JTextField();
			thsjField.setEditable(false);
		}
		return thsjField;
	}
	
	
	//��ʼ�������������б��jsrComboBox
	private JComboBox getJsrComboBox()
	{
		if(jsrComboBox==null)
		{
			jsrComboBox=new JComboBox();
			List jsrinfos=Dao.getJsrs();
			for(Iterator iter=jsrinfos.iterator();iter.hasNext();)
			{
				List<String> tmp=(List<String>)iter.next();
				Item item=new Item();
				item.setId(tmp.get(0).trim());
				item.setName(tmp.get(1).trim());
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
			hpzsField=new JTextField();
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
	
	
	//��ʼ����Ӱ�ť��tjButton
	private JButton getTjButton()
	{
		if(tjButton==null)
		{
			tjButton=new JButton();
			tjButton.setText("���");
			
			//��ӿ���
			tjButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					
					//ͬ�������˻�Ʊ�ź��˻�ʱ���ı���
					long time=thdate.getTime();
					java.sql.Date sql_date=new java.sql.Date(time);
					thsjField.setText(sql_date.toString());
					
					//��ȡ����˻����ID
					String thid=Dao.getRkthMainMaxId(sql_date);
					idField.setText(thid);
					
					
					for(int i=0;i<table.getRowCount();i++)
					{
						TbKucun info=(TbKucun)table.getValueAt(i, 0);
						
						if(info==null || info.getId()==null || info.getId().isEmpty())
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
	
	
	/*
	 * �˻�ʱ������Ҫ��������Ʒ�Ĺ�Ӧ�̶�Ϊͬһ��������������ô���������δ�����
	 */
	
	//����?��2019.7.15 1:32)


	//��ʼ���˻���ť��thButton
	private JButton getThButton()
	{
		if(thButton==null)
		{
			thButton=new JButton("�˻�");
			//��Ӽ����
			thButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					stopTableCellEditing();
					clearEmptyRow();    //�������
					
					String rkthID=idField.getText();    //����˻�ID
					String pzs=pzslField.getText();    //Ʒ������
					String je=hjjeField.getText();    //���
					String ysjl=ysjlField.getText();    //���ս���
					//String gysname=gysComboBox.getSelectedItem().toString();    //��Ӧ������
					String rtdate=thsjField.getText();    //�˻�ʱ��
					String czy=czyField.getText();    //����Ա
					String jsr=jsrComboBox.getSelectedItem().toString();    //������
					String jsfs=jsfsComboBox.getSelectedItem().toString();    //���㷽ʽ
					
					
					if(jsr==null || jsr.isEmpty())
					{
						JOptionPane.showMessageDialog(JinHuoTuiHuo_IFrame.this, "����д������");
						return;
					}
					
					if(ysjl==null || ysjl.isEmpty())
					{
						JOptionPane.showMessageDialog(JinHuoTuiHuo_IFrame.this, "����д���ս���");
						return;
					}
					
					
					if(table.getRowCount()<=0)
					{
						JOptionPane.showMessageDialog(JinHuoTuiHuo_IFrame.this, "������˻���Ʒ");
						return;
					}
					
					
					/*
					 * �˻�ʱ���жϱ���е����п����Ʒ�Ƿ�ʱ��ͬһ����Ӧ���ṩ
					 */
					TbKucun kucun=(TbKucun)table.getValueAt(0, 0);
					String gysname=null;
					if(kucun!=null && kucun.getId()!=null && kucun.getSpname()!=null)
					{
						Item item=new Item();
						item.setId(kucun.getId());
						item.setName(kucun.getSpname());
						TbSpinfo spinfo=Dao.getSpinfo(item);
						gysname=spinfo.getGysname();
					}
					
					for(int i=0;i<table.getRowCount();i++)
					{
						TbKucun tmp=(TbKucun)table.getValueAt(i, 0);
						if(tmp!=null && tmp.getSpname()!=null && tmp.getId()!=null)
						{
							Item item=new Item();
							item.setId(tmp.getId());
							item.setName(tmp.getSpname());
							TbSpinfo t_sp=Dao.getSpinfo(item);
							if(!gysname.equals(t_sp.getGysname()))
							{
								JOptionPane.showMessageDialog(JinHuoTuiHuo_IFrame.this, "����д��ڲ�����ͬһ��Ӧ�̵���Ʒ�����޸�");
								return;
							}
						}	
					}
					
					
					//����TbRkthMain��
					TbRkthMain rkthMain=new TbRkthMain(rkthID,pzs,je,ysjl,gysname,rtdate,czy,jsr,jsfs);
					Set<TbRkthDetail> details=rkthMain.getTbRkthDetail();
					
					int row=table.getRowCount();
					for(int i=0;i<row;i++)
					{
						TbKucun tmp=(TbKucun)table.getValueAt(i, 0);
						String djStr=(String)table.getValueAt(i, 6);
						String slStr=(String)table.getValueAt(i, 7);
						
						Double dj=Double.valueOf(djStr);
						Integer sl=Integer.valueOf(slStr);
						
						//��ʼ������˻���ϸ��Ϣ��
						TbRkthDetail detail=new TbRkthDetail();
						detail.setDj(dj);
						detail.setSl(sl);
						detail.setTbRkthMain(rkthID);
						detail.setSpid(tmp.getId());
						details.add(detail);
				    }
					
					//����Ϣ��ӽ����ݿ�
					boolean rs=Dao.insertRkthInfo(rkthMain);
					if(rs)
					{
						JOptionPane.showMessageDialog(JinHuoTuiHuo_IFrame.this, "�˻��ɹ�");
						//��ձ�����
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
		return thButton;
	}
	
	
	
	
	/*
	 * ��ʼ�����������
	 */
	//��ʼ�������壺tablePane
	private JScrollPane getTablePane()
	{
		if(tablePane==null)
		{
			tablePane=new JScrollPane();
			tablePane.setViewportView(this.getTable());
			
		}
		return tablePane;
	}
	
	//��ʼ�����table
	private JTable getTable()
	{
		if(table==null)
		{
			table=new JTable();
			String[] columnName= { "��Ʒ����", "��Ʒ���", "����", "��λ", "���", "��װ", "����", "����" };
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			model.setColumnIdentifiers(columnName);    //���ñ�ͷ
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			table.setShowGrid(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    //ȡ���Զ�����ģʽ
			
			
			//���ñ����Ʒ�еı༭��Ϊ�����б��
			TableColumn column=table.getColumnModel().getColumn(0);
			DefaultCellEditor editor=new DefaultCellEditor(this.getSpComboBox());
			column.setCellEditor(editor);
			
			//�����ʱ���Զ�����Ʒ����������Ʒ�������ϼƽ��ļ����
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
	
	
	//��ʼ����Ʒ�����б��spComboBox
	private JComboBox getSpComboBox()
	{
		if(spComboBox==null)
		{
			spComboBox=new JComboBox();
			spComboBox.addItem(new TbKucun());
			//��Ӽ������������Ʒ�����б��
			spComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					ResultSet rs=Dao.findForResultSet("select * from tb_kucun where id in (select id from tb_spinfo where gysname='" + gysComboBox.getSelectedItem() + "')");
					updatespComboBox(rs);
				}
					});
			
			
			//��Ӽ��������ѡ����Ʒ�б���е���ʱ���Զ����±��б����������
			spComboBox.addItemListener(new ItemListener()
					{
				public void itemStateChanged(ItemEvent e)
				{
					TbKucun kucun=(TbKucun)spComboBox.getSelectedItem();
					if(kucun!=null && kucun.getId()!=null)
					{
						updateTable();
					}
				}
					});
		}
		return spComboBox;
	}
	
	
	
	
	
	//������Ʒ�����б��
	/*
	 * ������ݿ����棬��Ʒ�ı�Ŷ���Ψһ�ģ����۸������µĽ��и��£����������ͬһ����Ʒ
	 * ����۸������µļ۸�
	 */
	
	private void updatespComboBox(ResultSet rs)    
	{
		List<String> lst=new ArrayList<>();
		for(int i=0;table!=null && i<table.getRowCount();i++)
		{
			TbKucun kucun=(TbKucun)table.getValueAt(i, 0);
			if(kucun!=null && kucun.getId()!=null)
			{
				lst.add(kucun.getId());
			}
		}
		
		spComboBox.removeAllItems();
		try
		{
			while(rs.next())
			{
				TbKucun tmp=new TbKucun();
				String id=rs.getString("id").trim();
				if(lst.contains(id))
					continue;
				tmp.setId(id);
				tmp.setSpname(rs.getString("spname").trim());
				tmp.setJc(rs.getString("jc").trim());
				tmp.setCd(rs.getString("cd").trim());
				tmp.setGg(rs.getString("gg").trim());
				tmp.setBz(rs.getString("bz").trim());
				tmp.setDw(rs.getString("dw").trim());
				tmp.setDj(Double.valueOf(rs.getString("dj").trim()));
				tmp.setKcsl(Integer.valueOf(rs.getString("kcsl").trim()));
				spComboBox.addItem(tmp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	//��ѡ����Ʒ�����б��󣬸��±�������ݵķ���
	private synchronized void updateTable()
	{
		TbKucun kucun=(TbKucun)spComboBox.getSelectedItem();
		int row=table.getSelectedRow();
		if(row>=0 && kucun!=null)
		{
			table.setValueAt(kucun.getId(), row, 1);
			table.setValueAt(kucun.getCd(), row, 2);
			table.setValueAt(kucun.getDw(), row, 3);
			table.setValueAt(kucun.getGg(), row, 4);
			table.setValueAt(kucun.getBz(), row, 5);
			table.setValueAt(kucun.getDj().toString(), row, 6);
			table.setValueAt(kucun.getKcsl().toString(), row, 7);
			table.editCellAt(row, 7);
		}
	}
	
	
	
	//�����Ʒ�������ϼƽ�������
	private void computeInfos()
	{
		int hpzs=0;
		Double hjje=0.0;
		
		//����б����У���Ϊû���еĻ����˷����������ļ������Ͳ��ᷢ��
		int row=table.getRowCount();
		
		//������Ӱ�ť��������һ�е���Ʒ���ݿ���Ϊ�գ������бض���Ϊ��
		TbKucun kucun=null;
		Object obj=table.getValueAt(row-1, 0);
		if(!(obj instanceof TbKucun))    //������һ��Ϊ�գ���ֱ�ӷ��أ������µײ�����ı���
			return;
		
		kucun=(TbKucun)obj;    //������ΪTbKucun��
		if(row>0 && (kucun==null || kucun.getId().isEmpty()))
			row--;
		
		for(int i=0;i<row;i++)
		{
			String djStr=(String)table.getValueAt(i, 6);
			String slStr=(String)table.getValueAt(i, 7);
			
			Double dj=Double.valueOf(djStr);
			Integer sl=Integer.valueOf(slStr);
			
			hpzs+=sl;
			hjje+=(dj*sl);
		}
		
		pzslField.setText(String.valueOf(row));
		hpzsField.setText(String.valueOf(hpzs));
		hjjeField.setText(String.valueOf(hjje));
	}
	
	
	//ֹͣ�༭���
	private void stopTableCellEditing()
	{
		TableCellEditor celleditor=table.getCellEditor();
		if(celleditor!=null)
		{
			celleditor.stopCellEditing();
		}
	}
	
	//��տ���
	private synchronized void clearEmptyRow()
	{
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		for(int i=0;i<table.getRowCount();i++)
		{
			TbKucun tmp=(TbKucun)table.getValueAt(i, 0);
			if(tmp==null || tmp.getId()==null || tmp.getId().isEmpty())
			{
				model.removeRow(i);
			}
		}
	}
	
	
	//�������λ�ã�����ӵ�������
	private void setupComponent(JComponent component,int gridx,int gridy,int gridwidth, int ipadx,boolean fill)
	{
		final GridBagConstraints constraint=new GridBagConstraints();
		//�������λ��
		constraint.gridx=gridx;
		constraint.gridy=gridy;
		constraint.insets=new Insets(5,1,3,1);
		
		if(gridwidth>1)
		{
			constraint.gridwidth=gridwidth;
		}

		constraint.ipadx=ipadx;

		
		
		if(fill)
		{
			constraint.fill=GridBagConstraints.HORIZONTAL;
		}
		this.getContentPane().add(component, constraint);
	}
}

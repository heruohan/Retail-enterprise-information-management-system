
package com.lzw.iframe;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.util.*;
import java.util.Date;
import com.lzw.dao.*;
import java.util.List;
import com.lzw.*;
import com.lzw.dao.model.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.*;


public class XiaoShouDan_IFrame extends JInternalFrame{
	
	/*
	 * �������
	 */
	private JLabel idLabel=null;    //����Ʊ�ű�ǩ
	private JTextField idField=null;    //����Ʊ���ı���
	
	private JLabel khLabel=null;    //�ͻ���ǩ
	private JComboBox khComboBox=null;    //�ͻ������ı���
	
	private JLabel lxrLabel=null;    //��ϵ�˱�ǩ
	private JTextField lxrField=null;    //��ϵ���ı���
	
	private JLabel jsfsLabel=null;    //���㷽ʽ��ǩ
	private JComboBox jsfsComboBox=null;    //���㷽ʽ�����ı���
	
	private JLabel xssjLabel=null;    //����ʱ���ǩ
	private JTextField xssjField=null;    //����ʱ���ı���
	
	private JLabel jsrLabel=null;    //�����˱�ǩ
	private JComboBox jsrComboBox=null;    //�����������ı���
	
	
	/*
	 * �ײ����
	 */
	private JLabel pzslLabel=null;    //Ʒ��������ǩ
	private JTextField pzslField=null;    //Ʒ�������ı���
	
	private JLabel hpzsLabel=null;    //��Ʒ������ǩ
	private JTextField hpzsField=null;    //��Ʒ�����ı���
	
	private JLabel hjjeLabel=null;     //�ϼƽ���ǩ
	private JTextField hjjeField=null;    //�ϼƽ���ı���
	
	private JLabel ysjlLabel=null;    //���ս��۱�ǩ
	private JTextField ysjlField=null;    //���ս����ı���
	
	private JLabel czyLabel=null;    //����Ա��ǩ
	private JTextField czyField=null;    //����Ա�ı���
	
	private JButton tjButton=null;    //��Ӱ�ť
	private JButton xsButton=null;    //���۰�ť
	
	
	/*
	 * ���������
	 */
	//�����壺tablePane
	private JScrollPane tablePane=null;
	//���table
	private JTable table=null;
	//��Ʒ�����б��
	private JComboBox spComboBox=null;
	
	
	//����ʱ��:��ȷ��ʱ���֣���
	private Date xsdate=null;
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		XiaoShouDan_IFrame inFrame=new XiaoShouDan_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	//���캯��
	public XiaoShouDan_IFrame()
	{
		init();
	}
	
	
	//��ʼ�����۵��ڲ�����
	private void init()
	{
		this.setTitle("���۵�");
		this.setMaximizable(true);    //���
		this.setIconifiable(true);    //��ͼ�껯
		this.setResizable(true);    //�ɵ�����С
		this.setClosable(true);    //�ɹر�
		this.getContentPane().setLayout(new GridBagLayout());    //�����ڲ�����Ĳ��ֹ�����Ϊ�����鲼�ֹ�����
		this.setBounds(50, 50, 600, 320);    //�����ڲ������λ�úʹ�С
		
		
		/*
		 * �������鲼�ֹ���������Ӹ������
		 */
		//����Ʊ�ű�ǩ��idLabel
		idLabel=new JLabel("����Ʊ�ţ�");
		this.setupComponent(idLabel, 0, 0, 1, 0, false);
		
		idField=this.getIdField();
		idField.setPreferredSize(new Dimension(120,21));
		this.setupComponent(this.getIdField(), 1, 0, 1, 0, true);
		
		
		//�ͻ���ǩ��khLabel
		khLabel=new JLabel("�ͻ���");
		this.setupComponent(khLabel, 2, 0, 1, 0, false);
		
		khComboBox=this.getKhComboBox();
		khComboBox.setPreferredSize(new Dimension(130,21));
		this.setupComponent(this.getKhComboBox(), 3, 0, 1, 0, true);
		
		
		//��ϵ�˱�ǩ��lxrLabel
		lxrLabel=new JLabel("��ϵ�ˣ�");
		this.setupComponent(lxrLabel, 4, 0, 1, 0, false);
		this.setupComponent(this.getLxrField(), 5, 0, 2, 0, true);
		
		
		//���㷽ʽ��ǩ��jsfsLabel
		jsfsLabel=new JLabel("���㷽ʽ��");
		this.setupComponent(jsfsLabel, 0, 1, 1, 0, false);
		this.setupComponent(this.getJsfsComboBox(), 1, 1, 1, 0, true);
		
		
		//����ʱ���ǩ��xssjLabel
		xssjLabel=new JLabel("����ʱ�䣺");
		this.setupComponent(xssjLabel, 2, 1, 1, 0, false);
		this.setupComponent(this.getXssjField(), 3, 1, 1, 0, true);
		
		
		//�����˱�ǩ��jsrLabel
		jsrLabel=new JLabel("�����ˣ�");
		this.setupComponent(jsrLabel, 4, 1, 1, 0, false);
		this.setupComponent(this.getJsrComboBox(), 5, 1, 2, 0, true);
		
		
		//�����壺tablePane
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(580,170));
		this.setupComponent(this.getTablePane(), 0, 2, 7, 0, true);
		
		
		//Ʒ��������ǩ��pzslLabel
		pzslLabel=new JLabel("Ʒ��������");
		this.setupComponent(pzslLabel, 0, 3, 1, 0, false);
		this.setupComponent(this.getPzslField(), 1, 3, 1, 0, true);
		
		
		//��Ʒ������ǩ��hpzsLabel
		hpzsLabel=new JLabel("��Ʒ������");
		this.setupComponent(hpzsLabel, 2, 3, 1, 0, false);
		this.setupComponent(this.getHpzsField(), 3, 3, 1, 0, true);
		
		
		//�ϼƽ���ǩ��hjjeLabel
		hjjeLabel=new JLabel("�ϼƽ�");
		this.setupComponent(hjjeLabel, 4, 3, 1, 0, false);
		this.setupComponent(this.getHjjeField(), 5, 3, 2, 0, true);
		
		
		//���ս��۱�ǩ��ysjlLabel
		ysjlLabel=new JLabel("���ս��ۣ�");
		this.setupComponent(ysjlLabel, 0, 4, 1, 0, false);
		this.setupComponent(this.getYsjlField(), 1, 4, 1, 0, true);
		
		
		//����Ա��ǩ��czyLabel
		czyLabel=new JLabel("����Ա��");
		this.setupComponent(czyLabel, 2, 4, 1, 0, false);
		this.setupComponent(this.getCzyField(), 3, 4, 1, 0, true);
		
		
		//��Ӱ�ť��tjButton
		this.setupComponent(this.getTjButton(), 5, 4, 1, 0, false);
		
		//���۰�ť��xsButton
		this.setupComponent(this.getXsButton(), 6, 4, 1, 0, false);
	}
	
	
	//��������ڴ����λ��
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
	 * ��ʼ���������
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
			List kehuinfos=Dao.getKhInfos();
			for(Iterator iter=kehuinfos.iterator();iter.hasNext();)
			{
				List<String> tmp=(List<String>)iter.next();
				Item item=new Item();
				item.setId(tmp.get(0).trim());
				item.setName(tmp.get(1).trim());
				khComboBox.addItem(item);
			}
			
			//��Ӹ�����ϵ���ı���ļ�����
			khComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Item item=(Item)khComboBox.getSelectedItem();
					TbKhinfo kehu=Dao.getKhInfo(item);
					lxrField.setText(kehu.getLian());
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
			jsfsComboBox.setEditable(true);
			jsfsComboBox.addItem("�ֽ�");
			jsfsComboBox.addItem("֧Ʊ");
		}
		return jsfsComboBox;
	}
	
	
	//����ʱ���ı���xssjField
	private JTextField getXssjField()
	{
		if(xssjField==null)
		{
			xssjField=new JTextField();
			xssjField.setEditable(false);
		}
		return xssjField;
	}
	
	
	//�����������б��jsrComboBox
	private JComboBox getJsrComboBox()
	{
		if(jsrComboBox==null)
		{
			jsrComboBox=new JComboBox();
			List jsr=Dao.getJsrs();
			for(Iterator iter=jsr.iterator();iter.hasNext();)
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
	
	
	//������Ա�ı���czyField
	private JTextField getCzyField()
	{
		if(czyField==null)
		{
			czyField=new JTextField();
			czyField.setEditable(false);
			//��ʼ����ʱ��ͬ������
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
			//��Ӽ����
			tjButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��������Ʊ��
					xsdate=new Date();
					long time=xsdate.getTime();
					java.sql.Date sql_date=new java.sql.Date(time);
					String id=Dao.getSellMainMaxId(sql_date);
					idField.setText(id);
					
					//�жϱ�����Ƿ��п���
					for(int i=0;i<table.getRowCount();i++)
					{
						TbSpinfo info=(TbSpinfo)table.getValueAt(i, 0);
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
	
	
	
	//���۰�ť��xsButton
	private JButton getXsButton()
	{
		if(xsButton==null)
		{
			xsButton=new JButton("����");
			
			//��Ӽ����
			xsButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��������ʱ���ı���
					xsdate=new Date();
					String s=String.format("%1$tF %1$tT", xsdate);
					xssjField.setText(s);
					
					//������������������ϸ������
					stopTableCellEditing();
					clearEmptyRow();
					
					String sellID=idField.getText();    //����Ʊ��
					String pzs=pzslField.getText();    //Ʒ����
					String je=hjjeField.getText();    //���
					String ysjl=ysjlField.getText();    //���ս���
					String khname=(String)khComboBox.getSelectedItem();    //�ͻ�����
					
					
					String xsdate=xssjField.getText();    //����ʱ��
					String czy=czyField.getText();    //����Ա
					String jsr=(String)jsrComboBox.getSelectedItem();    //������
					String jsfs=(String)jsfsComboBox.getSelectedItem();    //���㷽ʽ
					
					if(khname==null || khname.isEmpty())
					{
						JOptionPane.showMessageDialog(XiaoShouDan_IFrame.this, "����ӿͻ�");
						return;
					}
					
					if(jsr==null || jsr.isEmpty())
					{
						JOptionPane.showMessageDialog(XiaoShouDan_IFrame.this, "����д������");
						return;
					}
					
					if(ysjl==null || ysjl.isEmpty())
					{
						JOptionPane.showMessageDialog(XiaoShouDan_IFrame.this, "����д���ս���");
						return;
					}
					
					if(table.getRowCount()<=0)
					{
						JOptionPane.showMessageDialog(XiaoShouDan_IFrame.this, "�����������Ʒ");
						return;
					}
					
					
					TbSellMain sellMain=new TbSellMain(sellID,pzs,je,ysjl,khname,xsdate,czy,jsr,jsfs);
					Set<TbSellDetail> details=sellMain.getTbSellDetails();
					for(int i=0;i<table.getRowCount();i++)
					{
						TbSpinfo tmp=(TbSpinfo)table.getValueAt(i, 0);
						
						String dj_str=(String)table.getValueAt(i, 6);
						String sl_str=(String)table.getValueAt(i, 7);
						
						Double dj=Double.valueOf(dj_str);
						Integer sl=Integer.valueOf(sl_str);
						//������ϸ��
						TbSellDetail detail=new TbSellDetail();
						detail.setTbSellMain(sellID);
						detail.setSpid(tmp.getId());
						detail.setDj(dj);
						detail.setSl(sl);
						details.add(detail);
					}
					
					boolean re=Dao.insertSellInfo(sellMain);    //��������Ϣ��ӵ����ݿ�
					if(re)
					{
						JOptionPane.showMessageDialog(XiaoShouDan_IFrame.this, "�������");
						//��ձ������
						DefaultTableModel model=(DefaultTableModel)table.getModel();
						int rows=table.getRowCount();
						for(int i=rows-1;i>=0;i--)
						{
							model.removeRow(i);
						}
						pzslField.setText("0");
						hpzsField.setText("0");
						hjjeField.setText("0.0");
					}
				}
					});
		}
		return xsButton;
	}
	
	
	
	/*
	 * �����壬��������
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
			String[] columnName={ "��Ʒ����", "��Ʒ���", "��Ӧ��", "����", "��λ", "���", "����", "����", "��װ", "����", "��׼�ĺ�" };
			table=new JTable();
			table.setShowGrid(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    //�ر��Զ�����ģʽ
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			
			//�������
			((DefaultTableModel)table.getModel()).setColumnIdentifiers(columnName);
			
			
			
			//������Ԫ�༭��
			DefaultCellEditor editor=new DefaultCellEditor(this.getSpcomBox());
			//������Ʒ�����еı༭��Ϊ�����б��
			TableColumn column=table.getColumnModel().getColumn(0);
			column.setCellEditor(editor);
			
			
			//���ʵʱ���»�Ʒ������Ʒ���������ϼƽ���ı���ļ����
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
	
	
	//��Ʒ�����б��spComboBox
	private JComboBox getSpcomBox()
	{
		if(spComboBox==null)
		{
			spComboBox=new JComboBox();
			spComboBox.addItem(new TbSpinfo());
			
			//��Ӽ����
			spComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					ResultSet rs=Dao.query("select * from tb_spinfo where id in (select id from kucun where kcsl>0)");
					//������Ʒ�����б��
					updateSpcomboBox(rs);
				}
					});
			
			//��Ӽ���������µ�ǰ�е�����
			spComboBox.addItemListener(new ItemListener()
					{
				public void itemStateChanged(ItemEvent e)
				{
					TbSpinfo spinfo=(TbSpinfo)spComboBox.getSelectedItem();
					if(spinfo!=null && spinfo.getId()!=null && !spinfo.getId().isEmpty())
					{
						updateTable();
					}
				}
					});	
		}
		return spComboBox;
	}
	
	
	
	//������Ʒ�����б�򷽷�
	private void updateSpcomboBox(ResultSet rs)
	{
		//ÿ�θ���ʱ������������б��
		spComboBox.removeAll();
		List<String> lst=new ArrayList<>();
		for(int i=0;table!=null && i<table.getRowCount();i++)
		{
			TbSpinfo info=(TbSpinfo)table.getValueAt(i, 0);
			if(info!=null && info.getId()!=null)
			{
				lst.add(info.getId());
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
			spinfo.setId(id);    //��Ʒ���
			spinfo.setSpname(rs.getString("spname").trim());    //��Ʒ����
			spinfo.setJc(rs.getString("jc").trim());    //���
			spinfo.setCd(rs.getString("cd").trim());    //����
			spinfo.setDw(rs.getString("dw").trim());    //��λ
			spinfo.setGg(rs.getString("gg").trim());    //���
			spinfo.setBz(rs.getString("bz").trim());    //��װ
			spinfo.setPh(rs.getString("ph").trim());    //����
			spinfo.setPzwh(rs.getString("pzwh").trim());    //��׼�ĺ�
			spinfo.setMemo(rs.getString("meno").trim());    //��ע
			spinfo.setGysname(rs.getString("gysname").trim());    //��Ӧ������
			spComboBox.addItem(spinfo);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//��ѡ����Ʒʱ�����±��ĵ�ǰ�з���
	private synchronized void updateTable()
	{
		TbSpinfo sp=(TbSpinfo)spComboBox.getSelectedItem();
		
		int row=table.getSelectedRow();
		Item item=new Item();
		item.setId(sp.getId());
		TbKucun kucun=Dao.getKucun(item);
		if(row>=0)
		{
			table.setValueAt(sp.getId(), row, 1);
			table.setValueAt(sp.getGysname(), row, 2);
			table.setValueAt(sp.getCd(), row, 3);
			table.setValueAt(sp.getDw(), row, 4);
			table.setValueAt(sp.getGg(), row, 5);
			table.setValueAt(kucun.getDj()+"", row, 6);    //����ʱ����͵���
			table.setValueAt(kucun.getKcsl()+"", row, 7);    //����ʱ�����п������
			table.setValueAt(sp.getBz(), row, 8);
			table.setValueAt(sp.getPh(), row, 9);
			table.setValueAt(sp.getPzwh(), row, 10);
			table.editCellAt(row, 6);
		}
	}
	
	
	
	
	
	//ʵʱ����Ʒ����������Ʒ�������ϼƽ��ķ���
	private void computeInfos()
	{
		int pzsl=0;    //Ʒ������
		int hpzs=0;    //��Ʒ����
		Double hjje=0.0;    //�ϼƽ��
		
		int row=table.getRowCount();
		TbSpinfo sp=null;
		Object info=table.getValueAt(row-1, 0);
		//���Ϊnull����ֱ�ӷ���
		if(!(info instanceof TbSpinfo))
		{
			return;
		}
		
		sp=(TbSpinfo)info;
		if(row>0 && (sp.getId()==null || sp.getId().isEmpty()))
		{
			row--;
		}
		
		for(int i=0;i<row;i++)
		{
			String djStr=(String)table.getValueAt(i, 6);
			String slStr=(String)table.getValueAt(i, 7);
			
			Double dj=Double.valueOf(djStr);
			Integer sl=Integer.valueOf(slStr);
			
			hpzs+=sl;
			hjje+=(dj*sl);
		}
		
		pzslField.setText(row+"");
		hpzsField.setText(hpzs+"");
		hjjeField.setText(String.valueOf(hjje));	
	}
	
	
	//��տ���
	private synchronized void clearEmptyRow()
	{
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		for(int i=0;i<table.getRowCount();i++)
		{
			TbSpinfo info=(TbSpinfo)table.getValueAt(i, 0);
			if(info==null || info.getId()==null || info.getId().isEmpty())
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

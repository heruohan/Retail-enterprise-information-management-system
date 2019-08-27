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
	 * ��Ʒ�޸ĺ�ɾ�����ĸ��������
	 */
	private JTextField spnameField=null;    //��Ʒ�����ı���
	private JTextField jcField=null;     //����ı���
	private JTextField cdField=null;    //�����ı���
	private JTextField dwField=null;    //��λ�ı���
	private JTextField ggField=null;    //����ı���
	private JTextField bzField=null;    //��װ�ı���
	private JTextField phField=null;    //�����ı���
	private JTextField pzwhField=null;    //��׼�ĺ��ı���
	private JComboBox gysComboBox=null;    //��Ӧ�������ı���
	private JTextField memoField=null;    //��ע�ı���
	private JComboBox spComboBox=null;    //��Ʒ�����б��
	
	private JButton xgButton=null;    //�޸İ�ť
	private JButton delButton=null;    //ɾ����ť
	
	
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
	
	
	
	//���캯��
	public ShangPinXiuGaiPanel()
	{
		init();
	}
	
	
	//��ʼ����Ʒ�޸ĺ�ɾ���ڲ�����
	private void init()
	{
		this.setLayout(new GridBagLayout());
		//this.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		//������
		//��Ʒ����
		JLabel spnameLabel=new JLabel("��Ʒ���ƣ�");
		this.setupComboBox(spnameLabel, 0, 0, 1, 0, false);
		
		
		spnameField=new JTextField();
		spnameField.setEditable(false);
		spnameField.setPreferredSize(new Dimension(490,21));
		this.setupComboBox(spnameField, 1, 0, 3, 0, true);
		
		//���
		JLabel jcLabel=new JLabel("��ƣ�");
		this.setupComboBox(jcLabel, 0, 1, 1, 0, false);
		
		jcField=new JTextField();
		this.setupComboBox(jcField, 1, 1, 3, 0, true);
		
		//����
		JLabel cdLabel=new JLabel("���أ�");
		this.setupComboBox(cdLabel, 0, 2, 1, 0, false);
		
		cdField=new JTextField();
		this.setupComboBox(cdField, 1, 2, 3, 0, true);
		
		//��λ
		JLabel dwLabel=new JLabel("��λ��");
		this.setupComboBox(dwLabel, 0, 3, 1, 0, false);
		
		dwField=new JTextField();
		dwField.setPreferredSize(new Dimension(240,21));
		this.setupComboBox(dwField, 1, 3, 1, 0, true);
		
		//���
		JLabel ggLabel=new JLabel("���");
		this.setupComboBox(ggLabel, 2, 3, 1, 0, false);
		
		ggField=new JTextField();
		//ggField.setPreferredSize(new Dimension(140,21));
		this.setupComboBox(ggField, 3, 3, 1, 0, true);
		
		//��װ
		JLabel bzLabel=new JLabel("��װ��");
		this.setupComboBox(bzLabel, 0, 4, 1, 0, false);
		
		bzField=new JTextField();
		this.setupComboBox(bzField, 1, 4, 1, 0, true);
		
		//����
		JLabel phLabel=new JLabel("���ţ�");
		this.setupComboBox(phLabel, 2, 4, 1, 0, false);
		
		phField=new JTextField();
		this.setupComboBox(phField, 3, 4, 1, 0, true);
		
		//��׼�ĺ�
		JLabel pzwhLabel=new JLabel("��׼�ĺţ�");
		this.setupComboBox(pzwhLabel, 0, 5, 1, 0, false);
		
		pzwhField=new JTextField();
		this.setupComboBox(pzwhField, 1, 5, 3, 0, true);
		
		//��Ӧ�������б��
		JLabel gysLabel=new JLabel("��Ӧ��ȫ�ƣ�");
		this.setupComboBox(gysLabel, 0, 6, 1, 0, false);
		
		this.setupComboBox(this.getGysComboBox(), 1, 6, 3, 0, true);
		
		//��ע
		JLabel memoLabel=new JLabel("��ע��");
		this.setupComboBox(memoLabel, 0, 7, 1, 0, false);
		
		memoField=new JTextField();
		this.setupComboBox(memoField, 1, 7, 3, 0, true);
		
		//ѡ����Ʒ
		JLabel spLabel=new JLabel("ѡ����Ʒ��");
		this.setupComboBox(spLabel, 0, 8, 1, 0, false);
		
		spComboBox=this.getSpComboBox();
		spComboBox.setPreferredSize(new Dimension(280,25));
		this.setupComboBox(this.getSpComboBox(), 1, 8, 2, 0, true);
		
		
		//�޸İ�ť��xgButton
		
		JPanel panel=new JPanel();
		FlowLayout layout=new FlowLayout();
		layout.setHgap(18);
		panel.setLayout(layout);
		panel.add(this.getXgButton());
		panel.add(this.getDelButton());
		
		this.setupComboBox(panel, 3, 8, 1, 0, true);
		
		//this.setupComboBox(this.getXgButton(), 2, 8, 1, 0, false);
		
		
		//ɾ����ť��delButton
		//this.setupComboBox(this.getDelButton(), 3, 8, 1, 0, false);
		
	}
	
	
	
	//���ò�������ķ���
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
	
	
	//��ʼ����Ʒ�����б��spComboBox
	private JComboBox getSpComboBox()
	{
		if(spComboBox==null)
		{
			spComboBox=new JComboBox();
			spComboBox.setMaximumRowCount(5);
			
			//��Ӽ����
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
	
	
	
	//��ʼ����Ӧ�������б��gysComboBox
	private JComboBox getGysComboBox()
	{
		if(gysComboBox==null)
		{
			gysComboBox=new JComboBox();
			gysComboBox.setMaximumRowCount(5);
		}
		return gysComboBox;
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
					Item item=(Item)spComboBox.getSelectedItem();
					if(item==null || item.getId()==null)
					{
						JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "����ȷ��д��Ʒ");
						return;
					}
					
					//�����ʱ��TbSpinfo��
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
						JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "�޸����");
						
					}
					else
					{
						JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "�޸�ʧ��");
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
					Item item=(Item)spComboBox.getSelectedItem();
					if(item==null || item.getId()==null || !(item instanceof Item))
					{
						return;
					}
					
					int confirm=JOptionPane.showConfirmDialog(ShangPinXiuGaiPanel.this, "ȷ��ɾ����Ʒ��");
					if(confirm==JOptionPane.YES_OPTION)
					{
						int res=Dao.delete("delete from tb_spinfo where id='" + item.getId() + "'");
						if(res>0)
						{
							JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this, "��Ʒ��" + item.getName() + ",ɾ���ɹ�");
							spComboBox.removeItem(item);
						}
					}
				}
					});
		}
		return delButton;
	}
	
	
	//������Ʒ�����б��ķ��������е���Ŀ��Item
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
		System.out.println("�δϴ�");
		
	}
	
	
	
	//���¹�Ӧ�������б��ķ���,���е�����Item
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
	
	
	//��ѡ������Ʒ�󣬸��¸����ı���͹�Ӧ�������б��ķ���
	private void updateAllField()
	{
		Object obj=spComboBox.getSelectedItem();
		if(!(obj instanceof Item))
		{
			return;
		}
		
		
		Item item=(Item)obj;    //��Ʒ����
		TbSpinfo spinfo=Dao.getSpinfo(item);
		//�ж�
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
			
			
			//���¹�Ӧ�������б��
			/*
			 * ��������Ʒ�������б���е�ѡ��ֵΪ��ǰֵʱ��һ��Ҫ��ֵ����Ϊ��ʹItem�����Զ���ͬ��
			 * ���ǵ�ַ����ͬ������Ϊ����һ�
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
			
			//���ù�Ӧ�������б���ѡ��ֵ
			gysComboBox.setSelectedItem(gysItem);
		}
		
	}
	

}

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
	 * �ڲ������ϵĸ��������
	 */
	private JLabel spnameLabel=null;    //��Ʒ���Ʊ�ǩ
	private JComboBox spComboBox=null;    //��Ʒ�����б��
	
	private JLabel ggLabel=null;    //����ǩ
	private JLabel ggField=null;    //�������
	
	private JLabel cdLabel=null;    //���ر�ǩ
	private JLabel cdField=null;    //��������
	
	private JLabel jcLabel=null;    //��Ʊ�ǩ
	private JLabel jcField=null;    //�������
	
	private JLabel bzLabel=null;    //��װ��ǩ
	private JLabel bzField=null;    //��װ����
	
	private JLabel dwLabel=null;    //��λ��ǩ
	private JLabel dwField=null;    //��λ����
	
	private JLabel djLabel=null;    //���۱�ǩ
	private JTextField djField=null;    //�����ı���
	
	private JLabel kcslLabel=null;    //���������ǩ
	private JTextField kcslField=null;    //��������ı���
	
	private JLabel kcjeLabel=null;    //������ǩ
	private JTextField kcjeField=null;    //������ı���
	
	private JButton qdButton=null;    //ȷ����ť
	private JButton gbButton=null;    //�رհ�ť
	
	private TbKucun kucuninfo;    //�����Ϣ��
	
	
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
	
	
	//���캯��
	public JiaGeTiaoZheng_IFrame()
	{
		init();
	}
	
	
	//��ʼ���۸�����ڲ�����
	private void init()
	{
		//���ڲ�������Ӽ�������������ڲ������ʱ��ͬ����ʼ����Ʒ�����б�������
		//�˼�������ڲ����弤�������setVisible����ִ�к���ִ�У�
		this.addInternalFrameListener(new InternalFrameAdapter()
				{
			public void internalFrameActivated(InternalFrameEvent e)
			{
				System.out.println(123);
				DefaultComboBoxModel model=(DefaultComboBoxModel)spComboBox.getModel();
				
				model.removeAllElements();
				List kucun=Dao.getKucunInfos();
				spComboBox.addItem("--��ѡ��--");
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
		
		
		//�ڲ����������
		this.setTitle("�۸����");
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setClosable(true);
		this.setBounds(50, 50, 570, 300);
		this.getContentPane().setLayout(new GridBagLayout());    //���ò��ֹ�����
		
		
		//�������
		//��Ʒ���ƣ�spnameLabel
		spnameLabel=new JLabel("��Ʒ���ƣ�");
		this.setupComponent(spnameLabel, 0, 0, 1, 0, false);
		this.setupComponent(this.getSpComboBox(), 1, 0, 1, 0, true);
		
		
		
		//����ǩ��ggLabel
		ggLabel=new JLabel("��    ��");
		this.setupComponent(ggLabel, 2, 0, 1, 0, false);
		this.setupComponent(this.getGgField(), 3, 0, 1, 0, false);
		
		
		//���ر�ǩ��cdLabel
		cdLabel=new JLabel("��    �أ�");
		this.setupComponent(cdLabel, 0, 1, 1, 0, false);
		this.setupComponent(this.getCdField(), 1, 1, 1, 0, false);
		
		
		//��Ʊ�ǩ��jcLabel
		jcLabel=new JLabel("��    �ƣ�");
		this.setupComponent(jcLabel, 2, 1, 1, 0, false);
		this.setupComponent(this.getJcField(), 3, 1, 1, 0, false);
		
		
		//��װ��ǩ��bzLabel
		bzLabel=new JLabel("��    װ��");
		this.setupComponent(bzLabel, 0, 2, 1, 0, false);
		this.setupComponent(this.getBzField(), 1, 2, 1, 0, false);
		
		
		//��λ��ǩ��dwLable
		dwLabel=new JLabel("��    λ��");
		this.setupComponent(dwLabel, 2, 2, 1, 0, false);
		this.setupComponent(this.getDwField(), 3, 2, 1, 0, false);
		
		
		//���۱�ǩ��djLabel
		djLabel=new JLabel("��    �ۣ�");
		this.setupComponent(djLabel, 0, 3, 1, 0, false);
		djField=this.getDjField();
		djField.setPreferredSize(new Dimension(180,24));
		this.setupComponent(this.getDjField(), 1, 3, 1, 0, false);
		
		
		//���������kcslLabel
		kcslLabel=new JLabel("���������");
		this.setupComponent(kcslLabel, 2, 3, 1, 0, false);
		kcslField=this.getKcslField();
		kcslField.setPreferredSize(new Dimension(150,24));
		this.setupComponent(this.getKcslField(), 3, 3, 1, 0, false);
		
		
		//������ǩ��kcjeLabel
		kcjeLabel=new JLabel("����");
		this.setupComponent(kcjeLabel, 0, 4, 1, 0, false);
		kcjeField=this.getKcjeField();
		kcjeField.setPreferredSize(new Dimension(180,24));
		this.setupComponent(this.getKcjeField(), 1, 4, 1, 0, false);
		
		
		//ȷ����ť��qdButton
		this.setupComponent(this.getQdButton(), 1, 5, 1, 0, false);
		
		//�رհ�ť��gbButton
		this.setupComponent(this.getGbButton(), 2, 5, 1, 0, false);
		
		
		
		
	}
	
	
	
	//����Ĳ���λ�÷���
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
	
	
	
	
	//��ʼ����Ʒ�����б��spComboBox
	private JComboBox getSpComboBox()
	{
		if(spComboBox==null)
		{
			spComboBox=new JComboBox();
			spComboBox.addItem("--��ѡ��--");
			
			//��Ӽ��������ѡ����Ʒʱ��ͬ����������ѡ��
			spComboBox.addItemListener(new ItemListener()
					{
				public void itemStateChanged(ItemEvent e)
				{
					Object obj=spComboBox.getSelectedItem();
					if(obj==null || obj.equals("--��ѡ��--"))
					{
						reStore();
						return;
					}
					
					Item item=(Item)obj;
					kucuninfo=Dao.getKucun(item);
					if(kucuninfo.getId()==null)    //��ִ��SQL���ʱ��id����Ϊ���ַ���""����������Ϊnull
					{
						reStore();
						return;
					}
					
					//ͬ�����������ı�������
					Double dj=kucuninfo.getDj();
					Integer kcsl=kucuninfo.getKcsl();
					
					ggField.setText(kucuninfo.getGg());    //���
					cdField.setText(kucuninfo.getCd());    //����
					jcField.setText(kucuninfo.getJc());    //���
					bzField.setText(kucuninfo.getBz());    //��װ
					dwField.setText(kucuninfo.getDw());    //��λ
					djField.setText(dj + "");    //����
					kcslField.setText(kcsl + "");    //�������
					kcjeField.setText((dj*kcsl) + "");    //�����
				}
					});
		}
		return spComboBox;
	}
	
	
	
	
	//��ѡ��"��ѡ��"��ʱ��������������Ϊ��
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
	
	
	//������ݣ�ggField
	private JLabel getGgField()
	{
		if(ggField==null)
		{
			ggField=new JLabel();
			ggField.setForeground(Color.BLUE);
		}
		return ggField;
	}
	
	
	//�������ݣ�cdField
	private JLabel getCdField()
	{
		if(cdField==null)
		{
			cdField=new JLabel();
			cdField.setForeground(Color.BLUE);
		}
		return cdField;
	}
	
	
	//������ݣ�jcField
	private JLabel getJcField()
	{
		if(jcField==null)
		{
			jcField=new JLabel();
			jcField.setForeground(Color.BLUE);
		}
		return  jcField;
	}
	
	
	//��װ���ݣ�bzField
	private JLabel getBzField()
	{
		if(bzField==null)
		{
			bzField=new JLabel();
			bzField.setForeground(Color.BLUE);
		}
		return bzField;
	}
	
	
	//��λ���ݣ�dwField
	private JLabel getDwField()
	{
		if(dwField==null)
		{
			dwField=new JLabel();
			dwField.setForeground(Color.BLUE);
		}
		return dwField;
	}
	
	
	//�����ı���djField
	private JTextField getDjField()
	{
		if(djField==null)
		{
			djField=new JTextField();
			
			//��Ӽ�������޸ĵ��ۺ�ͬ�����¿����
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
							JOptionPane.showMessageDialog(JiaGeTiaoZheng_IFrame.this, "������ȷ��ʽ�޸���Ʒ����");
						}
						return;
					}
				}
					});
			
		}
		return djField;
	}
	
	
	//��������ı���kcslField
	private JTextField getKcslField()
	{
		if(kcslField==null)
		{
			kcslField=new JTextField();
			kcslField.setEditable(false);
		}
		return kcslField;
	}
	
	
	//������ı���kcjeField
	private JTextField getKcjeField()
	{
		if(kcjeField==null)
		{
			kcjeField=new JTextField();
			kcjeField.setEditable(false);
		}
		return kcjeField;
	}
	
	
	
	//ȷ����ť��qdButton
	private JButton getQdButton()
	{
		if(qdButton==null)
		{
			qdButton=new JButton("ȷ��");
			
			//��Ӽ�������������ݿ�Ŀ����Ϣ
			qdButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					Object obj=spComboBox.getSelectedItem();
					if(obj==null || obj.equals("--��ѡ��--"))
					{
						JOptionPane.showMessageDialog(JiaGeTiaoZheng_IFrame.this, "��ѡ����Ʒ");
						return;
					}
					
					//���¿����Ϣ
					if(kucuninfo!=null || kucuninfo.getId()!=null)
					{
						kucuninfo.setDj(Double.valueOf(djField.getText()));    //���ÿ�浥��
						int rs=Dao.updateKuCunDj(kucuninfo);
						if(rs>0)    //����޸��˶��������е�����Ŀ
						{
							JOptionPane.showMessageDialog(JiaGeTiaoZheng_IFrame.this, "�۸�������", kucuninfo.getSpname() + "�۸����", JOptionPane.INFORMATION_MESSAGE);
							
						}
					}	
				}
					});
		}
		return qdButton;
	}
	
	
	
	//�رհ�ť��gbButton
	private JButton getGbButton()
	{
		if(gbButton==null)
		{
			gbButton=new JButton();
			gbButton.setText("�ر�");
			
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

package com.lzw.iframe;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import com.lzw.*;
import java.util.Date;
import java.util.Iterator;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.List;
import com.lzw.dao.*;
import com.lzw.*;
import com.lzw.dao.model.*;
import java.awt.*;


public class KuCunPanDian_IFrame extends JInternalFrame{
	
	/*
	 * 内部窗体上的所有组件
	 */
	private JLabel czyLabel=null;    //操作员标签
	private JTextField czyField=null;    //操作员文本框
	
	private JLabel pdsjLabel=null;    //盘点时间标签
	private JTextField pdsjField=null;    //盘点时间文本框
	
	private JLabel pzsLabel=null;    //品种数标签
	private JTextField pzsField=null;    //品种数文本框
	
	/*
	 * 表格及相关组件
	 */
	private JScrollPane tablePane=null;    //表格面板
	private JTable table=null;    //表格
	
	
	//盘点时间
	private Date pddate=new Date();
	
	
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		KuCunPanDian_IFrame inFrame=new KuCunPanDian_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	
	
	
	
	//构造函数
	public KuCunPanDian_IFrame()
	{
		init();
		
	}
	
	
	//初始化库存盘点内部窗体
	private void init()
	{
		this.setTitle("库存盘点");
		this.setMaximizable(true);    //最大化
		this.setIconifiable(true);    //图标化
		this.setClosable(true);    //可关闭
		this.setResizable(true);
		this.getContentPane().setLayout(new GridBagLayout());
		this.setBounds(50, 50, 600, 320);
		
		
		//操作员标签：czyLabel
		czyLabel=new JLabel("操作员：");
		this.setupComponent(czyLabel, 0, 0, 1, 0, false);
		czyField=this.getCzyField();
		czyField.setPreferredSize(new Dimension(100,20));
		this.setupComponent(this.getCzyField(), 1, 0, 1, 0, true);
		
		
		//盘点时间标签：pdsjLabel
		pdsjLabel=new JLabel("盘点时间：");
		this.setupComponent(pdsjLabel, 2, 0, 1, 0, false);
		pdsjField=this.getPdsjField();
        pdsjField.setPreferredSize(new Dimension(150,20));
		this.setupComponent(this.getPdsjField(), 3, 0, 1, 0, true);
		
		
		//品种数标签：pzsLabel
		pzsLabel=new JLabel("品种数：");
		this.setupComponent(pzsLabel, 4, 0, 1, 0, false);
		this.setupComponent(this.getPzsField(), 5, 0, 1, 0, true);
		
		
		
		//表格面板及相关组件：tablePane
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(570,240));
		this.setupComponent(this.getTablePane(), 0, 1, 6, 0, true);
		
	}
	
	
	
	//设置内部窗体的布局管理器
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
	
	
	//初始化操作员文本框：czyField
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
	
	
	//初始化盘点时间文本框：pdsjField
	private JTextField getPdsjField()
	{
		if(pdsjField==null)
		{
			pdsjField=new JTextField();
			pdsjField.setEditable(false);
			String s=String.format("%1$tF %1$tT", pddate);
			pdsjField.setText(s);
		}
		return pdsjField;
	}
	
	
	//初始化品种数文本框：pzsField
	private JTextField getPzsField()
	{
		if(pzsField==null)
		{
			pzsField=new JTextField("0");
			pzsField.setEditable(false);
		}
		return pzsField;
	}
	
	
	
	/*
	 * 表格及相关组件
	 */
	//表格面板：tablePane
	private JScrollPane getTablePane()
	{
		if(tablePane==null)
		{
			tablePane=new JScrollPane();
			tablePane.setViewportView(this.getTable());
		}
		return tablePane;
	}
	
	
	
	//表格：table
	private JTable getTable()
	{
		if(table==null)
		{
			String[] columnName= { "商品名称", "商品编号", "供应商", "产地", "单位", "规格", "单价", "数量", "包装", "盘点数量", "损益数量" };
			table=new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setShowGrid(true);
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));    //设置表格的边界形状
			
			
			//添加表格列标题
			DefaultTableModel model=(DefaultTableModel)table.getModel();    //表格模型
			model.setColumnIdentifiers(columnName);
			
			
			//设置盘点数量列和其他列的编辑器
			final JTextField pdField=new JTextField(0);    //盘点列的编辑器
			pdField.setEditable(false);
			pdField.addKeyListener(new pdslListener(pdField));    //添加监控器
			
			
			final JTextField readOnlyField=new JTextField(0);
			readOnlyField.setEditable(false);
			
			
			//构造编辑器
			DefaultCellEditor pdEditor=new DefaultCellEditor(pdField);
			DefaultCellEditor readOnlyEditor=new DefaultCellEditor(readOnlyField);
			
			
			//设置表格中的所有列为只读模式
			for(int i=0;i<columnName.length;i++)
			{
				TableColumn column=table.getColumnModel().getColumn(i);
				column.setCellEditor(readOnlyEditor);
			}
			
			//覆盖盘点数量列的编辑器为pdEditor
			TableColumn pdColumn=table.getColumnModel().getColumn(9);
			pdColumn.setCellEditor(pdEditor);
			
			//初始化表格中的内容
			String pzs_str=pzsField.getText();
			int pzs=Integer.parseInt(pzs_str);    //初始品种数
			List kucun_List=Dao.getKucunInfos();
			for(int i=0;i<kucun_List.size();i++)
			{
				List tmp=(List)kucun_List.get(i);
				Item item=new Item();
				item.setId((String)tmp.get(0));
				item.setName((String)tmp.get(1));
				
				TbSpinfo sp=Dao.getSpinfo(item);    //获得相应的商品类
				
				//构造行数组
				String[] new_row=new String[columnName.length];
				if(sp!=null && sp.getId()!=null && !sp.getId().isEmpty())
				{
					new_row[0]=sp.getSpname();
					new_row[1]=sp.getId();
					new_row[2]=sp.getGysname();
					new_row[3]=sp.getCd();
					new_row[4]=sp.getDw();
					new_row[5]=sp.getGg();
					new_row[6]=(String)tmp.get(2);
					new_row[7]=(String)tmp.get(3);
					new_row[8]=sp.getBz();
					new_row[9]="";
					new_row[10]="";
					model.addRow(new_row);
					
					//更新品种数量文本框
					pzs++;
				}
			}
			pzsField.setText(pzs+"");
		}
		return table;
	}
	
	
	
	/*
	 * 实现了KeyListener接口的成员内部类pdslListener,
	 * 其目的是当表格中输入盘点数量时，实时计算损益数量，
	 * 其中，损益数量=库存数量-盘点数量
	 */
	
	
	/*
	 * KeyListener中的方法一般执行的顺序是：KeyPressed,KeyTyped,KeyReleased
	 */
	//成员内部类pdslListener
	class pdslListener implements KeyListener
	{
		private final JTextField pdField;
		
		//构造函数，为了传递进另一个方法中的局部变量
		public pdslListener(JTextField field)
		{
			this.pdField=field;
		}
		
		public void keyTyped(KeyEvent e)
		{
			/*
			 * 判断每次输入的是不是数字和
			 * 删除键：(char)8
			 */
			if(("0123456789" + (char)8).indexOf((int)e.getKeyChar())<0)
			{
				e.consume();    //如果不是数字和删除键就不会在组件字段上显示
			}
			pdField.setEditable(true);
		}
		
		//实时更新损益数量
		public void keyReleased(KeyEvent e)
		{
			int row=table.getSelectedRow();
			String kucunSL_str=null;    //库存数量
			String pdSL_str=pdField.getText();    //盘点数量
			if(row>=0)
			{
				kucunSL_str=(String)table.getValueAt(row, 7);	
			}
			
			//当盘点数量为null时，转化会出现错误，并进行捕捉
			try
			{
				int pdSL=Integer.parseInt(pdSL_str);
				int kucunSL=Integer.parseInt(kucunSL_str);
				
				int sySL=kucunSL-pdSL;
				if(row>=0)
				{
					table.setValueAt(sySL, row, 10);
				}
				
			}
			catch(Exception e1)
			{
				if(e.getKeyChar()!=8)    //如果输入的字符不是删除键
				{
					pdField.setEditable(false);
				}
				
				pdField.setText("");
			}
		}
		
		
		public void keyPressed(KeyEvent e)
		{
			
		}
	}

}

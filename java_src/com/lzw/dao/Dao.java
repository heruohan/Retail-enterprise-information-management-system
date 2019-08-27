package com.lzw.dao;

import java.sql.*;
import java.sql.Date;
import com.lzw.dao.model.*;
import com.lzw.Item;
import java.util.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.io.*;


public class Dao {
	
	//�������ݿ������������
	protected static String dbClassName="com.mysql.cj.jdbc.Driver";
	//�������ݿ�ķ���URL
	protected static String dbUrl="jdbc:mysql://localhost:3306/db_database28?serverTimezone=UTC";
	//����������ݿ���û���
	protected static String dbUser="root";
	//����������ݿ������
	protected static String dbPwd="465160";
	protected static String second=null;
	public static Connection conn;
	
	
	static    //��̬��ʼ��Dao��
	{
		try
		{
			if(conn==null)
			{
				Class.forName(dbClassName).getDeclaredConstructor().newInstance();
				conn=DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�뽫MySQL��JDBC���������Ƶ�lib�ļ����С�");//�����쳣�󣬵�����ʾ��
			System.exit(-1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	//����˽�й��캯��,����������Dao���ʵ��������Ϊ���ж��Ǿ�̬����
	private Dao()
	{
		
	}
	
	
	
	//����ִ��sql��䣬����ResultSet���͵ķ���
	public static ResultSet findForResultSet(String sql)
	{
		if(conn==null)
			return null;
		long time=System.currentTimeMillis();
		ResultSet rs=null;
		try
		{
			Statement stmt=null;
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);
			second=((System.currentTimeMillis()-time)/1000D) + "";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	
	
	//ִ��sql��䣬���ز�ѯ��������ַ�����ά����
	public static List findForList(String sql)
	{
		List<List<String>> list=new ArrayList<>();    //������ά����
		ResultSet rs=findForResultSet(sql);    //���ز�ѯ�����
		
		try
		{
			ResultSetMetaData metadata=rs.getMetaData();
			int numberOfColumn=metadata.getColumnCount();    //��ý����������
			
			while(rs.next())
			{
				List<String> row=new ArrayList<>();
				for(int i=1;i<=numberOfColumn;i++)
				{
					String r=rs.getString(i);
					if(r!=null && !r.isEmpty())
						r=r.trim();
					row.add(r);
				}
				
				list.add(row);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	//�������
	public static boolean insert(String sql)
	{
		boolean result=false;
		
		try
		{
			Statement stmt=conn.createStatement();
			result=stmt.execute(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//��������
	public static int update(String sql)
	{
		int result=0;
		
		try
		{
			Statement stmt=conn.createStatement();
			result=stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	//��ȡ���������ID
	public static String getMainTypeTableMaxId(Date date,String table,String idChar,String idName)
	{
		String dateStr=date.toString().replace("-", "");
		String id=idChar + dateStr;
		
		String sql="select max(" + idName + ") from " + table + " where " + idName + " like '" + id + "%'";
		ResultSet rs=query(sql);
		
		String baseid=null;
		try
		{
			if(rs.next())
			{
				baseid=rs.getString(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		baseid = baseid==null ? "000" : baseid.substring(baseid.length()-3);
		int baseNum=Integer.parseInt(baseid)+1;
		id+=String.format("%03d", baseNum);
		
		return id;
		
	}
	
	
	
	
	//��ȡ���пͻ���Ϣ
	public static List getKhInfos()
	{
		List list=findForList("select id,khname from tb_khinfo");
		return list;
	}
	
	
	
	//��ȡ���й�Ӧ����Ϣ
	public static List getGysInfos()
	{
		List list=findForList("select id,name from tb_gysinfo");
		return list;
	}
	
	
	
	//��ȡ�ͻ���Ϣ,����TbKhinfo��
	public static TbKhinfo getKhInfo(Item item)
	{
		String where="khname='" + item.getName() + "'";
		if(item.getId()!=null)
			where="id='" + item.getId() + "'";
		TbKhinfo info=new TbKhinfo();
		ResultSet set=findForResultSet("select * from tb_khinfo where " + where);
		
		try
		{
			if(set.next())
			{
				info.setId(set.getString("id").trim());
				info.setKhname(set.getString("khname").trim());
				info.setJian(set.getString("jian").trim());
				info.setAddress(set.getString("address").trim());
				info.setBianma(set.getString("bianma").trim());
				info.setFax(set.getString("fax").trim());
				info.setHao(set.getString("hao").trim());
				info.setLian(set.getString("lian").trim());
				info.setLtel(set.getString("ltel").trim());
				info.setMail(set.getString("mail").trim());
				info.setTel(set.getString("tel").trim());
				info.setXinhang(set.getString("xinhang").trim());
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return info;
	}
	
	
	
	
	
	//���ݿⱸ�ݲ���
	public static String backup() throws SQLException
	{
		LinkedList<String> sqls=new LinkedList<>();    //�����ļ��е�����sql
		
		//��صı�������
		String[] tables= {"tb_gysinfo","tb_jsr","tb_khinfo","tb_kucun","tb_rkth_detail",
				         "tb_rkth_main","tb_ruku_detail","tb_ruku_main","tb_sell_detail",
				         "tb_sell_main","tb_spinfo","tb_userlist","tb_xsth_detail","tb_xsth_main"};
		
		
		//�����������б����ļ���
		ArrayList<Tables> tableList=new ArrayList<>();
		for(int i=0;i<tables.length;i++)
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("desc " + tables[i]);    //���ر����������
			
			ArrayList<Columns> columns=new ArrayList<>();
			while(rs.next())
			{
				Columns c=new Columns();
				c.setName(rs.getString("Field"));
				c.setType(rs.getString("Type"));
				String isNull=rs.getString("Null");
				if("YES".equals(isNull))
					c.setIsNull(true);    //��ΪĬ��ֵ��false�����Բ���Ҫ�ж�
				
				String isKey=rs.getString("Key");    //�ж��Ƿ�������
				if("PRI".equals(isKey))
				{
					c.setIsKey(true);    //�� ����
					String isIncrement=rs.getString("Extra");    //���������Ļ������ж��Ƿ����
					if("auto_increment".equals(isIncrement))
						c.setIsIncrement(true);
				}
				columns.add(c);	
			}
			
			
			Tables table=new Tables(tables[i],columns);    //ʵ���������
			tableList.add(table);    //���������뵽������
			rs.close();
			stmt.close();
		}
		
		
		//ѭ������󼯺�
		for(int i=0;i<tableList.size();i++)
		{
			Tables table=tableList.get(i);    //��ȡ�����
			
			String dropsql="drop table if exists " + table.getName() + ";";    //ɾ�����sql
			sqls.add(dropsql);
			
			
			//�������sql
			StringBuilder createsql=new StringBuilder();
			createsql.append("create table " + table.getName() + "(");    //������ͷsql
			
			ArrayList<Columns> columns=table.getColumns();
			for(int j=0;j<columns.size();j++)
			{
				Columns c=columns.get(j);
				createsql.append(c.getName() + " " + c.getType());
				if(!c.getIsNull())
					createsql.append(" NOT NULL ");
				
				if(c.getIsKey())
				{
					createsql.append("PRIMARY KEY ");
					if(c.getIsIncrement())
						createsql.append("AUTO_INCREMENT");
				}
				
				if(j<columns.size()-1)
					createsql.append(",");
				else
					createsql.append(");");
			}
			
			//����������
			sqls.add(createsql.toString());
			
			
			//��������sql���
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from " + table.getName()); //�õ�����������ݼ���
			
			while(rs.next())    //
			{
				StringBuilder insertsql=new StringBuilder();    //����ÿ�еĲ�����sql
				insertsql.append("insert into " + table.getName() + " values(");
				for(int j=0;i<columns.size();i++)    //ѭ����ǰ��ĵ�ǰ�е�������
				{
					Columns c=columns.get(j);    //��ȡ�ж���
					String type=c.getType();
					if(type.startsWith("char")  || type.startsWith("varchar")  || type.startsWith("datetime"))
					{
						insertsql.append("'" + rs.getString(c.getName()) + "'");
					}
					else
					{
						insertsql.append(rs.getString(c.getName()));
					}
					
					if(j<columns.size()-1)
					{
						insertsql.append(",");
					}
					else
					{
						insertsql.append(");");
					}
				}
				
				sqls.add(insertsql.toString());
			}
			
			rs.close();
			stmt.close();
		}
		
		
		//�����ͼ������
		//��ͼv_rukuView
		sqls.add("drop view if exists v_rukuView;");
		sqls.add("create view v_rukuView as select tb_ruku_main.rkID, tb_ruku_detail.spid, " + 
		         "tb_spinfo.spname, tb_spinfo.gg, tb_ruku_detail.dj, tb_ruku_detail.sl, " + 
				"tb_ruku_detail.dj*tb_ruku_detail.sl as je, tb_spinfo.gysname, tb_ruku_main.rkdate, " +
		         "tb_ruku_main.czy, tb_ruku_main.jsr, tb_ruku_main.jsfs from tb_ruku_detail inner join " +
				" tb_ruku_main on tb_ruku_detail.rkID = tb_ruku_main.rkID inner join tb_spinfo on " +
		         "tb_ruku_detail.spid = tb_spinfo.id;");
		
		
		
		//��ͼv_sellView
		sqls.add("drop view if exists v_sellView;");
		sqls.add("create view v_sellView as select tb_sell_main.sellID, tb_spinfo.spname, " +
		        "tb_sell_detail.spid, tb_spinfo.gg, tb_sell_detail.dj, tb_sell_detail.sl, " + 
				"tb_sell_detail.sl * tb_sell_detail.dj as je, tb_sell_main.khname, tb_sell_main.xsdate, " +
		        "tb_sell_main.czy, tb_sell_main.jsr, tb_sell_main.jsfs from tb_sell_detail inner join " +
				"tb_sell_main on tb_sell_detail.sellID = tb_sell_mian.sellID inner join tb_spinfo on " + 
		        "tb_sell_detail.spid = tb_spinfo.id;");
		
		
		
		//
		java.util.Date date=new java.util.Date();    //ͨ��Date�����ȡ��ǰʱ�����
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmss");
		String backupTime=sdf.format(date);
		//��ñ����ļ��Ĵ��·��
		String filePath="backup\\" + backupTime + ".sql";    //ǰ��û��\\��ʾ�ڵ�ǰĿ¼��
		
		File sqlFile=new File(filePath);
		
		//�ж��ļ��ĸ�Ŀ¼�Ƿ���ڣ��粻�����򴴽�
		File parent=sqlFile.getParentFile();
		if(!parent.exists())
		{
			parent.mkdirs();
		}
		
		FileOutputStream fos=null;
		OutputStreamWriter osw=null;
		BufferedWriter rw=null;
		
		try
		{
			//System.out.println(1);
			fos=new FileOutputStream(sqlFile);
			//System.out.println(2);
			osw=new OutputStreamWriter(fos);
			rw=new BufferedWriter(osw);
			for(String tmp : sqls)
			{
				try
				{
				rw.write(tmp);
				rw.newLine();
				rw.flush();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//�ر�rw��
			if(rw!=null)
			{
				try
				{
					rw.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			
			
			//�ر�osw��
			if(osw!=null)
			{
				try
				{
					osw.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			
			
			//�ر�fos��
			if(fos!=null)
			{
				try
				{
					fos.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			
			
		}
		
		return filePath;	
	}
	

	
	
	
	//���ݿ�Ļָ�����,��Ҫ��ͨ������ִ�б����ļ��е�SQL���ʵ��
	public static void restore(String filepath)
	{
		File sqlFile=new File(filepath);    //���������ļ�����
		Statement stmt=null;    //sql���ӿ�
		FileInputStream fis=null;    //�ļ������ֽ���
		InputStreamReader isr=null;    //�ֽ���ת��Ϊ�ַ���
		BufferedReader br=null;    //���������ַ���
		
		try
		{
			fis=new FileInputStream(sqlFile);
			isr=new InputStreamReader(fis);
			br=new BufferedReader(isr);
			
			String readStr=null;    //���汸���ļ��е�һ��sql���
			while((readStr=br.readLine())!=null)    //���ж�ȡ�����ļ��е�����
			{
				if(!"".equals(readStr.trim()))
				{
					stmt=conn.createStatement();
					stmt.executeUpdate(readStr);
					stmt.close();
				}
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//�ر�br��
			if(br!=null)
			{
				try
				{
					br.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			
			//�ر�isr��
			if(isr!=null)
			{
				try
				{
					isr.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			
			//�ر�fis��
			if(fis!=null)
			{
				try
				{
					fis.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}	
	}
	
	
	
	
	//��ȡָ����Ӧ����Ϣ������TbGysinfo��
	public static TbGysinfo getGysinfo(Item item)
	{
		String where="name=" + "'" + item.getName() + "'";
		if(item.getId()!=null)
		{
			where="id=" + "'" + item.getId() + "'";
		}
		
		TbGysinfo info=new TbGysinfo();
		ResultSet rs=findForResultSet("select * from tb_gysinfo where " + where);
		
		try
		{
			if(rs.next())
			{
				info.setId(rs.getString("id").trim());
				info.setName(rs.getString("name").trim());
				info.setJc(rs.getString("jc").trim());
				info.setAddress(rs.getString("address").trim());
				info.setBianma(rs.getString("bianma").trim());
				info.setTel(rs.getString("tel").trim());
				info.setFax(rs.getString("fax").trim());
				info.setLian(rs.getString("lian").trim());
				info.setLtel(rs.getString("ltel").trim());
				info.setYh(rs.getString("yh").trim());
				info.setMail(rs.getString("mail").trim());
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return info;
	}
	
	
	
	
	//��ȡ�û���Ϣ,����TbUserlist��
	public static TbUserlist getUserlist(String name,String password)
	{
		TbUserlist user=new TbUserlist();
		ResultSet rs=findForResultSet("select * from tb_userlist where name='" + name + "'");
		
		try
		{
			if(rs.next())
			{
				if(rs.getString("pass").equals(password))
				{
					user.setName(name);
					user.setPass(rs.getString("pass"));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return user;
	}
	
	
	
	
	//ִ��ָ����ѯ
	public static ResultSet query(String QueryStr)
	{
		ResultSet rs=findForResultSet(QueryStr);
		
		return rs;
	}
	
	
	
	//ִ��ɾ��
	public static int delete(String sql)
	{
		return update(sql);
	}
	
	
	
	//��ӿͻ���Ϣ����
	public static boolean addKeHu(TbKhinfo kehuinfo)
	{
		if(kehuinfo==null)
		{
			return false;
		}
		
		return insert("insert into tb_khinfo values('" + kehuinfo.getId() + "','" + 
		              kehuinfo.getKhname() + "','" + kehuinfo.getJian() + "','" + 
				      kehuinfo.getAddress() + "','" + kehuinfo.getBianma() + "','" + 
		              kehuinfo.getTel() + "','" + kehuinfo.getFax() + "','" + 
				      kehuinfo.getLian() + "','" + kehuinfo.getLtel() + "','" + 
		              kehuinfo.getMail() + "','" + kehuinfo.getXinhang() + "','" + 
				      kehuinfo.getHao() + "')");
	}
	
	
	
	//�޸Ŀͻ���Ϣ����
	public static int updateKeHu(TbKhinfo kehuinfo)
	{
		return update("update tb_khinfo set khname='" + kehuinfo.getKhname() + "'," +
	                   "jian='" + kehuinfo.getJian() +"'," + "address='" + kehuinfo.getAddress() +"'," +
	                   "bianma='" + kehuinfo.getBianma() +"'," + "tel='" +kehuinfo.getTel() +"'," +
	                   "fax='" + kehuinfo.getFax() +"'," + "lian='" +kehuinfo.getLian() +"'," +
	                   "ltel='" + kehuinfo.getLtel() +"'," + "mail='" + kehuinfo.getMail() + "'," +
	                   "xinhang='" +kehuinfo.getXinhang() + "'," + "hao='" +kehuinfo.getHao() +
	                   "' where id='" + kehuinfo.getId() + "'");
	}
	
	
	
	
	//�޸Ŀ����Ϣ����
	public static int updateKuCunDj(TbKucun kucun)
	{
		return update("update tb_kucun set dj='" + kucun.getDj() +
				      "' where id='" + kucun.getId() + "'");
	}
	
	
	
	//�޸Ĺ�Ӧ����Ϣ�ķ���
	public static int updateGys(TbGysinfo gysinfo)
	{
		return update("update tb_gysinfo set name='" + gysinfo.getName() + "'," +
	                  "jc='" +gysinfo.getJc() + "'," + "address='" + gysinfo.getAddress() + "'," +
				      "bianma='" + gysinfo.getBianma() + "'," + "tel='" + gysinfo.getTel() + "'," +
	                  "fax='" + gysinfo.getFax() + "'," + "lian='" + gysinfo.getLian() + "'," + 
				      "ltel='" + gysinfo.getLtel() + "'," + "yh='" + gysinfo.getYh() + "'," + 
	                  "mail='" + gysinfo.getMail() + "' where id='" + gysinfo.getId() + "'");
	}
	
	
	
	//��ӹ�Ӧ����Ϣ����
	public static boolean addGys(TbGysinfo gysinfo)
	{
		if(gysinfo==null)
			return false;
		
		return insert("insert into tb_gysinfo values('" + gysinfo.getId() + "','" +
		             gysinfo.getName() + "','" + gysinfo.getJc() + "','" + gysinfo.getAddress() + "','" +
				     gysinfo.getBianma() + "','" + gysinfo.getTel() + "','" + gysinfo.getFax() + "','" +
		             gysinfo.getLian() + "','" + gysinfo.getLtel() + "','" + gysinfo.getYh() + "','" + 
				     gysinfo.getMail() + "')");
	}
	
	
	//�����Ʒ
	public static boolean addSp(TbSpinfo spinfo)
	{
		if(spinfo==null)
			return false;
		
		return insert("insert into tb_spinfo values('" + spinfo.getId() + "','" + 
		             spinfo.getSpname() + "','" + spinfo.getJc() + "','" + spinfo.getCd() + "','" + 
				     spinfo.getDw() + "','" + spinfo.getGg() + "','" + spinfo.getBz() + "','" + 
		             spinfo.getPh() + "','" + spinfo.getPzwh() + "','" + spinfo.getMemo() + "','" + 
				     spinfo.getGysname() + "')");
	}
	
	
	
	
	//������Ʒ
	public static int updateSp(TbSpinfo spinfo)
	{
		return update("update tb_spinfo set spname='" + spinfo.getSpname() + 
	                 "',jc='" + spinfo.getJc() + "',cd='" + spinfo.getCd() + "',dw='" + spinfo.getDw() + 
	                 "',gg='" + spinfo.getGg() + "',Bz='" + spinfo.getBz() + "',ph='" + spinfo.getPh() + 
	                 "',pzwh='" + spinfo.getPzwh() + "',memo='" + spinfo.getMemo() + "',gysname='" + spinfo.getGysname() +
	                 "' where id='" + spinfo.getId() + "'");
	}
	
	
	
	//��ȡ��Ʒ��Ϣ
	public static TbSpinfo getSpinfo(Item item)
	{
		TbSpinfo info=new TbSpinfo();
		String where="spname='" + item.getName() + "'";
		if(item.getId()!=null)
			where="id='" + item.getId() + "'";
		
		ResultSet rs=findForResultSet("select * from tb_spinfo where " + where);
		
		try
		{
			if(rs.next())
			{
				info.setId(rs.getString("id").trim());
				info.setSpname(rs.getString("spname").trim());
				info.setJc(rs.getString("jc").trim());
				info.setCd(rs.getString("cd").trim());
				info.setDw(rs.getString("dw").trim());
				info.setGg(rs.getString("gg").trim());
				info.setBz(rs.getString("Bz").trim());
				info.setPh(rs.getString("ph").trim());
				info.setPzwh(rs.getString("pzwh").trim());
				info.setMemo(rs.getString("memo").trim());
				info.setGysname(rs.getString("gysname").trim());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return info;
	}
	
	
	
	//��ȡ������Ʒ��Ϣ
	public static List getSpinfos()
	{
		List list=findForList("select * from tb_spinfo");
		
		return list;
	}
	
	
	
	
	//��ȡ�����Ʒ����Ϣ
	public static TbKucun getKucun(Item item)
	{
		String where="spname='" + item.getName() + "'";
		if(item.getId()!=null)
			where="id='" + item.getId() + "'";
		
		TbKucun info=new TbKucun();
		ResultSet rs=findForResultSet("select * from tb_kucun where " + where);
		
		try
		{
			if(rs.next())
			{
				info.setId(rs.getString("id").trim());
				info.setSpname(rs.getString("spname").trim());
				info.setJc(rs.getString("jc").trim());
				info.setCd(rs.getString("cd").trim());
				info.setGg(rs.getString("gg").trim());
				info.setBz(rs.getString("bz").trim());
				info.setDw(rs.getString("dw").trim());
				info.setDj(rs.getDouble("dj"));
				info.setKcsl(rs.getInt("kcsl"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return info;
	}
	
	
	
	//��ȡ��ⵥ�����ID����������Ʊ��
	public static String getRuKuMainMaxId(Date date)
	{
		return getMainTypeTableMaxId(date,"tb_ruku_main","RK","rkID");
	}
	
	
	
	//����������������Ϣ
	public static boolean insertRuKuInfo(TbRukuMain ruMain)
	{
		try
		{
			boolean autoCommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			
			//��������ģ����ӵ����������
			insert("insert into tb_ruku_main values('" + ruMain.getRkId() + "','" + 
			       ruMain.getPzs() + "','" + ruMain.getJe() + "','" + ruMain.getYsjl() + "','" + 
					ruMain.getGysname() + "','" + ruMain.getRkdate() + "','" + ruMain.getCzy() + "','" + 
			       ruMain.getJsr() + "','" + ruMain.getJsfs() + "')");
			
			
			
			Set<TbRukuDetail> rkDetails=ruMain.getTabRukuDetails();
			for(Iterator<TbRukuDetail> iter = rkDetails.iterator();iter.hasNext();)
			{
				TbRukuDetail details=iter.next();
				
				//��������ӵ������ϸ����
				insert("insert into tb_ruku_detail values('" + ruMain.getRkId() + "','" + 
				      details.getTbSpinfo() + "','" + details.getDj() + "','" + details.getSl() + "')");
				
				
				//�޸Ŀ����Ϣ
				Item item=new Item();
				item.setId(details.getTbSpinfo());
				TbSpinfo spinfo=getSpinfo(item);
				
				if(spinfo.getId()!=null && !spinfo.getId().isEmpty())
				{
					TbKucun kucuninfo=getKucun(item);
					
					//��������û�д���Ʒ,������������
					if(kucuninfo.getId()==null || kucuninfo.getId().isEmpty())
					{
						insert("insert into tb_kucun values('" + spinfo.getId() + "','" + 
					          spinfo.getSpname() + "','" + spinfo.getJc() + "','" + spinfo.getCd() + "','" + 
								spinfo.getGg() + "','" + spinfo.getBz() + "','" + spinfo.getDw() + 
								"','" + details.getDj() + "','" + details.getSl() + "')");
						
					}
					else    //���������д�����Ʒ��������������
					{
						int newNum=kucuninfo.getKcsl() + details.getSl();
						update("update tb_kucun set kcsl='" + newNum + "',dj='" + details.getDj() +
								"' where id='" + kucuninfo.getId() + "'");
					}
				}
				
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	//��ȡ�˻����ID
	public static String getRkthMainMaxId(Date date)
	{
		return getMainTypeTableMaxId(date,"tb_rkth_main","RT","rkthID");
	}
	
	
	
	//���������������˻���Ϣ
	public static boolean insertRkthInfo(TbRkthMain rkthMain)
	{
		try
		{
			boolean autoCommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			//����������ӵ�����˻�������
			insert("insert into tb_rkth_main values('" + rkthMain.getRkthId() + "','" + 
			      rkthMain.getPzs() + "','" + rkthMain.getJe() + "','" + rkthMain.getYsjl() + "','" + 
					rkthMain.getGysname() + "','" + rkthMain.getRtdate() + "','" + rkthMain.getCzy() + "','" + 
			      rkthMain.getJsr() + "','" + rkthMain.getJsfs() + "')");
			
			
			
			Set<TbRkthDetail> rkthDetails=rkthMain.getTbRkthDetail();
			for(Iterator<TbRkthDetail> iterator=rkthDetails.iterator();iterator.hasNext();)
			{
				TbRkthDetail detail=iterator.next();
				
				//�����ݼ��뵽����˻���ϸ��Ϣ����
				insert("insert into tb_rkth_detail values('" + rkthMain.getRkthId() + "','" + 
				       detail.getSpid() + "','" + detail.getDj() + "','" + detail.getSl() + "')");
				
				
				//�޸Ŀ�����Ϣ
				Item item=new Item();
				item.setId(detail.getSpid());
				
				TbSpinfo spinfo=getSpinfo(item);
				if(spinfo.getId()!=null && !spinfo.getId().isEmpty())
				{
					//���������Ϣ
					TbKucun kucuninfo=getKucun(item);
					if(kucuninfo.getId()!=null && !kucuninfo.getId().isEmpty())
					{
						int newSl=kucuninfo.getKcsl()-detail.getSl();
						update("update tb_kucun set kcsl='" + newSl + "' where id='" + kucuninfo.getId() + "'");
					}
				}
				
			}
			
			conn.commit();
			conn.setAutoCommit(autoCommit);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	
	//��ȡ�����������ID
	public static String getSellMainMaxId(Date date)
	{
		return getMainTypeTableMaxId(date,"tb_sell_main","XS","sellID");
	}
	
	
	
	//�����������������Ϣ
	public static boolean insertSellInfo(TbSellMain sellMain)
	{
		try
		{
			boolean autoCommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			//��������Ϣ��ӵ�����������
			insert("insert into tb_sell_main values('" + sellMain.getSellId() + "','" + 
			       sellMain.getPzs() + "','" + sellMain.getJe() + "','" + sellMain.getYsjl() + "','" + 
					sellMain.getKhname() + "','" + sellMain.getXsdate() + "','" + sellMain.getCzy() +
					"','" + sellMain.getJsr() + "','" + sellMain.getJsfs() + "')");
			
			
			Set<TbSellDetail> selldetails=sellMain.getTbSellDetails();
			for(Iterator<TbSellDetail> iterator=selldetails.iterator();iterator.hasNext();)
			{
				TbSellDetail detail=iterator.next();
				//��������ϸ��Ϣ��ӵ�������ϸ����
				insert("insert into tb_sell_detail values('" + sellMain.getSellId() + "','" + 
				       detail.getSpid() + "','" + detail.getDj() + "','" + detail.getSl() + "')");
				
				
				//�޸Ŀ����Ϣ
				Item item=new Item();
				item.setId(detail.getSpid());
				TbSpinfo info=getSpinfo(item);
				if(info.getId()!=null && !info.getId().isEmpty())
				{
					TbKucun kucuninfo=getKucun(item);
					if(kucuninfo.getId()!=null && !kucuninfo.getId().isEmpty())
					{
						int newNum=kucuninfo.getKcsl()-detail.getSl();
						update("update tb_kucun set kcsl='" + newNum + "' where id='" + kucuninfo.getId() + "'");
						
					}
				}
				
			}
			
			conn.commit();
			conn.setAutoCommit(autoCommit);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	
	//��ȡ��������˻����
	public static String getXsthMainMaxId(Date date)
	{
		return getMainTypeTableMaxId(date,"tb_xsth_main","XT","xsthID");
	}
	
	
	//��ȡ���п����Ϣ
	public static List getKucunInfos()
	{
		List list=findForList("select id,spname,dj,kcsl from tb_kucun");
		return list;
	}
	
	
	//����������������˻���Ϣ
	public static boolean insertXsthInfo(TbXsthMain xsthMain)
	{
		try
		{
			boolean autoCommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			//�������˻���Ϣ���뵽�����˻�������
			insert("insert into tb_xsth_main values('" + xsthMain.getXsthId() + "','" + 
			      xsthMain.getPzs() + "','" + xsthMain.getJe() + "','" + xsthMain.getYsjl() + "','" + 
					xsthMain.getKhname() + "','" + xsthMain.getThdate() + "','" + xsthMain.getCzy() + "','" + 
			      xsthMain.getJsr() + "','" + xsthMain.getJsfs() + "')");
			
			
			Set<TbXsthDetail> xsthdetails=xsthMain.getTbXsthDetails();
			for(Iterator<TbXsthDetail> iterator=xsthdetails.iterator();iterator.hasNext();)
			{
				TbXsthDetail detail=iterator.next();
				
				//����Ϣ��ӵ������˻���ϸ����
				insert("insert into tb_xsth_detail values('" + xsthMain.getXsthId() + "','" +
				      detail.getSpid() + "','" + detail.getDj() + "','" + detail.getSl() + "')");
				
				
				//�޸Ŀ����Ϣ
				Item item=new Item();
				item.setId(detail.getSpid());
				TbSpinfo info=getSpinfo(item);
				if(info.getId()!=null && !info.getId().isEmpty())
				{
					TbKucun kucuninfo=getKucun(item);
					if(kucuninfo.getId()!=null && !kucuninfo.getId().isEmpty())
					{
						int newNum=kucuninfo.getKcsl()+detail.getSl();
						update("update tb_kucun set kcsl='" + newNum + "' where id='" + kucuninfo.getId() + "'");
					}
				}
			}
			
			conn.commit();
			conn.setAutoCommit(autoCommit);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	//��Ӿ�����
	public static int addJsr(TbJsr jsr)
	{
		String sql="insert into tb_jsr values(" + null + ",'" + jsr.getName() + "','" + jsr.getSex() + "','" +
	                jsr.getAge() + "','" + jsr.getTel() + "',1)";
		
		System.out.println(sql);
		return update(sql);
	}
	
	
	//��ȡ���о�������Ϣ
	public static List getJsrs()
	{
		List list=findForList("select * from tb_jsr where enable=1");
		return list;
	}
	
	
	//�޸��û�����
	public static int modifyPassword(String oldPass,String pass)
	{
		return update("update tb_userlist set pass='" + pass + "' where pass='" + oldPass + "'");
	}
	
	
	//��ȡ�����˶��󣬷���TbJsr��
	public static TbJsr getJsr(Item item)
	{
		String where="name='" + item.getName() + "'";
		if(item.getId()!=null)
			where="id='" + item.getId() + "'";
		
		ResultSet rs=findForResultSet("select * from tb_jsr where " + where);
		TbJsr jsr=new TbJsr();
		
		try
		{
			if(rs.next())
			{
				jsr.setName(rs.getString("name").trim());
				jsr.setSex(rs.getString("sex").trim());
				jsr.setAge(rs.getString("age").trim());
				jsr.setTel(rs.getString("tel").trim());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return jsr;
	}
	
	
	//��֤��¼
	public static boolean checkLogin(String userStr,String passStr) throws SQLException
	{
		ResultSet rs=findForResultSet("select * from tb_userlist where name='" + userStr + "' and pass='" + passStr + "'");
		if(rs==null)
			return false;
		return rs.next();	
	}	
}
 
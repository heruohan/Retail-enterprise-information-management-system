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
	
	//定义数据库驱动类的名称
	protected static String dbClassName="com.mysql.cj.jdbc.Driver";
	//定义数据库的访问URL
	protected static String dbUrl="jdbc:mysql://localhost:3306/db_database28?serverTimezone=UTC";
	//定义访问数据库的用户名
	protected static String dbUser="root";
	//定义访问数据库的密码
	protected static String dbPwd="465160";
	protected static String second=null;
	public static Connection conn;
	
	
	static    //静态初始化Dao类
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
			JOptionPane.showMessageDialog(null, "请将MySQL的JDBC驱动包复制到lib文件夹中。");//捕获异常后，弹出提示框
			System.exit(-1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	//创建私有构造函数,即不允许创建Dao类的实例对象，因为类中都是静态方法
	private Dao()
	{
		
	}
	
	
	
	//创建执行sql语句，返回ResultSet类型的方法
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
	
	
	
	
	//执行sql语句，返回查询结果集的字符串二维数组
	public static List findForList(String sql)
	{
		List<List<String>> list=new ArrayList<>();    //创建二维数组
		ResultSet rs=findForResultSet(sql);    //返回查询结果集
		
		try
		{
			ResultSetMetaData metadata=rs.getMetaData();
			int numberOfColumn=metadata.getColumnCount();    //获得结果集的列数
			
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
	
	
	
	//添加数据
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
	
	
	//更新数据
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
	
	
	
	//获取类主表最大ID
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
	
	
	
	
	//读取所有客户信息
	public static List getKhInfos()
	{
		List list=findForList("select id,khname from tb_khinfo");
		return list;
	}
	
	
	
	//读取所有供应商信息
	public static List getGysInfos()
	{
		List list=findForList("select id,name from tb_gysinfo");
		return list;
	}
	
	
	
	//读取客户信息,返回TbKhinfo类
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
	
	
	
	
	
	//数据库备份操作
	public static String backup() throws SQLException
	{
		LinkedList<String> sqls=new LinkedList<>();    //备份文件中的所有sql
		
		//相关的表名数组
		String[] tables= {"tb_gysinfo","tb_jsr","tb_khinfo","tb_kucun","tb_rkth_detail",
				         "tb_rkth_main","tb_ruku_detail","tb_ruku_main","tb_sell_detail",
				         "tb_sell_main","tb_spinfo","tb_userlist","tb_xsth_detail","tb_xsth_main"};
		
		
		//创建保存所有表对象的集合
		ArrayList<Tables> tableList=new ArrayList<>();
		for(int i=0;i<tables.length;i++)
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("desc " + tables[i]);    //返回表描述结果集
			
			ArrayList<Columns> columns=new ArrayList<>();
			while(rs.next())
			{
				Columns c=new Columns();
				c.setName(rs.getString("Field"));
				c.setType(rs.getString("Type"));
				String isNull=rs.getString("Null");
				if("YES".equals(isNull))
					c.setIsNull(true);    //因为默认值是false，所以不需要判断
				
				String isKey=rs.getString("Key");    //判断是否是主键
				if("PRI".equals(isKey))
				{
					c.setIsKey(true);    //是 主键
					String isIncrement=rs.getString("Extra");    //在是主键的基础上判断是否递增
					if("auto_increment".equals(isIncrement))
						c.setIsIncrement(true);
				}
				columns.add(c);	
			}
			
			
			Tables table=new Tables(tables[i],columns);    //实例化表对象
			tableList.add(table);    //将表对象加入到表集合中
			rs.close();
			stmt.close();
		}
		
		
		//循环表对象集合
		for(int i=0;i<tableList.size();i++)
		{
			Tables table=tableList.get(i);    //获取表对象
			
			String dropsql="drop table if exists " + table.getName() + ";";    //删除表的sql
			sqls.add(dropsql);
			
			
			//创建表的sql
			StringBuilder createsql=new StringBuilder();
			createsql.append("create table " + table.getName() + "(");    //创建表头sql
			
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
			
			//加入表创建语句
			sqls.add(createsql.toString());
			
			
			//创建插入sql语句
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from " + table.getName()); //得到表的所有数据集合
			
			while(rs.next())    //
			{
				StringBuilder insertsql=new StringBuilder();    //创建每行的插入语sql
				insertsql.append("insert into " + table.getName() + " values(");
				for(int j=0;i<columns.size();i++)    //循环当前表的当前行的所有列
				{
					Columns c=columns.get(j);    //获取列对象
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
		
		
		//添加视图相关语句
		//视图v_rukuView
		sqls.add("drop view if exists v_rukuView;");
		sqls.add("create view v_rukuView as select tb_ruku_main.rkID, tb_ruku_detail.spid, " + 
		         "tb_spinfo.spname, tb_spinfo.gg, tb_ruku_detail.dj, tb_ruku_detail.sl, " + 
				"tb_ruku_detail.dj*tb_ruku_detail.sl as je, tb_spinfo.gysname, tb_ruku_main.rkdate, " +
		         "tb_ruku_main.czy, tb_ruku_main.jsr, tb_ruku_main.jsfs from tb_ruku_detail inner join " +
				" tb_ruku_main on tb_ruku_detail.rkID = tb_ruku_main.rkID inner join tb_spinfo on " +
		         "tb_ruku_detail.spid = tb_spinfo.id;");
		
		
		
		//视图v_sellView
		sqls.add("drop view if exists v_sellView;");
		sqls.add("create view v_sellView as select tb_sell_main.sellID, tb_spinfo.spname, " +
		        "tb_sell_detail.spid, tb_spinfo.gg, tb_sell_detail.dj, tb_sell_detail.sl, " + 
				"tb_sell_detail.sl * tb_sell_detail.dj as je, tb_sell_main.khname, tb_sell_main.xsdate, " +
		        "tb_sell_main.czy, tb_sell_main.jsr, tb_sell_main.jsfs from tb_sell_detail inner join " +
				"tb_sell_main on tb_sell_detail.sellID = tb_sell_mian.sellID inner join tb_spinfo on " + 
		        "tb_sell_detail.spid = tb_spinfo.id;");
		
		
		
		//
		java.util.Date date=new java.util.Date();    //通过Date对象获取当前时间对象
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmss");
		String backupTime=sdf.format(date);
		//获得备份文件的存放路径
		String filePath="backup\\" + backupTime + ".sql";    //前面没有\\表示在当前目录下
		
		File sqlFile=new File(filePath);
		
		//判断文件的父目录是否存在，如不存在则创建
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
			//关闭rw流
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
			
			
			//关闭osw流
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
			
			
			//关闭fos流
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
	

	
	
	
	//数据库的恢复操作,主要是通过逐行执行备份文件中的SQL语句实现
	public static void restore(String filepath)
	{
		File sqlFile=new File(filepath);    //创建备份文件对象
		Statement stmt=null;    //sql语句接口
		FileInputStream fis=null;    //文件输入字节流
		InputStreamReader isr=null;    //字节流转化为字符流
		BufferedReader br=null;    //缓存输入字符流
		
		try
		{
			fis=new FileInputStream(sqlFile);
			isr=new InputStreamReader(fis);
			br=new BufferedReader(isr);
			
			String readStr=null;    //保存备份文件中的一行sql语句
			while((readStr=br.readLine())!=null)    //逐行读取备份文件中的内容
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
			//关闭br流
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
			
			
			//关闭isr流
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
			
			
			//关闭fis流
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
	
	
	
	
	//读取指定供应商信息，返回TbGysinfo类
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
	
	
	
	
	//读取用户信息,返回TbUserlist类
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
	
	
	
	
	//执行指定查询
	public static ResultSet query(String QueryStr)
	{
		ResultSet rs=findForResultSet(QueryStr);
		
		return rs;
	}
	
	
	
	//执行删除
	public static int delete(String sql)
	{
		return update(sql);
	}
	
	
	
	//添加客户信息方法
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
	
	
	
	//修改客户信息方法
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
	
	
	
	
	//修改库存信息方法
	public static int updateKuCunDj(TbKucun kucun)
	{
		return update("update tb_kucun set dj='" + kucun.getDj() +
				      "' where id='" + kucun.getId() + "'");
	}
	
	
	
	//修改供应商信息的方法
	public static int updateGys(TbGysinfo gysinfo)
	{
		return update("update tb_gysinfo set name='" + gysinfo.getName() + "'," +
	                  "jc='" +gysinfo.getJc() + "'," + "address='" + gysinfo.getAddress() + "'," +
				      "bianma='" + gysinfo.getBianma() + "'," + "tel='" + gysinfo.getTel() + "'," +
	                  "fax='" + gysinfo.getFax() + "'," + "lian='" + gysinfo.getLian() + "'," + 
				      "ltel='" + gysinfo.getLtel() + "'," + "yh='" + gysinfo.getYh() + "'," + 
	                  "mail='" + gysinfo.getMail() + "' where id='" + gysinfo.getId() + "'");
	}
	
	
	
	//添加供应商信息方法
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
	
	
	//添加商品
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
	
	
	
	
	//更新商品
	public static int updateSp(TbSpinfo spinfo)
	{
		return update("update tb_spinfo set spname='" + spinfo.getSpname() + 
	                 "',jc='" + spinfo.getJc() + "',cd='" + spinfo.getCd() + "',dw='" + spinfo.getDw() + 
	                 "',gg='" + spinfo.getGg() + "',Bz='" + spinfo.getBz() + "',ph='" + spinfo.getPh() + 
	                 "',pzwh='" + spinfo.getPzwh() + "',memo='" + spinfo.getMemo() + "',gysname='" + spinfo.getGysname() +
	                 "' where id='" + spinfo.getId() + "'");
	}
	
	
	
	//读取商品信息
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
	
	
	
	//获取所有商品信息
	public static List getSpinfos()
	{
		List list=findForList("select * from tb_spinfo");
		
		return list;
	}
	
	
	
	
	//获取库存商品的信息
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
	
	
	
	//获取入库单的最大ID，即最大入库票号
	public static String getRuKuMainMaxId(Date date)
	{
		return getMainTypeTableMaxId(date,"tb_ruku_main","RK","rkID");
	}
	
	
	
	//在事物中添加入库信息
	public static boolean insertRuKuInfo(TbRukuMain ruMain)
	{
		try
		{
			boolean autoCommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			
			//将此数据模型添加到入库主表中
			insert("insert into tb_ruku_main values('" + ruMain.getRkId() + "','" + 
			       ruMain.getPzs() + "','" + ruMain.getJe() + "','" + ruMain.getYsjl() + "','" + 
					ruMain.getGysname() + "','" + ruMain.getRkdate() + "','" + ruMain.getCzy() + "','" + 
			       ruMain.getJsr() + "','" + ruMain.getJsfs() + "')");
			
			
			
			Set<TbRukuDetail> rkDetails=ruMain.getTabRukuDetails();
			for(Iterator<TbRukuDetail> iter = rkDetails.iterator();iter.hasNext();)
			{
				TbRukuDetail details=iter.next();
				
				//将数据添加到入库详细表中
				insert("insert into tb_ruku_detail values('" + ruMain.getRkId() + "','" + 
				      details.getTbSpinfo() + "','" + details.getDj() + "','" + details.getSl() + "')");
				
				
				//修改库存信息
				Item item=new Item();
				item.setId(details.getTbSpinfo());
				TbSpinfo spinfo=getSpinfo(item);
				
				if(spinfo.getId()!=null && !spinfo.getId().isEmpty())
				{
					TbKucun kucuninfo=getKucun(item);
					
					//如果库存中没有此商品,则将其加入库存表中
					if(kucuninfo.getId()==null || kucuninfo.getId().isEmpty())
					{
						insert("insert into tb_kucun values('" + spinfo.getId() + "','" + 
					          spinfo.getSpname() + "','" + spinfo.getJc() + "','" + spinfo.getCd() + "','" + 
								spinfo.getGg() + "','" + spinfo.getBz() + "','" + spinfo.getDw() + 
								"','" + details.getDj() + "','" + details.getSl() + "')");
						
					}
					else    //如果库存中有此种商品，则将其数量增加
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
	
	
	
	//获取退货最大ID
	public static String getRkthMainMaxId(Date date)
	{
		return getMainTypeTableMaxId(date,"tb_rkth_main","RT","rkthID");
	}
	
	
	
	//在事物中添加入库退货信息
	public static boolean insertRkthInfo(TbRkthMain rkthMain)
	{
		try
		{
			boolean autoCommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			//将此数据添加到入库退货主表中
			insert("insert into tb_rkth_main values('" + rkthMain.getRkthId() + "','" + 
			      rkthMain.getPzs() + "','" + rkthMain.getJe() + "','" + rkthMain.getYsjl() + "','" + 
					rkthMain.getGysname() + "','" + rkthMain.getRtdate() + "','" + rkthMain.getCzy() + "','" + 
			      rkthMain.getJsr() + "','" + rkthMain.getJsfs() + "')");
			
			
			
			Set<TbRkthDetail> rkthDetails=rkthMain.getTbRkthDetail();
			for(Iterator<TbRkthDetail> iterator=rkthDetails.iterator();iterator.hasNext();)
			{
				TbRkthDetail detail=iterator.next();
				
				//将数据加入到入库退货详细信息表中
				insert("insert into tb_rkth_detail values('" + rkthMain.getRkthId() + "','" + 
				       detail.getSpid() + "','" + detail.getDj() + "','" + detail.getSl() + "')");
				
				
				//修改库存表信息
				Item item=new Item();
				item.setId(detail.getSpid());
				
				TbSpinfo spinfo=getSpinfo(item);
				if(spinfo.getId()!=null && !spinfo.getId().isEmpty())
				{
					//调整库存信息
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
	
	
	//获取销售主表最大ID
	public static String getSellMainMaxId(Date date)
	{
		return getMainTypeTableMaxId(date,"tb_sell_main","XS","sellID");
	}
	
	
	
	//在事物中添加销售信息
	public static boolean insertSellInfo(TbSellMain sellMain)
	{
		try
		{
			boolean autoCommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			//将销售信息添加到销售主表中
			insert("insert into tb_sell_main values('" + sellMain.getSellId() + "','" + 
			       sellMain.getPzs() + "','" + sellMain.getJe() + "','" + sellMain.getYsjl() + "','" + 
					sellMain.getKhname() + "','" + sellMain.getXsdate() + "','" + sellMain.getCzy() +
					"','" + sellMain.getJsr() + "','" + sellMain.getJsfs() + "')");
			
			
			Set<TbSellDetail> selldetails=sellMain.getTbSellDetails();
			for(Iterator<TbSellDetail> iterator=selldetails.iterator();iterator.hasNext();)
			{
				TbSellDetail detail=iterator.next();
				//将销售详细信息添加到销售详细表中
				insert("insert into tb_sell_detail values('" + sellMain.getSellId() + "','" + 
				       detail.getSpid() + "','" + detail.getDj() + "','" + detail.getSl() + "')");
				
				
				//修改库存信息
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
	
	
	//获取最大销售退货编号
	public static String getXsthMainMaxId(Date date)
	{
		return getMainTypeTableMaxId(date,"tb_xsth_main","XT","xsthID");
	}
	
	
	//获取所有库存信息
	public static List getKucunInfos()
	{
		List list=findForList("select id,spname,dj,kcsl from tb_kucun");
		return list;
	}
	
	
	//在事物中添加销售退货信息
	public static boolean insertXsthInfo(TbXsthMain xsthMain)
	{
		try
		{
			boolean autoCommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			//将销售退货信息插入到销售退货主表中
			insert("insert into tb_xsth_main values('" + xsthMain.getXsthId() + "','" + 
			      xsthMain.getPzs() + "','" + xsthMain.getJe() + "','" + xsthMain.getYsjl() + "','" + 
					xsthMain.getKhname() + "','" + xsthMain.getThdate() + "','" + xsthMain.getCzy() + "','" + 
			      xsthMain.getJsr() + "','" + xsthMain.getJsfs() + "')");
			
			
			Set<TbXsthDetail> xsthdetails=xsthMain.getTbXsthDetails();
			for(Iterator<TbXsthDetail> iterator=xsthdetails.iterator();iterator.hasNext();)
			{
				TbXsthDetail detail=iterator.next();
				
				//将信息添加到销售退货详细表中
				insert("insert into tb_xsth_detail values('" + xsthMain.getXsthId() + "','" +
				      detail.getSpid() + "','" + detail.getDj() + "','" + detail.getSl() + "')");
				
				
				//修改库存信息
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
	
	
	//添加经手人
	public static int addJsr(TbJsr jsr)
	{
		String sql="insert into tb_jsr values(" + null + ",'" + jsr.getName() + "','" + jsr.getSex() + "','" +
	                jsr.getAge() + "','" + jsr.getTel() + "',1)";
		
		System.out.println(sql);
		return update(sql);
	}
	
	
	//获取所有经手人信息
	public static List getJsrs()
	{
		List list=findForList("select * from tb_jsr where enable=1");
		return list;
	}
	
	
	//修改用户方法
	public static int modifyPassword(String oldPass,String pass)
	{
		return update("update tb_userlist set pass='" + pass + "' where pass='" + oldPass + "'");
	}
	
	
	//获取经手人对象，返回TbJsr类
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
	
	
	//验证登录
	public static boolean checkLogin(String userStr,String passStr) throws SQLException
	{
		ResultSet rs=findForResultSet("select * from tb_userlist where name='" + userStr + "' and pass='" + passStr + "'");
		if(rs==null)
			return false;
		return rs.next();	
	}	
}
 
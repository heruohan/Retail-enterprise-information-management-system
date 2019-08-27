package com.lzw.dao.model;

import java.io.*;

public class TbSpinfo implements Serializable{
	
	private String id;
	private String spname;
	private String jc;
	private String cd;
	private String dw;
	private String gg;
	private String bz;
	private String ph;
	private String pzwh;
	private String memo;
	private String gysname;
	
	
	//Construct Method
	public TbSpinfo()
	{
		
	}
	
	public TbSpinfo(String id)
	{
		this.id=id;
	}
	
	
	//id
	public void setId(String id)
	{
		this.id=id;
	}
	public String getId()
	{
		return id;
	}
	
	
	//spname
	public void setSpname(String spname)
	{
		this.spname=spname;
	}
	public String getSpname()
	{
		return spname;
	}
	
	
	//jc
	public void setJc(String jc)
	{
		this.jc=jc;
	}
	public String getJc()
	{
		return jc;
	}
	
	
	//cd
	public void setCd(String cd)
	{
		this.cd=cd;
	}
	public String getCd()
	{
		return cd;
	}
	
	
	//dw
	public void setDw(String dw)
	{
		this.dw=dw;
	}
	public String getDw()
	{
		return dw;
	}
	
	
	//gg
	public void setGg(String gg)
	{
		this.gg=gg;
	}
	public String getGg()
	{
		return gg;
	}
	
	
	//bz
	public void setBz(String bz)
	{
		this.bz=bz;
	}
	public String getBz()
	{
		return bz;
	}
	
	
	//ph
	public void setPh(String ph)
	{
		this.ph=ph;
	}
	public String getPh()
	{
		return ph;
	}
	
	
	//pzwh
	public void setPzwh(String pzwh)
	{
		this.pzwh=pzwh;
	}
	public String getPzwh()
	{
		return pzwh;
	}
	
	
	//memo
	public void setMemo(String memo)
	{
		this.memo=memo;
	}
	public String getMemo()
	{
		return memo;
	}
	
	
	//gysname
	public void setGysname(String gysname)
	{
		this.gysname=gysname;
	}
	public String getGysname()
	{
		return gysname;
	}
	
	
	
	//override toString()method
	public String toString()
	{
		return getSpname();
	}
	
	
	
	//Override hashCode()method
	public int hashCode()
	{
		final int PRIME=31;
		int result=1;
		result=PRIME*result+((bz==null) ? 0 : bz.hashCode());
		result=PRIME*result+((cd==null) ? 0 : cd.hashCode());
		result=PRIME*result+((dw==null) ? 0 : dw.hashCode());
		result=PRIME*result+((gg==null) ? 0 : gg.hashCode());
		result=PRIME*result+((gysname==null) ? 0 : gysname.hashCode());
		result=PRIME*result+((id==null) ? 0 : id.hashCode());
		result=PRIME*result+((jc==null) ? 0 : jc.hashCode());
		result=PRIME*result+((memo==null) ? 0 : memo.hashCode());
		result=PRIME*result+((ph==null) ? 0 : ph.hashCode());
		result=PRIME*result+((pzwh==null) ? 0 : pzwh.hashCode());
		result=PRIME*result+((spname==null) ? 0 : spname.hashCode());
		
		
		return result;
	}
	
	
	
	//Override equals()·½·¨
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(this.getClass()!=obj.getClass())
			return false;
		
		final TbSpinfo other=(TbSpinfo)obj;
		//bz
		if(bz==null)
		{
			if(other.bz!=null)
				return false;
		}
		else if(!bz.equals(other.bz))
			return false;
		
		
		//id
		if(id==null)
		{
			if(other.id!=null)
				return false;
		}
		else if(!id.equals(other.id))
			return false;
		
		
		//cd
		if(cd==null)
		{
			if(other.cd!=null)
				return false;
		}
		else if(!cd.equals(other.cd))
			return false;
		
		
		
		//spname
		if(spname==null)
		{
			if(other.spname!=null)
				return false;
		}
		else if(!spname.equals(other.spname))
			return false;
		
		
		//jc
		if(jc==null)
		{
			if(other.jc!=null)
				return false;
		}
		else if(!jc.equals(other.jc))
			return false;
		
		
		//dw
		if(dw==null)
		{
			if(other.dw!=null)
				return false;
		}
		else if(!dw.equals(other.dw))
			return false;
		
		
		//gg
		if(gg==null)
		{
			if(other.gg!=null)
				return false;
		}
		else if(!gg.equals(other.gg))
			return false;
		
		
		//ph
		if(ph==null)
		{
			if(other.ph!=null)
				return false;
		}
		else if(!ph.equals(other.ph))
			return false;
		
		
		//pzwh
		if(pzwh==null)
		{
			if(other.pzwh!=null)
				return false;
		}
		else if(!pzwh.equals(other.pzwh))
			return false;
		
		
		//memo
		if(memo==null)
		{
			if(other.memo!=null)
				return false;
		}
		else if(!memo.equals(other.memo))
			return false;
		
		
		//gysname
		if(gysname==null)
		{
			if(other.gysname!=null)
				return false;
		}
		else if(!gysname.equals(other.gysname))
			return false;
		
		
		return true;
	}

}

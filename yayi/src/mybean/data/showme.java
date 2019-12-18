package mybean.data;
import java.io.UnsupportedEncodingException;
import java.sql.*;
//import java.sql.rowset.*;
//import com.sun.rowset.*;
public class showme
{
	int pageSize = 5;
    int pageAllCount = 0;
	int showPage = 1;
	String name="all";
	String username;
	StringBuffer presentPageResult;
	//CachedRowSetImpl rowSet;
	ResultSet rs;
	String databaseName = "yayi";
	String tableName = "yy";
	String user = "root";
	String password = "root";
	String ziduan[] = new String[100];
	int zid = 0;
	public showme(){
		presentPageResult = new StringBuffer();
		try{Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e){}
	}
	public void setPageSize(int size){
		pageSize = size;
		zid = 0;
		String uri = "jdbc:mysql://localhost:3306/"+databaseName+"?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
		try{
			Connection con = DriverManager.getConnection(uri,user,password);
			DatabaseMetaData metadata = con.getMetaData();
			ResultSet rs1 = metadata.getColumns(null,null,tableName,null);
			int k = 0;
			while(rs1.next()){
				zid++;
				ziduan[k] = rs1.getString(4);
				k++;
			}
			Statement sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			if(name.equals("all"))
				rs = sql.executeQuery("select * from "+tableName+" where 账号='"+username+"'");
			else
				rs = sql.executeQuery("select * from "+tableName+" where 姓名='"+name+"' and 账号='"+username+"'");
			//	rowSet = new CachedRowSetImpl();
		//	rowSet.populate(rs);
		//	con.close();
			rs.last();
			int m = rs.getRow();
			int n = pageSize;
			pageAllCount = ((m%n)==0)?(m/n):(m/n+1);
		}catch(Exception e){}
	}
	public int getPageSize(){
		return pageSize;
	}
	public int getPageAllCount(){
		return pageAllCount;
	}
	public void setShowPage(int n){
		showPage = n;
	}
	public int getShowPage(){
		return showPage;
	}
	public void setname(String n){
		try {
			n=new String(n.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name = n;
		//
		System.out.println(n);
	}
	public String getname(){
		return name;
	}
	public StringBuffer getPresentPageResult(){
		if(showPage > pageAllCount)
			showPage = 1;
		if(showPage <= 0)
			showPage = pageAllCount;
		presentPageResult = show(showPage);
		return presentPageResult;
	}
	public StringBuffer show(int page){
		StringBuffer str = new StringBuffer();
		str.append("<table class=\"ta\" style=\"text-align:center;font-size:11px\">");
		str.append("<tr>");
		
		for(int i = 0;i<zid-1;i++)
			str.append("<th>" + ziduan[i] + "</th>");
                //str.append("<th>"+"管理员"+"</th>");
                //str.append("<th>"+"删除用户"+"</th>");
		str.append("</tr>");
		try{
			rs.absolute((page-1)*pageSize+1);
			boolean boo = true;
			for(int i = 1;i<=pageSize&&boo;i++){
				str.append("<tr>");
				for(int k = 1;k<zid;k++){
					str.append("<td>"+rs.getString(k)+"</td>");
				}
				//str.append("<td><form action=\"/yayi/jieshou1\" method=\"post\"><input type=hidden name=\"jieshou\" value=\""+rs.getString(1)+","+rs.getString(2)+"\""+"><input type=submit name=\"\" value=\"管理员\" onclick=\"checkjs()\"><input type=hidden name=\"title\" value=\"userlist\"></form></td>");
				//str.append("<td><form action=\"/yayi/delete1\" method=\"post\"><input type=hidden name=\"quxiao\" value=\""+rs.getString(1)+","+rs.getString(2)+"\""+"><input type=submit name=\"\" value=\"删除用户\" onclick=\"delcfm()\"><input type=hidden name=\"title\" value=\"userlist\"></form></td>");
				str.append("</tr>");
				boo = rs.next();
			}
		}catch(Exception e){}
		str.append("</table>");
		return str;
	}
	public void setDatabaseName(String s){
		databaseName = s.trim();
	}
	public String getDatabaseName(){
		return databaseName;
	}
	public void setTableName(String s){
		tableName = s.trim();
	}
	public String getTableName(){
		return tableName;
	}
	public void setPassword(String s){
		password = s.trim();
	}
	public void setUser(String s){
		user = s.trim();
	}
	public String getUser(){
		return user;
	}
	public void setusername(String s){
		username = s;
		//System.out.println(s);
	}
	public String getusername(){
		return username;
	}
}
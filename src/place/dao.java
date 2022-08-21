package place;

import java.sql.*;
import java.util.*;

public class dao {
	
	public ArrayList<Member> create() throws java.lang.Exception{
		ArrayList<Member> member = new ArrayList<Member>();
		Connection conn = DBAction.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from place";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Member m = new Member();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				member.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(member, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				// TODO Auto-generated method stub
				if(o1.getId()<o2.getId())return -1;
				else if(o1.getId()>o2.getId())return 1;
				else return 0;
			}
			
		});
		return member;
	}
	public boolean insert(int id,String name) {
		Connection conn = DBAction.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "insert into place values('"+id+"','"+name+"')";
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean delect(int id) {
		Connection conn = DBAction.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "delete from place where id = '"+id+"'";
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO
{
	static List<Skill> list=new ArrayList<Skill>();
	public List< Skill > listAllSkills() throws ClassNotFoundException, SQLException, IOException
	{
        Connection con = ConnectionManager.getConnection();
        
        //to pass this type of statements to the data base ,first of all we should create Statements
		Statement stmt=  con.createStatement();
		
		ResultSet rs =stmt.executeQuery("SELECT * FROM prograd_pro_kabbadi_league.skill order by name asc ");
		
		while(rs.next())
		{
			
			long id=rs.getLong(1);
			String name=rs.getString(2);
			Skill skill=new Skill(id,name);
			
			list.add(skill);
			
		}
		
		return list;
		
		
	}
	
	
//	public void create(Skill skill) throws ClassNotFoundException, SQLException, IOException
//	{
//		Connection con=ConnectionManager.getConnection();
//		
//		
//		String sql="INSERT INTO Skills(skillid ,skillname)VALUES(?,?)";
//		
//		PreparedStatement st=con.prepareStatement(sql);
//		
//		st.setLong(1,skill.getSkilld());
//		st.setString(2, skill.getSkillName());
//		
//		st.executeUpdate();// update table
//		con.close();
//		
//		
//		
//	}
//	
//	public void  retrieve() throws ClassNotFoundException, SQLException, IOException
//	{
//		
//		
//         Connection con = ConnectionManager.getConnection();
//		
//		Statement stmt=  con.createStatement();
//		
//		ResultSet rs =stmt.executeQuery("select * from Skill ");
//		
//		while(rs.next())
//		{
//			
//			long id=rs.getLong(1);
//			String name=rs.getString(2);
//			Skill skill=new Skill();
//			skill.setSkilld(id);
//			skill.setSkillName(name);
//			list.add(skill);
//			
//		}
//		
//	}
	
}

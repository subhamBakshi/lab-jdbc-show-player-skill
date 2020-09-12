package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.SkillDAO;
import model.Skill;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
//	String name=br.readLine();
//	long id=Long.parseLong(br.readLine());
//	
//	Skill skill=new Skill(id,name);
	
	
	
		
	SkillDAO skilldao=new SkillDAO();
	//skilldao.create(skill);

	
ArrayList<Skill>  list= (ArrayList<Skill>) skilldao.listAllSkills();


System.out.println("Id"+"\t"+"name");

for(Skill s: list)
{
	System.out.println(s.getSkilld()+"\t"+s.getSkillName());

}
	}

}

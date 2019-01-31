package com.ilhanmert.dao;
import com.ilhanmert.object.*;
import java.sql.*;
import com.ilhanmert.database.ConnectDatabase;
public class UsersDAO 
{
	private Connection con; //Baðlantýyý saðlar
	private String driver=ConnectDatabase.getDriver(); //Databaseden driveri aldýk
	private String url=ConnectDatabase.getUrl(); //Databaseden urlyi aldýk
	private Statement stm; // SQL ifadeleri veritabanýna göndermek için kullanýlýr
	private ResultSet resultSet = null; // Veritabanýndan alýnan nesneleri tutmaya ve taþýmaya yarar
	private CallableStatement cs; //Saklý yordamlarý çaðýrmayý saðlar
	
	public UsersDAO()
	{
		try { Class.forName(driver).newInstance(); System.out.println("JDBC surucu basari ile yüklendi."); } catch (Exception e) { System.out.println("JDBC surucu Yüklenemedi. Hata:"+e.getMessage()); System.exit(0); }
		try{con=DriverManager.getConnection(url,ConnectDatabase.getKullaniciadi(),ConnectDatabase.getSifre());System.out.println("Veritabanina Baglanildi.");}catch (Exception e) { System.out.println("Veri Tabanina Baglanilmadi. Hata:"+e.getMessage()); System.exit(0); }
		try {stm=con.createStatement();}catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); }
	}
	
	public boolean createUser (Users user)
	{
		try
		{
			cs=con.prepareCall ("{ CALL createUser ( ?, ?, ?, ?, ? )}"); 
			cs.setString(1, user.getName());
			cs.setString(2, user.getSurname());
			cs.setString(3, user.getUsername());
			cs.setString(4, user.getPassword());
			cs.setString(5, user.getEmail());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;} //Hata halinde mesajý ekrana bastýrýp false döndürdük
	}
	
	public ResultSet getUsers()
	{
		try
		{
			String query = "CALL getUsers()";
			resultSet=stm.executeQuery(query);
			
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0);}
		return resultSet;
	}
	
	public boolean updateUsers (Users user,int id)
	{
		try
		{
			cs=con.prepareCall ("{ CALL updateUser ( ?, ?, ?, ?, ?, ?)}");
			cs.setInt(1, id);
			cs.setString(2, user.getName());
			cs.setString(3, user.getSurname());
			cs.setString(4, user.getUsername());
			cs.setString(5, user.getPassword());
			cs.setString(6, user.getEmail());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public boolean deleteUsers (int id)
	{
		try
		{
			cs=con.prepareCall ("{ CALL deleteUsers( ?)}");
			cs.setInt(1, id);
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
}

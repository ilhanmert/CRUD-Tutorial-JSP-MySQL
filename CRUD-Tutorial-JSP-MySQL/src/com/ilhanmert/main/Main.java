package com.ilhanmert.main;
import com.ilhanmert.dao.*;
import com.ilhanmert.object.*;
import java.sql.*;

public class Main {

	public static void main(String[] args)
	{
		Users user = new Users("mert","ilhan","ilhanmert","mert123","mert@gmail.com");
		UsersDAO userdao = new UsersDAO();
		if (userdao.createUser(user)) System.out.println("Kullanici Eklendi");
		ResultSet resultset = userdao.getUsers();
		try 
		{
			 while (resultset.next())
			 {
				System.out.print(resultset.getInt(1));
				System.out.print(resultset.getString(2)); 
				System.out.print(resultset.getString(3));
				System.out.print(resultset.getString(4)); 
				System.out.print(resultset.getString(5)); 
				System.out.println(resultset.getString(6)); 
			 }    
		} catch (Exception e) 
		{
		}
		if (userdao.updateUsers(user, 1)) System.out.println("Kullanici Basariyla Guncellend");
		if (userdao.deleteUsers(1)) System.out.println("Kullanici Basariyla Silindi");
  
	}
}

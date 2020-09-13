package com.abd;


import java.sql.*;

public class AdminDAO {
	
	public static ConnectionPool pool=new ConnectionPool(10,"jdbc:mysql://localhost:3306/studentsystem","root","root");
   
   public static boolean isThereSuchAnAdmin(int id,String password){
	   Connection connection=pool.getConnection();
	   try {
		   Statement statement=connection.createStatement();
		   String sql="select * from admins where adminid="+id+" and adminpassword = "+password;
		   ResultSet resultSet=statement.executeQuery(sql);	
		   
           if(resultSet.next()){
        	   return true;
           }
	   }
       catch (Exception e){
           e.printStackTrace();
       }
	   finally {
		   pool.returnConnection(connection);
	   }
	   
       return false;
   }
   
   public static String getAdminName(int id) {
	   Connection connection=pool.getConnection();
	   String name="";
	   try {
		   Statement statement=connection.createStatement();
		   String sql="select adminfirstname from admins where adminid="+id;
		   ResultSet resultSet=statement.executeQuery(sql);
        if(resultSet.next()){
     	   name=resultSet.getString("adminfirstname");
        }
	   }
	   catch (Exception e){
        e.printStackTrace();
    }
	   finally {
		   pool.returnConnection(connection);
	   }
	   return name;
   }	
}
   
//    public static Admin getAdmin(int adminId){
//        Connection connection=connectionPool.getConnection();
//        Admin admin=new Admin();
//        try{
//            Statement st=connection.createStatement();
//            String sql="select * from admins where adminid ="+adminId;
//            ResultSet resultSet=st.executeQuery(sql);
//            if(resultSet.next()){
//                admin.setAdminId(resultSet.getInt(1));
//                admin.setAdminFirstName(resultSet.getString(2));
//                admin.setAdminLastName(resultSet.getNString(3));
//                admin.setAdminPassword(resultSet.getString(4));
//            }
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//        connectionPool.returnConnection(connection);
//        return admin;
//    }
//    public static void deleteAdmin(int adminId){
//        Connection connection=connectionPool.getConnection();
//        try{
//            Statement st=connection.createStatement();
//            String sql="delete from admins where adminid="+adminId;
//            st.executeUpdate(sql);
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//        connectionPool.returnConnection(connection);
//    }
//    public static void addAdmin(Admin admin){
//        Connection connection=connectionPool.getConnection();
//        try{
//            Statement st=connection.createStatement();
//            String sql="insert into admins values ("+admin.getAdminId()+",'"+admin.getAdminFirstName()+
//                    "','"+admin.getAdminLastName()+"','"+admin.getAdminPassword()+"')";
//            st.executeUpdate(sql);
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//        connectionPool.returnConnection(connection);
//    }
//}

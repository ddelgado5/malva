//package com.example.apitienda.db;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class ConectionOracle {
//    private Connection conn = null;
//    private String url, user,pass;
//
//    public ConectionOracle(){
//        conectar();
//    }
//
//    public void desconectar(){
//        try{
//            conn.close();
//        }catch (Exception e){
//            System.out.println("NO se pudo descontectar a BD");
//            e.printStackTrace();
//        }
//    }
//
//    public void conectar(){
//        try{
//            Class.forName("");
//            url= "jdbc:oracle:thin:@localhost:1521:xe";
//            user= "system";
//            pass="123";
//            conn = DriverManager.getConnection(url, user, pass);
//            System.out.println("Contectado a BD");
//        }catch (Exception e){
//            System.out.println("NO se pudo contectar a BD");
//            e.printStackTrace();
//        }
//    }
//}

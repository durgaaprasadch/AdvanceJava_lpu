package com.lpu.Services;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import com.lpu.Entities.Product;

public class ProductService {

 static SessionFactory factory =
  new Configuration().configure().buildSessionFactory();

 public void addProduct(String n,double p){
  Session s=factory.openSession();
  Transaction tx=s.beginTransaction();
  try{
   Product pr=new Product();
   pr.setName(n); pr.setPrice(p);
   s.persist(pr);
   tx.commit();
  }catch(Exception e){tx.rollback();}
  finally{s.close();}
 }
}
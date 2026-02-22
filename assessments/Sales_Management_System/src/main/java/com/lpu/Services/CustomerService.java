package com.lpu.Services;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import com.lpu.Entities.*;

public class CustomerService {

 static SessionFactory factory =
  new Configuration().configure().buildSessionFactory();

 public void registerCustomer(String n,String e,String p){
  Session s=factory.openSession();
  Transaction tx=s.beginTransaction();
  try{
   Customer c=new Customer();
   c.setName(n); c.setEmail(e); c.setPhone(p);
   s.persist(c);
   tx.commit();
  }catch(Exception ex){tx.rollback();}
  finally{s.close();}
 }

 public void addAddressToCustomer(Long id, Address a){
  Session s=factory.openSession();
  Transaction tx=s.beginTransaction();
  try{
   Customer c=s.get(Customer.class,id);
   c.setAddress(a);
   tx.commit();
  }catch(Exception e){tx.rollback();}
  finally{s.close();}
 }
}
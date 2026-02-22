package com.lpu.Services;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import com.lpu.Entities.*;

public class LeadService {

 static SessionFactory factory =
  new Configuration().configure().buildSessionFactory();

 public void createLead(String n,String s,String c){
  Session ss=factory.openSession();
  Transaction tx=ss.beginTransaction();
  try{
   Lead l=new Lead();
   l.setName(n); l.setSource(s); l.setContactInfo(c);
   ss.persist(l);
   tx.commit();
  }catch(Exception e){tx.rollback();}
  finally{ss.close();}
 }

 public void assignLeadToEmployee(Long lid,Long eid){
  Session ss=factory.openSession();
  Transaction tx=ss.beginTransaction();
  try{
   Lead l=ss.get(Lead.class,lid);
   SalesEmployee e=ss.get(SalesEmployee.class,eid);
   l.setEmployee(e);
   tx.commit();
  }catch(Exception e){tx.rollback();}
  finally{ss.close();}
 }

 public void convertLeadToCustomer(Long lid){
  Session ss=factory.openSession();
  Transaction tx=ss.beginTransaction();
  try{
   Lead l=ss.get(Lead.class,lid);
   Customer c=new Customer();
   c.setName(l.getName());
   c.setEmail(l.getContactInfo());
   ss.persist(c);
   ss.remove(l);
   tx.commit();
  }catch(Exception e){tx.rollback();}
  finally{ss.close();}
 }
}
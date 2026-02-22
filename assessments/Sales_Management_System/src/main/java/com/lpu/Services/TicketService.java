package com.lpu.Services;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import com.lpu.Entities.*;

public class TicketService {

 static SessionFactory factory =
  new Configuration().configure().buildSessionFactory();

 public void raiseTicket(Long oid,String issue){
  Session s=factory.openSession();
  Transaction tx=s.beginTransaction();
  try{
   Order o=s.get(Order.class,oid);
   SupportTicket t=new SupportTicket();
   t.setOrder(o);
   t.setIssueDescription(issue);
   s.persist(t);
   tx.commit();
  }catch(Exception e){tx.rollback();}
  finally{s.close();}
 }
}
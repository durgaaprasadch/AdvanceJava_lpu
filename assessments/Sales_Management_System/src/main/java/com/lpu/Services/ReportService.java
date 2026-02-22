package com.lpu.Services;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class ReportService {

 static SessionFactory factory =
  new Configuration().configure().buildSessionFactory();

 public void getEmployeePerformance(Long eid){
  Session s=factory.openSession();
  Long count=s.createQuery(
   "select count(l) from Lead l where l.employee.id=:id",
   Long.class).setParameter("id",eid).uniqueResult();
  System.out.println("Leads handled: "+count);
  s.close();
 }
}
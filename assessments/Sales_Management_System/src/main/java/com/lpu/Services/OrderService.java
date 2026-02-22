package com.lpu.Services;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;
import com.lpu.Entities.*;

public class OrderService {

 static SessionFactory factory =
  new Configuration().configure().buildSessionFactory();

 public void placeOrder(Long cid,List<Long> pids){
  Session s=factory.openSession();
  Transaction tx=s.beginTransaction();
  try{
   Customer c=s.get(Customer.class,cid);
   List<Product> ps=new ArrayList<>();
   double total=0;
   for(Long id:pids){
    Product p=s.get(Product.class,id);
    ps.add(p); total+=p.getPrice();
   }
   Order o=new Order();
   o.setCustomer(c);
   o.setProducts(ps);
   o.setOrderDate(new Date());
   o.setTotalAmount(total);
   s.persist(o);
   tx.commit();
  }catch(Exception e){tx.rollback();}
  finally{s.close();}
 }
}
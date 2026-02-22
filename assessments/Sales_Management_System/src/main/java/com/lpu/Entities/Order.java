package com.lpu.Entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Order {

 @Id @GeneratedValue
 private Long id;

 @Temporal(TemporalType.DATE)
 private Date orderDate;

 private double totalAmount;

 @ManyToOne
 private Customer customer;

 @ManyToMany
 private List<Product> products;

 public Long getId(){return id;}
 public void setId(Long id){this.id=id;}
 public Date getOrderDate(){return orderDate;}
 public void setOrderDate(Date orderDate){this.orderDate=orderDate;}
 public double getTotalAmount(){return totalAmount;}
 public void setTotalAmount(double totalAmount){this.totalAmount=totalAmount;}
 public Customer getCustomer(){return customer;}
 public void setCustomer(Customer customer){this.customer=customer;}
 public List<Product> getProducts(){return products;}
 public void setProducts(List<Product> products){this.products=products;}
}
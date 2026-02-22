package com.lpu.Main;

import java.util.*;
import com.lpu.Services.*;
import com.lpu.Entities.*;

public class CRMApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

      
        CustomerService customerService = new CustomerService();
        LeadService leadService = new LeadService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        TicketService ticketService = new TicketService();
        ReportService reportService = new ReportService();

        while (true) {
            System.out.println("\n=== CRM MENU ===");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address to Customer");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead to Employee");
            System.out.println("5. Convert Lead to Customer");
            System.out.println("6. Add Product");
            System.out.println("7. Place Order");
            System.out.println("8. Raise Support Ticket");
            System.out.println("9. View Employee Performance");
            System.out.println("10. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // 1. Register Customer
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    customerService.registerCustomer(name, email, phone);
                    break;

                // 2. Add Address
                case 2:
                    System.out.print("Customer ID: ");
                    Long cid = sc.nextLong();
                    sc.nextLine();

                    Address addr = new Address();
                    System.out.print("Street: ");
                    addr.setStreet(sc.nextLine());
                    System.out.print("City: ");
                    addr.setCity(sc.nextLine());
                    System.out.print("State: ");
                    addr.setState(sc.nextLine());
                    System.out.print("Zip: ");
                    addr.setZipCode(sc.nextLine());

                    customerService.addAddressToCustomer(cid, addr);
                    break;

                // 3. Create Lead
                case 3:
                    System.out.print("Lead Name: ");
                    String lname = sc.nextLine();
                    System.out.print("Source: ");
                    String source = sc.nextLine();
                    System.out.print("Contact Info: ");
                    String contact = sc.nextLine();

                    leadService.createLead(lname, source, contact);
                    break;

                // 4. Assign Lead
                case 4:
                    System.out.print("Lead ID: ");
                    Long lid = sc.nextLong();
                    System.out.print("Employee ID: ");
                    Long eid = sc.nextLong();
                    sc.nextLine();

                    leadService.assignLeadToEmployee(lid, eid);
                    break;

                // 5. Convert Lead to Customer
                case 5:
                    System.out.print("Lead ID: ");
                    Long leadId = sc.nextLong();
                    sc.nextLine();

                    leadService.convertLeadToCustomer(leadId);
                    break;

                // 6. Add Product
                case 6:
                    System.out.print("Product Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    productService.addProduct(pname, price);
                    break;

                // 7. Place Order
                case 7:
                    System.out.print("Customer ID: ");
                    Long custId = sc.nextLong();

                    System.out.print("Number of products: ");
                    int n = sc.nextInt();

                    List<Long> productIds = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Product ID " + (i + 1) + ": ");
                        productIds.add(sc.nextLong());
                    }
                    sc.nextLine();

                    orderService.placeOrder(custId, productIds);
                    break;

                // 8. Raise Ticket
                case 8:
                    System.out.print("Order ID: ");
                    Long orderId = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Issue: ");
                    String issue = sc.nextLine();

                    ticketService.raiseTicket(orderId, issue);
                    break;

                // 9. Employee Performance
                case 9:
                    System.out.print("Employee ID: ");
                    Long empId = sc.nextLong();
                    sc.nextLine();

                    reportService.getEmployeePerformance(empId);
                    break;

                // 10. Exit
                case 10:
                    System.out.println("Exiting CRM...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
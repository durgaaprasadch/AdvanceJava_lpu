package com.lpu.main;

import com.lpu.entity.Booking;
import com.lpu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {

            System.out.println("---HOTEL MANAGEMENT SYSTEM---");
            System.out.println("1. Add Booking");
            System.out.println("2. View Bookings");
            System.out.println("3. Update Booking");
            System.out.println("4. Delete Booking");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    // for adding
                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Room Type(Standard/Deluxe/Suite): ");
                    String room = sc.nextLine();

                    System.out.print("Check-in Date(YYYY-MM-DD): ");
                    String inDate = sc.nextLine();

                    System.out.print("Check-out Date(YYYY-MM-DD): ");
                    String outDate = sc.nextLine();

                    Session s1 = HibernateUtil.getSessionFactory().openSession();
                    Transaction t1 = s1.beginTransaction();

                    Booking b = new Booking(name, room, inDate, outDate);
                    s1.persist(b);

                    t1.commit();
                    s1.close();

                    System.out.println("Booking Added");
                    break;

                case 2:
                    // for reading
                    Session s2 = HibernateUtil.getSessionFactory().openSession();

                    List<Booking> list =
                            s2.createQuery("from Booking", Booking.class).list();

                    for (Booking bk : list) {
                        System.out.println(
                        		bk.getBookingId() + " | " +
                                bk.getCustomerName() + " | " +
                                bk.getRoomType() + " | " +
                                bk.getTotalAmount()
                        );
                    }
                    s2.close();
                    break;

                case 3:
                    // for updation
                    System.out.print("Booking ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Room Type(): ");
                    String newRoom = sc.nextLine();

                    Session s3 = HibernateUtil.getSessionFactory().openSession();
                    Transaction t3 = s3.beginTransaction();

                    Booking ub = s3.get(Booking.class, uid);
                    if (ub != null) {
                        ub.setRoomType(newRoom);
                        System.out.println("Booking Updated");
                    } else {
                        System.out.println("Booking Not Found");
                    }

                    t3.commit();
                    s3.close();
                    break;

                case 4:
                    // for deletion
                    System.out.print("Booking ID to delete: ");
                    int did = sc.nextInt();

                    Session s4 = HibernateUtil.getSessionFactory().openSession();
                    Transaction t4 = s4.beginTransaction();

                    Booking db = s4.get(Booking.class, did);
                    if (db != null) {
                        s4.remove(db);
                        System.out.println("Booking Deleted");
                    } else {
                        System.out.println("Booking Not Found");
                    }
                    
                    t4.commit();
                    s4.close();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Wrong choice");
            }
        }
        HibernateUtil.getSessionFactory().close();
        sc.close();
    }
}

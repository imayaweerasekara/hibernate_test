package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Address;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();

        Address address=new Address();
        address.setId("1");
        address.setStreet("abc");
        address.setCity("xyz");

        Customer customer=new Customer();
        customer.setId("1");
        customer.setName("fff");
        customer.setAddress(address);

        Transaction transaction= session.beginTransaction();

        session.save(address);
        session.save(customer);
        transaction.commit();
        session.close();

    }
}
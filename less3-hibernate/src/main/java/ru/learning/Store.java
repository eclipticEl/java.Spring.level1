package ru.learning;

import ru.learning.persist.Person;
import ru.learning.persist.Product;
import ru.learning.persist.Buy;

import org.hibernate.cfg.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {

    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = factory.createEntityManager();

//        Person person1 = em.find(Person.class, 2L);
//        System.out.println(person1);
//
//        List<Product> products = em.createQuery("from Product").getResultList();
//
//        List<Buy> buy= new ArrayList<>();
//        buy.add(new Buy(person1,products.get(2),30));
//        buy.add(new Buy(person1,products.get(3),50));
//        em.getTransaction().begin();
//
//        try {
//            person1.setPersonbuy(buy);
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            em.getTransaction().rollback();
//        }


        Scanner in = new Scanner(System.in);
        System.out.println("Если вы хотите узнать, какие товары покупал n-й клиент, введите цифру 1; \n"+
                        "Если вы хотите узнать, какие клиенты купили n-й товар, введите цифру 2; \n"+
                        "Если вы хотите узнать стоимость n-го товара, в момент покупки клиентом m, введите 3\n"+
                        "Если вы хотите удалить клиента n и его покупки, введите 4\n"+
                        "Если вы хотите удалить товар и все его продажи, введите 5");
        int num = in.nextInt();
        if (num == 1){
            System.out.println("Введите номер клиента");
            Long clientid = in.nextLong();

            Person person = em.find(Person.class,clientid);
            System.out.println(person.getPersonbuy().toString());
        }else if (num == 2) {
            System.out.println("Введите номер товара");
            Long productid = in.nextLong();

            Product product =  em.find(Product.class,productid);
            System.out.println(product.getProductbuy().toString());
        }else if (num == 3) {
            System.out.println("Введите номер товара");
            Long productid = in.nextLong();
            System.out.println("Введите номер клиента");
            Long clientid = in.nextLong();

            List<Double> productCost = em.createQuery("select b.productCost from Buy b where client = "+clientid+" and product ="+productid).getResultList();
            productCost.forEach(System.out::println);

        }else if (num==4){
            System.out.println("Введите номер клиента");
            Long clientid = in.nextLong();

            Person person = em.find(Person.class,clientid);
            em.getTransaction().begin();
            try {
                em.remove(person);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
            }

        }else if (num==5){
            System.out.println("Введите номер товара");
            Long productid = in.nextLong();

            Product product =  em.find(Product.class,productid);
            em.getTransaction().begin();
            try {
                em.remove(product);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
            }

        }
        in.close();
        em.close();
    }
}

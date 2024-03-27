package application;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args) {
//        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "CarlosSilva@Gmail.com");
//        Pessoa p2 = new Pessoa(null, "Joses da Silva", "Joses@Gmail.com");
//        Pessoa p3 = new Pessoa(null, "Marlon da Silva", "Marlon@Gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        Pessoa p1 = em.find(Pessoa.class, 3);
        em.getTransaction().begin();
        em.remove(p1);
        em.getTransaction().commit();

        System.out.println("Removido: " + p1.toString());
//        Pessoa p = em.find(Pessoa.class, 2);
//        System.out.println(p.toString());
//
//        em.getTransaction().begin();
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);
//        em.getTransaction().commit();
//
//
//        System.out.println("Dados criados abaixo:");
//        System.out.println(p1.toString());
//        System.out.println(p2.toString());
//        System.out.println(p3.toString());


        em.close();
        emf.close();
    }
}

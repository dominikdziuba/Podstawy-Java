import entity.AddressInfoEntity;
import entity.PersonEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{


    private static EntityManagerFactory fac = Persistence.createEntityManagerFactory("default");
    private static EntityManager man = fac.createEntityManager();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {

        EntityTransaction tr = man.getTransaction();
        Session s = man.unwrap(org.hibernate.Session.class);
        Transaction trans = s.getTransaction();


        try
        {
            tr.begin();
            PersonEntity person = new PersonEntity();

            System.out.println("Dodawanie danych\nPodaj imie:");
            person.setpName(sc.nextLine());

            System.out.println("Podaj nazwisko: ");
            person.setpSurname(sc.nextLine());

            System.out.println("Podaj email: ");
            person.setpEmail(sc.nextLine());

            System.out.println("Podaj liczbę adresów do wpisania");
            int number = sc.nextInt();
            sc.nextLine();
            person.setAddressInfosByPId(new ArrayList<AddressInfoEntity>());
            for (int i = 0; i < number; i++)
            {
                System.out.println("Wprowadź " + (i + 1) + " adres:\n");
                AddressInfoEntity address = new AddressInfoEntity();

                System.out.println("Podaj ulice: ");
                address.setStreet(sc.nextLine());

                System.out.println("Podaj numer domu: ");
                address.setHouseNumber(sc.nextLine());

                System.out.println("Podaj miasto: ");
                address.setTown(sc.nextLine());

                System.out.println("Podaj wojewodztwo: ");
                address.setState(sc.nextLine());

                System.out.println("Podaj panstwo: ");
                address.setCountry(sc.nextLine());

                person.getAddressInfosByPId().add(address);
                address.setPersonByAiPId(person);

                System.out.println("Dodano adres: "+ address.getCountry()+"\n"+address.getState()+"\n"+address.getTown()+"\n"+address.getStreet()+"\n"+address.getHouseNumber());
            }
            man.persist(person);
            System.out.println("Zakończono dodawanie danych. \n\n\n");
            tr.commit();
        } finally {
            if (tr.isActive())
                tr.rollback();
        }

        try
        {
            System.out.println("Odczyt danych");
            tr.begin();
            TypedQuery<PersonEntity> personBySth = chosenPattern();
            personBySth.setParameter(1, sc.nextLine());
            int k = 0;
            for (PersonEntity p : personBySth.getResultList())
            {
                System.out.println(p);
                k++;
            }
            if (k == 0)
                System.out.println("Brak danych spełniających założenia");
            System.out.println("Zakończono odczyt danych\n\n\n");
            tr.commit();
        } finally {
            if (tr.isActive())
                tr.rollback();
        }

        try
        {
            System.out.println("Modyfikacja danych");
            trans.begin();
            TypedQuery<PersonEntity> personBySth = chosenPattern();
            personBySth.setParameter(1, sc.nextLine());
            List<PersonEntity> resultList = personBySth.getResultList();

            int k = 0;
            System.out.println("Wybierz które dane zmienić: ");
            for (PersonEntity p : personBySth.getResultList())
            {
                System.out.println(k + ":");
                System.out.println(p);
                k++;
            }
            if (k == 0)
                System.out.println("Brak danych spełniających założenia");
            int g;
            do
            {
                System.out.println("Podaj numer ID osoby: ");
                g = sc.nextInt();
                sc.nextLine();
            } while (g < 0 || g >= k);
            PersonEntity p = resultList.get(g);

            System.out.println("Podaj nowe imie: ");
            p.setpName(sc.nextLine());

            System.out.println("Podaj nowe nazwisko: ");
            p.setpSurname(sc.nextLine());

            System.out.println("Podaj nowy email: ");
            p.setpEmail(sc.nextLine());

            int i = 1;
            for (AddressInfoEntity address : p.getAddressInfosByPId())
            {
                System.out.println("Podaj " + i+1 +" adres:");
                System.out.println();

                System.out.println("Podaj nową ulice: ");
                address.setStreet(sc.nextLine());

                System.out.println("Podaj nowy numer domu: ");
                address.setHouseNumber(sc.nextLine());

                System.out.println("Podaj nowe miasto: ");
                address.setTown(sc.nextLine());

                System.out.println("Podaj nowe wojewodztwo: ");
                address.setState(sc.nextLine());

                System.out.println("Podaj nowe panstwo: ");
                address.setCountry(sc.nextLine());

                i++;
            }
            s.update(p);
            System.out.println("Zakończono modyfikację danych");
            trans.commit();
        } finally {
            if (trans.isActive())
                trans.rollback();
        }
        try
        {
            System.out.println("Usuwanie danych");
            trans.begin();
            TypedQuery<PersonEntity> personBySth = chosenPattern();
            personBySth.setParameter(1, sc.nextLine());

            List<PersonEntity> lista = personBySth.getResultList();
            int k = 0;
            System.out.println("Wybierz dane do usuniecia: ");
            for (PersonEntity p : lista)
            {
                System.out.println(k + ": \n");
                System.out.println(p);
                k++;
            }
            if (k == 0)
                System.out.println("Brak danych spełniających założenia");

            int g;
            do
            {
                System.out.println("Podaj numer ID osoby: ");
                g = sc.nextInt();
                sc.nextLine();
            } while (g < 0 || g >= k);
            PersonEntity p = lista.get(g);

            man.remove(p);
            man.flush();
            man.clear();
            System.out.println("Usunieto pomyslnie wybrane dane.");
            System.out.println("Zakończono usuwanie danych.");
            trans.commit();
        } finally {
            if (trans.isActive())
                trans.rollback();
        }

    }

    private static TypedQuery<PersonEntity> chosenPattern()
    {
        System.out.println("Filtruj dane: ");
        System.out.println("1. Imieniu");
        System.out.println("2. Nazwisku");
        System.out.println("3. Województwie");
        System.out.println("4. Kraju");
        System.out.println("5. Mieście");
        System.out.println("6. Mailu\n");
        System.out.println("Wybierz: ");
        int choice = sc.nextInt();
        sc.nextLine();
        while (true)
        {
            if(choice==1) {
                System.out.println("Podaj imie: ");
                return man.createNamedQuery("PersonEntity.ByName", PersonEntity.class);
            } else if (choice==2) {
                System.out.println("Podaj nazwisko: ");
                return man.createNamedQuery("PersonEntity.BySurname", PersonEntity.class);
            } else if (choice==3) {
                System.out.println("Podaj województwo: ");
                return man.createNamedQuery("PersonEntity.ByState", PersonEntity.class);
            } else if (choice==4) {
                System.out.println("Podaj kraj: ");
                return man.createNamedQuery("PersonEntity.ByCountry", PersonEntity.class);
            } else if (choice==5) {
                System.out.println("Podaj miasto: ");
                return man.createNamedQuery("PersonEntity.ByTown", PersonEntity.class);
            } else if (choice==6) {
                System.out.println("Podaj maila: ");
                return man.createNamedQuery("PersonEntity.ByEmail", PersonEntity.class);
            }
            else {
                System.out.println("Wybrano nieprawidłową opcje");
                System.exit(1);
            }
        }
    }
}

package hemanth;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("pu");
		EntityManager em=emf.createEntityManager();
		//Alien a=new Alien(1,"hemanth","java");
//		em.getTransaction().begin();
//		em.persist(a);
//		em.getTransaction().commit();
		Alien a =em.find(Alien.class, 1);
		System.out.println(a);
		

	}

}

package myjpa2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UseMember2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("MyJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			Member2 member2 = new Member2("홍길동2", "1234");
			//영속성 개체로 Member1을 전달하여 추가한다.
			em.persist(member2);
			//JPA가 오라클에 테이블을 생성하면서 동기화된다.
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			em.close();
		}
		
		emf.close();
	}

}

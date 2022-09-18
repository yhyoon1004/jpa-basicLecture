package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
	public static void main(String[] args) {
		//EntityManagerFactory는 웹서비스를 실행하는 순간 하나만 올라오는 객체로써
		//EntityManager를 만들때 사용됨
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		//EntityManager는 사용자의 DB요청이 올 때 마다 생성하여 하나의 트렌젝션을 처리하고 종료하는 객체(쓰레드간 공유 x)
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();//트렌젝션 처리를 할 수 있는 트렌젝션 객체를 받아옴
		tx.begin();//트렌젝션 처리 시작

		try{
			//JPQL을 사용한 sql 처리
			List<Member> result = em.createQuery("select m from Member as m", Member.class)
					.setFirstResult(5)
					.setMaxResults(8)
					.getResultList();
			 for (Member member : result) {
				 System.out.println("member.name = "+member.getName() );
			}
/*
//			DB에 값을 insert하는 코드
			Member member = new Member();
			member.setId(1L);
			member.setName("helloA");
			em.persist(member);
*/

			/*
			DB에 값을 select하는 코드
			Member findMember = em.find(Member.class, 1L);
			System.out.println("findMember.id = " + findMember.getId());
			System.out.println("findMember.name = " + findMember.getName());
			*/

			/*
			DB에 값을 받아와 update하는 코드
			Member findMember = em.find(Member.class, 1L);
			findMember.setName("HelloJPA");
			*/


			tx.commit();//정상 수행 시 커밋하는 트렌젝션 메서드
		}catch (Exception e){
			tx.rollback();//에러 및 잘못 됬을 때 롤백하는 트렌젝션 메서드
		}finally {
			em.close();//DB처리를 성공하던 실패하던 entityManager를 닫아 줌
		}
		emf.close();
	}
}

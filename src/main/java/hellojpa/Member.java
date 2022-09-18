package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="USER")//해당하는 테이블명을 매핑해주는 어노테이션
public class Member {
	@Id//primaryKey라고 알려주는 어노테이션
	private Long id;
//	@Column(name="userName")//해당하는 컬럼명 설정해주는 어노테이션
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

package hellojpa;

import javax.persistence.*;

import java.util.Date;

@Entity
@TableGenerator(
		name = "MEMBER_SEQ_GENERATOR",
		table = "MY_SEQUENCES",
		pkColumnValue = "MEMBER_SEQ", allocationSize = 1)

public class Member {

	@Id
	@GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

//	@Column(name="TEAM_ID")
//	private Long teamId;
	@ManyToOne
	@JoinColumn(name="TEAM_ID")
	private Team team;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Team getTeam() {
		return team;
	}

	public void foreignKeySetTeam(Team team) {
		this.team = team;
		team.getMembers().add(this);//양방향 매핑하게 참조하는 team에 자신의 값을 넣음
	}
}//end of class

//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")

//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="member_seq_generator")

//@SequenceGenerator(name="member_seq_generator", sequenceName = "member_seq")
//@Table(name="USER")//해당하는 테이블명을 매핑해주는 어노테이션

//	@Column(name="userName")//해당하는 컬럼명 설정해주는 어노테이션


//	private Integer age;//DB에 적합한 타입으로 생성
//	@Enumerated(EnumType.STRING)//java의 Enum타입을 사용하고 싶으면 해당 언노테이션 사용 //!!Enum타입은 필수로 STRING설정해줘야함(ORDINAL이 순서를 망침)
//	private RoleType roleType;
//	@Temporal(TemporalType.TIMESTAMP)//시간 정보를 입력할 때 사용하는 어노테이션(3가지 타입이 있음)
//	private Date createdDate;
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date lastModifiedDate;
//	@Lob//대규모 데이터를 넣고 싶으면 해당 어노테이션을 사용
//	private String description;

//	public Integer getAge() {
//		return age;
//	}
//
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//
//	public RoleType getRoleType() {
//		return roleType;
//	}
//
//	public void setRoleType(RoleType roleType) {
//		this.roleType = roleType;
//	}
//
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	public Date getLastModifiedDate() {
//		return lastModifiedDate;
//	}
//
//	public void setLastModifiedDate(Date lastModifiedDate) {
//		this.lastModifiedDate = lastModifiedDate;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
package pl.honestit.spring.demo.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name = "users")
@Getter @Setter @ToString(exclude = {"password"})
@EqualsAndHashCode(of = {"id"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable= false)
	private String lastName;
	private Boolean active;
	
	
	public User(Long id, String username, String firstName, String lastName, String password, Boolean active) {
		this.active = active;
		this.firstName = firstName;
		this.id = id;
		this.lastName = lastName;
		this.password= password;
		this.username = username;
	}
	
	public User() {}
}

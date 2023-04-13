package cl.ey.bci.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cl.ey.bci.util.Util;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
	@Column(name = "id", columnDefinition = "uuid")
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "created")
	private Date created;

	@Column(name = "modified")
	private Date modified;

	@Column(name = "last_login")
	private Date last_login;

	@Column(name = "token")
	private String token;

	@Column(name = "isactive")
	private Boolean isactive;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Phone> phones;

	public void createDataUser() {
		Date date = new Date();
		this.created = date;
		this.modified = date;
		this.last_login = date;
		this.isactive = true;
		this.token = Util.generateToken(this.email);
	}

}
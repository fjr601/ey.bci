package cl.ey.bci.response;

import java.util.Date;
import java.util.UUID;

import cl.ey.bci.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response {
	private UUID id;
	private Date created;
	private Date modified;
	private Date last_login;
	private String token;
	private Boolean isactive;

	public Response(User user) {
		super();
		this.id = user.getId();
		this.created = user.getCreated();
		this.modified = user.getModified();
		this.last_login = user.getLast_login();
		this.token = user.getToken();
		this.isactive = user.getIsactive();
	}

}

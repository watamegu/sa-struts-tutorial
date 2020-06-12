package tutorial.dto;

import java.io.Serializable;
import java.util.List;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

@Component(instance = InstanceType.SESSION)
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public Long id;

	public String name;

	public String email;

	public String password;

	public Boolean admin;

	public List<UserDto> userList;

}
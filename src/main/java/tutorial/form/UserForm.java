package tutorial.form;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

@Component(instance = InstanceType.SESSION)
public class UserForm implements Serializable {

	private static final long serialVersionUID = 1L;

	public Long id;

	public String name;

	public String email;

	public String password;
}
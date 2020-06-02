package tutorial.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import tutorial.form.UserForm;

public class UserAction {

	public String name;
	public String email;

	@Resource
	protected HttpSession session;

	@ActionForm
	@Resource
	protected UserForm userForm;


	@Execute(validator = false)
	public String profile() {
		return "/user/profile.jsp";
	}

	@Execute(validator = false)
	@RemoveSession(name = "userDto")
	public String logout() {
		return "/login/index.jsp";
	}
}
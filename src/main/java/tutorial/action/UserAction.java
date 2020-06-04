package tutorial.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import tutorial.dto.UserDto;
import tutorial.form.UserForm;
import tutorial.service.UserService;

public class UserAction {

	public String name;
	public String email;
	public String password;

	@Resource
	protected HttpSession session;

	@ActionForm
	@Resource
	protected UserForm userForm;

	@Resource
    protected UserService userService;

	@Resource
	protected UserDto userDto;

   @Execute(validator = false)
    public String index() {
        return "/user/index.jsp";
    }

    @Execute(input = "index.jsp")
    public String regist() {
        userService.createUser();
        return "menu.jsp";
     }

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
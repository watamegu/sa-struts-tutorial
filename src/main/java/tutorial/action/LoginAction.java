package tutorial.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import tutorial.dto.UserDto;
import tutorial.entity.User;
import tutorial.form.UserForm;
import tutorial.service.UserService;

public class LoginAction {

    public String name;
    public String password;

    @Resource
    protected HttpSession session;

    @Resource
    protected UserService userService;

    @ActionForm
    @Resource
    protected UserForm userForm;

    @Resource
    protected UserDto userDto;

    @Execute(validator =false)
    public String index() {
        return "index.jsp";
    }

	@Execute(input = "index.jsp")
	public String login() {

	    try {
	        User user = userService.getUser(userForm.name, userForm.password);

            if (user != null ) {
                userDto.id = user.id;
                userDto.name = user.name;
                userDto.email = user.email;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

		return "/user/menu.jsp";
	}

}
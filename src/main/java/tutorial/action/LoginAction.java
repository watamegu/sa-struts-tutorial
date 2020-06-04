package tutorial.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.seasar.framework.beans.util.Beans;
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

	    /* 固定値設定
	    User user = new User();
	    user.id = 1L;
	    user.name = "test1";
	    user.email = "test1@seasar2.org";

	    userForm.id = user.id;
        userForm.name = user.name;
        userForm.email = user.email;
	    */

	    User user = userService.getUser(userForm.name, userForm.password);

        try {

            if (user != null ) {
                userDto.id = user.id;
                userDto.name = user.name;
                userDto.email = user.email;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        Beans.copy(userDto, userForm).execute();

		return "/user/menu.jsp";
	}

}
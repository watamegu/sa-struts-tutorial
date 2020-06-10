package tutorial.action;

import javax.annotation.Resource;

import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import tutorial.dto.UserDto;
import tutorial.entity.User;
import tutorial.form.MessageForm;
import tutorial.form.UserForm;
import tutorial.service.UserService;

public class LoginAction {

    @ActionForm
    @Resource
    protected UserForm userForm;

    @ActionForm
    @Resource
    protected MessageForm messageForm;

    @Resource
    protected UserService userService;

    @Resource
    protected UserDto userDto;

    @Execute(validator =false)
    public String index() {
        return "index.jsp";
    }

	@Execute(input = "index.jsp")
	public String login() {

	    try {
	        User user = userService.loginUser(userForm.name, userForm.password);
            if (user != null ) {
                userForm.id = user.id;
                userForm.name = user.name;
                userForm.email = user.email;
                userForm.password = user.password;
                Beans.copy(userForm, userDto).execute();
            } else {
                messageForm.message = "ユーザーが存在しません。";
                return "index.jsp";
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
		return "/post/list?redirect=true";

	}
}
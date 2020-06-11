package tutorial.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ActionMessagesUtil;

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

    public HttpSession session;

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
                setMessages("ユーザーが存在しません。");
                return "index.jsp";
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
		return "/post/list?redirect=true";

	}

	private void setMessages(String message) {
        ActionMessages messages = new ActionMessages();
        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(message, false));
        ActionMessagesUtil.saveMessages(session, messages);
    }
}
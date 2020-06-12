package tutorial.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ActionMessagesUtil;

import tutorial.dto.UserDto;
import tutorial.entity.User;
import tutorial.form.MessageForm;
import tutorial.form.UserForm;
import tutorial.service.UserService;

public class UserAction {

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

    @Execute(validator = false, urlPattern = "new")
    public String index() {
        return "new.jsp";
    }

    @Execute(validator = false)
    public String menu() {
        return "menu.jsp";
    }

    @Execute(input = "index.jsp")
    public String create() {
        userService.createUser(userForm.name, userForm.email, userForm.password, userForm.admin);
        return "../login?redirect=true";
    }

    @Execute(validator = false)
    public String list() {
        userForm.userList = userService.getAllUser();
        return "list.jsp";
    }

    @Execute(validator = false, urlPattern = "edit/{strId}")
    public String edit() {
        Long id = Long.parseLong(userForm.strId);
        User user = userService.getUser(id);
        Beans.copy(user, userForm).execute();
        return "edit.jsp";
    }

    @Execute(validator = false, urlPattern = "update/{strId}")
    public String update() {
        Long id = Long.parseLong(userForm.strId);
        int result = userService.updateUser(id, userForm.name, userForm.email, userForm.password);
        if(result == 1) {
            setMessages("ユーザーを更新しました。");
        } else {
            setMessages("ユーザー更新に失敗しました。");
        }
        return "edit/" + userForm.id;
    }

    @Execute(validator = false, urlPattern = "delete/{strId}")
    public String destroy() {
        Long id = Long.parseLong(userForm.strId);
        if(id != userDto.id) {
            int result = userService.destroyUser(id);
            if(result == 1) {
                setMessages("ユーザーを削除しました。");
            } else {
                setMessages("ユーザー削除に失敗しました。");
            }
        } else {
            setMessages("ログインユーザーの削除はできません。");
        }
        return "list";
    }

	@Execute(validator = false)
	public String profile() {
	    Beans.copy(userDto, userForm).execute();
		return "/user/profile.jsp";
	}

	@Execute(validator = false)
	@RemoveSession(name = "userDto")
	public String logout() {
		return "/login?redirect=true";
	}

	private void setMessages(String message) {
        ActionMessages messages = new ActionMessages();
        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(message, false));
        ActionMessagesUtil.saveMessages(session, messages);
    }

}
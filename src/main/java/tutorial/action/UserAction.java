package tutorial.action;

import javax.annotation.Resource;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

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

	public static final String update_BINDING_METHOD = "path=/update/{strId}";

    @Execute(validator = false, urlPattern = "new")
    public String index() {
        return "new.jsp";
    }

    @Execute(validator = false)
    public String menu() {
        return "menu.jsp";
    }

    @Execute(input = "index.jsp")
    public String regist() {
        userService.createUser();
        return "menu?redirect=true";
    }

    @Execute(validator = false)
    public String show() {
        userForm.userList = userService.getAllUser();
        return "show.jsp";
    }

    @Execute(validator = false, urlPattern = "edit/{strId}")
    public String edit() {
        User user = userService.getUser();
        Beans.copy(user, userForm).execute();
        return "edit.jsp";
    }

    @Execute(validator = false, urlPattern = "update/{strId}")
    public String update() {
        int result = userService.updateUser();
        if(result == 1) {
            messageForm.message = "ユーザーを更新しました。";
        } else {
            messageForm.message = "ユーザー更新に失敗しました。";
        }
        return "edit/" + userForm.id;
    }

    @Execute(validator = false, urlPattern = "delete/{strId}")
    public String destroy() {
        if(userForm.id != Long.parseLong(userForm.strId)) {
            int result = userService.DestroyUser();
            if(result == 1) {
                messageForm.message = "ユーザーを削除しました。";
            } else {
                messageForm.message = "ユーザー削除に失敗しました。";
            }
        } else {
            messageForm.message = "ログインユーザーの削除はできません。";
        }
        return "show";
    }

	@Execute(validator = false)
	public String profile() {
	    Beans.copy(userDto, userForm).execute();
		return "/user/profile.jsp";
	}

	@Execute(validator = false)
	@RemoveSession(name = "userForm")
	public String logout() {
		return "/login?redirect=true";
	}

}
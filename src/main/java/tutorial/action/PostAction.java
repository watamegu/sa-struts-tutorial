package tutorial.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ActionMessagesUtil;

import tutorial.dto.PostDto;
import tutorial.dto.UserDto;
import tutorial.entity.Post;
import tutorial.form.MessageForm;
import tutorial.form.PostForm;
import tutorial.form.UserForm;
import tutorial.service.PostService;

public class PostAction {

	@ActionForm
	@Resource
	protected PostForm postForm;

	@ActionForm
    @Resource
    protected UserForm userForm;

	@ActionForm
    @Resource
    protected MessageForm messageForm;

	@Resource
    protected PostService postService;

	@Resource
	protected PostDto postDto;

	@Resource
	protected UserDto userDto;

	public Long userId;
	public Long postId;
	public HttpSession session;

	@Execute(validator = false)
    public String list() {
        postForm.postList = postService.getAllPostsByUserId(userDto.id);
        Beans.copy(userDto.admin, userForm.admin).execute();
        if(postForm.postList.size() == 0) {
            setMessages("メモが1件も存在しません。");
        }
        return "list.jsp";
    }

    @Execute(validator = false, urlPattern = "show/{strId}")
    public String show() {
        userId = Long.parseLong(postForm.strId);
        Post post = postService.getPostById(userId);
        Beans.copy(post, postForm).execute();
        return "show.jsp";
    }

    @Execute(validator = false, urlPattern = "new")
    public String newMemo() {
        return "new.jsp";
    }

    @Execute(validator = false)
    public String create() {
        if(postForm.flag == null ) {
            postForm.flag = false;
        }
        int result = postService.createPost(postForm.title, postForm.content, userDto.id, postForm.flag);
        if(result == 1) {
            setMessages("メモを作成しました");
        } else {
            setMessages("メモ作成に失敗しました。");
        }
        return "list?redirect=true";
    }

    @Execute(validator = false, urlPattern = "edit/{strId}")
    public String edit() {
        userId = Long.parseLong(postForm.strId);
        Post result = postService.getPostById(userId);
        Beans.copy(result, postForm).execute();
        return "edit.jsp";
    }

    @Execute(validator = false, urlPattern = "update/{strId}")
    public String update() {
        postId = Long.parseLong(postForm.strId);
        if(postForm.flag == null ) {
            postForm.flag = false;
        }
        int result = postService.updatePost(postId, postForm.title, postForm.content, postForm.flag);
        if(result == 1) {
            setMessages("メモを更新しました。");
        } else {
            setMessages("メモを更新に失敗しました。");
            return "edit/" + postForm.strId + "?redirect=true";
        }
        return "show/" + postForm.strId + "?redirect=true";
    }

    @Execute(validator = false, urlPattern = "delete/{strId}")
    public String destroy() {
        postId = Long.parseLong(postForm.strId);
        int result = postService.destroyPost(postId);
        if(result == 1) {
            setMessages("メモを削除しました。");
        } else {
            setMessages("メモを削除に失敗しました。");
        }
        return "list?redirect=true";
    }

    private void setMessages(String message) {
        ActionMessages messages = new ActionMessages();
        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(message, false));
        ActionMessagesUtil.saveMessages(session, messages);
    }
}
package tutorial.action;

import javax.annotation.Resource;

import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import tutorial.dto.PostDto;
import tutorial.dto.UserDto;
import tutorial.entity.Post;
import tutorial.form.MessageForm;
import tutorial.form.PostForm;
import tutorial.service.PostService;

public class PostAction {

	@ActionForm
	@Resource
	protected PostForm postForm;

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

	@Execute(validator = false)
    public String list() {
        postForm.postList = postService.getAllPostsByUserId(userDto.id);
        if(postForm.postList.size() == 0) {
            messageForm.message = "メモが存在しません。";
        }
        return "list.jsp";
    }

    @Execute(validator = false, urlPattern = "show/{strId}")
    public String show() {
        userId = Long.parseLong(postForm.strId);
        Post result = postService.getPostById(userId);
        Beans.copy(result, postForm).execute();
        return "show.jsp";
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
        int result = postService.updatePost(postId, postForm.title, postForm.content);
        if(result == 1) {
            messageForm.message = "メモを更新しました。";
        } else {
            messageForm.message = "メモ更新に失敗しました。";
            return "edit/" + postForm.strId + "?redirect=true";
        }
        return "show/" + postForm.strId + "?redirect=true";
    }

    @Execute(validator = false, urlPattern = "delete/{strId}")
    public String destroy() {
        postId = Long.parseLong(postForm.strId);
        int result = postService.destroyPost(postId);
        if(result == 1) {
            messageForm.message = "メモを削除しました。";
        } else {
            messageForm.message = "メモ削除に失敗しました。";
        }
        return "list?redirect=true";
    }
}
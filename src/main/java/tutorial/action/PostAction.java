package tutorial.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import tutorial.dto.PostDto;
import tutorial.dto.UserDto;
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

    @Execute(validator = false)
    public String list() {
        postForm.postList = postService.getAllPostsByUserId(userDto.id);
        return "list.jsp";
    }

}
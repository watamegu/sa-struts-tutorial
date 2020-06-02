package tutorial.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

import tutorial.form.AjaxForm;

public class AjaxAction {

    public String message;

    @ActionForm
    @Resource
    protected AjaxForm ajaxForm;

	@Execute(validator = false)
	public String index() {
		return "index.jsp";
	}

	@Execute(validator = false)
	public String hello() {
	    message = String.valueOf(ajaxForm.message);
		ResponseUtil.write(message);
		return null;
	}
}
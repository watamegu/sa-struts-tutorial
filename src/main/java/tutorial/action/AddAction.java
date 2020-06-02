package tutorial.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import tutorial.form.AddForm;

public class AddAction {

    public String name;
    public String article;

    @ActionForm
    @Resource
    protected AddForm addForm;

    @Execute(validator = false)
    public String index() {
        return "index.jsp";
    }

    @Execute(input = "index.jsp")
    public String submit() {
        name = String.valueOf(addForm.name);
        article = String.valueOf(addForm.article);
        return "result.jsp";
    }

}
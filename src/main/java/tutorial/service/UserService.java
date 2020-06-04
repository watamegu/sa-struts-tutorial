package tutorial.service;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.struts.annotation.ActionForm;

import tutorial.entity.User;
import tutorial.form.UserForm;

public class UserService extends AbstractService<User> {

    @ActionForm
    @Resource
    protected UserForm userForm;

    public int createUser() {

        String name = userForm.name;
        String email = userForm.email;
        String password = userForm.password;

        int result =
            jdbcManager
                .updateBySql(
                    "INSERT INTO user VALUES(?,?,?)",
                        String.class,
                        String.class,
                        String.class)
                    .params(name, email, password)
                    .execute();

        return result;
    }


    public User getUser(String name, String password) {

        if (name == null) {
            throw new IllegalArgumentException("required username");
        }

        if (password == null) {
            throw new IllegalArgumentException("required password");
        }

        SimpleWhere where = new SimpleWhere();
        where.eq("name", name);
        where.eq("password", password);

        return select().where(where).getSingleResult();
    }

}
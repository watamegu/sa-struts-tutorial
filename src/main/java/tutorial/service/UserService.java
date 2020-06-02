package tutorial.service;

import org.seasar.extension.jdbc.service.S2AbstractService;
import org.seasar.extension.jdbc.where.SimpleWhere;

import tutorial.entity.User;

public class UserService extends S2AbstractService<User> {

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
package tutorial.service;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.struts.annotation.ActionForm;

import tutorial.dto.UserDto;
import tutorial.entity.User;
import tutorial.form.UserForm;

public class UserService extends AbstractService<User> {

    @ActionForm
    @Resource
    protected UserForm userForm;

    //ログイン時検索
    public User loginUser(String name, String password) {

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

    //1件検索
    public User getUser() {
        Long id = Long.parseLong(userForm.strId);
        User result =
                jdbcManager
                    .from(User.class)
                    .where("id = ?", id)
                    .getSingleResult();
        return result;
    }

    //全件検索
    public List<UserDto> getAllUser() {
        List<UserDto> results =
                jdbcManager
                    .selectBySql(
                        UserDto.class,
                        "SELECT * FROM USER")
                    .getResultList();
        return results;
    }

    //ユーザー登録
    public int createUser() {

        String name = userForm.name;
        String email = userForm.email;
        String password = userForm.password;

        int result =
            jdbcManager
                .updateBySql(
                    "INSERT INTO user(name,email,password) VALUES(?,?,?)",
                        String.class,
                        String.class,
                        String.class)
                .params(name, email, password)
                .execute();
        return result;
    }

    //ユーザー更新
    public int updateUser() {

        Long id = Long.parseLong(userForm.strId);
        String name = userForm.name;
        String email = userForm.email;
        String password = userForm.password;

        int result =
                jdbcManager
                    .updateBySql(
                        "UPDATE user "
                      + "SET name = ?, email = ?, password = ? "
                      + "WHERE id = ?",
                            String.class,
                            String.class,
                            String.class,
                            Long.class)
                    .params(name, email, password, id)
                    .execute();
        return result;
    }

    //ユーザー削除
    public int DestroyUser() {

        Long id = Long.parseLong(userForm.strId);

        int result =
                jdbcManager
                    .updateBySql(
                        "DELETE FROM user WHERE id = ?",
                            Long.class)
                    .params(id)
                    .execute();
        return result;
    }


}
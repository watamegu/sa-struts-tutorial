package tutorial.service;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;

import tutorial.dto.PostDto;
import tutorial.entity.Post;
import tutorial.entity.User;
import tutorial.form.PostForm;

public class PostService extends AbstractService<User> {

    @ActionForm
    @Resource
    protected PostForm postForm;

    // メモ一覧取得
    public List<PostDto> getAllPostsByUserId(Long user_id) {
        List<PostDto> results =
                jdbcManager
                    .selectBySql(
                        PostDto.class,
                        "SELECT * FROM POST WHERE user_id = ?",
                        user_id)
                    .getResultList();
        return results;
    }

    // メモ詳細取得
    public Post getPostById(Long id) {
        Post result =
                jdbcManager
                    .from(Post.class)
                    .where("id = ?", id)
                    .getSingleResult();
                return result;
    }

    // 新規メモ作成
    public int createPost(String title, String content, Long userId, Boolean flag) {
        int result =
            jdbcManager
                .updateBySql(
                    "INSERT INTO post(title, content, user_id,flag) VALUES(?,?,?,?)",
                        String.class,
                        String.class,
                        Long.class,
                        Boolean.class)
                .params(title, content, userId, flag)
                .execute();
        return result;
    }

    // メモ更新
    public int updatePost(Long id, String title, String content, Boolean flag) {
        int result =
                jdbcManager
                    .updateBySql(
                        "UPDATE post "
                      + "SET title = ?, content = ?, flag = ? "
                      + "WHERE id = ?",
                            String.class,
                            String.class,
                            Boolean.class,
                            Long.class)
                    .params(title, content, flag, id)
                    .execute();
        return result;
    }

    // メモ削除
    public int destroyPost(Long id) {
        int result =
                jdbcManager
                    .updateBySql(
                        "DELETE FROM post WHERE id = ?",
                            Long.class)
                    .params(id)
                    .execute();
        return result;
    }
}

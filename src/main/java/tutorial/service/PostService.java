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
    public Post getPostById(Long postId) {
        Post result =
                jdbcManager
                    .from(Post.class)
                    .where("id = ?", postId)
                    .getSingleResult();
                return result;
    }

    // メモ更新
    public int updatePost(Long id, String title, String content) {
        int result =
                jdbcManager
                    .updateBySql(
                        "UPDATE post "
                      + "SET title = ?, content = ? "
                      + "WHERE id = ?",
                            String.class,
                            String.class,
                            Long.class)
                    .params(title, content, id)
                    .execute();
        return result;
    }
}

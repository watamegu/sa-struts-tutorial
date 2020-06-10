package tutorial.service;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;

import tutorial.dto.PostDto;
import tutorial.entity.User;
import tutorial.form.PostForm;

public class PostService extends AbstractService<User> {

    @ActionForm
    @Resource
    protected PostForm postForm;

    //メモ一覧取得
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
}

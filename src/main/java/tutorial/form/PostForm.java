package tutorial.form;

import java.io.Serializable;
import java.util.List;

import tutorial.dto.PostDto;

public class PostForm implements Serializable {

	public Long id;

	public String title;

	public String content;

	public Long user_id;

	public Boolean flag;

	// メモ一覧表示用
	public List<PostDto> postList;

	// URLパラメータ用
	public String strId;

}
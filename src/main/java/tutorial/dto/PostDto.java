package tutorial.dto;

import java.io.Serializable;
import java.util.List;

public class PostDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public Long id;

	public String title;

	public String content;

	public Long user_id;

	public List<PostDto> postList;

}
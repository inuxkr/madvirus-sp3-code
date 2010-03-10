package madvirus.spring.chap08;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {

	private int lastId = 0;
	private List<Comment> comments = new ArrayList<Comment>();
	
	@Override
	public Comment save(Comment comment) {
		comment.setId(++lastId);
		comments.add(comment);
		return comment;
	}

	@Override
	public List<Comment> findAll() {
		return comments;
	}

}

package madvirus.spring.chap08;

import java.util.List;

public interface CommentService {

	Comment write(Comment comment);
	
	List<Comment> list();
}

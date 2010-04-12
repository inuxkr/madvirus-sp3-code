package madvirus.spring.appa;

import java.util.List;

public interface CommentService {

	Comment write(Comment comment);
	
	List<Comment> list();
}

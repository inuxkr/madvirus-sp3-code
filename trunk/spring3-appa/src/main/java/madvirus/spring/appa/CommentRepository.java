package madvirus.spring.appa;

import java.util.List;

public interface CommentRepository {

	Comment save(Comment comment);

	List<Comment> findAll();

}

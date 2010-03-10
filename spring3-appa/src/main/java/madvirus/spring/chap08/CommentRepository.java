package madvirus.spring.chap08;

import java.util.List;

public interface CommentRepository {

	Comment save(Comment comment);

	List<Comment> findAll();

}

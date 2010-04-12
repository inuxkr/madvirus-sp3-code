package madvirus.spring.appa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {

	@RequestMapping("/comment.do")
	public String comment() {
		return "comment";
	}
}

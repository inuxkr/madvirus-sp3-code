package madvirus.spring.chap06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

	@RequestMapping("/search/internal.do")
	public String searchInternal(@RequestParam("query") String query,
			@RequestParam(value = "p", defaultValue = "1") int pageNumber) {
		return "";
	}
}

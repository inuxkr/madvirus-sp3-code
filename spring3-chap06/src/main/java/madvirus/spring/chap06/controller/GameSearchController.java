package madvirus.spring.chap06.controller;

import madvirus.spring.chap06.service.SearchCommand;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameSearchController {

	@RequestMapping("/search/game")
	public ModelAndView search(SearchCommand command) {
		ModelAndView mav = new ModelAndView("search/game");
		mav.addObject("result", new Object());
		return mav;
	}
}

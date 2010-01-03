package madvirus.spring.chap06.controller;

import java.util.ArrayList;
import java.util.List;

import madvirus.spring.chap06.service.SearchCommand;
import madvirus.spring.chap06.service.SearchResult;
import madvirus.spring.chap06.service.SearchService;
import madvirus.spring.chap06.service.SearchType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameSearchController {
	private SearchService searchService;

	@ModelAttribute("searchTypeList")
	public List<SearchType> referenceSearchTypeList() {
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "아이템"));
		options.add(new SearchType(3, "캐릭터"));
		return options;
	}

	@ModelAttribute("popularQueryList")
	public String[] getPopularQueryList() {
		return new String[] { "게임", "창천2", "위메이드" };
	}

	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}

	@RequestMapping("/search/game.do")
	public ModelAndView search(@ModelAttribute("command") SearchCommand command) {
		ModelAndView mav = new ModelAndView("search/game");
		SearchResult result = searchService.search(command);
		mav.addObject("searchResult", result);
		return mav;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

}

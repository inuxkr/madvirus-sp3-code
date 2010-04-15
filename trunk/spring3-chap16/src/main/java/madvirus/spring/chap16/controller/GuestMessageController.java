package madvirus.spring.chap16.controller;

import madvirus.spring.chap16.model.GuestMessageList;
import madvirus.spring.chap16.service.GuestMessageService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/message/list/${pageNo}")
public class GuestMessageController {

	private GuestMessageService guestMessageService;

	@RequestMapping(method = RequestMethod.GET)
	public String getList(@PathVariable(value="pageNo") int pageNo, ModelMap model) {
		GuestMessageList messageList = guestMessageService
				.getMessageList(pageNo);
		model.addAttribute("messageList", messageList);
		return "message/list";
	}

	public void setGuestMessageService(GuestMessageService guestMessageService) {
		this.guestMessageService = guestMessageService;
	}

}

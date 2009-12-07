package kame.spring.chap05;

import kame.spring.chap05.board.Article;
import kame.spring.chap05.board.service.WriteArticleService;
import kame.spring.chap05.member.Member;
import kame.spring.chap05.member.service.MemberService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainQuickStart2 {

	public static void main(String[] args) {
		String[] configLocations = new String[] { "acQuickStart2.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);

		WriteArticleService articleService = (WriteArticleService) context
				.getBean("writeArticleService");
		articleService.write(new Article());

		MemberService memberService = context.getBean("memberService",
				MemberService.class);
		memberService.regist(new Member());
	}
}

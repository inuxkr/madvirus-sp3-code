package madvirus.spring.chap16.model;

import java.util.List;

public class GuestMessageList {
	private int totalCount;
	private int pageNum;
	private int begin;
	private int end;
	private List<GuestMessage> messages;

	public GuestMessageList(int totalCount, int pageNum, int begin, int end,
			List<GuestMessage> messages) {
		super();
		this.totalCount = totalCount;
		this.pageNum = pageNum;
		this.begin = begin;
		this.end = end;
		this.messages = messages;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getBegin() {
		return begin;
	}

	public int getEnd() {
		return end;
	}

	public List<GuestMessage> getMessages() {
		return messages;
	}

}

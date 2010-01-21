package madvirus.spring.chap07.controller;

public class PageRank {

	private int rank;
	private String page;

	public PageRank(int rank, String page) {
		this.rank = rank;
		this.page = page;
	}

	public int getRank() {
		return rank;
	}

	public String getPage() {
		return page;
	}

}

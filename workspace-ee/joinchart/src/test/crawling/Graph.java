package test.crawling;

public class Graph {
	private int hour;
	private int rank;
	private String notIn;
	private String week;
	
	public Graph(int hour, String notIn) {
		super();
		this.hour = hour;
		this.notIn = notIn;
	}
	
	public Graph(String week) {
		super();
		this.week = week;
	}

	public String getNotIn() {
		return notIn;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Graph [hour=" + hour + ", rank=" + rank + ", notIn=" + notIn + "]";
	}
	
}

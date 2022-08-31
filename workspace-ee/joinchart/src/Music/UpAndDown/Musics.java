package Music.UpAndDown;

public class Musics {
	int rank;
	String title;
	String upAnddown;
	public Musics(int rank, String title, String upAnddown) {
		super();
		this.rank = rank;
		this.title = title;
		this.upAnddown = upAnddown;
	}
	
	public Musics(int rank, String title) {
		super();
		this.rank = rank;
		this.title = title;
	}

	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUpAnddown() {
		return upAnddown;
	}
	public void setUpAnddown(String upAnddown) {
		this.upAnddown = upAnddown;
	}
	@Override
	public String toString() {
		return "Musics [rank=" + rank + ", title=" + title + ", upAnddown=" + upAnddown + "]";
	}
	
}

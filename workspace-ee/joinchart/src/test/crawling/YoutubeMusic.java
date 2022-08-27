package test.crawling;

public class YoutubeMusic {
	private int rank;
	private String title;
	private String albumArt;
	private String link;
	
	public YoutubeMusic(int rank, String title, String albumArt, String link) {
		this.rank = rank;
		this.title = title;
		this.albumArt = albumArt;
		this.link = link;
	}
	
	public String getTitle() {
		return title;
	}
	public int getRank() {
		return rank;
	}

	public String getAlbumArt() {
		return albumArt;
	}
	public String getLink() {
		return link;
	}
	
}


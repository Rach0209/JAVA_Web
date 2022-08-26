package test.crawling;

public class YoutubeMusic {
	private int rank;
	private String title;
	private String albumArt;
	private String artist;
	
	public YoutubeMusic(int rank, String title, String artist, String albumArt) {
		this.rank = rank;
		this.title = title;
		this.artist = artist;
		this.albumArt = albumArt;
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
	public String getArtist() {
		return artist;
	}
	
}

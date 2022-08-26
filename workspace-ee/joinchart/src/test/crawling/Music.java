package test.crawling;

public class Music {
	private int rank;
	private String updown;
	private String title;
	private String artist;
	private String album;
	private String albumArt;
	public Music() {
		super();
	}
	public Music(int rank, String title, String artist, String album, String albumArt) {
		super();
		this.rank = rank;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.albumArt = albumArt;
		
	}
	public Music(int rank, String updown, String title, String artist, String album, String albumArt) {
		super();
		this.rank = rank;
		this.updown = updown;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.albumArt = albumArt;
		
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getUpdown() {
		return updown;
	}
	public void setUpdown(String updown) {
		this.updown = updown;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getAlbumArt() {
		return albumArt;
	}
	public void setAlbumArt(String albumart) {
		this.albumArt = albumart;
	}
	@Override
	public String toString() {
		return "순위 : " + rank+ ", 순위등락: " + updown + ", 제목: " + title + ", 가수: " + artist + ", 앨범: " + album + ", 앨범아트: " + albumArt;
	}
	
}

package test.crawling;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Vibej {

	public static List<Music> crawlingVibe() throws IOException {
		URL url = new URL("https://apis.naver.com/vibeWeb/musicapiweb/vibe/v1/chart/track/total?start=1&display=100");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");
		
		httpConn.setRequestProperty("authority", "apis.naver.com");
		httpConn.setRequestProperty("accept", "application/json");
		httpConn.setRequestProperty("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");
		httpConn.setRequestProperty("cookie",
				"NNB=K2FSISXKZEDGG; _ga_7VKFYR6RV1=GS1.1.1661397367.1.1.1661397382.45.0.0; X-Tx-Id=5c828838-db79-4516-86d1-8215f9cb1cc9; _gid=GA1.2.891223298.1661493936; _gat_gtag_UA_132321908_1=1; _ga=GA1.1.1180564165.1661389291; _ga_4BKHBFKFK0=GS1.1.1661493935.2.1.1661493940.55.0.0");
		httpConn.setRequestProperty("origin", "https://vibe.naver.com");
		httpConn.setRequestProperty("referer", "https://vibe.naver.com/chart/total");
		httpConn.setRequestProperty("sec-ch-ua",
				"\"Chromium\";v=\"104\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"104\"");
		httpConn.setRequestProperty("sec-ch-ua-mobile", "?0");
		httpConn.setRequestProperty("sec-ch-ua-platform", "\"Windows\"");
		httpConn.setRequestProperty("sec-fetch-dest", "empty");
		httpConn.setRequestProperty("sec-fetch-mode", "cors");
		httpConn.setRequestProperty("sec-fetch-site", "same-site");
		httpConn.setRequestProperty("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");
		
		InputStream responseStream = httpConn.getResponseCode() / 100 == 2 ? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response);
		
		List<JsonNode> upAndDown = node.findValues("rankVariation");
		List<JsonNode> trackList = node.findValues("trackTitle");
		List<JsonNode> artist = node.findValues("artists");
		List<JsonNode> albumList = node.findValues("albumTitle");
		List<JsonNode> albumArt = node.findValues("album");
		
		List<Music> vibelist = new ArrayList<>();
		for (int i = 0; i < trackList.size(); i++) {
			int rank = i + 1;
			String upAndDown_temp = String.valueOf(upAndDown.get(i)).replaceAll("\"", "");
			int uad = Integer.valueOf(upAndDown_temp);
			if ( uad == 0) {
				upAndDown_temp = "- ";
			} else if ( uad > 0 ) {
				upAndDown_temp = "↑ ";
			} else if ( uad < 0 ) {
				upAndDown_temp = "↓ ";
			}
			String trackList_temp = trackList.get(i).toString().replaceAll("\"", "");
			String artistList_temp = artist.get(i * 2).findValue("artistName").toString().replaceAll("\"", "");
			String albumList_temp = albumList.get(i).toString().replaceAll("\"", "");
			String albumArtList_temp = albumArt.get(i).findValue("imageUrl").toString().replaceAll("\"", "");
			vibelist.add(new Music(rank, upAndDown_temp, trackList_temp, artistList_temp, albumList_temp, albumArtList_temp));
		}
		return vibelist;
	}
	
	public static String vibeTime() throws IOException {
		URL url = new URL("https://apis.naver.com/vibeWeb/musicapiweb/vibe/v1/chart/track/total?start=1&display=100");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");
		
		httpConn.setRequestProperty("authority", "apis.naver.com");
		httpConn.setRequestProperty("accept", "application/json");
		httpConn.setRequestProperty("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");
		httpConn.setRequestProperty("cookie",
				"NNB=K2FSISXKZEDGG; _ga_7VKFYR6RV1=GS1.1.1661397367.1.1.1661397382.45.0.0; X-Tx-Id=5c828838-db79-4516-86d1-8215f9cb1cc9; _gid=GA1.2.891223298.1661493936; _gat_gtag_UA_132321908_1=1; _ga=GA1.1.1180564165.1661389291; _ga_4BKHBFKFK0=GS1.1.1661493935.2.1.1661493940.55.0.0");
		httpConn.setRequestProperty("origin", "https://vibe.naver.com");
		httpConn.setRequestProperty("referer", "https://vibe.naver.com/chart/total");
		httpConn.setRequestProperty("sec-ch-ua",
				"\"Chromium\";v=\"104\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"104\"");
		httpConn.setRequestProperty("sec-ch-ua-mobile", "?0");
		httpConn.setRequestProperty("sec-ch-ua-platform", "\"Windows\"");
		httpConn.setRequestProperty("sec-fetch-dest", "empty");
		httpConn.setRequestProperty("sec-fetch-mode", "cors");
		httpConn.setRequestProperty("sec-fetch-site", "same-site");
		httpConn.setRequestProperty("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");
		
		InputStream responseStream = httpConn.getResponseCode() / 100 == 2 ? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response);
		
		List<JsonNode> vibeTime_temp = node.findValues("chartDate");
		String vibeTime = vibeTime_temp.toString().substring(2, 19);
			
		return vibeTime;
	}
	public static void main(String[] args) {
		Vibej f = new Vibej();
		try {
	         List<Music> list = f.crawlingVibe();
	         for (Music m : list) {
	            System.out.println(m);
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
		
		
		//		try {
//			String time = vibeTime();
//			System.out.println(time);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
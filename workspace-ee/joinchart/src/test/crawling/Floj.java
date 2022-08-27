package test.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.InputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Floj {

	public static List<Music> crawlingFlo() throws IOException {
		URL url = new URL("https://www.music-flo.com/api/display/v1/browser/chart/1/track/list?size=100");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");

		httpConn.setRequestProperty("authority", "www.music-flo.com");
		httpConn.setRequestProperty("accept", "application/json, text/plain, */*");
		httpConn.setRequestProperty("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");
		httpConn.setRequestProperty("cookie",
				"x-gm-device-id=V04-Y-6FF368136FBEDF621D4515CD69503A8A; initPopup_1018=false; x-gm-app-name=FLO_WEB; x-gm-app-version=6.7.0; x-gm-os-type=WEB; x-gm-os-version=10; osType=PC_WEB");
		httpConn.setRequestProperty("referer", "https://www.music-flo.com/browse");
		httpConn.setRequestProperty("sec-ch-ua",
				"\"Chromium\";v=\"104\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"104\"");
		httpConn.setRequestProperty("sec-ch-ua-mobile", "?0");
		httpConn.setRequestProperty("sec-ch-ua-platform", "\"Windows\"");
		httpConn.setRequestProperty("sec-fetch-dest", "empty");
		httpConn.setRequestProperty("sec-fetch-mode", "cors");
		httpConn.setRequestProperty("sec-fetch-site", "same-origin");
		httpConn.setRequestProperty("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");
		httpConn.setRequestProperty("x-gm-app-name", "FLO_WEB");
		httpConn.setRequestProperty("x-gm-app-version", "6.7.0");
		httpConn.setRequestProperty("x-gm-device-id", "V04-Y-6FF368136FBEDF621D4515CD69503A8A");
		httpConn.setRequestProperty("x-gm-device-model", "Windows_Chrome");
		httpConn.setRequestProperty("x-gm-os-type", "WEB");
		httpConn.setRequestProperty("x-gm-os-version", "10");

		InputStream responseStream = httpConn.getResponseCode() / 100 == 2 ? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response);
		
		List<Music> flolist = new ArrayList<>();
		// 전체 리스트
		List<JsonNode> titleList = node.findValues("trackList");
		// 제목 리스트
		List<JsonNode> titletempList = titleList.get(0).findValues("name");

		for (int i = 0; i < 100; i++) {
			titletempList.remove(titleList.get(0).findValues("representationArtist").get(i).findValue("name"));
			titletempList.remove(titleList.get(0).findValues("artistList").get(i).findValue("name"));
		}
		
		List<JsonNode> upAndDown = node.findValues("rank");
		List<JsonNode> artistList = node.findValues("artistList");
		List<JsonNode> albumList = node.findValues("album");
		List<JsonNode> albumArtList = node.findValues("imgList");
		System.out.println(albumArtList);
		
		//순위 등락 조건문 (플로는 New가 없음)
		for (int i = 0; i < 100; i++) {
			int rank = i + 1;
			// 등락처리
			String upAndDown_temp = String.valueOf(upAndDown.get(i).findValues("rankBadge")).replaceAll("[\\[\"\\]]", "");
			int uad = Integer.valueOf(upAndDown_temp);
			if ( uad == 0) {
				upAndDown_temp = "- ";
			} else if ( uad > 0 ) {
				upAndDown_temp = "↑" + String.valueOf(uad) + " ";
			} else if ( uad < 0 ) {
				upAndDown_temp = "↓" + String.valueOf(uad * -1) + " ";
			}
			// 곡명처리
			String titleList_temp = String.valueOf(titletempList.get(i)).replaceAll("\"", "");
			// 가수 처리
			String artistList_temp = String.valueOf(artistList.get(i).findValues("name")).replaceAll("[\\[\"\\]]", "");
			// 앨범명 처리
			String albumList_temp = String.valueOf(albumList.get(i).findValues("title")).replaceAll("[\\[\"\\]]", "");
			// 앨범 이미지 처리
			String albumArtList_temp = String.valueOf(albumArtList.get(i+1).findValues("url")).replaceAll("[\\[\"\\]]", "");

			flolist.add(new Music(rank, upAndDown_temp, titleList_temp, artistList_temp, albumList_temp, albumArtList_temp));
		}
		return flolist;
	}
	
	public static void main(String[] args) {
		
		Floj f = new Floj();
		try {
	         List<Music> list = f.crawlingFlo();
	         for (Music m : list) {
	            System.out.println(m);
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}
}

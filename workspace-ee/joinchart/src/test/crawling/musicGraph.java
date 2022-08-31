package test.crawling;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class musicGraph {
	public static List<List<String>> Graph() {
		LocalDateTime now = LocalDateTime.now();	
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("MM/dd");
		DateTimeFormatter hourformatter = DateTimeFormatter.ofPattern("HH");
		
		List<String> dateList = new ArrayList<>();
		List<String> hourList = new ArrayList<>();
		List<List<String>> graphlist = new ArrayList<>();
		
		//3일 날짜 구하기
		for (int i = 0; i < 3; i++ ) {
			String date;
			if (i ==0) {
				date = now.format(dateformatter);
			} else {
				date = now.minusDays(i).format(dateformatter);
			}
			String date2 = now.minusDays(i+1).format(dateformatter);
			dateList.add(String.valueOf((date2 + "~" + date)));
		}
		graphlist.add(dateList);
		
		//24시간 구하기
		for (int i = 23; i >= 0 ; i-- ) {
//			if (i ==0) {
//				hour = now.format(hourformatter);
//			} else {
//				hour = now.minusDays(i).format(hourformatter);
//			}
			String hour = now.minusHours(i).format(hourformatter);
			hourList.add(String.valueOf(hour + ":" + "00"));
		}
		graphlist.add(hourList);
		
		return graphlist;
	}
	public static void main(String[] args) {

	}
}

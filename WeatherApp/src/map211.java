/*
Johnathan Chi
Student ID: 202467624
10/21/2022
Creates html file from user input with weather Info 
*/

import java.awt.Desktop;
import java.io.*;
import java.util.*;

public class map211 extends myWeatherApp {
	static String html;
	static String weather;
	static String mapFileName = "myMap.html";

	map211(ArrayList<String> weatherInfo, String mapType, int zoom) throws IOException {

		String city = weatherInfo.get(0);
		String description = weatherInfo.get(1);
		String temp = weatherInfo.get(2);
		String minTemp = weatherInfo.get(3);
		String maxTemp = weatherInfo.get(4);
		String windSpeed = weatherInfo.get(5);
		String humidity = weatherInfo.get(6);

		weather = " " + city.toUpperCase() + "   | " + description + " | " + temp + "  |" + minTemp + "  |" + maxTemp
				+ "  |" + windSpeed + "  |" + humidity + "  |";

		// HTML file
		writeHTML(weather, city, mapType, zoom);

		String url = mapFileName;
		File htmlFile = new File(url);
		Desktop.getDesktop().browse(htmlFile.toURI());
	}

	// HTML file with input
	public static void writeHTML(String weatherNow, String city, String mapType, int zoom) {
		html = "<!DOCTYPE html>" + "<html>" + "<body>" + "<h2>" + weatherNow + "</h2>" + "<iframe" + "  width=1200"
				+ "  height=900" + "  style=border:0" + "  loading=lazy" + "  allowfullscreen"
				+ "  referrerpolicy=\"no-referrer-when-downgrade\""
				+ "src=\"https://www.google.com/maps/embed/v1/place?key=AIzaSyCsz63nmfNR8pGj2udR6lv3Hz_-8UnzfyI&q="
				+ city + "&zoom=" + zoom + "&maptype=" + mapType + "\"" + "</iframe>" + "</body>" + "</html>";

		File f = new File(mapFileName);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(html);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
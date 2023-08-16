
/*
Johnathan Chi
Student ID: 202467624
10/21/2022
Reads information from JSON file and adds to weatherInfo
*/
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class weather211 extends myWeatherApp {

	public static boolean CityWeather(String cityName) throws Exception {

		boolean validCityName = false;

		try {

			// Create a URL instance
			String firstPartURL = "https://api.openweathermap.org/data/2.5/weather?q=";
			String secondPartURL = "&appid=69c88899fc8dc7553751b56a54230a83";
			String theURL = firstPartURL + cityName + secondPartURL;
			URL url = new URL(theURL);

			/// Reads information from URL
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			// JSON parser object
			JSONParser jsonParser = new JSONParser();
			// Read JSON file, stored in “myObject"
			JSONObject myObject = (JSONObject) jsonParser.parse(br);

			// add city name
			weatherInfo.add(cityName);

			// Get Description
			JSONArray weatherArray = (JSONArray) myObject.get("weather");
			JSONObject w = (JSONObject) weatherArray.get(0);
			String weatherNow = (String) w.get("description");
			weatherInfo.add(weatherNow);

			// Get temperature
			double cityTemp = (double) ((JSONObject) myObject.get("main")).get("temp");
			cityTemp = ((cityTemp - 273.15) * 9) / 5 + 32;// convert to Fahrenheit;
			String tempNow = "Temperature: " + String.format("%.1f", cityTemp) + "\u00B0";
			weatherInfo.add(tempNow);

			// Get minimum temperature
			double cityTempMin = (double) ((JSONObject) myObject.get("main")).get("temp_min");
			cityTempMin = ((cityTempMin - 273.15) * 9) / 5 + 32;// convert to Fahrenheit;
			String tempMin = "Low Temp: " + String.format("%.1f", cityTempMin) + "\u00B0";
			weatherInfo.add(tempMin);

			// Get maximum temperature
			double cityTempMax = (double) ((JSONObject) myObject.get("main")).get("temp_max");
			cityTempMax = ((cityTempMax - 273.15) * 9) / 5 + 32;
			String tempMax = "High Temp: " + String.format("%.1f", cityTempMax) + "\u00B0";
			weatherInfo.add(tempMax);

			// Get wind speed
			double cityWindSpeed = (double) ((JSONObject) myObject.get("wind")).get("speed");
			String windSpeed = "Wind Speed: " + String.format("%.1f", cityWindSpeed) + "mph";
			weatherInfo.add(windSpeed);

			// Get humidity
			long cityHumidity = (long) ((JSONObject) myObject.get("main")).get("humidity");
			String humidity = "Humidity: " + (cityHumidity) + "%";
			weatherInfo.add(humidity);
			validCityName = true;

		} catch (Exception ex) {
			return validCityName = false;
		}
		return validCityName;

	}

	public static ArrayList<String> getCityWeatherNow() {
		return weatherInfo;
	}

}

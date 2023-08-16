
/*
Johnathan Chi
Student ID: 202467624
10/21/2022
Takes user input and calls weather211 and Map211
*/
import java.util.*;

public class myWeatherApp {
	static Scanner consol = new Scanner(System.in);
	public static ArrayList<String> weatherInfo = new ArrayList<>();
	static String mapType;
	static int zoom;

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to Weather 211 - Fall 2022");
		System.out.println();

		inputCityName();
		getWeatherInfo();
	}

	// Get user input and call weather 211
	public static void inputCityName() throws Exception {
		boolean validCityName = false;
		while (!validCityName) {
			System.out.println("Input a city name:");
			String city = consol.nextLine();

			boolean valid = weather211.CityWeather(city);

			if (valid) {
				System.out.println("Select map type:  1) Roadmap   2) Satellite");
				int type = consol.nextInt();
				if (type == 1) {
					mapType = "roadmap";
				} else if (type == 2) {
					mapType = "satellite";
				} else {
					break;
				}
				System.out.println("Select zoom level of the map: 0 ~ 21   (Default = 14)");
				int size = consol.nextInt();
				zoom = size;
				System.out.println("Current Weather [" + city + "]\n");
				break;
			} else {

				System.out.println("Invalid city name. Type again.\n");
			}
		}
	}

	// Get array of weatherInfo
	public static void getWeatherInfo() throws Exception {

		weatherInfo = weather211.getCityWeatherNow();

		// print text version
		for (int i = 0; i < weatherInfo.size(); i++) {
			System.out.println(weatherInfo.get(i));
		}

		// call Map211
		new map211(weatherInfo, mapType, zoom);
	}

}

package loesninger._13;

import java.util.List;
import java.util.Scanner;

public class Program {
    private final WorldService worldService;
    public Program(){
        worldService = new WorldService();
    }
    public void run(){
        System.out.println("Welcome to this beautiful program.");
        int choice = 0;
        Scanner userInput = new Scanner(System.in);
        while(choice!=4){
            presentMainMenu();
            choice = userInput.nextInt();
            switch(choice){
                case 1 -> presentAllCountries();
                case 2 -> presentAllCities();
                case 3 -> presentAllCitiesByCountryCode();
                case 4 -> quit();
            }
        }
    }

    private void quit() {
        System.out.println("Bye!");
    }

    private void presentAllCitiesByCountryCode() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter country code:");
        String countryCode = userInput.nextLine();
        List<City> cities = worldService.getAllCitiesByCountryCode(countryCode);
        System.out.printf("Found %d cities.%n", cities.size());
        for (City city : cities) {
            System.out.println(city);
        }
    }

    private void presentAllCities() {
        List<City> cities = worldService.getAllCities();
        System.out.printf("Found %d cities.%n", cities.size());
        System.out.println("Here are 10 of them");
        for (int i = 0; i < 10; i++) {
            System.out.println(cities.get(i));
        }
    }

    private void presentAllCountries() {
        List<Country> countries = worldService.getAllCountries();
        System.out.println("Here are all the countries:");
        for (Country country : countries) {
            System.out.println(country);
        }
    }

    private void presentMainMenu() {
        System.out.println("You have 4 choices:");
        System.out.println("1: Get all countries");
        System.out.println("2: Get all cities");
        System.out.println("3: Get cities by country code");
        System.out.println("4: Quit");
    }
}

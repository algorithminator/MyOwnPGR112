package loesninger._15;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldService {
    private final MysqlDataSource worldDS;
    private static final String GET_ALL_COUNTRIES_SQL = "SELECT * FROM Country";
    private static final String GET_ALL_CITIES_SQL = "SELECT * FROM City";
    private static final String GET_ALL_CITIES_BY_COUNTRY_CODE_SQL = "SELECT * FROM City WHERE CountryCode=?";
    private static final String ADD_CITY_SQL = "INSERT INTO city VALUES (?,?,?,?,?)";
    private static final String UPDATE_CITY_SQL = "UPDATE City SET Name=?, CountryCode=?, District=?, Population=? WHERE id=?";
    private static final String DELETE_CITY_SQL = "DELETE FROM City WHERE id=?";

    // I added a string to continent mapper here to use an ENUM for continent in Country
    private static final Map<String, Continent> continentMapper;

    static{
        continentMapper = new HashMap<>();
        continentMapper.put("Asia", Continent.ASIA);
        continentMapper.put("Europe", Continent.EUROPE);
        continentMapper.put("North America", Continent.NORTH_AMERICA);
        continentMapper.put("Africa", Continent.AFRICA);
        continentMapper.put("Oceania", Continent.OCEANIA);
        continentMapper.put("Antarctica", Continent.ANTARCTICA);
        continentMapper.put("South America", Continent.SOUTH_AMERICA);
    }

    public WorldService(){
        worldDS = new MysqlDataSource();
        worldDS.setServerName(PropertiesProvider.PROPS.getProperty("host"));
        worldDS.setPortNumber(Integer.parseInt(PropertiesProvider.PROPS.getProperty("port")));
        worldDS.setDatabaseName(PropertiesProvider.PROPS.getProperty("db_name"));
        worldDS.setUser(PropertiesProvider.PROPS.getProperty("uname"));
        worldDS.setPassword(PropertiesProvider.PROPS.getProperty("pwd"));
    }

    public List<Country> getAllCountries() throws SQLException {
        List<Country> countries = new ArrayList<>();
        try (Connection conn = worldDS.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(GET_ALL_COUNTRIES_SQL)
        ) {
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                String continentString = rs.getString("continent");
                Continent continent = continentMapper.get(continentString);
                String region = rs.getString("region");
                float surfaceArea = rs.getFloat("surfaceArea");
                int indepYear = rs.getInt("indepYear");
                int population = rs.getInt("population");
                float lifeExpectancy = rs.getFloat("lifeExpectancy");
                float gnp = rs.getFloat("GNP");
                float gnpOld = rs.getFloat("GNPOld");
                String localName = rs.getString("localName");
                String governmentForm = rs.getString("governmentForm");
                String headOfState = rs.getString("headOfState");
                int capital = rs.getInt("capital");
                String code2 = rs.getString("code2");
                countries.add(new Country(code, name, continent, region, surfaceArea, indepYear,
                        population, lifeExpectancy, gnp, gnpOld, localName, governmentForm,
                        headOfState, capital, code2));
            }
        }
        return countries;
    }

    public List<City> getAllCities() throws SQLException {
        List<City> cities = new ArrayList<>();
        try (Connection conn = worldDS.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(GET_ALL_CITIES_SQL)
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String countryCode = rs.getString("countryCode");
                String district = rs.getString("district");
                int population = rs.getInt("population");
                cities.add(new City(id, name, countryCode, district, population));
            }
        }
        return cities;
    }

    public List<City> getAllCitiesByCountryCode(String countryCode) throws SQLException {
        List<City> cities = new ArrayList<>();
        try (Connection conn = worldDS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_ALL_CITIES_BY_COUNTRY_CODE_SQL)
        ) {
            stmt.setString(1, countryCode);
            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String district = rs.getString("district");
                    int population = rs.getInt("population");
                    cities.add(new City(id, name, countryCode, district, population));
                }
            }
        }
        return cities;
    }

    public int addCity(City newCity) throws SQLException {
        try (Connection conn = worldDS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(ADD_CITY_SQL)
        ) {
            stmt.setInt(1, newCity.id());
            stmt.setString(2, newCity.name());
            stmt.setString(3, newCity.countryCode());
            stmt.setString(4, newCity.district());
            stmt.setInt(5, newCity.population());
            return stmt.executeUpdate();
        }
    }

    public int updateCity(City newCity) throws SQLException {
        try (Connection conn = worldDS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_CITY_SQL)
        ) {
            stmt.setString(1, newCity.name());
            stmt.setString(2, newCity.countryCode());
            stmt.setString(3, newCity.district());
            stmt.setInt(4, newCity.population());
            stmt.setInt(5, newCity.id());
            return stmt.executeUpdate();
        }
    }

    public int deleteCity(int id) throws SQLException {
        try (Connection conn = worldDS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_CITY_SQL)
        ) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        }
    }
}

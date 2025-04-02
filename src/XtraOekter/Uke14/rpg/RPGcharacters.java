package XtraOekter.Uke14.rpg;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static XtraOekter.Uke13.PropertiesProvider.PROPS;

public class RPGcharacters {
    private final MysqlDataSource rpgDS;
    private static final String UPDATE_RPG_SQL = "UPDATE RPGcharacter SET strength=?, health=?, xp=? WHERE name=?";
    private static final String DELETE_RPG_SQL = "DELETE FROM RPGcharacter WHERE name =?";
    private static final String INSERT_RPG_SQL = "INSERT INTO RPGcharacter (name,type,strength, health, xp, mp) VALUES(?,?,?,?,?,?)";

    public MysqlDataSource getRpgDS() {
        return rpgDS;
    }

    public RPGcharacters(){
        rpgDS = new MysqlDataSource();
        rpgDS.setServerName(PROPS.getProperty("host"));
        rpgDS.setPortNumber(Integer.parseInt(PROPS.getProperty("port")));
        rpgDS.setDatabaseName(PROPS.getProperty("db_name"));
        rpgDS.setUser(PROPS.getProperty("uname"));
        rpgDS.setPassword(PROPS.getProperty("pwd"));
    }
    public List<Character> loadFromSQL(){
        List<Character> rpgCharacters = new ArrayList<>();
        try (Connection con = rpgDS.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery("SELECT character_id,name,type,strength, health, xp, mp FROM RPGcharacter")){

            while(rs.next()){
                //(name, type, strength, health, xp, mp)
                int id = rs.getInt("character_id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                //System.out.println(name+ " "+ type);
                int strength = rs.getInt("strength");
                int health = rs.getInt("health");
                int xp = rs.getInt("xp");
                int mp = rs.getInt("mp");

                switch(type.toLowerCase()){
                    case "warrior":
                        Warrior wa = new Warrior(name, strength, health, xp);
                        rpgCharacters.add(wa);
                        break;
                    case "wizard":
                        Wizard wi = new Wizard(name, strength, health, xp, mp);
                        rpgCharacters.add(wi);
                        break;
                    case "ork":
                        Ork o = new Ork(name);
                        rpgCharacters.add(o);
                        break;
                    default:
                        System.out.println("Wrong type of character in DB.");
                        break;



                }

            }

        } catch(SQLException e){
            System.out.println("Unable to connect to database:"+e.getMessage());
            e.printStackTrace();
        }
    return rpgCharacters;
    }
    public int updateRPGCharacters(Character c, Connection con) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement(UPDATE_RPG_SQL);
        ) {
            statement.setInt(1, c.getStrength());
            statement.setInt(2, c.getHealth());
            statement.setInt(3, c.getXp());
            statement.setString(4, c.getName());

            return statement.executeUpdate();
        }
    }
    public int addRPGCharacter(Character c, String cType) throws SQLException {

        try (Connection conn = rpgDS.getConnection();
             PreparedStatement statement = conn.prepareStatement(INSERT_RPG_SQL, Statement.RETURN_GENERATED_KEYS)
        ) {

            statement.setString(1, c.getName());
            statement.setString(2, cType);
            statement.setInt(3, c.getStrength());
            statement.setInt(4, c.getHealth());
            statement.setInt(5, c.getXp());
            statement.setInt(6, c.getXp());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected == 1){
                try(ResultSet keys = statement.getGeneratedKeys()){
                    if(keys.next()){
                        return keys.getInt(1);
                    }
                }
            }
            return 0;
        }
    }

    public int deleteRPGCharacter(Character c, Connection con) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement(DELETE_RPG_SQL);
        ) {
            statement.setString(1, c.getName());
            return statement.executeUpdate();
        }
    }
}


import java.sql.*;



/**
 * Created by Cyprian on 2017-04-09.
 */
public class DbConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DbConnect() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            st=con.createStatement();
        }
        catch(Exception ex){
            System.out.println("Exception" +ex);
        }

    }
    public void getData(){
        try{
            String query = "select * from persons";
            rs = st.executeQuery(query);
            System.out.println("Records from database");
            while(rs.next()){
                String name = rs.getString("name");
                String age = rs.getString("age");
                System.out.println("name:" + name + " age:" + age);
            }

        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}

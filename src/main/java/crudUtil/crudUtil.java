package crudUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by chenjie on 16/12/15.
 */
public class crudUtil {

    public final static String url = "jdbc:mysql://127.0.0.1/amelia";
    public final static String name = "com.mysql.jdbc.Driver";
    public final static String user = "root";
    public final static String passWord = "";



    public static void main(String[] args) {
         Connection conn = null;
         PreparedStatement pst = null;
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url,user,passWord);
            String sql = "select * from t_push_amelia";
            pst= conn.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();

        } catch (Exception e) {

        }

    }

}

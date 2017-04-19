package jdbc;

import java.sql.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenjie on 17/4/11.
 */
public class TransactionTest {

    private final static String jdbcDirver = "com.mysql.jdbc.Driver";
    private final static String userName = "root";
    private final static String passWord = "";
    private final static String url = "jdbc:mysql://localhost:3306/amelia?characterEncoding=utf-8";

    public static void main(String[] args) throws Exception{
        Class.forName(jdbcDirver) ;
        Connection connection = DriverManager.getConnection(url,userName,passWord);
        Statement statement = connection.createStatement();
        String sql = "UPDATE t_amelia_realtime_push set status='COMMITTED',\n" +
                "push_interval=\"19:38:00 - 11:43:00\" WHERE id=1";


        connection.setAutoCommit(false);

        statement.execute(sql);
        TimeUnit.SECONDS.sleep(2);
        //connection.rollback();
        System.out.println("===========事务执行失败");
    }
}

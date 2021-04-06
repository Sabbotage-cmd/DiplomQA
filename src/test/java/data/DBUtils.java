package data;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private static String dbUrl = System.getProperty("db.url");
    private static String dbUser = System.getProperty("db.user");
    private static String dbPasswd = System.getProperty("db.password");

    public String getPaymentStatus() throws SQLException {
        val codesSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);){
            return runner.query(conn, codesSQL, new ScalarHandler<>());
        }
    }

    public String getCreditStatus() throws SQLException {
        val codesSQL = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);){
            return runner.query(conn, codesSQL, new ScalarHandler<>());
        }
    }

    public String getOrderInformation() throws SQLException {
        val codesSQL = "SELECT credit_id FROM order_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);){
            return runner.query(conn, codesSQL, new ScalarHandler<>());
        }
    }
}
package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);
            st = conn.prepareStatement(
                    "UPDATE seller "
                    + "SET BaseSalary = ? "
                    + "WHERE "
                    + "DepartmentId = ?");

            st.setDouble(1, 7777.22);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

//            int x = 10;
//            if(x > 1){
//                throw new DbIntegrityException("Fake error.");
//            }

            st = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = ? "
                            + "WHERE "
                            + "DepartmentId = ?");

            st.setDouble(1, 4444.22);
            st.setInt(2, 2);

            rowsAffected = st.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            conn.commit();

        } catch (SQLException e){
            try {
                conn.rollback();
                throw new DbIntegrityException("Roll back! " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbIntegrityException("Error in rollback: " + e.getMessage());
            }

        }
    }
}

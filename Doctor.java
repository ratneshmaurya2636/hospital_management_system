package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {
    private Connection connection;

    public Doctor(Connection connection) {
        this.connection = connection;

    }

    // Other patient related methods...
    public void viewDoctors() {
        // View patient logic here
        // Example:
        System.out.println("Viewing all patients...");
        String sql = "SELECT * FROM doctors ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String specialization = rs.getString("specialization");
                System.out.println("ID: " + id + ", Name: " + name + " Specialization: " + specialization);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Other patient related methods...
    public boolean getDoctorsById(int id) {
        String sql = "SELECT * FROM doctors WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
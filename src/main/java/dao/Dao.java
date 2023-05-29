package dao;

import context.DBContext;
import model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private static final String INSERT_Staff_SQL = "INSERT INTO Staff (name,email,address,phoneNumber,salary,department_id) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_Staff_SQL = "SELECT * FROM Staff";
    private static final String SELECT_Staf_BY_NAME =  "SELECT * FROM Staff WHERE `name` LIKE ?;";
    private static final String DELETE_Staff_SQL = "DELETE FROM Staff WHERE id = ?";
    private static final String UPDATE_Saff_SQL = "UPDATE Staff set name = ?, email = ?, address = ?, phoneNumber = ?, salary = ?, department_id =? ,WHERE id = ?";

    public void DAO() {
    }

    // hien thi tat ca nhan vien
    public List<Staff> getAllStaff() throws SQLException, ClassNotFoundException {
        List<Staff> list = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_Staff_SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Staff(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getFloat("salary"),
                        resultSet.getInt("department_id")
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //them nhan vien
    public void insertStaff(String name, String email, String address, String phoneNumber, String salary,  String department_id ) throws ClassNotFoundException {
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_Staff_SQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, salary);
            preparedStatement.setString(6, department_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   // sua nhan vien theo id
   public void updateStaffById(String name, String email, String address, String phoneNumber, String salary, String department_id, String id) {
       try {
           connection = new DBContext().getConnection();
           preparedStatement = connection.prepareStatement(UPDATE_Saff_SQL);
           preparedStatement.setString(1, name);
           preparedStatement.setString(2, email);
           preparedStatement.setString(3, address);
           preparedStatement.setString(4, phoneNumber);
           preparedStatement.setString(5, salary);
           preparedStatement.setString(6, department_id);
           preparedStatement.setString(7, id);
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

   // xoa nhan vien theo id
   public void deleteStaff(String id) {
       try {
           connection = new DBContext().getConnection();
           preparedStatement = connection.prepareStatement(DELETE_Staff_SQL);
           preparedStatement.setString(1, id);
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
       e.printStackTrace();
       }
   }

   // tim kiem nhan vien theo id
   public List<Staff> searchStaffByName(String name) throws SQLException, ClassNotFoundException {
       List<Staff> list = new ArrayList<>();
       try {
           connection = new DBContext().getConnection();
           preparedStatement = connection.prepareStatement(SELECT_Staf_BY_NAME);
           preparedStatement.setString(1, "%" + name + "%");
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               list.add(new Staff(
                       resultSet.getInt("id"),
                       resultSet.getString("name"),
                       resultSet.getString("email"),
                       resultSet.getString("address"),
                       resultSet.getString("phoneNumber"),
                       resultSet.getFloat("salary"),
                       resultSet.getInt("department_id")
               ));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return list;
   }

   // tim kiem nhan vien theo id
   public Staff getStaffByID(String id) throws SQLException, ClassNotFoundException {
       String sql = "SELECT * FROM Staff WHERE id = ?;";
       try {
           connection = new DBContext().getConnection();
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, id);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               return new Staff(
                       resultSet.getInt("id"),
                       resultSet.getString("name"),
                       resultSet.getString("email"),
                       resultSet.getString("address"),
                       resultSet.getString("phoneNumber"),
                       resultSet.getFloat("salary"),
                       resultSet.getInt("department")
               );
           }
       } catch (Exception e) {
       }
       return null;
   }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Dao dao = new Dao();
        List<Staff> staffList = dao.getAllStaff();
        for (Staff staff : staffList){
            System.out.println(staff);
        }

    }
}

package dao;

import model.Sample;
import utility.DriverAccessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Student;

public class StudentDAO extends DriverAccessor {
    
    public List<Sample> findAll(Connection connection) {
        String findAll = "select * from sample";
        try {
            PreparedStatement statement = connection.prepareStatement(findAll);
            ResultSet resultSet = statement.executeQuery();
            List<Sample> sampleList = new ArrayList<Sample>();
            while(resultSet.next()) {
                Sample sample = new Sample();
                sample.setSampleId(resultSet.getInt("id"));
                sample.setContent(resultSet.getString("content"));
                sampleList.add(sample);
            }
            statement.close();
            resultSet.close();

            return sampleList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void registStudent(Student student, Connection connection) {

        try {
            // SQLコマンド
            String sql = "insert into student_info(student_id, student_name, student_birthplace) values(?, ?, ?)";

            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql);

            // SQLコマンドのクエッションマークに値を、1番目から代入する
            stmt.setString(1, student.getStudentID());
            stmt.setString(2, student.getStudentName());
            stmt.setString(3, student.getStudentBirthplace());

            stmt.executeUpdate();

        } catch (SQLException e) {

            // エラーが発生した場合、エラーの原因を出力する
            e.printStackTrace();

        } finally {
        }
    }

    public Student searchStudent(Student student, Connection connection) {

        try {
            // SQLコマンド
            String sql = "select * from student_info where student_id = ? ";

            // SQLのコマンドを実行する
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, student.getStudentID());
            // 実行結果はrsに格納される
            ResultSet rs = stmt.executeQuery();

            if (rs.first()) { // DBに存在した場合
                // rsからそれぞれの情報を取り出し、Studentオブジェクトに設定する
                student.setStudentName(rs.getString("student_name"));
                student.setStudentBirthplace(rs.getString("student_birthplace"));
            } else { // DBに存在しなかった場合
                student = null; // studentオブジェクトをnullにする
            }

            // 終了処理
            stmt.close();
            rs.close();

            // Studentオブジェクトを返す
            return student;

        } catch (SQLException e) {

            // エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
            e.printStackTrace();
            return null;

        } finally {
        }
    }

}
// //　自分が格納されているフォルダ名
// package dao;

// //  自分が格納されているフォルダの外にある必要なクラス
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

// import beans.Student;

// public class StudentDAO {

//     // 属性

//     // データベースの接続先アドレスを静的変数として記述
//     private final static String DRIVER_URL = "jdbc:mysql://localhost:3306/student?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";
//     // DockerでMysqlを起動した場合
//     // private final static String DRIVER_URL = "jdbc:mysql://localhost:3307/student?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";

//     // データベース接続ドライバの名前を静的変数として記述
//     // Mysql5.系
//     // private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
//     // Mysql8.系
//     private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

//     // データベースのユーザー名 （デフォルトではroot）
//     private final static String USER_NAME = "root";

//     // データベースのユーザーのパスワード (デフォルトでは設定なし)
//     private final static String PASSWORD = "";
//     // DockerでMysqlを起動した場合
//     // private final static String PASSWORD = "root";

//     // データベースとの接続を行う
//     // データベースの接続情報を持ったConnectionオブジェクトを返す
//     public Connection createConnection() {
//         try {
//             Class.forName(DRIVER_NAME);
//             System.out.println(DRIVER_NAME);
//             System.out.println(USER_NAME);
//             System.out.println(PASSWORD);
//             Connection con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
//             return con;
//         } catch (ClassNotFoundException e) {
//             System.out.println("Can't Find JDBC Driver.\n");
//         } catch (SQLException e) {
//             System.out.println("Connect Error.\n");
//         }
//         return null;
//     }

//     // Connectionオブジェクトを使って、データベースとの接続を切断する
//     // 引数Connectionオブジェクト
//     public void closeConnection(Connection con) {

//         try {
//             con.close();
//         } catch (Exception ex) {
//         }
//     }

//     // 情報をデータベースに登録する
//     // 引数はStudentオブジェクトと、Connectionオブジェクト


    // 検索する
    // 引数はStudentオブジェクトと、Connectionオブジェクト
    

// }

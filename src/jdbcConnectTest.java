import java.sql.*;


public class jdbcConnectTest {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null; // 쿼리문을 데이터베이스쪽으로 넘겨줌
		ResultSet rs = null;  // select 구문 전용 객체
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "select * from dept";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("연결성공");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql); // executeQuery() : select , executeUpdate : insert, update, delete
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				System.out.println(deptno + " : " + dname + " : " + loc);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


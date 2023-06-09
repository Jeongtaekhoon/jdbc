import java.sql.*;

// 데이터 조회

public class JdbcEmp {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null; // 쿼리문을 데이터베이스쪽으로 넘겨줌
		ResultSet rs = null;  // select 구문 전용 객체
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "select * from emp";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("연결성공");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql); // executeQuery() : select , executeUpdate : insert, update, delete
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hireDate = rs.getDate("hireDate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				
				System.out.println(empno + " / " + ename + " / " + job + " / " + mgr + " / " + 
								   hireDate + " / " + sal + " / " + comm + " / " + deptno );
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


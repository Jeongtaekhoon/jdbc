import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 데이터 삭제

public class JdbcEmp03 {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null; // 쿼리문을 데이터베이스쪽으로 넘겨줌
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "select * from emp01";
		String sql4 = "delete from emp01 "
				+ "where empno = 2222";
//		String sql3 = "update emp01 "
//				+ "set empno = 3333 "
//				+ "where empno = 1111";
//		String sql2 = "insert into emp01 "
//				+ "values (2222, 'King', 'SALES', 7788, sysdate, 1000, null, 30)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("연결성공");
			
			stmt = con.createStatement();
//			int result = stmt.executeUpdate(sql3);
//			int result = stmt.executeUpdate(sql2);
			int result = stmt.executeUpdate(sql4); 
			if(result <= 0) {
				System.out.println("데이터 처리 실패");
			}else {
				System.out.println("데이터 처리 성공");
			}
			rs = stmt.executeQuery(sql);
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


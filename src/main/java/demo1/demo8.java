package demo1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JdbcUtils;

public class demo8 {
	public static void main(String[] args) {
		String sql = "select * from myPicture where id =?";
		     PreparedStatement  pstmt=JdbcUtils.getPreparedStatement(sql);
		     try {
				pstmt.setInt(1, 1);
				 ResultSet rs=pstmt.executeQuery();
				 while(rs.next()) {
					 InputStream is=rs.getBinaryStream("img");
					 OutputStream os = new FileOutputStream("src\\psc.jpg");
					 int length = -1;
					 while((length=is.read())!=-1) {
						 os.write(length);
					 }
					 os.close();
					 is.close();
					 
					 
					 
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		
		
	}
}

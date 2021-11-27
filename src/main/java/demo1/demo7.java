package demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.JdbcUtils;

public class demo7 {
	public static void main(String[] args) {
		String sql="insert into mypicture values(?,?)";
		  PreparedStatement pstmt=JdbcUtils.getPreparedStatement(sql);
		  File file = new File("E:\\psc.jpg");
		    try {
				InputStream is =new FileInputStream(file);
				pstmt.setBinaryStream(2, is, file.length());
				pstmt.setInt(1, 1);
				 int result =pstmt.executeUpdate();
				 if(result>0) {
					 System.out.println("–¥»Î≥…π¶");
				 }
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom5.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 *
 * @author Giang Phan
 */
public class SqlServerConnected {
    protected Connection conn=null;
	
	public SqlServerConnected() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl=
					"jdbc:sqlserver://GIANGPHAN:1433;databaseName=CSDL_DKTINCHI;integratedSecurity=true;";
			conn= DriverManager.getConnection(connectionUrl);
                        System.out.println("Kết nối CSDL thành công");
		}
		catch(Exception ex) {
                        System.out.println("Kết nối CSDL thất bại");
			ex.printStackTrace();
		}
	}
}

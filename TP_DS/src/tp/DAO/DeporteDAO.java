package tp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tp.clases.Deporte;



public class DeporteDAO {
	
	public DeporteDAO() {
		super();
	}
	
	public List<String> getNombres() {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<String> m = new ArrayList<>();
		try {
			pstm = con.prepareStatement(
					"SELECT nombre FROM dsi20203c.Deporte ");
			rs = pstm.executeQuery();
			while(rs.next()) {
				m.add(rs.getString(1)) ;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			DataBase.cerrarRs(rs);
			DataBase.cerrarPstm(pstm);
			DataBase.cerrarConexion(con);
		}
		return m;
	}
	
	
	
}

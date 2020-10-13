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
	
	public Integer getIDbyNombre(String nombre) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Integer m = null;
		try {
			pstm = con.prepareStatement(
					"SELECT id_deporte FROM dsi20203c.Deporte WHERE nombre = ?");
			pstm.setString(1,nombre);
			rs = pstm.executeQuery();
			if(rs.next()) {
				return  Integer.valueOf(rs.getInt(1));
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

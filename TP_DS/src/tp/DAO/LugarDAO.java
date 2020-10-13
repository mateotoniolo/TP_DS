package tp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LugarDAO {
	
	public static List<String> getLugares() {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<String> places = new ArrayList<String>();
		try {
			pstm = con.prepareStatement(
					"SELECT nombre FROM dsi20203c.Lugar");
			rs = pstm.executeQuery();
			while(rs.next()) {
				places.add(rs.getString(1)) ;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			DataBase.cerrarRs(rs);
			DataBase.cerrarPstm(pstm);
			DataBase.cerrarConexion(con);
		}
		return places;
	}
	
	public static List<String> getNombreLugaresByDeporteUsuario(Integer id_deporte, Integer id_usuario) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<String> places = new ArrayList<String>();
		LugarDAO lugarDao = new LugarDAO();
		try {
			pstm = con.prepareStatement(
					"SELECT * FROM (SELECT codigo FROM dsi20203c.Relacion_Lugar_Deporte WHERE id_deporte = ?) d, (SELECT codigo FROM dsi20203c.Relacion_Lugar_Usuario WHERE id_Usuario = ? ) u WHERE d.codigo = u.codigo");
			pstm.setInt(1, id_deporte);
			pstm.setInt(2, id_usuario);
			rs = pstm.executeQuery();
			while(rs.next()) {
				places.add(lugarDao.getLugaresByID(Integer.valueOf(rs.getString(1))));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			DataBase.cerrarRs(rs);
			DataBase.cerrarPstm(pstm);
			DataBase.cerrarConexion(con);
		}
		return places;
	}
	
	public static String getLugaresByID(Integer id_Lugar) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = con.prepareStatement(
					"SELECT nombre FROM dsi20203c.Lugar WHERE codigo = ?");
			pstm.setInt(1, id_Lugar);
			rs = pstm.executeQuery();
			if(rs.next()) {
				return  rs.getString(1);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			DataBase.cerrarRs(rs);
			DataBase.cerrarPstm(pstm);
			DataBase.cerrarConexion(con);
		}
		return null;
	}
	
	
}

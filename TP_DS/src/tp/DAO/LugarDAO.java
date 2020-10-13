package tp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tp.clases.Lugar;


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
	
	public static List<Lugar> getLugarByDeporteUsuario(Integer id_deporte, Integer id_usuario) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Lugar> places = new ArrayList<Lugar>();
		LugarDAO lugarDao = new LugarDAO();
		try {
			pstm = con.prepareStatement(
					"SELECT * FROM (SELECT codigo FROM dsi20203c.Relacion_Lugar_Deporte WHERE id_deporte = ?) d, (SELECT codigo FROM dsi20203c.Relacion_Lugar_Usuario WHERE id_Usuario = ? ) u WHERE d.codigo = u.codigo");
			pstm.setInt(1, id_deporte);
			pstm.setInt(2, id_usuario);
			rs = pstm.executeQuery();
			while(rs.next()) {
				places.add(lugarDao.getLugarByID(Integer.valueOf(rs.getString(1))));
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
	
	public static Lugar getLugarByID(Integer id_Lugar) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Lugar l = null;
		
		try {
			pstm = con.prepareStatement(
					"SELECT * FROM dsi20203c.Lugar WHERE codigo = ?");
			pstm.setInt(1, id_Lugar);
			rs = pstm.executeQuery();
			while(rs.next()) {
				l=parsearRS(rs);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			DataBase.cerrarRs(rs);
			DataBase.cerrarPstm(pstm);
			DataBase.cerrarConexion(con);
		}
		return l;
	}
	
	static Lugar parsearRS(ResultSet rs) throws SQLException {
		
		return new Lugar(Integer.valueOf(rs.getInt(1)),
				rs.getString(2),
				rs.getString(3));
	}
	
}

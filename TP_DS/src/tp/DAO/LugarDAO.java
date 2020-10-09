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
	
}

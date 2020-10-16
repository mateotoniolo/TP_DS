package tp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import tp.clases.Competencia;



public class CompetenciaDAO {

	
	public Boolean Save(Competencia comp) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(
					"INSERT INTO dsi20203c.Competencia VALUES (default,?,?,?,?,NULL,NULL,NULL,NULL,NULL,NULL);");
			pstm.setInt(1,comp.getIdAdministrador());
			pstm.setInt(2, comp.getFixtureID());
			pstm.setString(3, comp.getNombre());
			pstm.setString(4, comp.getReglamento());
			

			return pstm.executeUpdate() == 1;
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			DataBase.cerrarPstm(pstm);
			DataBase.cerrarConexion(con);
		}
		return false;
	}
	
}

package tp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

import tp.clases.Competencia;



public class CompetenciaDAO {

	
	public Boolean Save(Competencia comp) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(
					"INSERT INTO dsi20203c.Competencia VALUES (NULL,?,NULL,?,?,?,'CREADA',?,?,?,?);");
			pstm.setInt(1,comp.getIdAdministrador());
			pstm.setString(2, comp.getNombre());
			pstm.setInt(3, comp.getCantSets());
			pstm.setString(4, comp.getReglamento());
			pstm.setString(5, comp.getModalidad().toString());	
			pstm.setString(6, comp.getModalidadDePuntuacion().toString());
			pstm.setDouble(7, comp.getTantosXAusencia());
			pstm.setInt(8, comp.getIdDeporte());
			

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

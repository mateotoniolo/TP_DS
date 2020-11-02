package tp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import tp.clases.Competencia;



public class CompetenciaDAO {

	
	public Boolean Save(Competencia comp) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(
					"INSERT INTO dsi20203c.Competencia VALUES (NULL,?,NULL,?,?,?,?,'CREADA',?,?,?,?);");
			pstm.setInt(1,comp.getIdAdministrador());
			pstm.setString(2, comp.getNombre());
			pstm.setInt(3, comp.getCantSets());
			pstm.setBoolean(4, comp.getEmpate());
			pstm.setString(5, comp.getReglamento());
			pstm.setString(6, comp.getModalidad().toString());	
			pstm.setString(7, comp.getModalidadDePuntuacion().toString());
			pstm.setDouble(8, comp.getTantosXAusencia());
			pstm.setInt(9, comp.getIdDeporte());
			
			
			pstm.executeUpdate();
			return this.SaveCompetenciaModalidad(comp);
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			
			DataBase.cerrarPstm(pstm);
			DataBase.cerrarConexion(con);
		}
		return false;
	}
	
	public Boolean SaveCompetenciaModalidad(Competencia comp) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		Integer id_competencia = this.getIDbyNombre(comp.getNombre());
		switch(comp.getModalidad().toString()) {
		case "LIGA":
			try {
				pstm = con.prepareStatement(
						"INSERT INTO dsi20203c.Competencia_Liga VALUES (?,NULL,NULL,NULL,NULL);");
				pstm.setInt(1,id_competencia);
	
				return pstm.executeUpdate() == 1;
			}catch(Exception e) {
				System.out.println(e.getMessage());	
			}
			finally {
				DataBase.cerrarPstm(pstm);
				DataBase.cerrarConexion(con);
			}
			break;
		case "ELIMINACION_DIRECTA":
			try {
				pstm = con.prepareStatement(
						"INSERT INTO dsi20203c.Competencia_Eliminacion_Directa VALUES (?);");
				pstm.setInt(1, id_competencia);

				return pstm.executeUpdate() == 1;
			}catch(Exception e) {
				System.out.println(e.getMessage());	
			}
			finally {
				DataBase.cerrarPstm(pstm);
				DataBase.cerrarConexion(con);
			}
			break;
		case "ELIMINACION_DOBLE":
			try {
				pstm = con.prepareStatement(
						"INSERT INTO dsi20203c.Competencia_Eliminacion_Doble VALUES (?);");
				pstm.setInt(1, id_competencia);

				return pstm.executeUpdate() == 1;
			}catch(Exception e) {
				System.out.println(e.getMessage());	
			}
			finally {
				DataBase.cerrarPstm(pstm);
				DataBase.cerrarConexion(con);
			}
			break;
	}
		return false;
	}
	
	public static Integer getIDbyNombre(String nombre) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Integer id_Competencia = null;
		try {
			pstm = con.prepareStatement(
					"SELECT id_competencia FROM dsi20203c.Competencia WHERE nombre = ?");
			pstm.setString(1, nombre);
			rs = pstm.executeQuery();
			while(rs.next()) {
			id_Competencia = rs.getInt(1);}
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			DataBase.cerrarRs(rs);
			DataBase.cerrarPstm(pstm);
			DataBase.cerrarConexion(con);
		}
		return id_Competencia;
	}
}

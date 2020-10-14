package tp.GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tp.clases.ItemLugar;
import tp.clases.Lugar;




public class AltaCompetenciaTM extends AbstractTableModel{
	private List<ItemLugar> data = new ArrayList<ItemLugar>();
	private String[] columnNames = {"Codigo","Lugar","Disponibilidad"};
	
	public AltaCompetenciaTM() {
		data.add(new ItemLugar(new Lugar(200,"Cancha norte",""),0,5,true));
		
	}
	
	public void addItemTM(ItemLugar item) {
		this.data.add(item);
	}
	
	
	@Override
	public int getRowCount() {
		return data.size();
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		ItemLugar temp = data.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return temp.getCodigo();
		case 1:
			return temp.getLugar();
		case 2: 
			return temp.getCantidadEncuentros();
		}
		return null;
	}
	
	@Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	public void vaciarTabla() {
		this.data = null;
		this.data = new ArrayList<ItemLugar>();
	}
}

package manager;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import entity.Clientes;

public class ClienteDataModel extends ListDataModel implements SelectableDataModel<Clientes> {

	public ClienteDataModel(List<Clientes> lista) {
		super(lista);
	}

	@Override
	public Clientes getRowData(String row) {
		List<Clientes> clientes = (List<Clientes>) getWrappedData();
		for (Clientes c : clientes) {
			if (c.getCodigo().equals(Integer.parseInt(row))) {
				return c;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(Clientes c) {
		// TODO Auto-generated method stub
		return c.getCodigo();
	}

}

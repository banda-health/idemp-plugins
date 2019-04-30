package org.bandahealth.idempiere.webui.dataservice;

import java.util.List;

import org.compiere.model.PO;

public interface DataService<T extends PO> {

	List<T> getData();
}

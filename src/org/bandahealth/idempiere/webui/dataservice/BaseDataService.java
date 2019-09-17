package org.bandahealth.idempiere.webui.dataservice;

import java.util.Properties;

import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.Env;

public abstract class BaseDataService<T extends PO> implements DataService<T> {

	protected abstract String getTableName();

	protected abstract String getTrxName();

	protected Properties getContext() {
		return Env.getCtx();
	}

	protected abstract String getWhereClause();

	protected Query buildQuery = new Query(getContext(), getTableName(), getWhereClause(), getTrxName())
	        .setOnlyActiveRecords(true);
}

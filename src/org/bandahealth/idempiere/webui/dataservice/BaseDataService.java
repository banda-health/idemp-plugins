package org.bandahealth.idempiere.webui.dataservice;

import java.lang.reflect.ParameterizedType;
import java.util.Properties;

import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.Env;

public abstract class BaseDataService<T extends PO> implements DataService<T> {

	private T instance;

	@SuppressWarnings("unchecked")
	private T getDataType() {
		if (instance == null) {
			ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();

			instance = (T) parameterizedType.getActualTypeArguments()[0];
		}
		
		return instance;
	}

	protected Properties getContext() {
		return Env.getCtx();
	}

	protected abstract String getWhereClause();

	protected Query buildQuery = new Query(getContext(), getDataType().get_TableName(), getWhereClause(),
	        getDataType().get_TrxName()).setOnlyActiveRecords(true);
}

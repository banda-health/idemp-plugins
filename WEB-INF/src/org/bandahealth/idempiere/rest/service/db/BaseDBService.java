package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.compiere.model.PO;

public abstract class BaseDBService<T extends BaseMetadata, S extends PO> {

	// Default fields used for lists
	protected abstract T createInstanceWithDefaultFields(S instance);

	// All fields
	protected abstract T createInstanceWithAllFields(S instance);

	protected abstract S getModelInstance();

	private boolean checkColumnExists(String columnName) {
		if (getModelInstance() != null) {
			return getModelInstance().get_ColumnIndex(columnName) > -1;
		}

		return false;
	}
	
	protected String getOrderBy(String sortColumn, String sortOrder) {
		if (sortColumn != null && !sortColumn.isEmpty() && sortOrder != null) {
			// check if column exists
			if (checkColumnExists(sortColumn)) {
				return sortColumn + " " + (sortOrder.equalsIgnoreCase("DESC") ? "DESC" : "ASC");
			}
		} else {
			return MBPartner_BH.COLUMNNAME_Created + " DESC";
		}

		return null;
	}

}

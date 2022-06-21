package org.bandahealth.idempiere.base.test;

import java.util.Properties;

import org.compiere.model.MDocType;
import org.compiere.model.Query;

public class MDocTypeTemplate extends BaseModelTemplate<MDocType> {

	private int clientId;
	private String name;

	public MDocTypeTemplate(String transactionName, Properties context, int clientId, String name) {
		super(transactionName, context);

		this.clientId = clientId;
		this.name = name;
	}

	@Override
	protected MDocType createInstance() {
		return null;
	}

	@Override
	public MDocType findInstance() {
		StringBuilder whereClause = new StringBuilder(MDocType.COLUMNNAME_AD_Client_ID);
		whereClause.append("=");
		whereClause.append(clientId);
		whereClause.append(" AND ");
		whereClause.append(MDocType.COLUMNNAME_Name);
		whereClause.append("=");
		whereClause.append(name);
		return new Query(getContext(), MDocType.Table_Name, whereClause.toString(), getTransactionName()).first();
	}

	@Override
	protected void setFields(MDocType instance) {
	}
}

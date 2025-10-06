package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MInvoiceLine;

import java.util.List;
import java.util.TreeMap;

public class MInvoiceLineQuery extends X_C_InvoiceLineQuery {
	@Override
	public Connection<MInvoiceLine> C_InvoiceLineGet(int Page, int PageSize, String Sort, String Filter, String Where,
			List<Object> Parameters, DataFetchingEnvironment environment) {
		return Repository.get(getTableName(), null, new PagingInfo(Page, PageSize), Sort, Filter,
				Repository.parseApiWhereClauseAndParameters(Where, Parameters), Parameters,
				new TreeMap<>(String.CASE_INSENSITIVE_ORDER) {{
					put(MInvoice_BH.Table_Name, "JOIN  " + MInvoice_BH.Table_Name + " ON " + MInvoiceLine.Table_Name + "." +
							MInvoiceLine.COLUMNNAME_C_Invoice_ID + " = " + MInvoice_BH.Table_Name + "." +
							MInvoice_BH.COLUMNNAME_C_Invoice_ID);
				}}, environment);
	}
}

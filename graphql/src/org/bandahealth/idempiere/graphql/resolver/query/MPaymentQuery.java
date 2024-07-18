package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.repository.Repository;

import java.util.TreeMap;

public class MPaymentQuery extends X_C_PaymentQuery {
	@Override
	public Connection<MPayment_BH> C_PaymentGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return Repository.get(getTableName(), null, new PagingInfo(Page, PageSize), Sort, Filter, null, null,
				new TreeMap<>(String.CASE_INSENSITIVE_ORDER) {{
					put(MBPartner_BH.Table_Name, "LEFT JOIN  " + MBPartner_BH.Table_Name + " ON " + MPayment_BH.Table_Name +
							"." + MPayment_BH.COLUMNNAME_C_BPartner_ID + " = " + MBPartner_BH.Table_Name + "." +
							MBPartner_BH.COLUMNNAME_C_BPartner_ID);
				}}, environment);
	}
}

package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MStorageOnHand;

import java.util.Map;
import java.util.TreeMap;

public class MStorageOnHandQuery extends X_M_StorageOnHandQuery {
	private static final Map<String, String> dynamicJoins = new TreeMap<>(String.CASE_INSENSITIVE_ORDER) {{
		put(MAttributeSetInstance_BH.Table_Name,
				" JOIN " + MAttributeSetInstance_BH.Table_Name + " ON " + MAttributeSetInstance_BH.Table_Name
						+ "." + MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_ID + "="
						+ MStorageOnHand.Table_Name + "."
						+ MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID);
		put(MAttributeSet_BH.Table_Name,
				" JOIN " + MAttributeSet_BH.Table_Name + " ON " + MAttributeSet_BH.Table_Name + "."
						+ MAttributeSet_BH.COLUMNNAME_M_AttributeSet_ID + "="
						+ MAttributeSetInstance_BH.Table_Name + "."
						+ MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSet_ID);
		put(MProduct_BH.Table_Name,
				" JOIN " + MProduct_BH.Table_Name + " ON " + MProduct_BH.Table_Name + "."
						+ MProduct_BH.COLUMNNAME_M_Product_ID + "="
						+ MStorageOnHand.Table_Name + "."
						+ MStorageOnHand.COLUMNNAME_M_Product_ID);
	}};

	@Override
	public Connection<MStorageOnHand> M_StorageOnHandGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return Repository.get(getTableName(), null, new PagingInfo(Page, PageSize), Sort, Filter, null, null, dynamicJoins,
				environment);
	}
}

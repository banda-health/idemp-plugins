package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHProductCategoryDefault;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Product_CategoryDefault - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Product_CategoryDefaultResolver extends POResolver<MBHProductCategoryDefault> implements GraphQLResolver<MBHProductCategoryDefault> {


	static Map<String, String> BH_PRODUCT_CATEGORY_TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("P", "305558d1-db4a-456f-9c25-057750949060");
			put("S", "f3c40565-4bb3-4e82-b280-1ad24f6701cd");
		}
	};
	public CompletableFuture<MRefList_BH> BH_Product_Category_Type(MBHProductCategoryDefault entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Product_Category_Type())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(BH_PRODUCT_CATEGORY_TYPE_UUIDS_BY_VALUE.get(entity.getBH_Product_Category_Type()));
	}

}

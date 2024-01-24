package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MDiscountSchema;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_DiscountSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DiscountSchemaResolver extends POResolver<MDiscountSchema> implements GraphQLResolver<MDiscountSchema> {


	static Map<String, String> CUMULATIVELEVEL_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "e1900a88-3b1d-42d1-bdd1-73c98e8da204");
		}
	};
	public CompletableFuture<MRefList_BH> CumulativeLevel(MDiscountSchema entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCumulativeLevel())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CUMULATIVELEVEL_UUIDS_BY_VALUE.get(entity.getCumulativeLevel()));
	}

	static Map<String, String> DISCOUNTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("F", "05de479b-68e1-4938-9780-32cc46552a61");
			put("S", "0e5a081a-1ff0-41fe-9416-d49900f47c01");
			put("B", "72cb1574-a005-4e1f-bb1d-64e2eb4f8724");
			put("P", "fc11d767-ab3d-44c4-bdcc-6404c2c5af07");
		}
	};
	public CompletableFuture<MRefList_BH> DiscountType(MDiscountSchema entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDiscountType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DISCOUNTTYPE_UUIDS_BY_VALUE.get(entity.getDiscountType()));
	}

	public Boolean IsBPartnerFlatDiscount(MDiscountSchema entity, DataFetchingEnvironment environment) {
		return entity.isBPartnerFlatDiscount();
	}

	public Boolean IsQuantityBased(MDiscountSchema entity, DataFetchingEnvironment environment) {
		return entity.isQuantityBased();
	}

	public Boolean Processing(MDiscountSchema entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}

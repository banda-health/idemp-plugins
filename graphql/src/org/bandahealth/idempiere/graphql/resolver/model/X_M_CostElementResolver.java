package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MCostElement;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_CostElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostElementResolver extends POResolver<MCostElement> implements GraphQLResolver<MCostElement> {


	static Map<String, String> COSTELEMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("M", "7584057d-06fd-4576-9d52-0ec754e6dd52");
			put("O", "c87ce13d-1133-4cc9-ad8b-23eb9ff2c22b");
			put("B", "f3c861cc-8f8d-4ec8-897b-611d97e279c1");
			put("X", "64ec11a2-2a30-4c83-9e32-b21c334291ba");
			put("R", "c03ac230-49bc-4dde-a4fd-bf76647f173c");
		}
	};
	public CompletableFuture<MRefList_BH> CostElementType(MCostElement entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCostElementType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(COSTELEMENTTYPE_UUIDS_BY_VALUE.get(entity.getCostElementType()));
	}

	static Map<String, String> COSTINGMETHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "d3ba6803-5479-4b30-ba20-6b40e658c5d8");
			put("A", "29b356c5-1757-4bab-a331-a01b9415f4e6");
			put("L", "fb47834b-767e-4ffe-b7ea-f690279d4345");
			put("F", "835a19ab-521e-406c-b0b2-f3e4c64c44b7");
			put("p", "01741faf-094c-46ed-9266-2d3adac2c504");
			put("I", "9127a623-4d9b-4a1a-8462-b31d8ddb24ed");
			put("i", "f4296d4f-761c-4545-a2ec-ca5c86e1b741");
			put("U", "10ca122c-b77e-410e-8755-5033f17405d4");
			put("x", "c788f7ef-7cf6-479e-85fc-7212ae0a9f9b");
		}
	};
	public CompletableFuture<MRefList_BH> CostingMethod(MCostElement entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCostingMethod())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(COSTINGMETHOD_UUIDS_BY_VALUE.get(entity.getCostingMethod()));
	}

	public Boolean IsCalculated(MCostElement entity, DataFetchingEnvironment environment) {
		return entity.isCalculated();
	}

}

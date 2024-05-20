package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperCfgDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.model.X_M_ShipperLabelsCfg;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ShipperLabelsCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperLabelsCfgResolver extends POResolver<X_M_ShipperLabelsCfg> implements GraphQLResolver<X_M_ShipperLabelsCfg> {


	public Boolean IsDefault(X_M_ShipperLabelsCfg entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	static Map<String, String> LABELPRINTMETHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("E", "30f489ba-1343-4132-8ed5-af624c38a565");
			put("I", "68594d7b-e52d-4755-a921-29d3b112e8bd");
			put("Z", "0ee3f5cd-f1a0-416a-831c-687456fbc0fc");
		}
	};
	public CompletableFuture<MRefList_BH> LabelPrintMethod(X_M_ShipperLabelsCfg entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLabelPrintMethod())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(LABELPRINTMETHOD_UUIDS_BY_VALUE.get(entity.getLabelPrintMethod()));
	}


	/**
	 * Get Shipper Configuration.
	 *
	 * @return Shipper Configuration
	 */
	public CompletableFuture<X_M_ShipperCfg> M_ShipperCfg(X_M_ShipperLabelsCfg entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShipperCfg_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_M_ShipperCfg> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperCfgDataLoader.DATALOADER_M_ShipperCfg_BY_ID);
		return dataLoader.load(entity.getM_ShipperCfg_ID());
	}

}

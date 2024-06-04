package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperLabelsCfgDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperLabels;
import org.compiere.model.X_M_ShipperLabelsCfg;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ShipperLabels - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperLabelsResolver extends POResolver<MShipperLabels> implements GraphQLResolver<MShipperLabels> {


	public Boolean IsDefault(MShipperLabels entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public static Map<String, String> LABELPRINTMETHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("E", "30f489ba-1343-4132-8ed5-af624c38a565"); // Eltron
			put("I", "68594d7b-e52d-4755-a921-29d3b112e8bd"); // Image
			put("Z", "0ee3f5cd-f1a0-416a-831c-687456fbc0fc"); // Zebra
		}
	};
	public CompletableFuture<MRefList_BH> LabelPrintMethod(MShipperLabels entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLabelPrintMethod())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(LABELPRINTMETHOD_UUIDS_BY_VALUE.get(entity.getLabelPrintMethod()));
	}


	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public CompletableFuture<MShipper> M_Shipper(MShipperLabels entity, DataFetchingEnvironment environment) {
		if (entity.getM_Shipper_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MShipper> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperDataLoader.DATALOADER_M_Shipper_BY_ID);
		return dataLoader.load(entity.getM_Shipper_ID());
	}


	/**
	 * Get Shipper Labels Configuration.
	 *
	 * @return Shipper Labels Configuration
	 */
	public CompletableFuture<X_M_ShipperLabelsCfg> M_ShipperLabelsCfg(MShipperLabels entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShipperLabelsCfg_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_M_ShipperLabelsCfg> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperLabelsCfgDataLoader.DATALOADER_M_ShipperLabelsCfg_BY_ID);
		return dataLoader.load(entity.getM_ShipperLabelsCfg_ID());
	}

}

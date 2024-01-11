package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;
import org.eevolution.model.MPPProductBOM;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Data Loader for PP_Product_BOM_Trl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Product_BOM_TrlDataLoader extends PODataLoader<PO> {
	public static String PP_Product_BOM_Trl_BY_ID_DATA_LOADER = "PP_Product_BOMByIdDataLoader";
	public static String PP_Product_BOM_Trl_BY_UUID_DATA_LOADER = "PP_Product_BOMByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPPProductBOM.Table_Name + "_Trl";
	}

	@Override
	protected String getByIdDataLoaderName() {
		return null;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PP_Product_BOM_Trl_BY_UUID_DATA_LOADER;
	}

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(PP_Product_BOM_Trl_BY_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByIdAndLanguageBatchLoader(),
						getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<Integer, PO> getByIdAndLanguageBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			List<Object> parameters = new ArrayList<>();
			String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);
			parameters.add(Env.getLanguage(batchLoaderEnvironment.getContext()).getAD_Language());
			List<PO> translations = new Query(batchLoaderEnvironment.getContext(), getTableName(),
					MPPProductBOM.COLUMNNAME_PP_Product_BOM_ID + " IN (" + whereClause + ") AND AD_Language = ?", null).setParameters(
					parameters).list();
			return translations.stream().collect(
					Collectors.toMap(translation -> translation.get_ValueAsInt(MPPProductBOM.COLUMNNAME_PP_Product_BOM_ID),
							translation -> translation));
		});
	}
}

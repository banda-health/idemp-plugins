package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;
import org.eevolution.model.X_PP_Order_BOM;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Data Loader for PP_Order_BOM_Trl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PP_Order_BOM_TrlDataLoader extends PODataLoader<PO> {
	public static String DATALOADER_PP_Order_BOM_Trl_BY_ID = "PP_Order_BOM_TrlByIdDataLoader";
	public static String DATALOADER_PP_Order_BOM_Trl_BY_UUID = "PP_Order_BOM_TrlByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order_BOM.Table_Name + "_Trl";
	}

	@Override
	protected String getByIdDataLoaderName() {
		return null;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_Order_BOM_Trl_BY_UUID;
	}

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_PP_Order_BOM_Trl_BY_ID,
				DataLoader.newMappedDataLoader(getByIdAndLanguageBatchLoader(),
						getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<Integer, PO> getByIdAndLanguageBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			List<Object> parameters = new ArrayList<>();
			String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);
			parameters.add(Env.getLanguage(batchLoaderEnvironment.getContext()).getAD_Language());
			List<PO> translations = new Query(batchLoaderEnvironment.getContext(), getTableName(),
					X_PP_Order_BOM.COLUMNNAME_PP_Order_BOM_ID + " IN (" + whereClause + ") AND AD_Language = ?", null).setParameters(
					parameters).list();
			return translations.stream().collect(
					Collectors.toMap(translation -> translation.get_ValueAsInt(X_PP_Order_BOM.COLUMNNAME_PP_Order_BOM_ID),
							translation -> translation));
		});
	}
}

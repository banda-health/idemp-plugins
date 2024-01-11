package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MTabNavBtnTab;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Data Loader for BH_TabNavBtn_Tab_Trl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_TabNavBtn_Tab_TrlDataLoader extends PODataLoader<PO> {
	public static String BH_TabNavBtn_Tab_Trl_BY_ID_DATA_LOADER = "BH_TabNavBtn_TabByIdDataLoader";
	public static String BH_TabNavBtn_Tab_Trl_BY_UUID_DATA_LOADER = "BH_TabNavBtn_TabByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTabNavBtnTab.Table_Name + "_Trl";
	}

	@Override
	protected String getByIdDataLoaderName() {
		return null;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_TabNavBtn_Tab_Trl_BY_UUID_DATA_LOADER;
	}

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(BH_TabNavBtn_Tab_Trl_BY_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByIdAndLanguageBatchLoader(),
						getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<Integer, PO> getByIdAndLanguageBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			List<Object> parameters = new ArrayList<>();
			String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);
			parameters.add(Env.getLanguage(batchLoaderEnvironment.getContext()).getAD_Language());
			List<PO> translations = new Query(batchLoaderEnvironment.getContext(), getTableName(),
					MTabNavBtnTab.COLUMNNAME_BH_TabNavBtn_Tab_ID + " IN (" + whereClause + ") AND AD_Language = ?", null).setParameters(
					parameters).list();
			return translations.stream().collect(
					Collectors.toMap(translation -> translation.get_ValueAsInt(MTabNavBtnTab.COLUMNNAME_BH_TabNavBtn_Tab_ID),
							translation -> translation));
		});
	}
}

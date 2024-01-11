package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.compiere.model.MDocumentStatus;
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
 * Data Loader for PA_DocumentStatus_Trl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DocumentStatus_TrlDataLoader extends PODataLoader<PO> {
	public static String PA_DocumentStatus_Trl_BY_ID_DATA_LOADER = "PA_DocumentStatusByIdDataLoader";
	public static String PA_DocumentStatus_Trl_BY_UUID_DATA_LOADER = "PA_DocumentStatusByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDocumentStatus.Table_Name + "_Trl";
	}

	@Override
	protected String getByIdDataLoaderName() {
		return null;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_DocumentStatus_Trl_BY_UUID_DATA_LOADER;
	}

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(PA_DocumentStatus_Trl_BY_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByIdAndLanguageBatchLoader(),
						getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<Integer, PO> getByIdAndLanguageBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			List<Object> parameters = new ArrayList<>();
			String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);
			parameters.add(Env.getLanguage(batchLoaderEnvironment.getContext()).getAD_Language());
			List<PO> translations = new Query(batchLoaderEnvironment.getContext(), getTableName(),
					MDocumentStatus.COLUMNNAME_PA_DocumentStatus_ID + " IN (" + whereClause + ") AND AD_Language = ?", null).setParameters(
					parameters).list();
			return translations.stream().collect(
					Collectors.toMap(translation -> translation.get_ValueAsInt(MDocumentStatus.COLUMNNAME_PA_DocumentStatus_ID),
							translation -> translation));
		});
	}
}

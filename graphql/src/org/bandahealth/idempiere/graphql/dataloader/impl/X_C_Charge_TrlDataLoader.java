package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MCharge_BH;
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
 * Data Loader for C_Charge_Trl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Charge_TrlDataLoader extends PODataLoader<PO> {
	public static String C_Charge_Trl_BY_ID_DATA_LOADER = "C_ChargeByIdDataLoader";
	public static String C_Charge_Trl_BY_UUID_DATA_LOADER = "C_ChargeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCharge_BH.Table_Name + "_Trl";
	}

	@Override
	protected String getByIdDataLoaderName() {
		return null;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Charge_Trl_BY_UUID_DATA_LOADER;
	}

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(C_Charge_Trl_BY_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByIdAndLanguageBatchLoader(),
						getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<Integer, PO> getByIdAndLanguageBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			List<Object> parameters = new ArrayList<>();
			String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);
			parameters.add(Env.getLanguage(batchLoaderEnvironment.getContext()).getAD_Language());
			List<PO> translations = new Query(batchLoaderEnvironment.getContext(), getTableName(),
					MCharge_BH.COLUMNNAME_C_Charge_ID + " IN (" + whereClause + ") AND AD_Language = ?", null).setParameters(
					parameters).list();
			return translations.stream().collect(
					Collectors.toMap(translation -> translation.get_ValueAsInt(MCharge_BH.COLUMNNAME_C_Charge_ID),
							translation -> translation));
		});
	}
}

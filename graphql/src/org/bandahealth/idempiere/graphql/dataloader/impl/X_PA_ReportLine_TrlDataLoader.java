package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.report.MReportLine;
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
 * Data Loader for PA_ReportLine_Trl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_ReportLine_TrlDataLoader extends PODataLoader<PO> {
	public static String DATALOADER_PA_ReportLine_Trl_BY_ID = "PA_ReportLine_TrlByIdDataLoader";
	public static String DATALOADER_PA_ReportLine_Trl_BY_UUID = "PA_ReportLine_TrlByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReportLine.Table_Name + "_Trl";
	}

	@Override
	protected String getByIdDataLoaderName() {
		return null;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_ReportLine_Trl_BY_UUID;
	}

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_PA_ReportLine_Trl_BY_ID,
				DataLoader.newMappedDataLoader(getByIdAndLanguageBatchLoader(),
						getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<Integer, PO> getByIdAndLanguageBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			List<Object> parameters = new ArrayList<>();
			String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);
			parameters.add(Env.getLanguage(batchLoaderEnvironment.getContext()).getAD_Language());
			List<PO> translations = new Query(batchLoaderEnvironment.getContext(), getTableName(),
					MReportLine.COLUMNNAME_PA_ReportLine_ID + " IN (" + whereClause + ") AND AD_Language = ?", null).setParameters(
					parameters).list();
			return translations.stream().collect(
					Collectors.toMap(translation -> translation.get_ValueAsInt(MReportLine.COLUMNNAME_PA_ReportLine_ID),
							translation -> translation));
		});
	}
}

package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollFiling;
import org.bandahealth.idempiere.base.model.MBHPayrollRun;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_RunDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Payroll_Filing - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_FilingResolver extends POResolver<MBHPayrollFiling> implements GraphQLResolver<MBHPayrollFiling> {


	public static Map<String, String> BH_FILINGTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("PAYE", "fb4557a8-75a8-4dcd-9bb8-7645320ea424"); // PAYE
			put("NSSF", "03d58984-e15b-41f9-a2b3-905bca542fae"); // NSSF
			put("SHIF", "7088b5eb-8432-4a7c-bae5-069ceffa4d39"); // SHIF
			put("HLEVY", "1c50b604-d02c-43d7-91e3-49604edff8ba"); // Housing Levy
			put("NITA", "c3606182-dd5e-4d5f-8b35-0ce7eeeee912"); // NITA
		}
	};

	/**
	 * Get Filing Type.
	 *
	 * @return Filing Type
	 */
	public CompletableFuture<MRefList_BH> BH_FilingType(MBHPayrollFiling entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_FilingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_FILINGTYPE_UUIDS_BY_VALUE.get(entity.getBH_FilingType()));
	}

	public Boolean BH_IsPaid(MBHPayrollFiling entity, DataFetchingEnvironment environment) {
		return entity.isBH_IsPaid();
	}

	/**
	 * Get Payroll Run.
	 *
	 * @return Payroll Run
	 */
	public CompletableFuture<MBHPayrollRun> BH_Payroll_Run(MBHPayrollFiling entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Payroll_Run_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHPayrollRun> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Payroll_RunDataLoader.DATALOADER_BH_Payroll_Run_BY_ID);
		return dataLoader.load(entity.getBH_Payroll_Run_ID());
	}
}

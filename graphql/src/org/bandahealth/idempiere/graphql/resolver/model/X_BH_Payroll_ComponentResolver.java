package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Payroll_Component - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_ComponentResolver extends POResolver<MBHPayrollComponent> implements GraphQLResolver<MBHPayrollComponent> {


	public static Map<String, String> BH_CATEGORY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("EARNING", "352babfb-4207-45c7-8d4d-28cbb9ff7715"); // Earning
			put("EMPLOYER_CONTRIB", "407ec2f9-1b1d-4954-960a-32604f89b642"); // Employer contribution
			put("RELIEF", "da9479e1-7516-45af-becc-824fe11cbde6"); // Relief
			put("STAT_DED", "8677a447-7376-447a-bb8b-49f1166ce18d"); // Statutory deduction
			put("VOL_DED", "bf58c2a3-dc36-403f-a672-4ee1c3aad8ab"); // Voluntary deduction
		}
	};
	public static Map<String, String> BH_CALCMETHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("BANDS", "881c7c89-224e-4434-ac01-2f8bf77e48f2"); // Tax bands
			put("EMPLOYEE_AMOUNT", "d5d50c37-f484-40b9-84c0-79cf451f52e6"); // Employee-set amount
			put("FIXED", "8ce6d3df-8066-4ebe-a762-5afabb6b7c7c"); // Fixed amount
			put("PERCENT_OF_GROSS", "ed7c2160-fd41-4696-934c-fbd396017604"); // Percent of gross
			put("TIERED", "f8aba323-fb69-4d2e-a6ee-b3906786ddda"); // Tiered table
		}
	};

	/**
	 * Get Category.
	 *
	 * @return Category
	 */
	public CompletableFuture<MRefList_BH> BH_Category(MBHPayrollComponent entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Category())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_CATEGORY_UUIDS_BY_VALUE.get(entity.getBH_Category()));
	}

	/**
	 * Get Calculation Method.
	 *
	 * @return Calculation Method
	 */
	public CompletableFuture<MRefList_BH> BH_CalcMethod(MBHPayrollComponent entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_CalcMethod())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_CALCMETHOD_UUIDS_BY_VALUE.get(entity.getBH_CalcMethod()));
	}

	public Boolean BH_IsStatutory(MBHPayrollComponent entity, DataFetchingEnvironment environment) {
		return entity.isBH_IsStatutory();
	}

	public Boolean BH_IsTaxDeductible(MBHPayrollComponent entity, DataFetchingEnvironment environment) {
		return entity.isBH_IsTaxDeductible();
	}
}

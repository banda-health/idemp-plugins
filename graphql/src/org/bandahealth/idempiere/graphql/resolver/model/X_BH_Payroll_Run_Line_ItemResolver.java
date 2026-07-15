package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLine;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLineItem;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_Run_LineDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Payroll_Run_Line_Item - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_Run_Line_ItemResolver extends POResolver<MBHPayrollRunLineItem> implements GraphQLResolver<MBHPayrollRunLineItem> {


	/**
	 * Get Category. Line items share the component category list — the UUID map lives on
	 * {@link X_BH_Payroll_ComponentResolver#BH_CATEGORY_UUIDS_BY_VALUE}.
	 *
	 * @return Category
	 */
	public CompletableFuture<MRefList_BH> BH_Category(MBHPayrollRunLineItem entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Category())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(X_BH_Payroll_ComponentResolver.BH_CATEGORY_UUIDS_BY_VALUE.get(entity.getBH_Category()));
	}

	public Boolean BH_IsTaxDeductible(MBHPayrollRunLineItem entity, DataFetchingEnvironment environment) {
		return entity.isBH_IsTaxDeductible();
	}

	/**
	 * Get Payroll Run Line.
	 *
	 * @return Payroll Run Line
	 */
	public CompletableFuture<MBHPayrollRunLine> BH_Payroll_Run_Line(MBHPayrollRunLineItem entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Payroll_Run_Line_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHPayrollRunLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Payroll_Run_LineDataLoader.DATALOADER_BH_Payroll_Run_Line_BY_ID);
		return dataLoader.load(entity.getBH_Payroll_Run_Line_ID());
	}
}

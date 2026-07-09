package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLine;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLineItem;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHPayrollRunLineItemDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHPayrollRunLineResolver extends X_BH_Payroll_Run_LineResolver {

	public CompletableFuture<List<MBHPayrollRunLineItem>> BH_Payroll_Run_Line_Items(MBHPayrollRunLine entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHPayrollRunLineItem>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHPayrollRunLineItemDataLoader.DATALOADER_BH_Payroll_Run_Line_Item_BY_BH_Payroll_Run_Line_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.get_ID()));
	}
}

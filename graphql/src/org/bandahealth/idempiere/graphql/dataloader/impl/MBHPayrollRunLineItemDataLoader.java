package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayrollRunLineItem;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHPayrollRunLineItemDataLoader extends X_BH_Payroll_Run_Line_ItemDataLoader {
	public static String DATALOADER_BH_Payroll_Run_Line_Item_BY_BH_Payroll_Run_Line_ID =
			"DATALOADER_BH_Payroll_Run_Line_Item_BY_BH_Payroll_Run_Line_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Payroll_Run_Line_Item_BY_BH_Payroll_Run_Line_ID,
				DataLoader.newMappedDataLoader(getByBHPayrollRunLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHPayrollRunLineItem>> getByBHPayrollRunLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHPayrollRunLineItem::getBH_Payroll_Run_Line_ID,
				MBHPayrollRunLineItem.COLUMNNAME_BH_Payroll_Run_Line_ID, keys);
	}
}

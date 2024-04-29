package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MBankStatementLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBankStatementLineDataLoader extends X_C_BankStatementLineDataLoader {
	public static String DATALOADER_C_BankStatementLine_BY_C_BankStatement_ID =
			"DATALOADER_C_BankStatementLine_BY_C_BankStatement_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_BankStatementLine_BY_C_BankStatement_ID,
				DataLoader.newMappedDataLoader(getByBankStatementIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBankStatementLine>> getByBankStatementIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBankStatementLine::getC_BankStatement_ID,
				MBankStatementLine.COLUMNNAME_C_BankStatement_ID, keys);
	}
}

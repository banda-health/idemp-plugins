package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MBPBankAccount;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBPBankAccountDataLoader extends X_C_BP_BankAccountDataLoader {
	public static String DATALOADER_C_BP_BankAccount_BY_C_BPartner_ID = "DATALOADER_C_BP_BankAccount_BY_C_BPartner_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_BP_BankAccount_BY_C_BPartner_ID,
				DataLoader.newMappedDataLoader(getByBusinessPartnerIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBPBankAccount>> getByBusinessPartnerIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBPBankAccount::getC_BPartner_ID,
				MBPBankAccount.COLUMNNAME_C_BPartner_ID, keys);
	}
}

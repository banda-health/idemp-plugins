package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBankStatementLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBankStatement;
import org.compiere.model.MBankStatementLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBankStatementResolver extends X_C_BankStatementResolver {

	public CompletableFuture<List<MBankStatementLine>> C_BankStatementLines(MBankStatement entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBankStatementLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBankStatementLineDataLoader.DATALOADER_C_BankStatementLine_BY_C_BankStatement_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_BankStatement_ID()));
	}
}

package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MTimeExpenseLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MTimeExpense;
import org.compiere.model.MTimeExpenseLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MTimeExpenseResolver extends X_S_TimeExpenseResolver {

	public CompletableFuture<List<MTimeExpenseLine>> S_TimeExpenseLines(MTimeExpense entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MTimeExpenseLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MTimeExpenseLineDataLoader.DATALOADER_S_TimeExpenseLine_BY_S_TimeExpense_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getS_TimeExpense_ID()));
	}
}

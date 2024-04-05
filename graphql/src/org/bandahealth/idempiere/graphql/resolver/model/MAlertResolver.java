package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MAlertRecipientDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MAlertRuleDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAlert;
import org.compiere.model.MAlertRecipient;
import org.compiere.model.MAlertRule;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MAlertResolver extends X_AD_AlertResolver {

	public CompletableFuture<List<MAlertRule>> AD_AlertRules(MAlert entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MAlertRule>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MAlertRuleDataLoader.DATALOADER_AD_AlertRule_BY_AD_Alert_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Alert_ID()));
	}

	public CompletableFuture<List<MAlertRecipient>> AD_AlertRecipients(MAlert entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MAlertRecipient>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MAlertRecipientDataLoader.DATALOADER_AD_AlertRecipient_BY_AD_Alert_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Alert_ID()));
	}
}

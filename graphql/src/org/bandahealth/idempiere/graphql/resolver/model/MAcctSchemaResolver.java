package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MAcctSchemaElementDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAcctSchemaElement;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MAcctSchemaResolver extends X_C_AcctSchemaResolver {

	public CompletableFuture<List<MAcctSchemaElement>> C_AcctSchema_Elements(MAcctSchema entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MAcctSchemaElement>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MAcctSchemaElementDataLoader.DATALOADER_C_AcctSchema_Element_BY_C_AcctSchema_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_AcctSchema_ID()));
	}
}

package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldSug;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldValSug;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHPayerInfoFldValSugDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHPayerInfoFldSugResolver extends X_BH_Payer_Info_Fld_SugResolver {
	public CompletableFuture<List<MBHPayerInfoFldValSug>> BH_Payer_Info_Fld_Val_SugList(MBHPayerInfoFldSug entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHPayerInfoFldValSug>> dataLoader = environment.getDataLoaderRegistry().getDataLoader(
				MBHPayerInfoFldValSugDataLoader.DATALOADER_BH_Payer_Info_Fld_Val_Sug_By_BH_Payer_Info_Fld_Sug_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Payer_Info_Fld_Sug_ID()));
	}
}

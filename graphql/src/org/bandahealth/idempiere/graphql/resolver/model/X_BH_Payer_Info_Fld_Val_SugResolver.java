package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldSug;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldValSug;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payer_Info_Fld_SugDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Payer_Info_Fld_Val_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Payer_Info_Fld_Val_SugResolver extends POResolver<MBHPayerInfoFldValSug> implements GraphQLResolver<MBHPayerInfoFldValSug> {



	/**
	 * Get Payer Info Field Suggestion.
	 *
	 * @return Payer Info Field Suggestion
	 */
	public CompletableFuture<MBHPayerInfoFldSug> BH_Payer_Info_Fld_Sug(MBHPayerInfoFldValSug entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Payer_Info_Fld_Sug_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBHPayerInfoFldSug> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Payer_Info_Fld_SugDataLoader.DATALOADER_BH_Payer_Info_Fld_Sug_BY_ID);
		return dataLoader.load(entity.getBH_Payer_Info_Fld_Sug_ID());
	}

}

package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payer_Info_FldDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Payer_Info_Fld_Val - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Payer_Info_Fld_ValResolver extends POResolver<MBHPayerInfoFldVal> implements GraphQLResolver<MBHPayerInfoFldVal> {



	/**
	 * Get Payer Info Field.
	 *
	 * @return Payer Info Field
	 */
	public CompletableFuture<MBHPayerInfoFld> BH_Payer_Info_Fld(MBHPayerInfoFldVal entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Payer_Info_Fld_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBHPayerInfoFld> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Payer_Info_FldDataLoader.DATALOADER_BH_Payer_Info_Fld_BY_ID);
		return dataLoader.load(entity.getBH_Payer_Info_Fld_ID());
	}

}

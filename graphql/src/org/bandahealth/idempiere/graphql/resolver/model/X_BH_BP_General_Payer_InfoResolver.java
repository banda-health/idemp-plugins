package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;
import org.bandahealth.idempiere.base.model.MBHBPPayerInfo;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_BP_Payer_InfoDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payer_Info_FldDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_BP_General_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_BP_General_Payer_InfoResolver extends POResolver<MBHBPGeneralPayerInfo> implements GraphQLResolver<MBHBPGeneralPayerInfo> {



	/**
	 * Get Business Partner Payer Information.
	 *
	 * @return Business Partner Payer Information
	 */
	public CompletableFuture<MBHBPPayerInfo> BH_BP_Payer_Info(MBHBPGeneralPayerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getBH_BP_Payer_Info_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBHBPPayerInfo> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_BP_Payer_InfoDataLoader.DATALOADER_BH_BP_Payer_Info_BY_ID);
		return dataLoader.load(entity.getBH_BP_Payer_Info_ID());
	}


	/**
	 * Get Payer Info Field.
	 *
	 * @return Payer Info Field
	 */
	public CompletableFuture<MBHPayerInfoFld> BH_Payer_Info_Fld(MBHBPGeneralPayerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Payer_Info_Fld_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBHPayerInfoFld> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Payer_Info_FldDataLoader.DATALOADER_BH_Payer_Info_Fld_BY_ID);
		return dataLoader.load(entity.getBH_Payer_Info_Fld_ID());
	}

}

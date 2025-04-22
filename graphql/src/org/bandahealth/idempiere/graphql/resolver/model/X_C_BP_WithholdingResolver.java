package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_WithholdingDataLoader;
import org.compiere.model.MWithholding;
import org.compiere.model.X_C_BP_Withholding;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BP_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BP_WithholdingResolver extends POResolver<X_C_BP_Withholding> implements GraphQLResolver<X_C_BP_Withholding> {



	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_C_BP_Withholding entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Withholding.
	 *
	 * @return Withholding type defined
	 */
	public CompletableFuture<MWithholding> C_Withholding(X_C_BP_Withholding entity, DataFetchingEnvironment environment) {
		if (entity.getC_Withholding_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWithholding> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_WithholdingDataLoader.DATALOADER_C_Withholding_BY_ID);
		return dataLoader.load(entity.getC_Withholding_ID());
	}

	public Boolean IsMandatoryWithholding(X_C_BP_Withholding entity, DataFetchingEnvironment environment) {
		return entity.isMandatoryWithholding();
	}

	public Boolean IsTemporaryExempt(X_C_BP_Withholding entity, DataFetchingEnvironment environment) {
		return entity.isTemporaryExempt();
	}

}

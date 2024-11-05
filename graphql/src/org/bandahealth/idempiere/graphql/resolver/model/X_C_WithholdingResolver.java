package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentTermDataLoader;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MWithholding;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_WithholdingResolver extends POResolver<MWithholding> implements GraphQLResolver<MWithholding> {



	/**
	 * Get Beneficiary.
	 *
	 * @return Business Partner to whom payment is made
	 */
	public CompletableFuture<MBPartner_BH> Benefici(MWithholding entity, DataFetchingEnvironment environment) {
		if (entity.getBeneficiary() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getBeneficiary());
	}


	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	public CompletableFuture<MPaymentTerm> C_PaymentTerm(MWithholding entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentTerm_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPaymentTerm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentTermDataLoader.DATALOADER_C_PaymentTerm_BY_ID);
		return dataLoader.load(entity.getC_PaymentTerm_ID());
	}

	public Boolean IsPaidTo3Party(MWithholding entity, DataFetchingEnvironment environment) {
		return entity.isPaidTo3Party();
	}

	public Boolean IsPercentWithholding(MWithholding entity, DataFetchingEnvironment environment) {
		return entity.isPercentWithholding();
	}

	public Boolean IsTaxProrated(MWithholding entity, DataFetchingEnvironment environment) {
		return entity.isTaxProrated();
	}

	public Boolean IsTaxWithholding(MWithholding entity, DataFetchingEnvironment environment) {
		return entity.isTaxWithholding();
	}

}

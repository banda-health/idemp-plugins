package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_SLA_CriteriaDataLoader;
import org.compiere.model.X_PA_SLA_Criteria;
import org.compiere.model.X_PA_SLA_Goal;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_SLA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_SLA_GoalResolver extends POResolver<X_PA_SLA_Goal> implements GraphQLResolver<X_PA_SLA_Goal> {



	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_PA_SLA_Goal entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get SLA Criteria.
	 *
	 * @return Service Level Agreement Criteria
	 */
	public CompletableFuture<X_PA_SLA_Criteria> PA_SLA_Criteria(X_PA_SLA_Goal entity, DataFetchingEnvironment environment) {
		if (entity.getPA_SLA_Criteria_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_SLA_Criteria> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_SLA_CriteriaDataLoader.DATALOADER_PA_SLA_Criteria_BY_ID);
		return dataLoader.load(entity.getPA_SLA_Criteria_ID());
	}

	public Boolean Processed(X_PA_SLA_Goal entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_PA_SLA_Goal entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}

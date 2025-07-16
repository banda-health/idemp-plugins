package org.bandahealth.idempiere.graphql.resolver.model;

import java.util.concurrent.CompletableFuture;

import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHVisitDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPaymentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.model.PaymentTrail;
import org.dataloader.DataLoader;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;

public class PaymentTrailResolver implements GraphQLResolver<PaymentTrail> {

	/**
	 * Return the user entity for this object of who created this entity, leveraging
	 * the user data loader
	 *
	 * @param Entity      The entity to fetch data for
	 * @param environment The GraphQL environment object
	 * @return A completable future of the user who created the entity
	 */
	public CompletableFuture<MUser_BH> CreatedBy(PaymentTrail Entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MUser_BH> userDataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return userDataLoader.load(Entity.getCreatedBy());
	}

	public CompletableFuture<MBPartner_BH> C_BPartner(PaymentTrail Entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MBPartner_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(Entity.getBusinessPartnerId());
	}

	public CompletableFuture<MPayment_BH> C_Payment(PaymentTrail Entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MPayment_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MPaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(Entity.getPaymentId());
	}
	
	public CompletableFuture<MBHVisit> BH_Visit(PaymentTrail Entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MBHVisit> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHVisitDataLoader.DATALOADER_BH_Visit_BY_ID);
		return dataLoader.load(Entity.getVisitId());
	}
}

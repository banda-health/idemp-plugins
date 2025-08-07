package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHVisitDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MOrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPaymentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.model.VendorPaymentTrail;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

public class VendorPaymentTrailResolver implements GraphQLResolver<VendorPaymentTrail> {

	public CompletableFuture<MBHVisit> BH_Visit(VendorPaymentTrail entity, DataFetchingEnvironment environment) {
		if (entity.getVisitId() == null || entity.getVisitId() < 1) {
			return null;
		}
		final DataLoader<Integer, MBHVisit> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MBHVisitDataLoader.DATALOADER_BH_Visit_BY_ID);
		return dataLoader.load(entity.getVisitId());
	}

	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(VendorPaymentTrail entity,
			DataFetchingEnvironment environment) {
		if (entity.getBusinessPartnerId() == null || entity.getBusinessPartnerId() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getBusinessPartnerId());
	}

	public CompletableFuture<MInvoice_BH> C_Invoice(VendorPaymentTrail entity, DataFetchingEnvironment environment) {
		if (entity.getInvoiceId() == null || entity.getInvoiceId() < 1) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MInvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getInvoiceId());
	}

	public CompletableFuture<MPayment_BH> C_Payment(VendorPaymentTrail entity, DataFetchingEnvironment environment) {
		if (entity.getPaymentId() == null || entity.getPaymentId() < 1) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MPaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getPaymentId());
	}
	public CompletableFuture<MOrder_BH> C_Order(VendorPaymentTrail entity, DataFetchingEnvironment environment) {
		if (entity.getOrderId() == null || entity.getOrderId() < 1) {
			return null;
		}
		DataLoader<Integer,MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MOrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getInvoiceId());
	}

	/**
	 * Return the user entity for this object of who created this entity, leveraging the user data loader
	 *
	 * @param Entity      The entity to fetch data for
	 * @param environment The GraphQL environment object
	 * @return A completable future of the user who created the entity
	 */
	public CompletableFuture<MUser_BH> CreatedBy(VendorPaymentTrail Entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MUser_BH> userDataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return userDataLoader.load(Entity.getCreatedBy());
	}
}

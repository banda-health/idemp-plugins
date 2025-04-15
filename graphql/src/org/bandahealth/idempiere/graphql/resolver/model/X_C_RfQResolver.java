package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQ_TopicDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MRfQ;
import org.compiere.model.MRfQTopic;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_RfQ - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RfQResolver extends POResolver<MRfQ> implements GraphQLResolver<MRfQ> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MRfQ entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MRfQ entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MRfQ entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MRfQ entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MRfQ entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get RfQ Topic.
	 *
	 * @return Topic for Request for Quotations
	 */
	public CompletableFuture<MRfQTopic> C_RfQ_Topic(MRfQ entity, DataFetchingEnvironment environment) {
		if (entity.getC_RfQ_Topic_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRfQTopic> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RfQ_TopicDataLoader.DATALOADER_C_RfQ_Topic_BY_ID);
		return dataLoader.load(entity.getC_RfQ_Topic_ID());
	}

	public Boolean IsInvitedVendorsOnly(MRfQ entity, DataFetchingEnvironment environment) {
		return entity.isInvitedVendorsOnly();
	}

	public Boolean IsQuoteAllQty(MRfQ entity, DataFetchingEnvironment environment) {
		return entity.isQuoteAllQty();
	}

	public Boolean IsQuoteTotalAmt(MRfQ entity, DataFetchingEnvironment environment) {
		return entity.isQuoteTotalAmt();
	}

	public Boolean IsRfQResponseAccepted(MRfQ entity, DataFetchingEnvironment environment) {
		return entity.isRfQResponseAccepted();
	}

	public Boolean IsSelfService(MRfQ entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}

	public Boolean Processed(MRfQ entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MRfQ entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	public static Map<String, String> QUOTETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("T", "18f2ccf6-c2e3-4863-b7b5-b3422a212bc5"); // Quote Total only
			put("S", "5ba28387-2277-4a42-be90-514049aad4e6"); // Quote Selected Lines
			put("A", "317f3134-990e-4104-89fa-2ca00916d1e9"); // Quote All Lines
		}
	};
	public CompletableFuture<MRefList_BH> QuoteType(MRfQ entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getQuoteType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(QUOTETYPE_UUIDS_BY_VALUE.get(entity.getQuoteType()));
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MRfQ entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

}

package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_B_BuyerFundsDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_B_TopicDataLoader;
import org.compiere.model.X_B_Bid;
import org.compiere.model.X_B_BuyerFunds;
import org.compiere.model.X_B_Topic;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for B_Bid - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_B_BidResolver extends POResolver<X_B_Bid> implements GraphQLResolver<X_B_Bid> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_B_Bid entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Buyer Funds.
	 *
	 * @return Buyer Funds for Bids on Topics
	 */
	public CompletableFuture<X_B_BuyerFunds> B_BuyerFunds(X_B_Bid entity, DataFetchingEnvironment environment) {
		if (entity.getB_BuyerFunds_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_B_BuyerFunds> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_B_BuyerFundsDataLoader.DATALOADER_B_BuyerFunds_BY_ID);
		return dataLoader.load(entity.getB_BuyerFunds_ID());
	}


	/**
	 * Get Topic.
	 *
	 * @return Auction Topic
	 */
	public CompletableFuture<X_B_Topic> B_Topic(X_B_Bid entity, DataFetchingEnvironment environment) {
		if (entity.getB_Topic_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_B_Topic> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_B_TopicDataLoader.DATALOADER_B_Topic_BY_ID);
		return dataLoader.load(entity.getB_Topic_ID());
	}

	public Boolean IsWillingToCommit(X_B_Bid entity, DataFetchingEnvironment environment) {
		return entity.isWillingToCommit();
	}

}

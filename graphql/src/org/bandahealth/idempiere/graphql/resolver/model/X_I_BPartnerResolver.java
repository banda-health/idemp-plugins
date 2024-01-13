package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_GreetingDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RegionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_InterestAreaDataLoader;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCountry;
import org.compiere.model.MInterestArea;
import org.compiere.model.MRegion;
import org.compiere.model.X_C_Greeting;
import org.compiere.model.X_I_BPartner;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for I_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_BPartnerResolver extends POResolver<X_I_BPartner> implements GraphQLResolver<X_I_BPartner> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_I_BPartner entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	public CompletableFuture<MBPGroup_BH> C_BP_Group(X_I_BPartner entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Group_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPGroup_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_GroupDataLoader.DATALOADER_C_BP_Group_BY_ID);
		return dataLoader.load(entity.getC_BP_Group_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_I_BPartner entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
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
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(X_I_BPartner entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	public CompletableFuture<MCountry> C_Country(X_I_BPartner entity, DataFetchingEnvironment environment) {
		if (entity.getC_Country_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCountry> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryDataLoader.DATALOADER_C_Country_BY_ID);
		return dataLoader.load(entity.getC_Country_ID());
	}


	/**
	 * Get Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	public CompletableFuture<X_C_Greeting> C_Greeting(X_I_BPartner entity, DataFetchingEnvironment environment) {
		if (entity.getC_Greeting_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_Greeting> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_GreetingDataLoader.DATALOADER_C_Greeting_BY_ID);
		return dataLoader.load(entity.getC_Greeting_ID());
	}


	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	public CompletableFuture<MRegion> C_Region(X_I_BPartner entity, DataFetchingEnvironment environment) {
		if (entity.getC_Region_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RegionDataLoader.DATALOADER_C_Region_BY_ID);
		return dataLoader.load(entity.getC_Region_ID());
	}

	public Boolean I_IsImported(X_I_BPartner entity, DataFetchingEnvironment environment) {
		return entity.isI_IsImported();
	}

	public Boolean IsCustomer(X_I_BPartner entity, DataFetchingEnvironment environment) {
		return entity.isCustomer();
	}

	public Boolean IsEmployee(X_I_BPartner entity, DataFetchingEnvironment environment) {
		return entity.isEmployee();
	}

	public Boolean IsVendor(X_I_BPartner entity, DataFetchingEnvironment environment) {
		return entity.isVendor();
	}

	public Boolean Processed(X_I_BPartner entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_I_BPartner entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Interest Area.
	 *
	 * @return Interest Area or Topic
	 */
	public CompletableFuture<MInterestArea> R_InterestArea(X_I_BPartner entity, DataFetchingEnvironment environment) {
		if (entity.getR_InterestArea_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInterestArea> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_InterestAreaDataLoader.DATALOADER_R_InterestArea_BY_ID);
		return dataLoader.load(entity.getR_InterestArea_ID());
	}

}

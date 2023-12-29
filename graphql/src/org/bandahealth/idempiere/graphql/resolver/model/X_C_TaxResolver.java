package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RuleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryGroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RegionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxCategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxProviderDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MCountry;
import org.compiere.model.MCountryGroup;
import org.compiere.model.MRefList;
import org.compiere.model.MRegion;
import org.compiere.model.MRule;
import org.compiere.model.MTax;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MTaxProvider;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxResolver extends POResolver<MTax> implements GraphQLResolver<MTax> {



	/**
	 * Get Rule.
	 *
	 * @return Rule
	 */
	public CompletableFuture<MRule> AD_Rule(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Rule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RuleDataLoader.AD_Rule_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Rule_ID());
	}


	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	public CompletableFuture<MCountry> C_Country(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_Country_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCountry> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryDataLoader.C_Country_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Country_ID());
	}


	/**
	 * Get Country Group From.
	 *
	 * @return Country Group From
	 */
	public CompletableFuture<MCountryGroup> C_CountryGroupFrom(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_CountryGroupFrom_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCountryGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryGroupDataLoader.C_CountryGroup_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_CountryGroupFrom_ID());
	}


	/**
	 * Get Country Group To.
	 *
	 * @return Country Group To
	 */
	public CompletableFuture<MCountryGroup> C_CountryGroupTo(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_CountryGroupTo_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCountryGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryGroupDataLoader.C_CountryGroup_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_CountryGroupTo_ID());
	}


	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	public CompletableFuture<MRegion> C_Region(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_Region_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RegionDataLoader.C_Region_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Region_ID());
	}


	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	public CompletableFuture<MTaxCategory> C_TaxCategory(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxCategory_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTaxCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxCategoryDataLoader.C_TaxCategory_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_TaxCategory_ID());
	}


	/**
	 * Get Tax Provider.
	 *
	 * @return Tax Provider
	 */
	public CompletableFuture<MTaxProvider> C_TaxProvider(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxProvider_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTaxProvider> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxProviderDataLoader.C_TaxProvider_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_TaxProvider_ID());
	}


	/**
	 * Get Parent Tax.
	 *
	 * @return Parent Tax indicates a tax that is made up of multiple taxes
	 */
	public CompletableFuture<MTax> Parent_Tax(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getParent_Tax_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTax> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDataLoader.C_Tax_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getParent_Tax_ID());
	}

	static Map<String, String> SOPOTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "4d7e51ff-cf6b-401d-b70b-fa87ba05a913");
			put("S", "178a8145-a858-4705-9feb-d2428b7c2427");
			put("P", "5d8aad9d-36bf-4f30-bbb2-639726c133f5");
		}
	};
	public CompletableFuture<MRefList> SOPOType_RL(MTax entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getSOPOType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(SOPOTYPE_UUIDS_BY_VALUE.get(entity.getSOPOType()));
	}


	/**
	 * Get To.
	 *
	 * @return Receiving Region
	 */
	public CompletableFuture<MRegion> To_Region(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getTo_Region_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RegionDataLoader.C_Region_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getTo_Region_ID());
	}

}

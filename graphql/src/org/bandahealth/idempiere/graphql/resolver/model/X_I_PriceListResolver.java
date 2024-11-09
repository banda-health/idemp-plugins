package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceList_VersionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MUOM;
import org.compiere.model.X_I_PriceList;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for I_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_PriceListResolver extends POResolver<X_I_PriceList> implements GraphQLResolver<X_I_PriceList> {



	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_I_PriceList entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(X_I_PriceList entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public CompletableFuture<MUOM> C_UOM(X_I_PriceList entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_ID());
	}

	public Boolean EnforcePriceLimit(X_I_PriceList entity, DataFetchingEnvironment environment) {
		return entity.isEnforcePriceLimit();
	}

	public Boolean I_IsImported(X_I_PriceList entity, DataFetchingEnvironment environment) {
		return entity.isI_IsImported();
	}

	public Boolean IsSOPriceList(X_I_PriceList entity, DataFetchingEnvironment environment) {
		return entity.isSOPriceList();
	}

	public Boolean IsTaxIncluded(X_I_PriceList entity, DataFetchingEnvironment environment) {
		return entity.isTaxIncluded();
	}


	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	public CompletableFuture<MPriceList> M_PriceList(X_I_PriceList entity, DataFetchingEnvironment environment) {
		if (entity.getM_PriceList_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.DATALOADER_M_PriceList_BY_ID);
		return dataLoader.load(entity.getM_PriceList_ID());
	}


	/**
	 * Get Price List Version.
	 *
	 * @return Identifies a unique instance of a Price List
	 */
	public CompletableFuture<MPriceListVersion> M_PriceList_Version(X_I_PriceList entity, DataFetchingEnvironment environment) {
		if (entity.getM_PriceList_Version_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPriceListVersion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceList_VersionDataLoader.DATALOADER_M_PriceList_Version_BY_ID);
		return dataLoader.load(entity.getM_PriceList_Version_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_I_PriceList entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

	public Boolean Processed(X_I_PriceList entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_I_PriceList entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}

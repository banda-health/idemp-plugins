package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxCategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_CategoryDataLoader;
import org.compiere.model.MResourceType;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for S_ResourceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_ResourceTypeResolver extends POResolver<MResourceType> implements GraphQLResolver<MResourceType> {


	public Boolean AllowUoMFractions(MResourceType entity, DataFetchingEnvironment environment) {
		return entity.isAllowUoMFractions();
	}


	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	public CompletableFuture<MTaxCategory> C_TaxCategory(MResourceType entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxCategory_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTaxCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxCategoryDataLoader.DATALOADER_C_TaxCategory_BY_ID);
		return dataLoader.load(entity.getC_TaxCategory_ID());
	}


	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public CompletableFuture<MUOM> C_UOM(MResourceType entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_ID());
	}

	public Boolean IsDateSlot(MResourceType entity, DataFetchingEnvironment environment) {
		return entity.isDateSlot();
	}

	public Boolean IsSingleAssignment(MResourceType entity, DataFetchingEnvironment environment) {
		return entity.isSingleAssignment();
	}

	public Boolean IsTimeSlot(MResourceType entity, DataFetchingEnvironment environment) {
		return entity.isTimeSlot();
	}


	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	public CompletableFuture<MProductCategory_BH> M_Product_Category(MResourceType entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_Category_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProductCategory_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_Product_CategoryDataLoader.DATALOADER_M_Product_Category_BY_ID);
		return dataLoader.load(entity.getM_Product_Category_ID());
	}

	public Boolean OnFriday(MResourceType entity, DataFetchingEnvironment environment) {
		return entity.isOnFriday();
	}

	public Boolean OnMonday(MResourceType entity, DataFetchingEnvironment environment) {
		return entity.isOnMonday();
	}

	public Boolean OnSaturday(MResourceType entity, DataFetchingEnvironment environment) {
		return entity.isOnSaturday();
	}

	public Boolean OnSunday(MResourceType entity, DataFetchingEnvironment environment) {
		return entity.isOnSunday();
	}

	public Boolean OnThursday(MResourceType entity, DataFetchingEnvironment environment) {
		return entity.isOnThursday();
	}

	public Boolean OnTuesday(MResourceType entity, DataFetchingEnvironment environment) {
		return entity.isOnTuesday();
	}

	public Boolean OnWednesday(MResourceType entity, DataFetchingEnvironment environment) {
		return entity.isOnWednesday();
	}

}

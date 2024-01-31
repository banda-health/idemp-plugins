package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MStorageOnHandDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ProductCostCalculationDataLoader;
import org.bandahealth.idempiere.graphql.model.ProductCostCalculation;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MStorageOnHand;
import org.dataloader.DataLoader;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MProductResolver extends X_M_ProductResolver {
	public CompletableFuture<Boolean> HasBeenPurchased(MProduct_BH entity, DataFetchingEnvironment environment) {
		DataLoader<Integer, Boolean> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MProductDataLoader.DATALOADER_M_ProductHasBeenPurchased);
		return dataLoader.load(entity.getM_Product_ID());
	}

	public CompletableFuture<Timestamp> LastPurchaseDate(MProduct_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<ProductCostCalculation>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(ProductCostCalculationDataLoader.DATALOADER_ProductCostCalculation_BY_Product_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_Product_ID())).thenApply(this::getMostRecentCost)
				.thenApply(ProductCostCalculation::getPurchaseDate);
	}

	public CompletableFuture<BigDecimal> LastPurchasePrice(MProduct_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<ProductCostCalculation>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(ProductCostCalculationDataLoader.DATALOADER_ProductCostCalculation_BY_Product_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_Product_ID())).thenApply(this::getMostRecentCost)
				.thenApply(ProductCostCalculation::getPurchasePrice);
	}

	public CompletableFuture<List<MStorageOnHand>> M_StorageOnHandList(MProduct_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MStorageOnHand>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MStorageOnHandDataLoader.DATALOADER_M_StorageOnHand_By_Product_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_Product_ID()));
	}

	public CompletableFuture<BigDecimal> TotalQuantity(MProduct_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MStorageOnHand>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MStorageOnHandDataLoader.DATALOADER_M_StorageOnHand_By_Product_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_Product_ID())).thenApply(storageOnHandList -> {
			if (storageOnHandList == null) {
				return BigDecimal.ZERO;
			}
			return storageOnHandList.stream().map(MStorageOnHand::getQtyOnHand).reduce(BigDecimal.ZERO, BigDecimal::add);
		});
	}

	private ProductCostCalculation getMostRecentCost(List<ProductCostCalculation> productCostCalculations) {
		return productCostCalculations.stream().filter(
						productCostCalculation -> productCostCalculation.getPurchaseDate() != null &&
								productCostCalculation.getPurchasePrice() != null)
				.max(Comparator.comparing(ProductCostCalculation::getPurchaseDate)).orElse(new ProductCostCalculation());
	}
}

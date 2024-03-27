package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.utils.MProductUtil;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MProductDataLoader extends X_M_ProductDataLoader {
	public static String DATALOADER_M_ProductHasBeenPurchased = "M_ProductHasBeenPurchasedDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_ProductHasBeenPurchased,
				DataLoader.newMappedDataLoader(getIfProductsHaveBeenPurchased(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<Integer, Boolean> getIfProductsHaveBeenPurchased() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			List<Integer> productIdsWithNoPurchaserOrders =
					MProductUtil.getProductIdsWithNoFinishedPurchaseOrders(batchLoaderEnvironment.getContext());
			return keys.stream().collect(
					Collectors.toMap(productId -> productId, productId -> !productIdsWithNoPurchaserOrders.contains(productId)));
		});
	}
}

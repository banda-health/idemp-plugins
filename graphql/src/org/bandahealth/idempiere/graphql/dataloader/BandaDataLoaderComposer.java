package org.bandahealth.idempiere.graphql.dataloader;

import org.bandahealth.idempiere.graphql.dataloader.impl.MRefListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHVisitDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MOrderDataLoader;
import org.dataloader.DataLoaderRegistry;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * This class is responsible for containing all data loaders that need to be registered for each query. It holds a list
 * of available data loaders and, when a new query comes in, it registers them for that query.
 */
public class BandaDataLoaderComposer {
	/**
	 * This list of data loaders available for each query.
	 */
	private final List<DataLoaderRegisterer> dataLoaders;

	/**
	 * The dataloaders are initialized in the constructor so that they are injected anew each request, which helps
	 * in hot-swapping in development without having to restart iDempiere
	 */
	public BandaDataLoaderComposer() {
		dataLoaders = Arrays.asList(
				new MRefListDataLoader(),
				new MBHVisitDataLoader(),
				new MOrderDataLoader()
		);
	}

	/**
	 * This method adds the data loaders when a new request comes in. Note, this is not a static method so hot-swaps
	 * will work if code changes are made to the data loaders.
	 *
	 * @param registry         The registry object that can register each data loader
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 */
	public void addDataLoaders(DataLoaderRegistry registry, Properties idempiereContext) {
		dataLoaders.forEach(dataLoader -> dataLoader.register(registry, idempiereContext));
	}
}

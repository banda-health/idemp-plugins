package org.bandahealth.idempiere.graphql.cache;

import org.compiere.util.CCache;

import java.util.HashMap;
import java.util.Map;

/**
 * This factory helps construct caches for the specified classes. Typically, these classes will be iDempiere entities
 * so GraphQL doesn't have to go to the DB to fetch data.
 */
public class CacheFactory {
	private final int DEFAULT_CACHE_TIMEOUT_IN_MINUTES = 5;
	private final int DEFAULT_CACHE_MAX_SIZE = 200;
	private final Map<String, BandaCache<Object, Object>> cacheMap = new HashMap<>();

	public BandaCache<Object, Object> getCache(String name) {
		BandaCache<Object, Object> classCache = cacheMap.get(name);
		if (classCache == null) {
			classCache = createCache(name);
			cacheMap.put(name, classCache);
		}
		return classCache;
	}

	/**
	 * Specify different types of caches for different types of objects (i.e. to persist objects different ways)
	 *
	 * @param name A string to represent what this cache is for
	 * @return A cache ready to use for the specified object
	 */
	private BandaCache<Object, Object> createCache(String name) {
		// Create a default cache
		CCache<Object, Object> cacheToUse =
				new CCache<>(name, 100, DEFAULT_CACHE_TIMEOUT_IN_MINUTES, false, DEFAULT_CACHE_MAX_SIZE);

		// TODO: Figure out how to set different cache stuff
//		if (clazz.getName().equalsIgnoreCase(MRefList.class.getName())) {
//			cacheToUse =
//					new CCache<>(name, name, 100, Integer.MAX_VALUE, false, DEFAULT_CACHE_MAX_SIZE);
//		}
		return new BandaCache<>(cacheToUse);
	}
}

package org.bandahealth.idempiere.graphql.cache;

import org.compiere.util.CCache;
import org.dataloader.CacheMap;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This is a wrapper for the iDempiere cache that implements the GraphQL Java interface. This allows us to cache
 * whatever we'd like
 *
 * @param <U> The key type of the cache.
 * @param <V> The value type of entities stored in the cache.
 */
public class BandaCache<U, V> implements CacheMap<U, V> {
	private final CCache<U, V> cache;

	public BandaCache(CCache<U, V> cache) {
		this.cache = cache;
	}

	public CCache<U, V> getCache() {
		return cache;
	}

	@Override
	public boolean containsKey(U key) {
		return cache.containsKey(key);
	}

	@Override
	public V get(U key) {
		return cache.get(key);
	}

	@Override
	public CacheMap<U, V> set(U key, V value) {
		cache.put(key, value);
		return this;
	}

	@Override
	public CacheMap<U, V> delete(U key) {
		cache.remove(key);
		return this;
	}

	@Override
	public CacheMap<U, V> clear() {
		cache.reset();
		return this;
	}
}

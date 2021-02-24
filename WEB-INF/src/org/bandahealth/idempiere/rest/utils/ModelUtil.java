package org.bandahealth.idempiere.rest.utils;

import org.bandahealth.idempiere.rest.function.VoidFunction;

import java.util.List;

/**
 * A utility class to work with iDempiere models
 */
public class ModelUtil {
	/**
	 * A simplified method to set a property on an entity if it's present on another entity, typically an input model
	 *
	 * @param propertyValue  The property value to set, if it's not null
	 * @param propertySetter The setter method on the entity, if the property is present
	 * @param <T>            The type of the property
	 */
	public static <T> void setPropertyIfPresent(T propertyValue, VoidFunction<T> propertySetter) {
		if (propertyValue == null) {
			return;
		}
		if (propertyValue instanceof String) {
			if (!StringUtil.isNullOrEmpty(propertyValue.toString())) {
				propertySetter.apply(propertyValue);
			}
		} else if (propertyValue instanceof List<?>) {
			if (!((List<?>) propertyValue).isEmpty()) {
				propertySetter.apply(propertyValue);
			}
		} else {
			propertySetter.apply(propertyValue);
		}
	}
}

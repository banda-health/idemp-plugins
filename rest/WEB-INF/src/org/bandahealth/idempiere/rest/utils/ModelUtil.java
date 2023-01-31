package org.bandahealth.idempiere.rest.utils;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.rest.exceptions.DocumentProcessException;
import org.bandahealth.idempiere.rest.function.VoidFunction;
import org.compiere.process.DocAction;

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

	/**
	 * Since processing a document can either fail or throw an error, capture both paths in a single method. An error
	 * will be thrown if the processing is unsuccessful.
	 *
	 * @param document      The document to process
	 * @param processAction Which action to take on the document
	 * @throws Exception An error with the failed process message as the body
	 */
	public static void processDocumentOrError(DocAction document, String processAction) throws Exception {
		try {
			if (!document.processIt(processAction)) {
				document.saveEx();
				throw new AdempiereException(document.getProcessMsg());
			}
		} catch (AdempiereException exception) {
			document.save();
			throw new DocumentProcessException(exception.getLocalizedMessage());
		}
	}
}

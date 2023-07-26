package org.bandahealth.idempiere.rest.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Mark either a class or method as being accessible to an administrator only
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AdministratorOnly {
}

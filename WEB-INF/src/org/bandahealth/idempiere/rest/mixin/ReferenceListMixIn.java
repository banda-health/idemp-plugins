package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"ad_Reference"})
public abstract class ReferenceListMixIn implements POMixIn {
}

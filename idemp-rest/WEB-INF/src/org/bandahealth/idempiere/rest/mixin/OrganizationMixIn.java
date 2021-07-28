package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"info", "linkedC_BPartner_ID", "ad_ReplicationStrategy"})
public abstract class OrganizationMixIn implements POMixIn {
}

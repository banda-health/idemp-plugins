package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"c_BPartner", "c_ChargeType", "c_TaxCategory"})
public abstract class ChargeMixIn implements POMixIn {
}

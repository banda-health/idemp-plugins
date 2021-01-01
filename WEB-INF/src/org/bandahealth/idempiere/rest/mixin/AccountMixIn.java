package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"c_BankAccount", "c_Currency", "c_Element"})
public abstract class AccountMixIn implements POMixIn {
}

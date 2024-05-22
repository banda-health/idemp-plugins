package org.bandahealth.idempiere.graphql.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"C_DocType_ID"})
public abstract class MPaymentMixin {
}

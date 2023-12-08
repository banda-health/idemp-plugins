package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"c_DocType_ID"})
public class M_C_PaymentInput extends X_C_PaymentInput {
}

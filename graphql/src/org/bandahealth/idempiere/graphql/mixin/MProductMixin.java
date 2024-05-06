package org.bandahealth.idempiere.graphql.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"Resource"})
public abstract class MProductMixin {
}

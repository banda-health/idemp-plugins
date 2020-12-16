package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"mattributeSet", "lot", "m_AttributeSet", "m_Lot"})
public abstract class AttributeSetInstanceMixIn extends POMixIn {
}

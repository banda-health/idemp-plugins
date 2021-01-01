package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"m_Warehouse_ID", "m_AttributeSetInstance", "m_Locator", "m_Product"})
public abstract class StorageOnHandMixIn implements POMixIn {
}

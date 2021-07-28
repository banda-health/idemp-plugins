package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.model.MStorageOnHand;
import org.compiere.util.Env;

import java.util.Properties;

@JsonIgnoreProperties(value = {"m_Warehouse_ID", "m_AttributeSetInstance", "m_Locator", "m_Product"})
public abstract class StorageOnHandMixIn extends MStorageOnHand implements POMixIn {
	/**
	 * The JsonCreator must match a superclass constructor to be used instead
	 *
	 * @param ctx     Unused
	 * @param id      Pulled from JSON
	 * @param trxName Unused
	 */
	@JsonCreator
	public StorageOnHandMixIn(@JsonProperty("nonExistentCtx") Properties ctx, @JsonProperty("id") int id,
			@JsonProperty("nonExistentTrxName") String trxName) {
		super(Env.getCtx(), id, null);
	}
}

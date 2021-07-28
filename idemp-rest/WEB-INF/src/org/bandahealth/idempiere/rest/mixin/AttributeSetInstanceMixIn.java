package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.model.MAttributeSetInstance;
import org.compiere.util.Env;

import java.util.Properties;

@JsonIgnoreProperties(value = {"mattributeSet", "lot", "m_AttributeSet", "m_Lot"})
public abstract class AttributeSetInstanceMixIn extends MAttributeSetInstance implements POMixIn {
	/**
	 * The JsonCreator must match a superclass constructor to be used instead
	 *
	 * @param ctx     Unused
	 * @param id      Pulled from JSON
	 * @param trxName Unused
	 */
	@JsonCreator
	public AttributeSetInstanceMixIn(@JsonProperty("nonExistentCtx") Properties ctx, @JsonProperty("id") int id,
			@JsonProperty("nonExistentTrxName") String trxName) {
		super(Env.getCtx(), id, null);
	}
}

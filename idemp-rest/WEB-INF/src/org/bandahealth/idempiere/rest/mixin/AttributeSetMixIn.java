package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.model.MAttributeSet;
import org.compiere.util.Env;

import java.util.Properties;

@JsonIgnoreProperties(value = {"mattributes", "lotCharStart", "lotCharEnd", "serNoCharStart", "serNoCharEnd",
		"mandatory", "mandatoryAlways", "mandatoryShipping", "excludeLot", "excludeSerNo", "m_LotCtl", "m_SerNoCtl"})
public abstract class AttributeSetMixIn extends MAttributeSet implements POMixIn {
	/**
	 * The JsonCreator must match a superclass constructor to be used instead
	 *
	 * @param ctx     Unused
	 * @param id      Pulled from JSON
	 * @param trxName Unused
	 */
	@JsonCreator
	public AttributeSetMixIn(@JsonProperty("nonExistentCtx") Properties ctx, @JsonProperty("id") int id,
			@JsonProperty("nonExistentTrxName") String trxName) {
		super(Env.getCtx(), id, null);
	}
}

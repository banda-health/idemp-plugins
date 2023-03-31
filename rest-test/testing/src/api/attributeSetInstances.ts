import { AttributeSetInstance } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class AttributeSetInstanceApi extends BaseApi<AttributeSetInstance> {
	entityName = 'attribute-set-instances';
}

export const attributeSetInstanceApi = new AttributeSetInstanceApi();

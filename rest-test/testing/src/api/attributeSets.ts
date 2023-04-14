import { AttributeSet } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class AttributeSetApi extends BaseApi<AttributeSet> {
	entityName = 'attribute-sets';
}

export const attributeSetApi = new AttributeSetApi();

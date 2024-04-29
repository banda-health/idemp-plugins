import { Concept } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class ConceptApi extends BaseApi<Concept> {
	entityName = 'concepts';
}

export const conceptApi = new ConceptApi();

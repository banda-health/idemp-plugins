import { ClientConcept } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class ClientConceptApi extends BaseApi<ClientConcept> {
	entityName = 'client-concepts';
}

export const clientConceptApi = new ClientConceptApi();

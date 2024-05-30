import { ClientConceptExtra } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class ClientConceptExtraApi extends BaseApi<ClientConceptExtra> {
	entityName = 'client-concept-extras';
}

export const clientConceptExtraApi = new ClientConceptExtraApi();

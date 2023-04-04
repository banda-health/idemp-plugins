import { StorageOnHand } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class StorageOnHandApi extends BaseApi<StorageOnHand> {
	entityName = 'storage-on-hand';
}

export const storageOnHandApi = new StorageOnHandApi();

package nl.mkoopman.micro.services.rest.camel.repository;

import nl.mkoopman.micro.services.rest.camel.model.Model;
import nl.mkoopman.micro.services.rest.camel.query.QueryContext;
import nl.mkoopman.micro.services.rest.camel.store.StoreContext;

public interface Repository<T extends Model> {
	T getModel(final QueryContext context, Class<T> modelClass);

	void storeModel(final StoreContext context);
}

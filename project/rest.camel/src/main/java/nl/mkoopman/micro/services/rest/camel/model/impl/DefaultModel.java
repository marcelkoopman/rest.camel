package nl.mkoopman.micro.services.rest.camel.model.impl;

import java.util.Map;

import nl.mkoopman.micro.services.rest.camel.model.Model;

import org.apache.commons.lang.StringUtils;

public class DefaultModel implements Model {

	private final Map<String, Object> attributes, meta, context;
	private final String key, name;

	private DefaultModel(final Builder builder) {
		this.attributes = builder.attributes;
		this.meta = builder.meta;
		this.context = builder.context;
		this.key = builder.key;
		this.name = builder.name;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public Map<String, Object> getMeta() {
		return meta;
	}

	public Map<String, Object> getContext() {
		return context;
	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public static Builder builder() {
		return new DefaultModel.Builder();
	}

	public static class Builder {

		private Map<String, Object> attributes, meta, context;
		private String key, name;

		/**
		 * Unique key for this Model, usually the storage key
		 *
		 * @param key
		 * @return
		 */
		public Builder key(final String key) {
			this.key = key;
			return this;
		}

		/**
		 * Logical name for this Model, to identify
		 *
		 * @param name
		 * @return
		 */
		public Builder name(final String name) {
			this.name = name;
			return this;
		}

		/**
		 * Attributes of the Model, that make up the total domain model
		 *
		 * @param attributes
		 * @return
		 */
		public Builder attibutes(final Map<String, Object> attributes) {
			this.attributes = attributes;
			return this;
		}

		/**
		 * Meta information for this Model, for instance creation dates, origin,
		 * etc
		 *
		 * @param meta
		 * @return
		 */
		public Builder meta(final Map<String, Object> meta) {
			this.meta = meta;
			return this;
		}

		/**
		 * Context for the Model, can be anything really.
		 *
		 * @param context
		 * @return
		 */
		public Builder context(final Map<String, Object> context) {
			this.context = context;
			return this;
		}

		public DefaultModel build() throws Exception {
			assertConstruction();
			return new DefaultModel(this);
		}

		private void assertConstruction() throws Exception {
			if (StringUtils.isEmpty(key)) {
				throw new Exception("Cannot build without a valid key");
			}
		}
	}
}

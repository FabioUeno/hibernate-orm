/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.boot.spi;

import org.hibernate.Incubating;
import org.hibernate.boot.model.TypeDefinitionRegistry;
import org.hibernate.boot.model.naming.ObjectNameNormalizer;
import org.hibernate.internal.util.config.ConfigurationHelper;

/**
 * Describes the context in which the process of building {@link org.hibernate.boot.Metadata}
 * from {@link org.hibernate.boot.MetadataSources} occurs.
 * <p>
 * {@link MetadataBuildingContext}s are hierarchical: global, persistence unit, document, mapping.
 *
 * @author Steve Ebersole
 *
 * @since 5.0
 */
public interface MetadataBuildingContext {
	BootstrapContext getBootstrapContext();

	/**
	 * Access to the options specified by the {@link org.hibernate.boot.MetadataBuilder}
	 *
	 * @return The options
	 */
	MetadataBuildingOptions getBuildingOptions();

	/**
	 * Access to mapping defaults in effect for this context
	 *
	 * @return The mapping defaults.
	 */
	MappingDefaults getMappingDefaults();

	/**
	 * Access to the collector of metadata as we build it.
	 *
	 * @return The metadata collector.
	 */
	InFlightMetadataCollector getMetadataCollector();

	/**
	 * Not sure how I feel about this exposed here
	 *
	 * @return The ObjectNameNormalizer
	 */
	ObjectNameNormalizer getObjectNameNormalizer();

	@Incubating
	default int getPreferredSqlTypeCodeForBoolean() {
		return ConfigurationHelper.getPreferredSqlTypeCodeForBoolean( getBootstrapContext().getServiceRegistry() );
	}

	@Incubating
	default int getPreferredSqlTypeCodeForDuration() {
		return ConfigurationHelper.getPreferredSqlTypeCodeForDuration( getBootstrapContext().getServiceRegistry() );
	}

	@Incubating
	default int getPreferredSqlTypeCodeForUuid() {
		return ConfigurationHelper.getPreferredSqlTypeCodeForUuid( getBootstrapContext().getServiceRegistry() );
	}

	@Incubating
	default int getPreferredSqlTypeCodeForInstant() {
		return ConfigurationHelper.getPreferredSqlTypeCodeForInstant( getBootstrapContext().getServiceRegistry() );
	}

	@Incubating
	default int getPreferredSqlTypeCodeForArray() {
		return ConfigurationHelper.getPreferredSqlTypeCodeForArray( getBootstrapContext().getServiceRegistry() );
	}

	TypeDefinitionRegistry getTypeDefinitionRegistry();

	/**
	 * The name of the contributor whose mappings we are currently processing
	 */
	String getCurrentContributorName();
}

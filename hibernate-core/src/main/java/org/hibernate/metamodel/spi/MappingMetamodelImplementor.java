/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.metamodel.spi;

import java.util.Collection;
import java.util.Set;

import org.hibernate.EntityNameResolver;
import org.hibernate.metamodel.MappingMetamodel;

/**
 * @author Steve Ebersole
 */
public interface MappingMetamodelImplementor extends MappingMetamodel {

	/**
	 * Retrieves a set of all the collection roles in which the given entity is a participant, as either an
	 * index or an element.
	 *
	 * @param entityName The entity name for which to get the collection roles.
	 *
	 * @return set of all the collection roles in which the given entityName participates.
	 */
	Set<String> getCollectionRolesByEntityParticipant(String entityName);

	/**
	 * Access to the EntityNameResolver instance that Hibernate is configured to
	 * use for determining the entity descriptor from an instance of an entity
	 */
	Collection<EntityNameResolver> getEntityNameResolvers();



}

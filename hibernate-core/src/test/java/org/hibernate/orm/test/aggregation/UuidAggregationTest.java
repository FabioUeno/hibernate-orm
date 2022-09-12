package org.hibernate.orm.test.aggregation;

import java.util.UUID;

import org.hibernate.testing.TestForIssue;
import org.hibernate.testing.orm.junit.DomainModel;
import org.hibernate.testing.orm.junit.SessionFactory;
import org.hibernate.testing.orm.junit.SessionFactoryScope;

import org.junit.jupiter.api.Test;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@DomainModel(annotatedClasses = { UuidAggregationTest.UuidIdentifiedEntity.class })
@SessionFactory
public class UuidAggregationTest {

	@Entity(name = "UuidIdentifiedEntity")
	public static class UuidIdentifiedEntity {

		@Id
		private UUID id;

		public UuidIdentifiedEntity() {
			super();
		}

		public UUID getId() {
			return id;
		}

		public void setId(final UUID id) {
			this.id = id;
		}
	}

	@Test
	@TestForIssue(jiraKey = "HHH-15495")
	public void testMaxUuid(SessionFactoryScope scope) {
		scope.inTransaction(
				s -> {
					s.createSelectionQuery( "select max(id) from UuidIdentifiedEntity", UUID.class ).getSingleResult();
				}
		);
	}
}

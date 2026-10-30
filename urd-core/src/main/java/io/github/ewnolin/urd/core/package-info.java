/**
 * Urd's domain model: accounts, fiscal years, vouchers and the rules that govern them.
 *
 * <p>This module is plain Java. It must not depend on Spring, JDBC or any other framework, so the
 * bookkeeping rules can be tested quickly and in isolation. {@code ArchitectureTest} enforces this.
 */
package io.github.ewnolin.urd.core;

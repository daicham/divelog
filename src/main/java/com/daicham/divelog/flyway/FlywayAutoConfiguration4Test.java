package com.daicham.divelog.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Auto-configuration for Flyway database migrations for test.
 *
 * Set clean task before migration.
 * @author daicham
 */
@Configuration
@ConditionalOnProperty(prefix = "flyway", name = "enabled", matchIfMissing = true)
@AutoConfigureBefore(FlywayAutoConfiguration.class)
@Profile("test")
public class FlywayAutoConfiguration4Test {
    @Bean
    public FlywayMigrationStrategy migrationStrategy() {
        return new FlywayMigrationStrategy() {
            @Override
            public void migrate(Flyway flyway) {
                flyway.clean();
                flyway.migrate();
            }
        };
    }
}

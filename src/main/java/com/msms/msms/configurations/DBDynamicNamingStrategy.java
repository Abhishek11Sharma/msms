package com.msms.msms.configurations;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class DBDynamicNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    private static final String TBL_PREFIX = "test_";

    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment context) {
        if (logicalName == null) {
            return null;
        }

        // Convert camelCase to snake_case and add prefix
        String tableName = TBL_PREFIX + camelToSnake(logicalName.getText());
        return Identifier.toIdentifier(tableName);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier logicalName, JdbcEnvironment context) {
        if (logicalName == null) {
            return null;
        }

        // Convert camelCase to snake_case
        String columnName = camelToSnake(logicalName.getText());
        return Identifier.toIdentifier(columnName);
    }

    private String camelToSnake(String input) {
        return input.replaceAll("([a-z])([A-Z])", "$1_$2")
                .toLowerCase();
    }
}

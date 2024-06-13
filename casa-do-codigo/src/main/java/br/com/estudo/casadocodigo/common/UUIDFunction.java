package br.com.estudo.casadocodigo.common;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class UUIDFunction {
    private UUIDFunction() {
        throw new IllegalStateException("Utility class");
    }

    public static Function<String, Optional<UUID>> getUUID = id -> {
        try {
            return Optional.of(UUID.fromString(id));
        } catch (Exception e) {
            return Optional.empty();
        }
    };
}

package com.example.framework.config;

/**
 * Centralized, lightweight configuration access.
 * <p>
 * We intentionally keep this simple (System properties first, then env vars, then defaults)
 * so that CI and local runs can override settings without code changes.
 */
public final class Config {
    private Config() {
        // utility class
    }

    public static String baseUrl() {
        return get("baseUrl", "https://the-internet.herokuapp.com");
    }

    public static boolean headless() {
        // Defaulting to headless makes the suite more CI-friendly; override locally with -Dheadless=false
        return Boolean.parseBoolean(get("headless", "true"));
    }

    public static int defaultTimeoutSeconds() {
        return Integer.parseInt(get("timeoutSeconds", "10"));
    }

    private static String get(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value != null && !value.isBlank()) {
            return value;
        }

        value = System.getenv(key);
        if (value != null && !value.isBlank()) {
            return value;
        }

        return defaultValue;
    }
}

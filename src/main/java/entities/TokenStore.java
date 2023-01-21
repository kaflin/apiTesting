package entities;

import java.util.prefs.Preferences;

public class TokenStore {
    private static final String TOKEN_KEY = "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";

    public static void storeToken(String token) {
        Preferences prefs = Preferences.userNodeForPackage(TokenStore.class);
        prefs.put(TOKEN_KEY, token);
    }

    public static String getToken() {
        Preferences prefs = Preferences.userNodeForPackage(TokenStore.class);
        return prefs.get(TOKEN_KEY, null);
    }
}


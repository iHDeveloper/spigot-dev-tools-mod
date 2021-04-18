package me.ihdeveloper.spigot.devtools.mod;

import me.ihdeveloper.spigot.devtools.mod.tool.Watcher;

public class Container {

    private AuthState authState = AuthState.NOT_REQUESTED;
    private Watcher watcher = new Watcher();

    public void setAuthState(AuthState authState) {
        this.authState = authState;
    }

    public AuthState getAuthState() {
        return authState;
    }

    public Watcher getWatcher() {
        return watcher;
    }

}

package me.ihdeveloper.spigot.devtools.mod;

public class Container {

    private AuthState authState = AuthState.NOT_REQUESTED;

    public void setAuthState(AuthState authState) {
        this.authState = authState;
    }

    public AuthState getAuthState() {
        return authState;
    }

}

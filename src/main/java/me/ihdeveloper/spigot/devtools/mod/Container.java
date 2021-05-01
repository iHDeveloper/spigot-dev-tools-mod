package me.ihdeveloper.spigot.devtools.mod;

import me.ihdeveloper.spigot.devtools.mod.tool.Watcher;

public class Container {

    private final Watcher watcher = new Watcher();
    private final Profiler profiler = new Profiler();
    private AuthState authState = AuthState.NOT_REQUESTED;
    private double[] recentTPS = new double[3];

    public void setAuthState(AuthState authState) {
        this.authState = authState;
    }

    public AuthState getAuthState() {
        return authState;
    }

    public Watcher getWatcher() {
        return watcher;
    }

    public Profiler getProfiler() {
        return profiler;
    }

    public void setTPS(int index, double tps) {
        recentTPS[index] = tps;
    }

    public double getTPS(int index) {
        return recentTPS[index];
    }

}

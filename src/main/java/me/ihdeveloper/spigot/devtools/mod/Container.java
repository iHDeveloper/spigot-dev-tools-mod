package me.ihdeveloper.spigot.devtools.mod;

import me.ihdeveloper.spigot.devtools.mod.tool.Profiler;
import me.ihdeveloper.spigot.devtools.mod.tool.ServerWall;
import me.ihdeveloper.spigot.devtools.mod.tool.Watcher;

public class Container {

    private final Watcher watcher = new Watcher();
    private final Profiler profiler = new Profiler();
    private final ServerWall serverWall = new ServerWall();
    private final double[] recentTPS = new double[3];
    private AuthState authState = AuthState.NOT_REQUESTED;

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

    public ServerWall getServerWall() {
        return serverWall;
    }

    public void setTPS(int index, double tps) {
        recentTPS[index] = tps;
    }

    public double getTPS(int index) {
        return recentTPS[index];
    }

}

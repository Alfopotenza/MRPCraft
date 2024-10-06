package RPCraft.rPCraft;

import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.index.qual.NonNegative;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Logger;

public final class RPCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger log = Logger.getLogger("Minecraft");
        log.info("Hello World!");

        this.getCommand("CreateKingdom").setExecutor(new CreateKingdom());
        this.getCommand("setCapitalName").setExecutor(new setCapitalName());
        this.getCommand("addCity").setExecutor(new addCity());

        File data = new File(getDataFolder(), "data");
        data.getParentFile().mkdirs();
        File kingdomData = new File(getDataFolder(), "data/kingdomData");
        kingdomData.getParentFile().mkdirs();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

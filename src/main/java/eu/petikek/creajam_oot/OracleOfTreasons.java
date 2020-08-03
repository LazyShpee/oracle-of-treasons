package eu.petikek.creajam_oot;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eu.petikek.creajam_oot.registry.*;

public class OracleOfTreasons implements ModInitializer {
    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "creajam_oot";
    public static final String MOD_NAME = "Oracle of Treasons";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");

        Entities.init();
        Items.init();
    }

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}
package dev.denismasterherobrine.angelring.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.nio.file.Path;

@Mod.EventBusSubscriber
public class Configuration {

    public static final String CATEGORY_GENERAL = "general";
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec.BooleanValue BalancedRecipe;

    static {
        COMMON_BUILDER.comment("General Angel Ring Configuration Options").push(CATEGORY_GENERAL);
        // TODO: Add a config option to switch recipes?
        // BalancedRecipe = COMMON_BUILDER.comment("Define if Angel Ring must have a harder recipe or have a default recipe as it was in versions before 2.0.0.").define("BalancedRecipe", true);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {

        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }
}
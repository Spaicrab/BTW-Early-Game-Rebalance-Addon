package btw.community.spaicrab.earlygamerebalance;

import btw.AddonHandler;
import btw.BTWAddon;

import java.util.Map;

public class EarlyGameRebalance extends BTWAddon {
    @SuppressWarnings("unused")
    private static EarlyGameRebalance instance;

    public static boolean altUseToPickUpOvenItems = false;
    public static boolean altUseToPickUpTorches = false;
    public static boolean lessExpensiveIronIngots = true;

    public EarlyGameRebalance() {
        super();
    }

    @Override
    public void preInitialize() {
        earlygamerebalance_registerConfigProperties();
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }

    @Override
    public void postInitialize() {
        if (lessExpensiveIronIngots) {
            EarlyGameRebalanceRecipes.earlygamerebalance_lessExpensiveIronIngotsRecipes();
        }
    }

    private void earlygamerebalance_registerConfigProperties() {
        this.registerProperty("altUseToPickUpOvenItems", "False",
            "Set to True to enable having to hold Alt-Use to pick up items inside Fireplaces and Ovens"
        );
        this.registerProperty("altUseToPickUpTorches", "False",
                "Set to True to enable having to hold Alt-Use to pick up placed Torches"
        );
        this.registerProperty("lessExpensiveIronIngots", "True",
            "Set to False to disable the new recipes for 6 nuggets per Iron Ingot"
        );
    }

    @Override
    public void handleConfigProperties(Map<String, String> propertyValues) {
        altUseToPickUpOvenItems = Boolean.parseBoolean(propertyValues.get("altUseToPickUpOvenItems"));
        altUseToPickUpTorches = Boolean.parseBoolean(propertyValues.get("altUseToPickUpTorches"));
        lessExpensiveIronIngots = Boolean.parseBoolean(propertyValues.get("lessExpensiveIronIngots"));
    }

}
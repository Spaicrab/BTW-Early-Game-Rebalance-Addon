package btw.community.spaicrab.earlygamerebalance;

import btw.AddonHandler;
import btw.BTWAddon;

import java.util.Map;

public class EarlyGameRebalance extends BTWAddon {
    private static EarlyGameRebalance instance;

    private Map<String, String> propertyValues;
    public static boolean altUseToPickUpOvenItems = false;
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
        
        if (lessExpensiveIronIngots) {
            EarlyGameRebalanceRecipes.earlygamerebalance_lessExpensiveIronIngotsRecipes();
        }
    }

    private void earlygamerebalance_registerConfigProperties() {
        this.registerProperty("altUseToPickUpOvenItems", "False",
            "Set to True to enable having to hold Alt-Use to pick up items inside Fireplaces and Ovens"
        );
        this.registerProperty("lessExpensiveIronIngots", "True",
            "Set to False to disable the new recipes for 6 nuggets per Iron Ingot"
        );
    }

    @Override
    public void handleConfigProperties(Map<String, String> propertyValues) {
        this.propertyValues = propertyValues;

        altUseToPickUpOvenItems = Boolean.parseBoolean(this.propertyValues.get("altUseToPickUpOvenItems"));
        lessExpensiveIronIngots = Boolean.parseBoolean(this.propertyValues.get("lessExpensiveIronIngots"));
    }

}
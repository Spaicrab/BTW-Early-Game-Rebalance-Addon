package btw.community.spaicrab.earlygamerebalance;

import btw.AddonHandler;
import btw.BTWAddon;

public class EarlyGameRebalance extends BTWAddon {
    private static EarlyGameRebalance instance;

    public EarlyGameRebalance() {
        super();
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }
}
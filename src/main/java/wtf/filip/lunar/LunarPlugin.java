package wtf.filip.lunar;

import me.coley.recaf.control.Controller;
import me.coley.recaf.plugin.api.EntryLoaderProviderPlugin;
import me.coley.recaf.plugin.api.StartupPlugin;
import me.coley.recaf.workspace.EntryLoader;
import org.plugface.core.annotations.Plugin;

/**
 * @author Filip
 */
@Plugin(name = "LunarPlugin")
public class LunarPlugin implements EntryLoaderProviderPlugin, StartupPlugin {

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String getDescription() {
        return "Renames Lunar client files";
    }

    @Override
    public EntryLoader create() {
        return new EntryLoader() {
            @Override
            public boolean isFileValidClassName(String name) {
                if (name.contains(".lclass")) return true;
                else return super.isFileValidClassName(name);
            }
        };
    }


    /**
     * Called before the controller is started, but after the controller is configured.
     *
     * @param controller The controller context Recaf was started with.
     */
    @Override
    public void onStart(Controller controller) {
        // TODO Figure out LoadWorkspace
    }
}
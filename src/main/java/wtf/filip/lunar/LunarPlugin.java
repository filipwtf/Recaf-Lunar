package wtf.filip.lunar;

import me.coley.recaf.plugin.api.EntryLoaderProviderPlugin;
import me.coley.recaf.plugin.api.ResourceInterceptorPlugin;
import me.coley.recaf.workspace.EntryLoader;
import org.plugface.core.annotations.Plugin;

/**
 * @author Filip
 */
@Plugin(name = "LunarPlugin")
public class LunarPlugin implements EntryLoaderProviderPlugin, ResourceInterceptorPlugin {

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
     * @param name resource name
     * @param ext  resource extension
     * @return the actual extension of the resource
     */
    @Override
    public String onLoad(String name, String ext) {
        if (name.contains("lunar") || name.contains("prod") || name.equalsIgnoreCase("natives_win")) return "jar";
        else return ext;
    }
}

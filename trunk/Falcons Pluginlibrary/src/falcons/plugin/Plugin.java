package falcons.plugin;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @author Julius
 *
 *	An annotation that contains the ID and versionID of the plugin.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Plugin {
String pluginID() default "No pluginID";
String versionID() default "No versionID";
}

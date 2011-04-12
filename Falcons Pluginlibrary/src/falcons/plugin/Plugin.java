package falcons.plugin;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Plugin {
String pluginID() default "No pluginID";
String versionID() default "No versionID";
}

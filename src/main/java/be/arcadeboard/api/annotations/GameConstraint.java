package be.arcadeboard.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Module Constraint
 * <p>
 * Created by maxim on 15-Jan-17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface GameConstraint {
    /**
     * Constraint type of the module
     */
    ContraintType type();

    /**
     * Constraint value
     *
     * @return constraint value
     */
    String value();

    /**
     * Module constraint type
     */
    enum ContraintType {
        /**
         * Make sure this plugin is loaded
         */
        PLUGIN(1, "Plugin"),
        /**
         * Make sure the plugin CONTAINS this version string
         */
        PLUGIN_VERSION(3, "Plugin version"),
        /**
         * Make sure the plugin version is lower
         */
        PLUGIN_VERSION_IS_LOWER(4, "Plugin version lower"),
        /**
         * Make sure the plugin version is higher
         */
        PLUGIN_VERSION_IS_HIGHER(5, "Plugin version higher"),
        /**
         * Make sure the plugin has this class for main (written like in plugin.yml)
         */
        PLUGIN_MAIN(6, "Plugin main"),
        /**
         * Make sure the plugin has the following author
         */
        PLUGIN_AUTHOR(7, "Plugin author"),
        /**
         * ARCADEBOARD version higher
         */
        ARCADEBOARD_VERSION(2, "ARCADEBOARD version");

        private int priority = 0;
        private String name = "";

        ContraintType(int priority, String name) {
            setPriority(priority);
            setName(name);
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

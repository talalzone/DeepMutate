package io.zenmake.deepmutate.lang.types.conf;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Talal Ahmed on 13/02/2023
 */
public class InputConf extends BaseConf<String, Object> {

    public static final String KEY_TYPE = "type";

    public static final String KEY_BUILD_SYSTEM = "build";

    public static final String KEY_CONTENT = "content";

    public static final String TYPE_CONSOLE = "console";
    public static final String TYPE_CODE = "code";
    public static final String TYPE_FILE = "file";
    public static final String TYPE_DIR = "dir";

    public static final String BUILD_GRADLE = "gradle";
    public static final String BUILD_MAVEN = "maven";


    public String getType() {
        return getWithKeys(null, KEY_TYPE);
    }

    public String getBuildSystem() {
        return getWithKeys(null, KEY_BUILD_SYSTEM);
    }


    public Map<String, String> getContent() {
        return getWithKeys(new HashMap<>(), KEY_CONTENT);
    }

    public Set<Object> getContentIds() {
        return getWithKeys(new HashMap<>(), KEY_CONTENT).keySet();
    }

    public void addType(String type) {
        put(KEY_TYPE, type);
    }

    public void addContent(Map<String, String> map) {
        put(KEY_CONTENT, map);
    }

    public void addBuild(String build) {
        put(KEY_BUILD_SYSTEM, build);
    }

}

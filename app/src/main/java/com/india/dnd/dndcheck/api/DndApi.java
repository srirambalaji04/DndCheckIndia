package com.india.dnd.dndcheck.api;

import com.india.dnd.dndcheck.BuildConfig;

/**
 * Created by sriram on 30/10/16.
 */

public class DndApi {

    public static final String URL_BASE = "https://dndcheck.p.mashape.com/index.php";

    public static final String URL_GET_DND = URL_BASE + "?mobilenos=%s";

    public static final String API_KEY = BuildConfig.API_KEY;
}

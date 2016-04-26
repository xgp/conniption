/**
 * Copyright 2013 Cameron Cook
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.celexus.conniption.model.util;

import java.io.Serializable;

public enum MarketClockField implements Serializable {
    /**
     * Current date and time in the format of YYYY-MM-DD HH:MM:SS.
     */
    DATE("date", "//"),
    /**
     * Current market status as “pre”, “open”, “after”, or “closed”.
     */
    CURRENT("current", "//"),
    /**
     * Next market status as “pre”, “open”, “after”, or “closed”.
     */
    NEXT("next", "//"),
    /**
     * Timestamp of next market session change.
     */
    CHANGE_AT("change_at", "//"),
    /**
     * Message of market status as either open or closed.
     */
    MESSAGE("message", "//"),
    /**
     * Current timestamp in UNIX format.
     */
    UNIX_TIME("unixtime", "//"),
    ERROR("error", "//");

    private String abbrev;
    private String path;
    private static final String REALM = "//response";

    MarketClockField(String abbrev, String... path) {
        this.abbrev = abbrev;
        if (path.length >= 1) {
            this.path = path[0];
        }
    }

    @Override
    public String toString() {
        return abbrev;
    }

    public String getPath() {
        if (path != null) {
            return path + abbrev;
        }
        return path;
    }

    public static String getRealm() {
        return REALM;
    }

    public static MarketClockField getFieldFromAbbreviation(String a) {
        for (MarketClockField field : MarketClockField.values()) {
            if (field.toString().equals(a)) {
                return field;
            }
        }
        return null;
    }
}

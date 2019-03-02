package com.itacademy.akulov.robotfactory;

import java.util.HashMap;
import java.util.Map;

public class ScrapDump {

    private Map<RobotDetails, Integer> garbage = new HashMap<>();

    public void fillDetailMap(int count) {
        for (int i = 0; i < count; i++) {
            garbage.merge(RandomUtils.randomDetail(), 1, (oldValue, newValue) ->
                    oldValue + newValue);
        }
    }

    public boolean exludeDetailMap(RobotDetails detail) {
        boolean result = false;
        if (garbage.containsKey(detail) && garbage.get(detail) > 0) {
            garbage.merge(detail, 1, (oldValue, newValue) ->
                    oldValue - newValue);
            result = true;
        }
        return result;
    }

    public Map<RobotDetails, Integer> getGarbage() {
        return garbage;
    }
}

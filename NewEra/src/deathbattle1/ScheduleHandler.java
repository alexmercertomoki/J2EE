package deathbattle1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleHandler {

    public List<Map<String, List<ScheduleObject>>> getValidSchedule(Map<String, List<ScheduleObject>> rawMap) {
        List<Map<String, List<ScheduleObject>>> res = new ArrayList<>();
        Map<String, List<ScheduleObject>> map = new HashMap<>();
        List<String> areaList = new ArrayList<>();
        for (String areaId : rawMap.keySet()) {
            areaList.add(areaId);
        }
        dfsGetSchedule(res, map, rawMap, areaList, 0);
        return res;
    }

    private void dfsGetSchedule(List<Map<String, List<ScheduleObject>>> res, Map<String, List<ScheduleObject>> map, Map<String, List<ScheduleObject>> rawMap, List<String> areaList, int pos) {
        if (pos == areaList.size()) {
            res.add(new HashMap<>(map));
            return;
        }
        String areaId = areaList.get(pos);
        List<ScheduleObject> scheduleList = rawMap.get(areaId);
        List<List<ScheduleObject>> possibleList = getPossibleSchedule(scheduleList, map);
        for (List<ScheduleObject> possible : possibleList) {
            map.put(areaId, possible);
            dfsGetSchedule(res, map, rawMap, areaList, pos + 1);
            map.remove(areaId);
        }
    }

    private List<List<ScheduleObject>> getPossibleSchedule(
            List<ScheduleObject> scheduleList,
            Map<String, List<ScheduleObject>> scheduleMap) {
        List<List<ScheduleObject>> res = new ArrayList<>();
        List<ScheduleObject> partition = new ArrayList<>();
        Collections.sort(scheduleList);
        dfsPossibleSchedule(res, partition, scheduleList, 0, scheduleMap);
        return res;
    }

    private void dfsPossibleSchedule(List<List<ScheduleObject>> res,
            List<ScheduleObject> partition, List<ScheduleObject> scheduleList,
            int pos, Map<String, List<ScheduleObject>> scheduleMap) {
        if (pos == scheduleList.size()) {
            res.add(new ArrayList<>(partition));
            return;
        }
        for (int i = pos; i < scheduleList.size(); i++) {
            ScheduleObject cur = scheduleList.get(i);
            if (!validateSchedule(cur, partition, scheduleMap)) {
                continue;
            }
            partition.add(cur);
            dfsPossibleSchedule(res, partition, scheduleList, i + 1, scheduleMap);
            partition.remove(partition.size() - 1);
        }
        if (partition.size() > 0) {
            res.add(new ArrayList<>(partition));
        }
    }

    private boolean validateSchedule(ScheduleObject cur,
            List<ScheduleObject> partition,
            Map<String, List<ScheduleObject>> scheduleMap) {
        if (partition.size() > 0
                && partition.get(partition.size() - 1).getEndTime() >= cur
                        .getStartTime()) {
            return false;
        }
        for (List<ScheduleObject> list : scheduleMap.values()) {
            for (ScheduleObject schedule : list) {
                if (cur.overlap(schedule)) {
                    return !cur.getContentId().equals(schedule.getContentId());
                }
            }
        }
        return true;
    }
}

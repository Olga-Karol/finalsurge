package utils;

import constants.TextParserConstants;

import java.util.HashMap;


public class WorkoutDetailsParser {

   public static HashMap<Integer, String> map = new HashMap<Integer, String>();

    public static HashMap<Integer, String> getWorkoutDescData(String workoutDesc){
        String descAndPlanned = defaultParser(workoutDesc, TextParserConstants.WORKOUT_DESC_TITLE, 1);
        String desc = defaultParser(descAndPlanned, TextParserConstants.WORKOUT_PLANNED_LABEL, 0);
        String plannedDistDuration = defaultParser(descAndPlanned, TextParserConstants.WORKOUT_PLANNED_LABEL, 1);
        String plannedDuration = defaultParser(plannedDistDuration, TextParserConstants.SEPARATOR, 1);
        String plannedDistWithUnits = defaultParser(plannedDistDuration, TextParserConstants.SEPARATOR, 0);
        String plannedDistance = defaultParser(plannedDistWithUnits, TextParserConstants.SPACE, 0);
        String plannedDistanceUnit = defaultParser(plannedDistWithUnits, TextParserConstants.SPACE, 1);
        map.put(0,desc);
        map.put(1, plannedDistance);
        map.put(2, plannedDistanceUnit);
        map.put(3, plannedDuration);
        return map;
    }

    public static HashMap<Integer, String> getWorkoutStatistics (String workoutStats){
        String distDurationPace = defaultParser(workoutStats, TextParserConstants.WORKOUT_STATISTICS, 1);
        String distWithUnits = defaultParser(distDurationPace, TextParserConstants.SEPARATOR, 0);
        String distance = defaultParser(distWithUnits, TextParserConstants.SPACE, 0);
        String distanceUnits = defaultParser(distWithUnits, " ", 1);
        String durationPace = defaultParser(distDurationPace, TextParserConstants.SEPARATOR, 1);
        String duration = defaultParser(durationPace, TextParserConstants.SPACE, 0);
        String paceWithUnits = defaultParser(durationPace, TextParserConstants.SPACE, 1);
        String pace = defaultParser(paceWithUnits, TextParserConstants.SPACE, 0);
        String paceUnits = defaultParser(durationPace, TextParserConstants.SPACE, 2);
        map.put(4,distance);
        map.put(5, distanceUnits);
        map.put(6, duration);
        map.put(7,pace);
        map.put(8, paceUnits);
        return map;
    }

    public static HashMap<Integer, String> getPaceResults (String raceResults){
        String commonPart = defaultParser(raceResults, TextParserConstants.OVERALL_PLACE, 1);
        String overallPlace = defaultParser(commonPart, TextParserConstants.AGE_GROUP_PLACE, 0);
        String average = defaultParser(commonPart, TextParserConstants.AGE_GROUP_PLACE, 1);
        map.put(9, overallPlace);
        map.put(10, average);
        return map;
    }

    public static HashMap<Integer, String> getFeelings (String feelings){
        String commonPart = defaultParser(feelings, TextParserConstants.HOW_I_FELT, 1);
        String feel = defaultParser(commonPart, TextParserConstants.PERCEIVED_EFFORT, 0);
        String effort = defaultParser(commonPart, TextParserConstants.PERCEIVED_EFFORT, 1);
        map.put(11, feel);
        map.put(12, effort);
        return map;
    }

    public static HashMap<Integer, String> getHeartRate (String heartRate){
        String commonPart = defaultParser(heartRate, TextParserConstants.MIN_HR, 1);
        String minRhWithUnits = defaultParser(commonPart, TextParserConstants.AVG_HR, 0);
        String minRh = defaultParser(minRhWithUnits, TextParserConstants.SPACE, 0);
        String commonPart2 = defaultParser(commonPart, TextParserConstants.AVG_HR, 1);
        String avgRhWithUnits = defaultParser(commonPart2, TextParserConstants.MAX_HR, 0);
        String avgRh = defaultParser(avgRhWithUnits, TextParserConstants.SPACE, 0);
        String commonPart3 = defaultParser(commonPart2, TextParserConstants.MAX_HR, 1);
        String maxRhWithUnits = defaultParser(commonPart3, TextParserConstants.CALORIES_BURNED, 0);
        String maxRh = defaultParser(maxRhWithUnits, TextParserConstants.SPACE, 0);
        String calloriesWithUnits = defaultParser(commonPart3, TextParserConstants.CALORIES_BURNED, 1);
        String callories = defaultParser(calloriesWithUnits, TextParserConstants.SPACE, 0);
        map.put(13, minRh);
        map.put(14, avgRh);
        map.put(15, maxRh);
        map.put(16, callories);
        return map;
    }

    public static String defaultParser(String text, String separator, int index){
        return text.split(separator)[index].trim();
    }
}
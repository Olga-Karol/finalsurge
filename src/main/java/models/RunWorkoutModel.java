package models;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static constants.DateTimeParser.OUTPUT_DATE_FORMAT;
import static constants.WorkoutLeftMenuLabels.WORKOUT_SUBTYPE;
import static constants.WorkoutLeftMenuLabels.WORKOUT_TYPE;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RunWorkoutModel{

    @Builder.Default
    public String Date = convertCurrentTime();
    @Builder.Default
    public String TimeOfDay = "05:45 AM";
    @Builder.Default
    public String WorkoutName = "My test workout";
    @Builder.Default
    public  String WorkoutDescription = "It was difficult";
    @Builder.Default
    public double PlannedDistance = 300.00;
    @Builder.Default
    public String  PlannedDistanceUnit = "mi";
    @Builder.Default
    public String PlannedDuration = "1:20:23";
    @Builder.Default
    public double Distance = 303.00;
    @Builder.Default
    public String  DistanceUnit = "mi";
    @Builder.Default
    public String Duration = "1:30:23";
    @Builder.Default
    public String Pace = "0:25";
    @Builder.Default
    public String  PaceUnit = "min/mi";
    @Builder.Default
    public int OverallPlace = 20;
    @Builder.Default
    public int AgeGroupPlace = 2;
    @Builder.Default
    public String PerceivedEffort = "2 (Light)";
    @Builder.Default
    public int MinHR = 15;
    @Builder.Default
    public int AvgHR = 17;
    @Builder.Default
    public int MaxHR = 20;
    @Builder.Default
    public int CaloriesBurned = 2500;
    @Builder.Default
    public String RadioButtonOption = "Great";
    @Builder.Default
    public String WorkoutType = String.format("%s - %s", WORKOUT_TYPE, WORKOUT_SUBTYPE);


    static String convertCurrentTime(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(OUTPUT_DATE_FORMAT);
        return date.format(formatter);
    }

}

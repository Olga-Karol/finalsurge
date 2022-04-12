package models;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static constants.DateTimeParser.OUTPUT_DATE_FORMAT;
import static constants.WorkoutLeftMenuLabels.WORKOUT_SUBTYPE;
import static constants.WorkoutLeftMenuLabels.WORKOUT_TYPE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RunWorkoutModel{

    @Builder.Default
    public String Date = convertCurrentTime();
    @Builder.Default
    public String TimeOfDay = "5:45 AM";
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

    @Override
    public String toString() {
        return "RunWorkoutModel{" +
                "TimeOfDay='" + TimeOfDay + '\'' +
                ", WorkoutName='" + WorkoutName + '\'' +
                ", WorkoutDescription='" + WorkoutDescription + '\'' +
                ", PlannedDistance=" + PlannedDistance +
                ", PlannedDistanceUnit='" + PlannedDistanceUnit + '\'' +
                ", PlannedDuration='" + PlannedDuration + '\'' +
                ", Distance=" + Distance +
                ", DistanceUnit='" + DistanceUnit + '\'' +
                ", Duration='" + Duration + '\'' +
                ", Pace='" + Pace + '\'' +
                ", PaceUnit='" + PaceUnit + '\'' +
                ", OverallPlace=" + OverallPlace +
                ", AgeGroupPlace=" + AgeGroupPlace +
                ", PerceivedEffort='" + PerceivedEffort + '\'' +
                ", MinHR=" + MinHR +
                ", AvgHR=" + AvgHR +
                ", MaxHR=" + MaxHR +
                ", CaloriesBurned=" + CaloriesBurned +
                ", RadioButtonOption='" + RadioButtonOption + '\'' +
                ", WorkoutType='" + WorkoutType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RunWorkoutModel that = (RunWorkoutModel) o;
        return Double.compare(that.PlannedDistance, PlannedDistance) == 0 && Double.compare(that.Distance, Distance) == 0 && OverallPlace == that.OverallPlace && AgeGroupPlace == that.AgeGroupPlace && MinHR == that.MinHR && AvgHR == that.AvgHR && MaxHR == that.MaxHR && CaloriesBurned == that.CaloriesBurned && Objects.equals(TimeOfDay, that.TimeOfDay) && Objects.equals(WorkoutName, that.WorkoutName) && Objects.equals(WorkoutDescription, that.WorkoutDescription) && Objects.equals(PlannedDistanceUnit, that.PlannedDistanceUnit) && Objects.equals(PlannedDuration, that.PlannedDuration) && Objects.equals(DistanceUnit, that.DistanceUnit) && Objects.equals(Duration, that.Duration) && Objects.equals(Pace, that.Pace) && Objects.equals(PaceUnit, that.PaceUnit) && Objects.equals(PerceivedEffort, that.PerceivedEffort) && Objects.equals(RadioButtonOption, that.RadioButtonOption) && Objects.equals(WorkoutType, that.WorkoutType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TimeOfDay, WorkoutName, WorkoutDescription, PlannedDistance, PlannedDistanceUnit, PlannedDuration, Distance, DistanceUnit, Duration, Pace, PaceUnit, OverallPlace, AgeGroupPlace, PerceivedEffort, MinHR, AvgHR, MaxHR, CaloriesBurned, RadioButtonOption, WorkoutType);
    }
}

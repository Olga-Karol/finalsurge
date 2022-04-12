package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static models.RunWorkoutModel.convertCurrentTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VitalsModel {

    @Builder.Default
    public String Date = convertCurrentTime();
    @Builder.Default
    public int Steps = 4500;
    @Builder.Default
    public int CaloriesConsumed = 2500;
    @Builder.Default
    public int Weight = 55;
    @Builder.Default
    public String WeightKg = "kg";
    @Builder.Default
    public int BodyFat = 23;
    @Builder.Default
    public int Water = 62;
    @Builder.Default
    public int MuscleMass = 2;
    @Builder.Default
    public String MuscleKg = "kg";
    @Builder.Default
    public int RestingHR = 15;
    @Builder.Default
    public int HRVariability = 17;
    @Builder.Default
    public int SleepHours = 9;
    @Builder.Default
    public int TotalTimeAwake = 1;
    @Builder.Default
    public String SleepAmount = "Enough";
    @Builder.Default
    public String SleepQuality = "Good";
    @Builder.Default
    public String StressAmount = "High";
    @Builder.Default
    public String HealthNotes = "Nothing critical";
}
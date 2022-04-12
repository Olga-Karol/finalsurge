package steps;

import components.forms.formelements.buttons.SaveButton;
import components.forms.CreateForm;
import components.forms.EditForm;
import components.forms.formelements.vitalselements.DropdownVital;
import components.forms.formelements.vitalselements.InputFilter;
import components.forms.formelements.vitalselements.InputVitals;
import components.forms.formelements.vitalselements.TextAreaVitals;
import components.links.IconLink;
import components.links.Link;
import io.qameta.allure.Step;
import modals.DeleteConfirmation;
import models.VitalsModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.VitalsPage;

import java.util.List;

import static constants.CreationFormTitles.DAILY_VITALS_ADD_FORM_TITLE;
import static constants.DeleteLink.DELETE_LINK_TITLE;
import static constants.EditFormTitles.EDIT_VITALS_TITLE;
import static constants.LabelsVitalsForm.*;
import static constants.LabelsVitalsForm.DATE;
import static constants.SaveButtonLabels.*;
import static constants.TextParserConstants.*;
import static constants.VitalsViewElements.*;
import static org.testng.Assert.assertEquals;
import static utils.WorkoutDetailsParser.*;


public class DailyVitalsSteps extends BaseStep {

    private VitalsPage vitalsPage;
    private SaveButton saveButton;
    private CreateForm createForm;
    private EditForm editfForm;


    public DailyVitalsSteps(WebDriver driver) {
        super(driver);
        vitalsPage = new VitalsPage(driver);
        createForm = new CreateForm(driver, DAILY_VITALS_ADD_FORM_TITLE);
        saveButton = new SaveButton(driver, ADD_VITALS_BUTTON_LABEL);
        editfForm = new EditForm(driver, EDIT_VITALS_TITLE);
    }


    @Step("Add a new vitals and validate it")
    public DailyVitalsSteps addVital(VitalsModel vitalsModel) {
        vitalsPage.openPage();
        assertPageIsLoaded(vitalsPage);
        vitalsPage.openAddVitalsForm();
        assertComponentIsDisplayed(createForm);
        fillVitalsForm(vitalsModel);
        saveButton.save();
        assertComponentIsDisplayed(createForm);
        return this;
    }

    @Step("Find recently added vitals")
    public DailyVitalsSteps findAddedVitals(VitalsModel vitalsModel) {
        String filterValue = vitalsModel.getDate();
        new Link(driver, CUSTOM_VIEW_LINK_LABEL).click();
        assertComponentIsDisplayed(new InputFilter(driver, START_DATE_LABEL));
        new InputFilter(driver, START_DATE_LABEL).insert(filterValue);
        new InputFilter(driver, END_DATE_LABEL).insert(filterValue);
        vitalsPage.filerVitalsByDate();
        vitalsPage.waitPageLoaded();
        List<WebElement> testVitals = getVitalsElements();
        for (WebElement element : testVitals) {
            assertEquals(
                    testVitals.get(0).getText(),
                    filterValue,
                    String.format("Vitals creation date should be %s", filterValue)
            );
        }
        return this;
    }

    @Step
    public DailyVitalsSteps updateAddedVitals(VitalsModel updatedVitalsModel){
        List<WebElement> testVitals = getVitalsElements();
        openEditForm(testVitals);
        assertComponentIsDisplayed(editfForm);
        fillVitalsForm(updatedVitalsModel);
        saveButton = new SaveButton(driver, EDIT_VITALS_BUTTON_LABEL);
        saveButton.save();
        assertPageIsLoaded(vitalsPage);
        return this;
    }


    @Step("Make sure filled vitals data matches to data on the Details page")
    public void validateAddedVitals(VitalsModel expectedModel) {
        VitalsModel actualModel = getActualVitals();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("Actual is not valid: %s", actualModel)
        );
    }

    @Step("Remove test vitals")
    public void removeVitals() {
        List<WebElement> testVitals = getVitalsElements();
        openEditForm(testVitals);
        assertComponentIsDisplayed(editfForm);
        IconLink delete = new IconLink(driver, DELETE_LINK_TITLE);
        assertComponentIsDisplayed(delete);
        delete.click();
        DeleteConfirmation confirmation = new DeleteConfirmation(driver);
        assertComponentIsDisplayed(confirmation);
        confirmation.deleteConfirmation();
        assertPageIsLoaded(vitalsPage);
    }

    private void fillVitalsForm(VitalsModel vitalsModel) {
        new InputVitals(driver, DATE).insert(vitalsModel.getDate());
        new InputVitals(driver, STEPS).insert(String.valueOf(vitalsModel.getSteps()));
        new InputVitals(driver, CALORIES_CONCUMED).insert(String.valueOf(vitalsModel.getCaloriesConsumed()));
        new InputVitals(driver, WEIGHT).insert(String.valueOf(vitalsModel.getWeight()));
        new DropdownVital(driver, WEIGHT).selectDropdownOption(vitalsModel.getWeightKg());
        new InputVitals(driver, BODY_FAT).insert(String.valueOf(vitalsModel.getBodyFat()));
        new InputVitals(driver, WATER).insert(String.valueOf(vitalsModel.getWater()));
        new InputVitals(driver, MUSCLE_MASS).insert(String.valueOf(vitalsModel.getMuscleMass()));
        new DropdownVital(driver, MUSCLE_MASS).selectDropdownOption(vitalsModel.getMuscleKg());
        new InputVitals(driver, RESTING_HR).insert(String.valueOf(vitalsModel.getRestingHR()));
        new InputVitals(driver, HR_VARIABILITY).insert(String.valueOf(vitalsModel.getHRVariability()));
        new InputVitals(driver, SLEEP_HOURS).insert(String.valueOf(vitalsModel.getSleepHours()));
        new InputVitals(driver, TOTAL_TIME_AWAKE).insert(String.valueOf(vitalsModel.getTotalTimeAwake()));
        new DropdownVital(driver, SLEEP_AMOUNT).selectDropdownOption(vitalsModel.getSleepAmount());
        new DropdownVital(driver, SLEEP_QUALITY).selectDropdownOption(vitalsModel.getSleepQuality());
        new DropdownVital(driver, STRESS_AMOUNT).selectDropdownOption(vitalsModel.getStressAmount());
        new TextAreaVitals(driver, HEALTH_NOTES).insert(vitalsModel.getHealthNotes());

    }

    private VitalsModel getActualVitals() {
        VitalsModel actualModel = new VitalsModel();
        List<WebElement> testVitals = getVitalsElements();
        for (WebElement element : testVitals) {
            actualModel.setDate(testVitals.get(0).getText());
            actualModel.setSteps(Integer.parseInt(testVitals.get(1).getText()));
            actualModel.setWeight(Integer.parseInt(defaultParser(testVitals.get(2).getText(),SPACE,0)));
            actualModel.setWeightKg(defaultParser(testVitals.get(2).getText(), SPACE, 1));
            actualModel.setBodyFat(Integer.parseInt(defaultParser(testVitals.get(3).getText(), PERCENT, 0)));
            actualModel.setRestingHR(Integer.parseInt(defaultParser(testVitals.get(4).getText(), BPM, 0)));
            actualModel.setHRVariability(Integer.parseInt(testVitals.get(5).getText()));
            actualModel.setCaloriesConsumed(Integer.parseInt(defaultParser(testVitals.get(6).getText(), KCAL, 0)));
            actualModel.setWater(Integer.parseInt(defaultParser(testVitals.get(7).getText(), PERCENT, 0)));
            actualModel.setMuscleMass(Integer.parseInt(defaultParser(testVitals.get(8).getText(), SPACE,0)));
            actualModel.setMuscleKg(defaultParser(testVitals.get(8).getText(), SPACE, 1));
            actualModel.setSleepHours(Integer.parseInt(defaultParser(testVitals.get(9).getText(), HOURS, 0)));
            actualModel.setTotalTimeAwake(Integer.parseInt(defaultParser(testVitals.get(10).getText(), HOURS, 0)));
            actualModel.setSleepAmount(testVitals.get(11).getText());
            actualModel.setSleepQuality(testVitals.get(12).getText());
            actualModel.setStressAmount(testVitals.get(13).getText());
            actualModel.setHealthNotes(testVitals.get(15).getText());
        }
        return actualModel;
    }

    private List<WebElement> getVitalsElements() {
        List<WebElement> list = driver.findElements(By.xpath(VITAL_ROW_IN_TABLE));
        return list;
    }

    private void openEditForm(List<WebElement> testVitals){
        testVitals.get(0).click();
    }
}

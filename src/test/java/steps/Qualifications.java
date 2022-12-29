package steps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import org.junit.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;
import org.testng.asserts.SoftAssert;
import utils.ConfigReader;
public class Qualifications extends CommonMethods {
    @Then("user clicks on an employee id")
    public void user_clicks_on_an_employee_id() {
        click(employeeInfo.testEmployeeId);
    }
    @When("user clicks on Qualifications field")
    public void user_clicks_on_qualifications_field() {
        click(employeeInfo.Qualifications);
    }
    @When("user clicks on Add button for Work Experience")
    public void user_clicks_on_add_button_for_work_experience() {
        click(employeeInfo.addWorkExperience);
    }
    @Then("checks Company textbox is displayed and user can enter values there")
    public void checks_company_textbox_is_displayed_and_user_can_enter_values_there() {
        assertMethod(employeeInfo.addWorkExperienceCompany);
        sendText(employeeInfo.addWorkExperienceCompany, "Apple");
    }
    @Then("checks Job Title textbox is displayed and user can enter values there")
    public void checks_job_title_textbox_is_displayed_and_user_can_enter_values_there() {
        assertMethod (employeeInfo.addWorkExperienceJobTitle);
        sendText(employeeInfo.addWorkExperienceJobTitle, "CEO");
    }
    @Then("checks FROM calendar is displayed and user can pick values from there")
    public void checks_from_calendar_is_displayed_and_user_can_pick_values_from_there() {
    calendar( employeeInfo.addWorkExperienceCalendarFrom,employeeInfo.addWorkExperienceCalendarFrom,employeeInfo.MonthFrom,
            "Jan",employeeInfo.YearFrom,"2015",employeeInfo.tableFrom,"8");
        }
    @When("user clicks on Add button for Skills")
    public void user_clicks_on_add_button_for_skills() {
        click(employeeInfo.addSkillsBtn);
    }
    @Then("checks Skills dropdown is displayed and user can select of skills there")
    public void checks_skills_dropdown_is_displayed_and_user_can_select_of_skills_there() {
        assertMethod(employeeInfo.dropDownSkills);
        click(employeeInfo.dropDownSkills);
        selectDropdown(employeeInfo.dropDownSkills,ConfigReader.getPropertyValue("skills"));
    }
    @Then("checks Years of Experience textbox is displayed and user can enter values there")
    public void checks_years_of_experience_textbox_is_displayed_and_user_can_enter_values_there() {
        assertMethod(employeeInfo.yearsOfExperienceBtn);
        sendText(employeeInfo.yearsOfExperienceBtn, ConfigReader.getPropertyValue("yearsOfexperience"));
    }
    @Then("checks Comments textbox is displayed and user can enter values there")
    public void checks_comments_textbox_is_displayed_and_user_can_enter_values_there() {
        assertMethod(employeeInfo.skillsComments);
        sendText(employeeInfo.skillsComments, "If I need to spend a lot of time to solve any issue on my task I do it anyway");
    }
    @Then("user clicks on save changes")
    public void user_clicks_on_save_changes() {
        click(employeeInfo.saveSkillsBtn);
    }
    @Then("user varifies saved values")
    public void user_varifies_saved_values() {
        varification(employeeInfo.VarificationTableSkill,ConfigReader.getPropertyValue("skills"),
        employeeInfo.VarificationTableYears, ConfigReader.getPropertyValue("yearsOfexperience"));
        System.out.println("values are varified successfully!");
    }
}

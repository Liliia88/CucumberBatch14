package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class QualificationsPage extends CommonMethods {
    @FindBy(linkText="6274039")
    public WebElement testEmployeeId;

    @FindBy(linkText="Qualifications")
    public WebElement Qualifications;

    @FindBy(id="addWorkExperience")
    public WebElement addWorkExperience;

    @FindBy(id="experience_employer")
    public WebElement addWorkExperienceCompany;

    @FindBy(id="experience_jobtitle")
    public WebElement addWorkExperienceJobTitle;

    @FindBy(id="experience_from_date")
    public WebElement addWorkExperienceCalendarFrom;

    @FindBy(id="experience_to_date")
    public WebElement addWorkExperienceCalendarTo;

    @FindBy(id="experience_comments")
    public WebElement addWorkExperienceComments;

    @FindBy(id="btnWorkExpSave")
    public WebElement addWorkExperienceSaveBtn;

    @FindBy(linkText="Memberships")
    public WebElement Memberships;

    @FindBy(id="btnAddMembershipDetail")
    public WebElement addMemberBtn;

    @FindBy(id="membership_membership")
    public WebElement addMemberDropDown;

    @FindBy(id="membership_subscriptionPaidBy")
    public WebElement subscriptionPaidBy;

    @FindBy(id="membership_subscriptionAmount")
    public WebElement subscriptionAmount;

    @FindBy(id="membership_currency")
    public WebElement subscriptionAmountCurrency;

    @FindBy(id="membership_subscriptionCommenceDate")
    public WebElement subscriptionCommenceDate;

    @FindBy(id="membership_subscriptionRenewalDate")
    public WebElement subscriptionRenewalDate;

    @FindBy(id="btnSaveMembership")
    public WebElement saveNewMembershipBtn;

    @FindBy(id="addLicense")
    public WebElement addLicense;

    @FindBy(id="license_code")
    public WebElement licenseType;

    @FindBy(id="license_license_no")
    public WebElement licenseNumber;

    @FindBy(id="license_date")
    public WebElement addLicenseIssuedDate;

    @FindBy(id="license_renewal_date")
    public WebElement addLicenseExpiryDate;

    @FindBy(id="btnLicenseSave")
    public WebElement addLicenseSaveBtn;

    @FindBy(xpath="//input[@id='experience_from_date']")
    public WebElement caledarFrom;

    @FindBy (xpath ="//select[@class='ui-datepicker-month']")
    public WebElement MonthFrom;
    @FindBy(xpath="//select[@class='ui-datepicker-year']")
    public WebElement YearFrom;
    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
    public List<WebElement> tableFrom;
    @FindBy(xpath="//input[@id='addSkill']")
    public WebElement addSkillsBtn;
    @FindBy(id="skill_code")
    public WebElement dropDownSkills;
    @FindBy(id="skill_years_of_exp")
    public WebElement yearsOfExperienceBtn;
    @FindBy(id="btnSkillSave")
    public WebElement saveSkillsBtn;
    @FindBy(id="skill_comments")
    public WebElement skillsComments;

    @FindBy(xpath="//table[@class='table tablesorter'][2]/tbody/tr/td[1]")
    public List<WebElement> VarificationTableSkill;

    @FindBy(xpath="//table[@class='table tablesorter'][2]/tbody/tr/td[2]")
    public List<WebElement> VarificationTableYears;





    public QualificationsPage(){
        PageFactory.initElements(driver,this);
    }
}

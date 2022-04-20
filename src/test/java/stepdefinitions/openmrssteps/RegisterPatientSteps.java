package stepdefinitions.openmrssteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.openmrspages.OpenMRSLoginPage;
import pages.openmrspages.OpenMRSMainPage;
import pages.openmrspages.OpenMRSRegisterNewPatient;
import utils.DriverHelper;

import java.util.Map;

public class RegisterPatientSteps {


    WebDriver driver = DriverHelper.getDriver();
    OpenMRSLoginPage openMRSLoginPage = new OpenMRSLoginPage(driver);
    OpenMRSMainPage openMRSMainPage = new OpenMRSMainPage(driver);
    OpenMRSRegisterNewPatient openMRSRegisterNewPatient = new OpenMRSRegisterNewPatient(driver);


    @Given("the user logs in to OpenMRS with following credentials")
    public void the_user_logs_in_to_open_mrs_with_following_credentials(DataTable dataTable) {
       // you should know that: dataTable will come as a parameter when you provide data table in
        //the feature file. And delete the first part of the Datatable and import it


        //username=admin
        //password="Admin123"
//        String name =   usernamePasswordMap.get("username");
//        String password =   usernamePasswordMap.get("password");
//        System.out.println(name + "       "  + password);

        Map<String, String> usernamePasswordMap = dataTable.asMap();  //it makes connection
        openMRSLoginPage.login(usernamePasswordMap.get("username"), usernamePasswordMap.get("password"));

    }






    @When("the user registers a new patient with following information:")
    public void the_user_registers_a_new_patient_with_following_information(DataTable dataTable) {
       Map<String,String>patientInfoMap= dataTable.asMap();

       openMRSMainPage.clickRegisterPatientButton();
       openMRSRegisterNewPatient.sendName(patientInfoMap.get("GivenName"), patientInfoMap.get("FamilyName"));
       openMRSRegisterNewPatient.sendGender(patientInfoMap.get("Gender"));
       openMRSRegisterNewPatient.sendBirthdate(patientInfoMap.get("Day"),patientInfoMap.get("Month"), patientInfoMap.get("Year"));
       openMRSRegisterNewPatient.sendAddress(patientInfoMap.get("Address"));
       openMRSRegisterNewPatient.sendPhoneNumber(patientInfoMap.get("PhoneNumber"));
       openMRSRegisterNewPatient.sendRelativeInfo(patientInfoMap.get("Relative"),patientInfoMap.get("RelativeName") );
       openMRSRegisterNewPatient.clickConfirmButton();


    }


    @Then("the user validates the patient name and familyName")
    public void the_user_validates_the_patient_name_and_family_name(DataTable dataTable) {

        Map<String,String>validateNames= dataTable.asMap();

        Assert.assertEquals(validateNames.get("GivenName"), openMRSRegisterNewPatient.getGivenName());

        Assert.assertEquals(validateNames.get("FamilyName"), openMRSRegisterNewPatient.getFamilyName());

    }









}

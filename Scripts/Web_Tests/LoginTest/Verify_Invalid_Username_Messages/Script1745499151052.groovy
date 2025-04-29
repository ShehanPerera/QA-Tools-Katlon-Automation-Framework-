import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.URL)

WebUI.sendKeys(findTestObject('Web_Objects/LoginPage/username_Txt'), GlobalVariable.ValidUsername)

for (def index : (0..1)) {
    String passwordInput = ''

    String errorMessage = ''

    if (index == 0) {
        passwordInput = ''

        errorMessage = 'Epic sadface: Password is required'
    }
    
    if (index == 1) {
        passwordInput = 'abc'

        errorMessage = 'Epic sadface: Username and password do not match any user in this service'
    }
    
    WebUI.sendKeys(findTestObject('Web_Objects/LoginPage/password_Txt'), passwordInput)

    WebUI.click(findTestObject('Web_Objects/LoginPage/login_Btn'))

    WebUI.waitForPageLoad(5)

    WebUI.verifyElementText(findTestObject('Web_Objects/LoginPage/loginError_Msg'), errorMessage)
}

WebUI.callTestCase(findTestCase('Web_Tests/UtillTestCases/CloseBrowser'), [:], FailureHandling.STOP_ON_FAILURE)


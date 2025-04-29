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

WebUI.callTestCase(findTestCase('Android_Tests/DashboardTest/Verify_AddToCart_Sanity'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Android_Tests/UtilTest/GotoCart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Android_Tests/CartTest/Verify_CartDetails'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Android_Tests/UtilTest/GotoCheckout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Android_Tests/UtilTest/FormFill'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Android_Tests/UtilTest/GotoOverview'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Android_Tests/CartTest/Verify_Cart_Summary'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Android_Tests/UtilTest/FinishCart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Android_Tests/CartTest/Verify_CheckoutComplete'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Android_Tests/UtilTest/GoBackHome'), [:], FailureHandling.STOP_ON_FAILURE)


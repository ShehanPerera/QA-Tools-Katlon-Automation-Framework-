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

WebUI.callTestCase(findTestCase('Web_Tests/DashbordTest/Verify_Dashbord_Load'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'dashbord.Keywords.cartButtonText'(findTestObject('Web_Objects/DashbordPage/addToCartSauceLabsFleeceJacket_Btn'), addToCart)

WebUI.click(findTestObject('Web_Objects/DashbordPage/addToCartSauceLabsFleeceJacket_Btn'))

CustomKeywords.'dashbord.Keywords.cartButtonText'(findTestObject('Web_Objects/DashbordPage/removeSauceLabsFleeceJacket_Btn'), removeCart)

WebUI.verifyElementText(findTestObject('Web_Objects/DashbordPage/shoppingCartCount_Icon'), '1')

WebUI.callTestCase(findTestCase('Web_Tests/UtillTestCases/Add_SauceLabsBackpack'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Web_Objects/DashbordPage/shoppingCartCount_Icon'), '2')

WebUI.click(findTestObject('Web_Objects/DashbordPage/removeSauceLabsBackpack_Btn'))

CustomKeywords.'dashbord.Keywords.cartButtonText'(findTestObject('Web_Objects/DashbordPage/addToCartSauceLabsBackpack_Btn'), addToCart)

WebUI.verifyElementText(findTestObject('Web_Objects/DashbordPage/shoppingCartCount_Icon'), '1')

WebUI.click(findTestObject('Web_Objects/DashbordPage/removeSauceLabsFleeceJacket_Btn'))

CustomKeywords.'dashbord.Keywords.cartButtonText'(findTestObject('Web_Objects/DashbordPage/addToCartSauceLabsFleeceJacket_Btn'), addToCart)


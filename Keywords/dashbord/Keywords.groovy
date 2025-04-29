package dashbord
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class Keywords {
	
@Keyword
def cartButtonText(TestObject button, String expectingText) {
	WebElement element = WebUiBuiltInKeywords.findWebElement(button)
	String actualText = element.text

	if (actualText != expectingText) {
		int minLength = Math.min(actualText.length(), expectingText.length())
		for (int i = 0; i < minLength; i++) {
			if (actualText.charAt(i) != expectingText.charAt(i)) {
				println("Mismatch at index ${i}: expected '${expectingText.charAt(i)}' but got '${actualText.charAt(i)}'")
				break
			}
		}
		if (actualText.length() != expectingText.length()) {
			println("Length mismatch: expected ${expectingText.length()} characters, but got ${actualText.length()}")
		}
		KeywordUtil.markFailed("Text does not match!")
	} else {
		KeywordUtil.markPassed("Text matches successfully.")
	}
}
    @Keyword
    def ItemNameList(TestObject itemClass) {
        List<WebElement> elements = WebUI.findWebElements(itemClass, 10)

        for (WebElement element : elements) {
            println("Item Name: " + element.getText())
        }

        // Optional: return a list of the text values if needed
        List<String> itemNames = elements.collect { it.getText() }
        return itemNames
    }
	@Keyword
	def verifyItemExists(TestObject itemClass, String testDataName, int column, int row) {
		// Get the expected item from test data
		def testData = TestDataFactory.findTestData(testDataName)
		String expectedItem = testData.getValue(column, row).trim()

		// Get all items from the web page
		List<WebElement> elements = WebUI.findWebElements(itemClass, 10)
		List<String> itemNames = elements.collect { it.getText().trim() }

		// Print for debug
		println("Expected from Excel: ${expectedItem}")
		println("Items from UI: ${itemNames}")

		// Verify if the expected item is in the list
		if (itemNames.contains(expectedItem)) {
			KeywordUtil.markPassed("Item '${expectedItem}' found in UI list.")
		} else {
			KeywordUtil.markFailed("Item '${expectedItem}' NOT found in UI list.")
		}
	}
	@Keyword
	def verifyAllExcelItemsExistInUI(TestObject itemLocator, String testDataName, int columnIndex) {
		// Load test data
		def testData = TestDataFactory.findTestData(testDataName)
		int totalRows = testData.getRowNumbers()

		// Get all UI elements
		List<WebElement> uiElements = WebUI.findWebElements(itemLocator, 10)
		List<String> uiTexts = uiElements.collect { it.getText().trim() }

		println("Items from UI: ${uiTexts}")

		// Loop through each Excel row and verify
		for (int i = 1; i <= totalRows; i++) {
			String expectedItem = testData.getValue(columnIndex, i).trim()
			if (uiTexts.contains(expectedItem)) {
				KeywordUtil.logInfo("Item '${expectedItem}' found in UI list.")
			} else {
				KeywordUtil.markFailed("Item '${expectedItem}' NOT found in UI list.")
			}
		}
	}
}
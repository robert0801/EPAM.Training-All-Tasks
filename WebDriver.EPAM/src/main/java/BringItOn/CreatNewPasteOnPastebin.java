package BringItOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatNewPasteOnPastebin extends AbstractClassForPastebin{
    private String pasteName = "how to gain dominance among developers";
    private String areaName = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String selectPaste = "10 Minutes";
    private String syntaxName = "Bash";


    @FindBy (xpath = "//textarea[@name='PostForm[text]']")
    WebElement areaForNewPaste;

    @FindBy (xpath = "//select[@name='PostForm[expiration]']/parent::div")
    WebElement pasteExpiration;

    @FindBy (xpath = "//li[text()='10 Minutes']")
    WebElement pasteExpiration10Minutes;

    @FindBy (xpath = "//select[@name='PostForm[format]']/parent::div")
    WebElement syntaxHighlighting;

    @FindBy (xpath = "//li[text()='Bash']")
    WebElement syntaxHighlightingBash;

    @FindBy (xpath = "//input[@name='PostForm[name]']")
    WebElement pasteNameForNewPaste;

    @FindBy(xpath = "//button[contains(text(), Create)]")
    WebElement createNewPasteBtn;

    public CreatNewPasteOnPastebin(WebDriver driver) {
        super(driver);
    }
    public CreatNewPasteOnPastebin enterCodeOnPastebin() {
        driver.get(webSite);
        areaForNewPaste.sendKeys(areaName);
        return this;
    }

    public CreatNewPasteOnPastebin syntaxHighlighting() {
        selectOptionInSelect(syntaxHighlighting, syntaxHighlightingBash);
        return this;
    }


    public CreatNewPasteOnPastebin checkThe10Minutes() {
        selectOptionInSelect(pasteExpiration, pasteExpiration10Minutes);
        return this;
    }

    public CreatNewPasteOnPastebin insertPasteNameAndCreatPaste() {
        pasteNameForNewPaste.sendKeys(pasteName);
        createNewPasteBtn.click();
        return this;
    }

    private void selectOptionInSelect(WebElement select, WebElement option){
        select = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(select));
        select.click();
        option = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(option));
        option.click();
    }

}
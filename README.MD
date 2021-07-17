# **Selenium Book**

`**Запуск браузера** с авто скачкой всего необходимого через WebDriverManager`
https://github.com/bonigarcia/webdrivermanager



_WebDriverManager.chromedriver().setup();
driver = new ChromeDriver(options);

# Initialize

// Maven: selenium-chrome-driver
import org.openqa.selenium.chrome.ChromeDriver;
WebDriver driver = new ChromeDriver();
// Maven: selenium-firefox-driver
import org.openqa.selenium.firefox.FirefoxDriver;
WebDriver driver = new FirefoxDriver();
// Maven: selenium-edge-driver
import org.openqa.selenium.firefox.EdgeDriver;
WebDriver driver = new EdgeDriver();
// Maven: selenium-ie-driver
import org.openqa.selenium.ie.InternetExplorerDriver;
WebDriver driver = new InternetExplorerDriver();
// Maven: selenium-safari-driver
import org.openqa.selenium.safari.SafariDriver;
WebDriver driver = new SafariDriver();

# Locators

driver.findElement(By.className("className"));
driver.findElement(By.cssSelector("css"));
driver.findElement(By.id("id"));
driver.findElement(By.linkText("text"));
driver.findElement(By.name("name"));
driver.findElement(By.partialLinkText("pText"));
driver.findElement(By.tagName("input"));
driver.findElement(By.xpath("//*[@id='editor']"));
// Find multiple elements
List<WebElement> anchors = driver.findElements(By.tagName("a"));
// Search for an element inside another
WebElement div = driver.findElement(By.tagName("div"))
.findElement(By.tagName("a"));

# Basic Elements Operations

WebElement element = driver.findElement(By.id("id"));
element.click();
element.sendKeys("someText");
element.clear();
element.submit();
String innerText = element.getText();
boolean isEnabled = element.isEnabled();
boolean isDisplayed = element.isDisplayed();
boolean isSelected = element.isSelected();
WebElement element = driver.findElement(By.id("id"));
Select select = new Select(element);
select.selectByIndex(1);
select.selectByVisibleText("Ford");
select.selectByValue("ford");
select.deselectAll();
select.deselectByIndex(1);
select.deselectByVisibleText("Ford");
select.deselectByValue("ford");
List<WebElement> allSelected = select.getAllSelectedOptions();
boolean isMultipleSelect = select.isMultiple();

# Advanced Elements Operations


// Drag and Drop
WebElement element = driver.FindElement(
By.xpath("//*[@id='project']/p[1]/div/div[2]"));
Actions move = new Actions(driver);
move.dragAndDropBy(element, 30, 0).build().perform();
// How to check if an element is visible
Assert.assertTrue(driver.findElement(
By.xpath("//*[@id='tve_editor']/div")).isDisplayed());
// Upload a file
WebElement element = driver.findElement(By.id("RadUpload1file0"));
String filePath = "D:WebDriver.Series.TestsWebDriver.xml";
element.sendKeys(filePath);
// Scroll focus to control
WebElement link =
driver.findElement(By.partialLinkText("Previous post"));
String js = String.format("window.scroll(0, %d);",
link.getLocation().getY());
((JavascriptExecutor)driver).executeScript(js);
link.click();
// Taking an element screenshot
WebElement element =
driver.findElement(By.xpath("//*[@id='tve_editor']/div"));
File screenshotFile =
((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
BufferedImage fullImg = ImageIO.read(screenshotFile);
Point point = element.getLocation();
int elementWidth = element.getSize().getWidth();
int elementHeight = element.getSize().getHeight();
BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight);
ImageIO.write(eleScreenshot, "png", screenshotFile);
String tempDir = getProperty("java.io.tmpdir");
File destFile = new File(Paths.get(tempDir, fileName + ".png").toString());
FileUtils.getFileUtils().copyFile(screenshotFile, destFile);
// Focus on a control
WebElement link =
driver.findElement(By.partialLinkText("Previous post"));
Actions action = new Actions(driver);
action.moveToElement(link).build().perform();
// Wait for visibility of an element
WebDriverWait wait = new WebDriverWait(driver, 30);
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
By.xpath("//*[@id='tve_editor']/div[2]/div[2]/div/div")));

# Basic Browser Operations

// Navigate to a page
driver.navigate().to("http://google.com");
// Get the title of the page
String title = driver.getTitle();
// Get the current URL
String url = driver.getCurrentUrl();
// Get the current page HTML source
String html = driver.getPageSource();

# Advanced Browser Operations

// Handle JavaScript pop-ups
Alert alert = driver.switchTo().alert();
alert.accept();
alert.dismiss();
// Switch between browser windows or tabs
Set<String> windowHandles = driver.getWindowHandles();
String firstTab = (String)windowHandles.toArray()[1];
String lastTab = (String)windowHandles.toArray()[2];
driver.switchTo().window(lastTab);
// Navigation history
driver.navigate().back();
driver.navigate().refresh();
driver.navigate().forward();
// Maximize window
driver.manage().window().maximize();
// Add a new cookie
Cookie newCookie = new Cookie("customName", "customValue");
driver.manage().addCookie(newCookie);
// Get all cookies
Set<Cookie> cookies = driver.manage().getCookies();
// Delete a cookie by name
driver.manage().deleteCookieNamed("CookieName");
// Delete all cookies
driver.manage().deleteAllCookies();
//Taking a full-screen screenshot
File srceenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String tempDir = getProperty("java.io.tmpdir");
File destFile = new File(Paths.get(tempDir, fileName + ".png").toString());
FileUtils.getFileUtils().copyFile(srceenshotFile, destFile);
// Wait until a page is fully loaded via JavaScript
WebDriverWait wait = new WebDriverWait(driver, 30);
wait.until(x -> {
((String)((JavascriptExecutor)driver).executeScript(
"return document.readyState")).equals("complete");
});
// Switch to frames
driver.switchTo().frame(1);
driver.switchTo().frame("frameName");
WebElement element = driver.findElement(By.id("id"));
driver.switchTo().frame(element);
// Switch to the default document
driver.switchTo().defaultContent();

# Advanced Browser Configurations


// Use a specific Firefox profile
ProfilesIni profile = new ProfilesIni();
FirefoxProfile firefoxProfile = profile.getProfile("ProfileName");
FirefoxOptions firefoxOptions = new FirefoxOptions();
firefoxOptions.setProfile(firefoxProfile);
driver = new FirefoxDriver(firefoxOptions);
// Set a HTTP proxy Firefox
ProfilesIni profile = new ProfilesIni();
FirefoxProfile firefoxProfile = new FirefoxProfile();
firefoxProfile.setPreference("network.proxy.type", 1);
firefoxProfile.setPreference("network.proxy.http", "myproxy.com");
firefoxProfile.setPreference("network.proxy.http_port", 3239);
FirefoxOptions firefoxOptions = new FirefoxOptions();
firefoxOptions.setProfile(firefoxProfile);
driver = new FirefoxDriver(firefoxOptions);
// Set a HTTP proxy Chrome
var proxy = new Proxy();
proxy.setProxyType(Proxy.ProxyType.MANUAL);
proxy.setAutodetect(false);
proxy.setSslProxy("127.0.0.1:3239");
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.setProxy(proxy);
driver = new ChromeDriver(chromeOptions);
// Accept all certificates Firefox
FirefoxProfile firefoxProfile = new FirefoxProfile();
firefoxProfile.setAcceptUntrustedCertificates(true);
firefoxProfile.setAssumeUntrustedCertificateIssuer(false);
FirefoxOptions firefoxOptions = new FirefoxOptions();
firefoxOptions.setProfile(firefoxProfile);
driver = new FirefoxDriver(firefoxOptions);
// Accept all certificates Chrome
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.addArguments("--ignore-certificate-errors");
driver = new ChromeDriver(chromeOptions);
// Set Chrome options
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.addArguments("user-data-dir=C:PathToUser Data");
driver = new ChromeDriver(chromeOptions);
// Turn off the JavaScript Firefox
ProfilesIni profile = new ProfilesIni();
FirefoxProfile firefoxProfile = profile.getProfile("ProfileName");
firefoxProfile.setPreference("javascript.enabled", false);
FirefoxOptions firefoxOptions = new FirefoxOptions();
firefoxOptions.setProfile(firefoxProfile);
driver = new FirefoxDriver(firefoxOptions);
// Set the default page load timeout
driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
// Start Firefox with plugins
FirefoxProfile profile = new FirefoxProfile();
firefoxProfile.addExtension(new File("C:extensionsLocationextension.xpi"));
FirefoxOptions firefoxOptions = new FirefoxOptions();
firefoxOptions.setProfile(firefoxProfile);
driver = new FirefoxDriver(firefoxOptions);
// Start Chrome with an unpacked extension
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.addArguments("load-extension=/path/to/extension");
driver = new ChromeDriver(chromeOptions);
// Start Chrome with a packed extension
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.addExtensions(new File("local/path/to/extension.crx"));
driver = new ChromeDriver(chromeOptions);
// Change the default files’ save location
FirefoxProfile firefoxProfile = new FirefoxProfile();
String downloadFilepath = "c:temp";
firefoxProfile.setPreference("browser.download.folderList", 2);
firefoxProfile.setPreference("browser.download.dir", downloadFilepath);
firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/binary, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream"));
FirefoxOptions firefoxOptions = new FirefoxOptions();
firefoxOptions.setProfile(firefoxProfile);
driver = new FirefoxDriver(firefoxOptions);


****Список Capabilities****

_Capabilities & ChromeOptions_

https://sites.google.com/a/chromium.org/chromedriver/capabilities
https://github.com/SeleniumHQ/selenium/wiki/DesiredCapabilities

`_import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.ie.InternetExplorerDriver;
//...
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability("unexpectedAlertBehaviour", "dismiss");
WebDriver driver = new InternetExplorerDriver(caps);
System.out.println(((HasCapabilities) driver).getCapabilities());_`

****Опции командной строки****


_Опции командной строки Chrome: http://peter.sh/experiments/chromium-command-line-switches/

Опции командной строки Firefox: https://developer.mozilla.org/en-US/docs/Mozilla/Command_Line_Options

Опции командной строки Internet Explorer: https://msdn.microsoft.com/ru-ru/library/hh826025(v=vs.85).aspx

Статья про активацию микрофона:
http://www.testautomationguru.com/selenium-webdriver-google-voice-search-automation-using-arquillian-graphene/

**Ненастоящие браузеры**

Драйвер для PhantomJS: https://github.com/detro/ghostdriver

Драйвер для WebKit: https://github.com/MachinePublishers/jBrowserDriver/

Headless automation for Internet Explorer: http://triflejs.org/

Список headless-браузеров: https://github.com/dhamaniasad/HeadlessBrowsers

Список headless-браузеров: https://gist.github.com/evandrix/3694955


**Работа с cookies**

_`import org.openqa.selenium.Cookie;
//...
driver.manage().addCookie(new Cookie("test", "test"));
Cookie testCookie = driver.manage().getCookieNamed("test");
Set<Cookie> cookies = driver.manage().getCookies();
driver.manage().deleteCookieNamed("test");
driver.manage().deleteAllCookies();`_

*Параллельный запуск*

`Пример моего кода:`
https://github.com/telepnev/SeleniumBook/tree/parallel_Browser
https://github.com/telepnev/SeleniumBook/tree/parallel_Browser

`WebDriverFactory: https://github.com/barancev/webdriver-factory

https://github.com/barancev/selenium-training/blob/master/java-example/src/test/java/ru/stqa/training/selenium/TestBase.java

## Поиск элементов

**Локаторы**


`WebElement form1 = driver.findElement(By.id("login-form"));
WebElement form2 = driver.findElement(By.tagName("form"));
WebElement form3 = driver.findElement(By.className("login"));
WebElement form4 = driver.findElement(By.cssSelector("form.login"));
WebElement form5 = driver.findElement(By.cssSelector("#login-form"));

WebElement field1 = driver.findElement(By.name("username"));
WebElement field2 = driver.findElement(By.xpath("//input[@name='username']"));
WebElement link = driver.findElement(By.linkText("Logout"));


List<WebElement> links = driver.findElements(By.tagName("a"));`



**CSS Selectors**


Спецификация CSS Selectors Level 2 -- https://www.w3.org/TR/CSS21/

Спецификация CSS Selectors Level 3 -- https://www.w3.org/TR/css3-selectors/

Информация о том, в каких версиях браузеров можно использовать CSS Selectors Level 3 - http://caniuse.com/#feat=css-sel3

`Шпаргалки по CSS:`

http://www.w3schools.com/cssref/css_selectors.asp
https://www.simple-talk.com/dotnet/.net-framework/xpath,-css,-dom-and-selenium-the-rosetta-stone/ (постер)
https://www.smashingmagazine.com/2009/07/css-3-cheat-sheet-pdf/ (постер, последняя страница)

Проверка значения атрибута:

"[cheked]" - наличие атрибута (булиеновское значение)
"[name = email]" - совпадение значения
"[title * Name]" - одержит текст
"[src ˆ= http]" - начинается с текста
"[src $= .pdf]" - заканчивается текстом

Комбинация условий: 

- "label" -- по тегу
- ".error" -- по классу
- "label.error" -- по тегу и классу
- "label.error.fatal" --  по тегу и двум классам

Движение по дереву:

"div#main p" -p  где-то внутри блока div#main
"div#main > p" -p НЕПОСРЕДСТВЕННО внутри div#main


`XPath`

Спецификация XPath 1.0 -- https://www.w3.org/TR/xpath/

Шпаргалки по XPath:
http://scraping.pro/5-best-xpath-cheat-sheets-and-quick-references/
https://www.simple-talk.com/dotnet/net-framework/xpath-css-dom-and-selenium-the-rosetta-stone/ (постер)




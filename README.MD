# **Selenium Book**

`**Запуск браузера** с авто скачкой всего необходимого через WebDriverManager`
https://github.com/bonigarcia/webdrivermanager



_WebDriverManager.chromedriver().setup();
driver = new ChromeDriver(options);


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




**Selenium Book**

**Запуск браузера** с авто скачкой всего необходимого через WebDriverManager
`https://github.com/bonigarcia/webdrivermanager`



_WebDriverManager.chromedriver().setup();
driver = new ChromeDriver(options);_


**Список Capabilities**

_Capabilities & ChromeOptions_
`https://sites.google.com/a/chromium.org/chromedriver/capabilities`

`https://github.com/SeleniumHQ/selenium/wiki/DesiredCapabilities`

`_import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.ie.InternetExplorerDriver;
//...
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability("unexpectedAlertBehaviour", "dismiss");
WebDriver driver = new InternetExplorerDriver(caps);
System.out.println(((HasCapabilities) driver).getCapabilities());_`


**Опции командной строки**


_Опции командной строки Chrome: `http://peter.sh/experiments/chromium-command-line-switches/`

Опции командной строки Firefox: `https://developer.mozilla.org/en-US/docs/Mozilla/Command_Line_Options`

Опции командной строки Internet Explorer: `https://msdn.microsoft.com/ru-ru/library/hh826025(v=vs.85).aspx`

Статья про активацию микрофона:
`http://www.testautomationguru.com/selenium-webdriver-google-voice-search-automation-using-arquillian-graphene/`


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






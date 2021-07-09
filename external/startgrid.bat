set server_directory="C:\Users\79612\seleniumgrid"
set chrome_driver_path="C:\Users\79612\seleniumgrid\chromedriver.exe"
set gecko_driver_path="C:\Users\79612\seleniumgrid\geckodriver.exe"

cd %server_directory%
start java -jar .\selenium-server-standalone-3.141.59.jar -role hub
start java "-Dwebdriver.gecko.driver=%gecko_driver_path%" -jar .\selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register -port 5558
start java "-Dwebdriver.chrome.driver=%chrome_driver_path%" -jar .\selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register -port 5559

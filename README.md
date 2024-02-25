# Проект по автоматизации тестирования API на базе сервиса [Regres.IN](https://reqres.in/)

![regresin](reqres.jpg "Главная страница")

<p>Сервис для тестирования API</p>

##  Содержание:

- <a href="#tools"> Используемые инструменты</a>
- <a href="#cases"> Тест-кейсы</a>
- <a href="#autotests"> Запуск автотестов</a>
- <a href="#jenkins"> Сборка в Jenkins</a>
- <a href="#allureReport"> Пример Allure-отчета</a>
- <a href="#allure"> Интеграция с Allure TestOps</a>
- <a href="#jira"> Интеграция с Jira</a>
- <a href="#tg"> Уведомления в Telegram с использованием бота</a>
____
<a id="tools"></a>
## Используемые инструменты

<p align="center">
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/logo/Java.svg"></a>
<a href="https://rest-assured.io/"><img width="6%" title="Rest Assured" src="media/logo/RestAssured.png"></a>
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="media/logo/Selenoid.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/logo/AllureTestOps.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/logo/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/logo/JUnit5.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/logo/GitHub.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/logo/Jenkins.svg"></a>
<a href="https://web.telegram.org/a/"><img width="6%" title="Telegram" src="media/logo/Telegram.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira/"><img width="5%" title="Jira" src="media/logo/Jira.svg"></a>
</p>

____
Тесты написаны на языке <code>Java</code> с использованием фреймворка для автоматизации API тестирования [Rest Assured](https://rest-assured.io/), сборщик - <code>Gradle</code>.

<code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования.
При прогоне тестов для удаленного запуска используется [Selenoid](https://aerokube.com/selenoid/).

Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.
Также реализована интеграция с <code>Allure TestOps</code> и <code>Jira</code>.


Содержание Allure-отчета для каждого кейса:
* Body и response для всех выполненных кейсов c добавленным логированием params, body, url 

____
<a id="cases"></a>
## :male_detective: Тест-кейсы
Auto:
- ✓ Проверка пагинации
- ✓ Создание пользователя
- ✓ Обновление пользователя PUT
- ✓ Обновление пользователя PATCH
- ✓ Успешное удаление пользователя

  <a id="autotests"></a>
____
## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала

Локальный запуск.
Из корневой директории проекта выполнить:
```
./gradlew api_tests  запуск всех тестов
```
____
<a id="jenkins"></a>
## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> </a> Сборка в <a target="_blank" href="https://jenkins.autotests.cloud/job/apiProject_Ponomarenko/"> Jenkins </a>
Для доступа в Jenkins необходима регистрация на ресурсе [Jenkins](https://jenkins.autotests.cloud/)

![Build](media/screenshots/jenkins.jpg "Сборка Jenkins")
Для запуска сборки необходимо перейти в раздел <code>Build Now</code>,и нажать кнопку <code>Build</code>.

<p>После выполнения сборки, в блоке <code>Build History</code> напротив номера сборки появятся значки <code>Allure Report</code> и <code>Allure TestOps</code>, при клике на которые откроется страница с сформированным html-отчетом и тестовой документацией соответственно.</p>

![Suite](media/screenshots/allure1.jpg "Тест-кейсы")



____
<a id="allureReport"></a>
## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> </a> Пример <a target="_blank" href="https://jenkins.autotests.cloud/job/apiProject_Ponomarenko/allure/"> Allure-отчета </a>


<p align="center">
<img title="Allure Overview" src="allure1.jpg">
</p>

____
<p>Примеры логов в тестах</p>

![log](media/screenshots/allure2.jpg "Тест-кейсы")
![log](media/screenshots/allure3.jpg "Тест-кейсы")

____
<a id="allure"></a>
## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/AllureTestOps.svg"> </a> Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/4076/dashboards"> Allure TestOps </a>

На *Dashboard* в <code>Allure TestOps</code> видна статистика количества тестов: сколько из них добавлены и проходятся вручную, сколько автоматизированы. Новые тесты, а так же результаты прогона приходят по интеграции при каждом запуске сборки.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screenshots/alluretestops.jpg">
</p>

____
<a id="jira"></a>
## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logo/Jira.svg"> </a> Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1123"> Jira </a>

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в задаче отображается, какие тест-кейсы были написаны в рамках задачи и результат их прогона.
<p align="center">
<img title="Jira Task" src="media/screenshots/jira.jpg">
</p>

____
<a id="tg"></a>
## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов в специально настроенный чат.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screenshots/telegram.jpg">
</p>
## Дипломный проект курса "Тестировщик" от Нетологии

Дипломный проект представляет собой автоматизацию тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.

## Описание приложения

### Бизнес-часть

Приложение представляет из себя веб-сервис.

![AQA_ Заявка на карту - Google Chrome 2021-04-07 02](https://user-images.githubusercontent.com/70913727/113789218-64876880-9747-11eb-9cbd-91ffae6d3d52.png)

Приложение предлагает купить тур по определённой цене с помощью двух способов:

1. Обычная оплата по дебетовой карте
1. Выдача кредита по данным банковской карты

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:

* сервису платежей (далее - Payment Gate)
* кредитному сервису (далее - Credit Gate)

Приложение должно в собственной СУБД сохранять информацию о том, каким способом был совершён платёж и успешно ли он был совершён (при этом данные карт сохранять не допускается).

### Техническая часть

Само приложение расположено в файле `aqa-shop.jar` и запускается стандартным способом `java -jar aqa-shop.jar` на порту 8080.

В файле `application.properties` приведён ряд типовых настроек:

* учётные данные и url для подключения к СУБД
* url-адреса банковских сервисов

### СУБД

Заявлена поддержка двух СУБД:

* MySQL
* PostgreSQL

Учётные данные и url для подключения задаются в файле `application.properties`.

### Банковские сервисы

В качестве банковского сервиса для работы приложения будет использоваться симулятор, который может принимать запросы в нужном формате и генерировать ответы.

Симулятор написан на Node.js, поэтому для его запуска необходим либо Docker, либо установленный Node.js. Симулятор расположен в каталоге gate-simulator.

Симулятор позволяет для заданного набора карт генерировать предопределённые ответы.

Набор карт представлен в формате JSON в файле data.json.

Данный сервис, симулирует как Payment Gate, так и Credit Gate.

## Как запускать тесты

**Условия**

На тестируемой машине установлен Docker, Gradle, MySQL, PostgreSQL.

**Шаги**

1. Открыть терминал;
2. Скопировать репозиторий:
```
git clone https://github.com/Sabbotage-cmd/DiplomQA.git
```
3. Перейти в директорию `DiplomQA/`
4. Остановить и удалить запущенные контейнеры, если есть:
```
docker stop $(docker ps -q)
docker rm $(docker ps -qa)
```
5. Запустить контейнер Docker:
```
docker-compose up -d --force-recreate
```
6. Убедиться в том, что сервис БД запустился, выполнив вход;

    * Для MySQL:
    ```
    docker-compose exec mysql mysql -u app -p app
    ```
    * Для PostgreSQL:
    ```
    docker-compose exec postgres psql -U app -W postgres
    ```


7. Выйти из БД, выполнив запрос `exit;` (для MySQL) либо `exit` (для PostgreSQL)
8. Запустить SUT.

    * Для MySQL:
    ```
    java -jar -Dspring.datasource.url=jdbc:mysql://localhost:3306/app aqa-shop.jar
    ```
    * Для PostgreSQL:

    ```
    java -jar -Dspring.datasource.url=jdbc:postgresql://localhost:5432/postgres aqa-shop.jar

    ```    

9. Перейти на новую вкладку терминала
10. Запустить тесты

    * Для MySQL:
    ```
    ./gradlew test -Dsut.url=http://localhost:8080 -Ddb.url=jdbc:mysql://localhost:3306/app -Ddb.user=app -Ddb.password=pass
    ```

    * Для PostgreSQL:
    ```
    ./gradlew test -Dsut.url=http://localhost:8080 -Ddb.url=jdbc:postgresql://localhost:5432/postgres -Ddb.user=app -Ddb.password=pass
    ```
    ## Отчётность

+ [План автоматизации](https://github.com/Sabbotage-cmd/DiplomQA/blob/master/documentation/Plan.md)
+ [Отчёт о пройденных тестах](https://github.com/Sabbotage-cmd/DiplomQA/blob/master/documentation/Report.md)
+ [Итоги](https://github.com/Sabbotage-cmd/DiplomQA/blob/master/documentation/Summary.md)

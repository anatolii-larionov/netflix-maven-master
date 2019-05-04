Сборка мавен:
1) clean
2) install

Сборка образов докер:
1) docker build -f .\docker-config-server -t config-server:8888 .
2) docker build -f .\docker-eureka-server -t eureka-server:8282 .
3) docker build -f .\docker-api-gateway -t gateway-api:9094 .
4) docker build -f .\docker-employees-api -t employees-api:9092 .
5) docker build -f .\docker-workspaces-api -t workspaces-api:9090 .

Docker compose
1) Заупуск: docker-compose up -d
2) Остановка: docker-compose stop

Настройки:
    1) config-server настроен на 127.0.0.1:8888
    2) eureka настроена на 127.0.0.1:8282
    3) gateway-api настроен на 127.0.0.1:9094
    4) workspace-api настроен на 127.0.0.1:9090
    5) employees-api настроен на 127.0.0.1:9092
    6) elasticsearch настроен на 127.0.0.1:9092
    7) logstash настроен на 127.0.0.1:5044
    8) kibana настроена на 127.0.0.1:5601
    9) postgresql настроен на 127.0.0.1:5001 и 172.17.0.1:5432

http://127.0.0.1:9090/workspaces/0000001

    {
        id: "0000001",
        unit: 1,
        seat: 1,
        serialNumber: "6e950b17-b22d-409c-a8ae-aca5bbabb006",
        osFamily: "WINDOWS"
    }

http://127.0.0.1:9092/employees/0000001

    {
        id: "0000001",
        firstName: "Ivan",
        lastName: "Ivanov",
        email: "Ivan_Ivanov@corpmail.com",
        workspaceId: "0000001"
    }

http://127.0.0.1:9094/workspaces-service/workspaces/0000001

    {
        id: "0000001",
        unit: 1,
        seat: 1,
        serialNumber: "6e950b17-b22d-409c-a8ae-aca5bbabb006",
        osFamily: "WINDOWS"
    }

http://127.0.0.1:9094/employees-service/employees/0000001

    {
        id: "0000001",
        firstName: "Ivan",
        lastName: "Ivanov",
        email: "Ivan_Ivanov@corpmail.com",
        workspaceId: "0000001"
    }
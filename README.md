# AsynchRabbitMSG
Create a queue in RabbitMQ with this name "test.queue" and create the table like I mentioned in the SQL file and just ENJOY !
(when u post/put/delete data to/from service "test1" it will update its database , send the data to rabbitmq and then the second service "test2" which is a sub for the queue where "test1" published will pull the data and do the same to its database (databases synchronization between 2 microservices))

# SwagChat-API

Provides API for https://github.com/philhudson91/SwagChat 

## Building 

Install maven

```
mvn clean package
```
Will produce a fat jar runnable by

```
java -jar target/WebApi-0.0.1-SNAPSHOT.jar

```


Redis is required locally

redis schema
```
SADD chatservice '1'
SADD chatservice '2'
SADD chatservice '3'
SADD chatservice '4'
SADD chatservice '5'
SADD chatservice '6'
SADD chatservice '7'
SADD chatservice '8'

HMSET chatservice1 url "https://web.whatsapp.com" enabled true name "WhatsApp"
HMSET chatservice2 url "https://www.messenger.com" enabled true name "Messenger"
HMSET chatservice3 url "https://slack.com/signin" enabled true name "Slack"
HMSET chatservice4 url "https://web.skype.com/" enabled true name "Skype Web"
HMSET chatservice5 url "https://web.wechat.com/" enabled true name "wechat"
HMSET chatservice6 url "https://launchpad.37signals.com/campfire/signin" enabled true name "Campfire"
HMSET chatservice7 url "https://webchat.freenode.net/" enabled true name "freenode Web IRC"
HMSET chatservice8 url "https://webchat.oftc.net" enabled true name "OFTC Web IRC"
```

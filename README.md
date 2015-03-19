# java-Gmail-smpt-mail-sender
A simple class to send emails by smtp protocol

# how use (a very smaple example).
```java
Gmail.send(
	"login", "my.user@gmail.com",
	"password", "**secret**",
	"to", "edw_inkisidor@hotmail.com",
	"subject", "simple test",
	"body", "<h1>A simple test</h1><p>success<p>"
);
```

# Sample 2 (config and after send).
```java
//Config
Gmail.config(
	"username", "my.user@gmail.com", //alias de login
	"pass", "**secret**", //alias de password
	"to", "edw_inkisidor@hotmail.com",
	"cc", "chanerec@gmail.com",
	"bcc", "eymard@gmail.com"
);
// Sending
Gmail.send(
	"title", "second test",//alias de subject
	"msg", "<h1>other email</h1><p>success!!<p>"
);
```

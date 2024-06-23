# What is MailHog?

MailHog is an email testing tool for developers. It acts as a fake SMTP server, capturing emails sent to it so that they can be viewed and debugged via a web interface or an API. It's especially useful in development environments where you need to test email functionality without sending real emails.

## Clone the Repository
git clone https://github.com/akhter-rakib/spring-boot-suite/tree/master/MailHogSpringIntegration

## Running the Application
`docker compose up`

## Send a test plain text email
`http://localhost:8080/send-plain-text-email?to=test@example.com`

## Check MailHog
`http://localhost:8025`


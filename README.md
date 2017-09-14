# Build the project

Initial build setup:
`docker run --rm -v "$PWD":/project -w /project --name gradle gradle:alpine gradle wrapper`

Build:
`./gradlew build`

See more here: https://hub.docker.com/_/gradle/

# Trigger Jenkins job build

1. Create new user (e.g. `webhook`) with the following permissions: `Overall > Read`, `Job > Build`, `Job > Read` & `Job > Workspace`. Login as the user and get their API token
2. Under a job, enable "Trigger Builds Remotely" and set an authentication token
3. Trigger a POST request with the following structure:

If CSRF protection is enabled then you need to get the CRUMB first:
`CRUMB=$(curl -s 'http://USER:TOKEN@localhost:8080/crumbIssuer/api/xml?xpath=concat(//crumbRequestField,":",//crumb)')`

`http://{USER}:{API_TOKEN}@{JENKINS_URL}/job/{JOB}/build?token={AUTHENTICATION_TOKEN}`

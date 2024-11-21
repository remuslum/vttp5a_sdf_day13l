# Docker commands

1. docker --version <br>

2. docker system prune <br>
Clear the docker compilation/build cache

3. docker build -t <docker login>/<app name>:<version> <br>
Build the docker image
E.g. docker build -t remuslum98/vttp5a_ssf_day13l:0.0.1<br>

4. docker image ls
Check if docker omage is created in local docker repo

5. docker container -d -p <exposed public port>:<app server> <image name> <br>
docker container -d -p 8080:3000 vttp5a-ssf-day13l:0.0.1
Run the image inside the container (Exposed public port is what you use on the browser, app server is the port that the app runs on)

6. docker container ls
Check docker container running <br>

7. docker stop <container-name> <br>
Stop a running container

8. docker start <container-name> <br>
Start a stopped container

9. docker rm <container-name> <br>
Remove container

10. docker rmi <image id> <br>
Delete docker image

# Docker compile and push to railway
1. In railway app, create a service (linked the project) <br>
2. Create the env variable SERVER_PORT=3000
3. In your project root folder (terminal), execute "railway login
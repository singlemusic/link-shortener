# link-shortener

## Running in a local docker swarm

These steps will show you how to run the three components
as docker services in a local docker swarm.

We'll need an alias for localhost that we can use as our
short link host. To use `link-shortener` as the host add 
the following to `/etc/hosts`:

```
127.0.0.1   link-shortener
```


Execute maven to build the docker containers:
```
./mvnw clean install -DskipTests
```

Initialize a docker swarm on the local machine with:
```
docker swarm init
```

Deploy the services to the local swarm with:
```
docker stack deploy --compose-file docker-stack.yml link-shortener
```

Now, if you visit http://localhost:5001/dashboard you should see the traefik
dashboard with two configured front-ends and back-ends.
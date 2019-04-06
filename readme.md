# link-shortener

A simple link shortener API built with 
[spring-boot](https://github.com/spring-projects/spring-boot),
[traefik](https://github.com/containous/traefik),
and mysql running in docker.



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

## Using Short Links

### Link Creation
This example will create a short link with the slug "google" that
points to google.com:
```
curl -X POST http://localhost/api/shortener/short-link \
    -H "Accept: application/json" \
    -H "Content-Type: application/json" \
    -d '{"link":"https://google.com","slug":"google","title":"Google"}'
```
The response is the created short link:
```json
{
  "id": "9afbaa9d-a874-499d-9b00-6317baa389af",
  "slug": "google",
  "title": "Google",
  "link": "https://google.com",
  "createdAt": "2019-04-06T14:37:24.860Z",
  "state": "ACTIVE"
}

```
### Link Usage
To visit the short link we go to our short-link domain with `google` as the path:

http://link-shortener/google

You should be redirected to google's home page.

### Click data

To see the captured click information we can query the click endpoint:
```
curl http://localhost/api/shortener/short-link/click?slug=google
```
The response contains a page of click data:
```json
{
  "content": [
    {
      "id": "14e7cedd-5909-4b98-a725-31a0376688db",
      "shortLinkId": "9afbaa9d-a874-499d-9b00-6317baa389af",
      "link": "https://google.com",
      "ipAddress": "108.87.159.81",
      "userAgent": "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:66.0) Gecko/20100101 Firefox/66.0",
      "referrer": null,
      "createdAt": "2019-04-06T14:39:27.000Z"
    }
  ],
  "pageable": {
    "sort": {
      "sorted": false,
      "unsorted": true,
      "empty": true
    },
    "offset": 0,
    "pageSize": 20,
    "pageNumber": 0,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 1,
  "totalElements": 1,
  "last": true,
  "number": 0,
  "sort": {
    "sorted": false,
    "unsorted": true,
    "empty": true
  },
  "size": 20,
  "first": true,
  "numberOfElements": 1,
  "empty": false
}
```

## Shutting Down

To bring down the stack:
```
docker stack rm link-shortener
```

To completely shutdown the local docker swarm:
```
docker swarm leave --force
```
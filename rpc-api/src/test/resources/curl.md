
## 1. POST

> 发送数据请求

```
$ curl -X POST http://localhost:8080/apt-api/ -H 'Content-Type:application/json' --data '{"num":10,"infos":[{"ip":"访问ip地址0","visisted_url":"访问网站地址0","content":"浏览内容0"},{"ip":"访问ip地址1","visisted_url":"访问网站地址1","content":"浏览内容1"},{"ip":"访问ip地址2","visisted_url":"访问网站地址2","content":"浏览内容2"},{"ip":"访问ip地址3","visisted_url":"访问网站地址3","content":"浏览内容3"},{"ip":"访问ip地址4","visisted_url":"访问网站地址4","content":"浏览内容4"},{"ip":"访问ip地址5","visisted_url":"访问网站地址5","content":"浏览内容5"},{"ip":"访问ip地址6","visisted_url":"访问网站地址6","content":"浏览内容6"},{"ip":"访问ip地址7","visisted_url":"访问网站地址7","content":"浏览内容7"},{"ip":"访问ip地址8","visisted_url":"访问网站地址8","content":"浏览内容8"},{"ip":"访问ip地址9","visisted_url":"访问网站地址9","content":"浏览内容9"}]}'
```

## 2. GET

> 获取请求次数和字节数总量

```
$ curl -X GET http://localhost:8080/apt-api/
```

## 3. GET 

> 重置请求次数和字节数总量

```
$ curl -X GET http://localhost:8080/apt-api/?reset=true
```
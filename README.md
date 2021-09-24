## Ehcache를 사용한 springboot cache 구현하기

#### 도움을 주신 분들
[🙇🏻 - 이동욱](https://jojoldu.tistory.com/57)  
[🙇🏻‍ - dveamer](http://dveamer.github.io/backend/SpringCacheable.html)
[🙇🏻‍♂️ - jaehun2841](https://jaehun2841.github.io/2018/11/07/2018-11-04-ehcache-config-for-springframework/#ehcache-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0)


### dependency & env

1. build.gradle

```
implementation 'net.sf.ehcache:ehcache:2.10.3'
```

2. ehcache.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:noNamespaceSchemaLocation="http://ehcache.org/ehcache.xsd"
         maxBytesLocalHeap="300M" <!-- CacheManager에 의해 관리되는 캐시의 메모리를 300M로 제한 -->
         updateCheck="false">

    <!-- 임시저장 경로를 설정 -->
    <diskStore path="java.io.tmpdir" />
    <!-- 
        Cache에 저장할 레퍼런스의 최대값을 100000으로 지정,
        maxDepthExceededBehavior = "continue" :  초과 된 최대 깊이에 대해 경고하지만 크기가 조정 된 요소를 계속 탐색
        maxDepthExceededBehavior = "abort" : 순회를 중지하고 부분적으로 계산 된 크기를 즉시 반환
    -->
    <sizeOfPolicy maxDepth="100000" maxDepthExceededBehavior="continue"/>

   <!-- default Cache 설정 (반드시 선언해야 하는 Cache) -->
    <defaultCache
            eternal="false"
            timeToIdleSeconds="0"
            timeToLiveSeconds="1200"
            overflowToDisk="false"
            diskPersistent="false"
            diskExpiryThreadIntervalSeconds="120"
            memoryStoreEvictionPolicy="LRU">
    </defaultCache>

    <!-- 사용하고자 하는 캐시 별 설정 -->
    <cache name="LocalCacheData"
           eternal="false"
           timeToIdleSeconds="0"
           timeToLiveSeconds="1200"
           overflowToDisk="false"
           diskPersistent="false"
           diskExpiryThreadIntervalSeconds="120"
           memoryStoreEvictionPolicy="LRU">
    </cache>
```

### 간단한 기능
1. `@EnableCaching`: 프로젝트에서 캐시 관련 어노테이션을 사용하겠다는 선언.
2. `@Cacheable(value="findMemberCache", key="#name")`: ehcache.xml에서 지정한 findMemberCache 캐시를 사용하겠다는 의미이며, 여기서 key는 메소드 argument인 name을 사용하겠다는 의미이다.
3. `@CacheEvict(value = "findMemberCache", key="#name")`: 해당 캐시 내용을 지우겠다는 의미.


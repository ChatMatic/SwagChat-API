package io.swagchat.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@org.springframework.stereotype.Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private final String key = "chatservice";
//    public void saveData(String id, String data) {
//        redisTemplate.boundSetOps(id).add(data);
//    }
//
//    @HystrixCommand(fallbackMethod = "getDataFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    },
//            threadPoolProperties = {
//                    @HystrixProperty(name = "coreSize", value = "25"),
//                    @HystrixProperty(name = "maxQueueSize", value = "20"),
//                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "1"),
//                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "500"),
//            }, threadPoolKey = "getData")
//    public Set<String> getData(String id) {
//        return redisTemplate.<String>boundSetOps(id).members();
//    }
//
//    public void deleteData(String id, String data) {
//        redisTemplate.boundSetOps(id).remove(data);
//    }
//
//    @HystrixCommand(fallbackMethod = "sizeOfCacheFallback", threadPoolProperties = {}, threadPoolKey = "sizeOfCache")
//    public Long sizeOfCache(String id) {
//        return redisTemplate.boundSetOps(id).size();
//    }
//
//    public Set<String> getDataFallback(String id) {
//        return Collections.<String>emptySet();
//    }
//
//    public Long sizeOfCacheFallback(String id) {
//        return 0L;
//    }

    public List<Map<Object, Object>> getListOfServices() {
        Stream<Map<Object, Object>> chatservices = redisTemplate.boundSetOps(key).members()
                .stream().map(service -> {
                    Map<Object, Object> entries = redisTemplate.boundHashOps(key + service).entries();
                    entries.put("id", service);
                    return !redisTemplate.hasKey(key + service) ? null : entries;
                });

        return chatservices.collect(Collectors.toList());
    }


}

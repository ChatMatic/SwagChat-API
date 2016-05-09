package io.swagchat.webapi.service;

import io.swagchat.webapi.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
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

    public List<Service> getListOfServices() {
        Stream<Map<Object, Object>> chatservices = redisTemplate.boundSetOps(key).members()
                .stream().map(service -> {
                    Map<Object, Object> entries = redisTemplate.boundHashOps(key + service).entries();
                    entries.put("id", service);
                    return !redisTemplate.hasKey(key + service) ? null : entries;
                });

        List<Map<Object, Object>> collect = chatservices.collect(Collectors.toList());
        List<Service> services = new ArrayList<>();
        collect.stream().filter(map -> map.containsKey(Service.keys[0]) && map.containsKey(Service.keys[1]) && map.containsKey(Service.keys[2]) && map.containsKey(Service.keys[3]) && map.containsKey(Service.keys[4])).forEach(map -> {
            Service service = new Service(Long.valueOf(String.valueOf(map.get(Service.keys[3]))), String.valueOf(map.get(Service.keys[0])),
                    String.valueOf(map.get(Service.keys[1])), Boolean.valueOf(String.valueOf(map.get(Service.keys[2]))), String.valueOf(map.get(Service.keys[4])));
            services.add(service);
        });
        return services;
    }


}

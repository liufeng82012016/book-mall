package com.my.liufeng.provider.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.StandardCharsets;

@Configuration
public class RedisConfig {
    @Value("${spring.application.name:default}")
    private String moduleName;
//    @Value("${spring.redis.host}")
//    private String host;
//    @Value("${spring.redis.port}")
//    private String port;
//    @Value("${spring.redis.password}")
//    private String password;

    @Bean
    public RedisTemplate<String, Object> redisTemplate(@Autowired RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        KeyGenerator keyGenerator = new KeyGenerator(moduleName);
        redisTemplate.setKeySerializer(keyGenerator);
        redisTemplate.setHashKeySerializer(keyGenerator);
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

//    @Bean
//    public RedissonClient redissonClient() {
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://" + host + ":" + port).setPassword(password);
//        return Redisson.create(config);
//    }


    /**
     * 自定义key序列化，增加应用名称以做区分
     */
    public static class KeyGenerator implements RedisSerializer<String> {

        public final String moduleName;

        public KeyGenerator(String moduleName) {
            this.moduleName = moduleName;
        }

        @Override
        public byte[] serialize(String str) throws SerializationException {
            String prefix = this.moduleName + ":";
            if (str == null) {
                return (prefix + "").getBytes(StandardCharsets.UTF_8);
            }
            return (prefix + str).getBytes(StandardCharsets.UTF_8);
        }

        @Override
        public String deserialize(byte[] bytes) throws SerializationException {
            if (bytes == null) {
                return null;
            }
            String string = new String(bytes, StandardCharsets.UTF_8);
            String prefix = this.moduleName + ":";
            if (string.startsWith(prefix)) {
                return string.substring(prefix.length());
            } else {
                return string;
            }
        }
    }
}

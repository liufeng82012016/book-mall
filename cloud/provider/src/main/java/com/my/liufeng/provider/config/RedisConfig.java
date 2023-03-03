package com.my.liufeng.provider.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.StandardCharsets;

@Configuration
public class RedisConfig {
    @Value("${spring.application.name:default}")
    private String moduleName;

    @Bean
    public RedisTemplate<String, Object> redisTemplate(@Autowired RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.activateDefaultTyping(new DefaultBaseTypeLimitingValidator());
        KeyGenerator keyGenerator = new KeyGenerator(moduleName);
        redisTemplate.setKeySerializer(keyGenerator);
        redisTemplate.setHashKeySerializer(keyGenerator);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

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
                return (prefix + "null").getBytes(StandardCharsets.UTF_8);
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

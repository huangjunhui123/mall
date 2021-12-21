package com.macro.mall.demo.demo.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.macro.mall.demo.demo.common.RedisConfig;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * redis缓存配置类
 * @author 黄俊辉
 */
@Configuration
public class RedisCacheConfig extends CachingConfigurerSupport {

    @Bean
    public RedisCacheManager redisCacheWriter(RedisConnectionFactory redisConnectionFactory) {
        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
                this.getRedisCacheConfigurationWithTtl(600),
                this.getRedisCacheConfigurationMap()
        );
    }

    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper mapper = new ObjectMapper();
        jackson2JsonRedisSerializer.setObjectMapper(mapper);

        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * 设置指定key的缓存
     * @return
     */
    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        redisCacheConfigurationMap.put(RedisConfig.PLAT_TYPE, this.getRedisCacheConfigurationWithTtl(60*60*24*7));
        redisCacheConfigurationMap.put(RedisConfig.TASK_STATUS, this.getRedisCacheConfigurationWithTtl(60*60*24*7));
        redisCacheConfigurationMap.put(RedisConfig.JURISDICTION_UNIT, this.getRedisCacheConfigurationWithTtl(60*60*24*7));
        redisCacheConfigurationMap.put(RedisConfig.JURISDICTION_UNIT_ALL, this.getRedisCacheConfigurationWithTtl(60*60*24*7));
        redisCacheConfigurationMap.put(RedisConfig.INDUSTRY_CATEGORY_ALL, this.getRedisCacheConfigurationWithTtl(60*60*24*7));
        redisCacheConfigurationMap.put(RedisConfig.RECEIVE_PLATFORM, this.getRedisCacheConfigurationWithTtl(60*60*24*30));
        redisCacheConfigurationMap.put(RedisConfig.STAR_CATEGORY, this.getRedisCacheConfigurationWithTtl(60*60*8));
        redisCacheConfigurationMap.put(RedisConfig.AREA_INFO, this.getRedisCacheConfigurationWithTtl(60*60*24*30));
        redisCacheConfigurationMap.put(RedisConfig.AREA_INFO_ALL, this.getRedisCacheConfigurationWithTtl(60*60*24*30));
        redisCacheConfigurationMap.put(RedisConfig.AREA_INFO_ALL_DATA, this.getRedisCacheConfigurationWithTtl(60*60*24*30));
        redisCacheConfigurationMap.put(RedisConfig.DATA_DIC, this.getRedisCacheConfigurationWithTtl(60*60*24*30));
        redisCacheConfigurationMap.put(RedisConfig.COMPANY_INDUSTRY_INFO, this.getRedisCacheConfigurationWithTtl(60*60*24*30));

        return redisCacheConfigurationMap;
    }

    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
                RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(jackson2JsonRedisSerializer)
        ).entryTtl(Duration.ofSeconds(seconds));

        return redisCacheConfiguration;
    }

}

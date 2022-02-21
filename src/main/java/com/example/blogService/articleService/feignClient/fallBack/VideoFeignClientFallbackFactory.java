package com.example.blogService.articleService.feignClient.fallBack;

import com.example.blogService.articleService.dto.ResponseObject;
import com.example.blogService.articleService.feignClient.VideoFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class VideoFeignClientFallbackFactory implements FallbackFactory<VideoFeignClient> {
    @Override
    public VideoFeignClient create(Throwable throwable) {
        return articleId -> {
            System.out.println("触发异常 " + throwable.getClass().getSimpleName());
            throwable.printStackTrace();
            return new ResponseObject<>("-1", "failed");
        };
    }
}

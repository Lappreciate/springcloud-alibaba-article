package com.example.blogService.articleService.feignClient;

import com.example.blogService.articleService.dto.ResponseObject;
import com.example.blogService.articleService.entity.Video;
import com.example.blogService.articleService.feignClient.fallBack.VideoFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "video-service", fallbackFactory = VideoFeignClientFallbackFactory.class)
public interface VideoFeignClient {

    @GetMapping("/video")
    ResponseObject<Video> findByArticleId(@RequestParam("articleId") Long articleId);
}

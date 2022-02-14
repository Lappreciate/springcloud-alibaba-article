package com.example.blogService.articleService.feignClient;

import com.example.blogService.articleService.entity.Video;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("video-service")
public interface VideoFeignClient {

    @GetMapping("/video")
    Video findByArticleId(@RequestParam("articleId") Long articleId);
}

package com.example.blogService.articleService.feignClient;

import com.example.blogService.articleService.entity.Video;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class VideoFeignClientTest {


    @Resource
    private VideoFeignClient videoFeignClient;
    @Test
    public void testFindByArticleId() {
        for (int i=0;i<3;i++){
            Video video = videoFeignClient.findByArticleId(1649L);
            System.out.println(video);
        }

    }
}
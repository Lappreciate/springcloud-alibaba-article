package com.example.blogService.articleService.entity;

public class Video {
    private Long videoId;
    private String sn;

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", sn='" + sn + '\'' +
                '}';
    }
}

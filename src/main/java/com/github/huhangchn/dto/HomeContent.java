package com.github.huhangchn.dto;


import com.github.huhangchn.model.Content;
import com.github.huhangchn.model.ContentCategory;

import java.util.List;

public class HomeContent extends ContentCategory {
    private List<Content> contentList;

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }
}

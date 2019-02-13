package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.dto.HomeContent;
import com.github.huhangchn.model.Content;

import java.util.List;

public interface ContentMapper extends Mapper<Content> {
    List<HomeContent> selectHomeContent();
}
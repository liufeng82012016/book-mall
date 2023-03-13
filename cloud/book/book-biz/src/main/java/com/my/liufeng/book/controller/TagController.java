package com.my.liufeng.book.controller;


import com.my.liufeng.book.po.Tag;
import com.my.liufeng.book.service.ITagService;
import com.my.liufeng.common.book.dto.TagDTO;
import com.my.liufeng.provider.utils.BeanCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private ITagService tagService;

    @PostMapping("/addOrUpdate")
    public void addOrUpdate(@RequestBody TagDTO tagDTO) {
        tagService.saveOrUpdate(BeanCopyUtils.convert(tagDTO, Tag.class));
    }

    @GetMapping("/list")
    public List<TagDTO> list() {
        List<Tag> dynastyList = tagService.list();
        return dynastyList.stream().map(dynasty -> {
            return BeanCopyUtils.convert(dynasty, TagDTO.class);
        }).collect(Collectors.toList());
    }

}


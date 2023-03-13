package com.my.liufeng.book.controller;


import com.my.liufeng.book.po.Dynasty;
import com.my.liufeng.book.service.IDynastyService;
import com.my.liufeng.common.book.dto.DynastyDTO;
import com.my.liufeng.provider.utils.BeanCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 朝代表 前端控制器
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/dynasty")
public class DynastyController {
    @Resource
    private IDynastyService dynastyService;

    @PostMapping("/addOrUpdate")
    public void addOrUpdate(@Valid @RequestBody DynastyDTO dynastyDTO) {
        dynastyService.saveOrUpdate(BeanCopyUtils.convert(dynastyDTO, Dynasty.class));
    }

    @GetMapping("/list")
    public List<DynastyDTO> list() {
        List<Dynasty> dynastyList = dynastyService.list();
        return dynastyList.stream().map(dynasty -> {
            return BeanCopyUtils.convert(dynasty, DynastyDTO.class);
        }).collect(Collectors.toList());
    }
}


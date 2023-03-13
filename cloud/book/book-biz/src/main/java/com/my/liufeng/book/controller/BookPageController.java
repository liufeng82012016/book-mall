package com.my.liufeng.book.controller;


import com.my.liufeng.book.po.BookPage;
import com.my.liufeng.book.service.IBookPageService;
import com.my.liufeng.common.book.dto.BookPageDTO;
import com.my.liufeng.common.book.vo.BookPageOrderVO;
import com.my.liufeng.common.book.vo.BookPageVO;
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
 * 书页表 前端控制器
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/page")
public class BookPageController {

    @Resource
    private IBookPageService bookPageService;

    @PostMapping("/addOrUpdate")
    public void addOrUpdate(@Valid @RequestBody BookPageDTO bookPageDTO) {
        bookPageService.addOrUpdate(bookPageDTO);
    }

    @GetMapping("/list")
    public List<BookPageDTO> list(BookPageVO authorQueryVO) {
        // todo 逻辑完善
        List<BookPage> bookPageList = bookPageService.list();
        return bookPageList.stream().map(bookPage -> {
            return BeanCopyUtils.convert(bookPage, BookPageDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/adjustOrder")
    public void adjustOrder(@RequestBody BookPageOrderVO bookPageOrderVO) {

    }

}


package com.my.liufeng.book.controller;


import com.my.liufeng.book.po.Book;
import com.my.liufeng.book.service.IBookService;
import com.my.liufeng.common.book.dto.BookDTO;
import com.my.liufeng.common.book.vo.BookQueryVO;
import com.my.liufeng.provider.utils.BeanCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 书籍表 前端控制器
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    private IBookService bookService;

    /**
     * 添加书籍
     */
    @PostMapping("/addOrUpdate")
    public void addOrUpdate(@Valid @RequestBody BookDTO bookDTO) {
        // 不更新卷数量
        bookDTO.setPages(null);
        bookService.addOrUpdate(bookDTO);
    }


    /**
     * 书籍列表
     */
    @GetMapping("/list")
    public List<BookDTO> listBook(BookQueryVO bookQueryVO) {

        return Collections.emptyList();
    }

}


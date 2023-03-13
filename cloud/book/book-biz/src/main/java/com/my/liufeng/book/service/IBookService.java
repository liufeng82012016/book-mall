package com.my.liufeng.book.service;

import com.my.liufeng.book.po.Book;
import com.baomidou.mybatisplus.extension.service.IService;
import com.my.liufeng.common.book.dto.BookDTO;

/**
 * <p>
 * 书籍表 服务类
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
public interface IBookService extends IService<Book> {

    void addOrUpdate(BookDTO bookDTO);
}

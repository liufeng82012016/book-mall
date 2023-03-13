package com.my.liufeng.book.service;

import com.my.liufeng.book.po.BookPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.my.liufeng.common.book.dto.BookPageDTO;

/**
 * <p>
 * 书页表 服务类
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
public interface IBookPageService extends IService<BookPage> {

    void addOrUpdate(BookPageDTO bookPageDTO);
}

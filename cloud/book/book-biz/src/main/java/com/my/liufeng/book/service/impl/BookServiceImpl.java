package com.my.liufeng.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.liufeng.book.mapper.BookMapper;
import com.my.liufeng.book.po.Author;
import com.my.liufeng.book.po.Book;
import com.my.liufeng.book.service.IAuthorService;
import com.my.liufeng.book.service.IBookService;
import com.my.liufeng.common.Asserts;
import com.my.liufeng.common.book.dto.BookDTO;
import com.my.liufeng.common.enums.ErrorCode;
import com.my.liufeng.provider.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 书籍表 服务实现类
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Resource
    private IAuthorService authorService;

    @Override
    public void addOrUpdate(BookDTO bookDTO) {
        Author author = authorService.getById(bookDTO.getId());
        Asserts.assertNotNull(author, ErrorCode.AUTHOR_NOT_EXIST);
        this.saveOrUpdate(BeanCopyUtils.convert(bookDTO, Book.class));
    }
}

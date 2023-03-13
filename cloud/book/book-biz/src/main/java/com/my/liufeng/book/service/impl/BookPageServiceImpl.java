package com.my.liufeng.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.my.liufeng.book.config.KeyFactory;
import com.my.liufeng.book.po.Book;
import com.my.liufeng.book.po.BookPage;
import com.my.liufeng.book.mapper.BookPageMapper;
import com.my.liufeng.book.service.IBookPageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.liufeng.book.service.IBookService;
import com.my.liufeng.common.Asserts;
import com.my.liufeng.common.book.dto.BookPageDTO;
import com.my.liufeng.common.enums.ErrorCode;
import com.my.liufeng.provider.utils.BeanCopyUtils;
import com.my.liufeng.provider.utils.LockUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 * 书页表 服务实现类
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
@Service
public class BookPageServiceImpl extends ServiceImpl<BookPageMapper, BookPage> implements IBookPageService {
    @Resource
    private IBookService bookService;

    @Override
    public void addOrUpdate(BookPageDTO bookPageDTO) {
        Book book = bookService.getById(bookPageDTO.getBookId());
        Asserts.assertNotNull(book, ErrorCode.BOOK_NOT_EXIST);
        String key = KeyFactory.BOOK_PAGE.getKey(String.valueOf(bookPageDTO.getId() != null ? bookPageDTO.getId() : bookPageDTO.getPageId()));
        String value = LockUtil.randomValue();
        LockUtil.lockSuccess(key, value, 3);
        try {
            if (Objects.isNull(bookPageDTO.getId())) {
                // 新增，保证每一卷编号不重复
                if (Objects.isNull(bookPageDTO.getPageId())) {
                    Integer maxPageId = baseMapper.queryMaxPageId(bookPageDTO.getBookId());
                    if (Objects.isNull(maxPageId)) {
                        maxPageId = 0;
                    }
                    bookPageDTO.setPageId(maxPageId + 1);
                } else {
                    BookPage condition = new BookPage();
                    condition.setBookId(bookPageDTO.getBookId());
                    condition.setPageId(bookPageDTO.getPageId());
                    QueryWrapper<BookPage> queryWrapper = new QueryWrapper<>(condition);
                    Asserts.assertNull(this.getOne(queryWrapper), ErrorCode.BOOK_PAGE_EXIST);
                }
            }
            saveOrUpdate(BeanCopyUtils.convert(bookPageDTO, BookPage.class));
        } finally {
            LockUtil.unlock(key, value);
        }
    }
}

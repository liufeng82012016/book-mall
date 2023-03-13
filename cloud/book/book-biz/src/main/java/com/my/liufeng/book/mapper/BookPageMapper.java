package com.my.liufeng.book.mapper;

import com.my.liufeng.book.po.BookPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 书页表 Mapper 接口
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
public interface BookPageMapper extends BaseMapper<BookPage> {

    /**
     * 查询最大书卷号
     *
     * @param bookId 书籍id
     * @return 最大书卷号
     */
    Integer queryMaxPageId(@Param("bookId") Integer bookId);
}

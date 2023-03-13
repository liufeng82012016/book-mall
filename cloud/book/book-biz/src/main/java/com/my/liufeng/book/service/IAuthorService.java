package com.my.liufeng.book.service;

import com.my.liufeng.book.po.Author;
import com.baomidou.mybatisplus.extension.service.IService;
import com.my.liufeng.common.book.dto.AuthorDTO;

/**
 * <p>
 * 作者表 服务类
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
public interface IAuthorService extends IService<Author> {

    /**
     * 添加或新增作者
     *
     * @param authorDTO 作者信息
     */
    void addOrUpdate(AuthorDTO authorDTO);
}

package com.my.liufeng.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.liufeng.book.mapper.AuthorMapper;
import com.my.liufeng.book.po.Author;
import com.my.liufeng.book.po.Dynasty;
import com.my.liufeng.book.service.IAuthorService;
import com.my.liufeng.book.service.IDynastyService;
import com.my.liufeng.common.Asserts;
import com.my.liufeng.common.book.dto.AuthorDTO;
import com.my.liufeng.common.enums.ErrorCode;
import com.my.liufeng.provider.context.ContextUtils;
import com.my.liufeng.provider.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 作者表 服务实现类
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements IAuthorService {

    @Resource
    private IDynastyService dynastyService;

    @Override
    public void addOrUpdate(AuthorDTO authorDTO) {
        Dynasty dynasty = dynastyService.getById(authorDTO.getDynasty());
        Asserts.assertNotNull(dynasty, ErrorCode.DYNASTY_NOT_EXIST);
        Author author = BeanCopyUtils.convert(authorDTO, Author.class);
        author.setManagerId(ContextUtils.getUserId());
        this.saveOrUpdate(author);
    }
}

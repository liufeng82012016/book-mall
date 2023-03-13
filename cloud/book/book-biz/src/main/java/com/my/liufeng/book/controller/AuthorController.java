package com.my.liufeng.book.controller;


import com.my.liufeng.book.po.Author;
import com.my.liufeng.book.service.IAuthorService;
import com.my.liufeng.common.book.dto.AuthorDTO;
import com.my.liufeng.common.book.vo.AuthorQueryVO;
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
 * 作者表 前端控制器
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Resource
    private IAuthorService authorService;

    @PostMapping("/addOrUpdate")
    public void addOrUpdate(@Valid @RequestBody AuthorDTO authorDTO) {
        authorService.addOrUpdate(authorDTO);
    }

    @GetMapping("/list")
    public List<AuthorDTO> list(AuthorQueryVO authorQueryVO) {
        // todo 逻辑完善
        List<Author> authorList = authorService.list();
        return authorList.stream().map(author -> {
            return BeanCopyUtils.convert(author, AuthorDTO.class);
        }).collect(Collectors.toList());
    }

}


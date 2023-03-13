package com.my.liufeng.book.service.impl;

import com.my.liufeng.book.po.Tag;
import com.my.liufeng.book.mapper.TagMapper;
import com.my.liufeng.book.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}

package com.lazy.demo.sshvue.server.api.service.impl;

import com.lazy.demo.sshvue.server.api.constants.Constant;
import com.lazy.demo.sshvue.server.api.dao.IExampleRepository;
import com.lazy.demo.sshvue.server.api.dto.ExampleQueryDto;
import com.lazy.demo.sshvue.server.api.dto.WebResultDto;
import com.lazy.demo.sshvue.server.api.entity.TExampleEntity;
import com.lazy.demo.sshvue.server.api.service.IExampleService;
import com.lazy.demo.sshvue.server.api.service.IUniqueService;
import com.lazy.demo.sshvue.server.api.utils.AssertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 账号服务实现类
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ExampleServiceImpl implements IExampleService {

    @Autowired
    private IExampleRepository iExampleRepository;

    @Autowired
    private IUniqueService iUniqueService;

    /**
     * 动态生成where语句
     */
    private Specification<TExampleEntity> doCreatedCondition(final ExampleQueryDto entity) {
        return (Specification<TExampleEntity>) (root, query, cb) -> {
            List<Predicate> predicate = new ArrayList<>();
            if (!AssertUtils.isEmpty(entity.getName())) {
                predicate.add(cb.like(root.get("name"), "%" + entity.getName().trim() + "%"));
            }
            if (!AssertUtils.isEmpty(entity.getEmail())) {
                predicate.add(cb.like(root.get("email"), "%" + entity.getEmail().trim() + "%"));
            }
            if (!AssertUtils.isEmpty(entity.getValidStatus())) {
                predicate.add(cb.equal(root.get("validStatus"), entity.getValidStatus().trim()));
            }
            if (entity.getAge() != null) {
                predicate.add(cb.equal(root.get("age"), entity.getAge()));
            }

            if (!AssertUtils.isEmpty(entity.getLastUpdateTime()) && !AssertUtils.isEmpty(entity.getLastUpdateTime2())) {
                predicate.add(cb.between(root.get("lastUpdateTime"), LocalDateTime.parse(entity.getLastUpdateTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                        LocalDateTime.parse(entity.getLastUpdateTime2(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
            }
            Predicate[] pre = new Predicate[predicate.size()];
            return query.where(predicate.toArray(pre)).getRestriction();
        };
    }

    @Override
    public WebResultDto<List<TExampleEntity>> findByConditions(ExampleQueryDto queryDto, PageRequest pageable) {

        WebResultDto<List<TExampleEntity>> dto = new WebResultDto<>();
        Page<TExampleEntity> page = iExampleRepository.findAll(this.doCreatedCondition(queryDto), pageable);
        dto.setTotalPage(page.getTotalPages())
                .setCurrentPage(page.getPageable().getPageNumber())
                .setPageSize(page.getPageable().getPageSize())
                .setCount(page.getTotalElements());
        dto.setData(page.getContent());

        return dto;
    }

    @Override
    public void saveOrUpdate(TExampleEntity entity) {
        entity.setLastUpdateTime(LocalDateTime.now());
        if (entity.getId() == null) {
            entity.setId(iUniqueService.getPrimaryKey());
        }
        if (entity.getCreateTime() == null) {
            entity.setCreateTime(entity.getLastUpdateTime());
        }
        if (AssertUtils.isEmpty(entity.getValidStatus())) {
            entity.setValidStatus(Constant.Y);
        }
        iExampleRepository.save(entity);
    }

    @Override
    public void deleteAll(List<Long> ids) {
        List<TExampleEntity> list = new ArrayList<>(ids.size());
        for (Long id : ids) {
            list.add(new TExampleEntity().setId(id));
        }
        iExampleRepository.deleteAll(list);
    }


}

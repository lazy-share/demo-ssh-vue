package com.lazy.demo.sshvue.server.api.service.impl;

import com.lazy.demo.sshvue.server.api.dao.IUniqueRepository;
import com.lazy.demo.sshvue.server.api.entity.TUniqueEntity;
import com.lazy.demo.sshvue.server.api.enums.UniqueTypeEnum;
import com.lazy.demo.sshvue.server.api.service.IUniqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * DB 主键服务实现类
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DbUniqueServiceImpl implements IUniqueService {

    @Autowired
    private IUniqueRepository iUniqueRepository;

    private final Object lock = new Object();

    @Override
    public Long getPrimaryKey() {

        synchronized (lock) {
            TUniqueEntity uniqueEntity = iUniqueRepository.findByType(UniqueTypeEnum.PRIMARY_KEY.getCode());

            if (uniqueEntity == null) {
                uniqueEntity = new TUniqueEntity().setId(1L)
                        .setType(UniqueTypeEnum.PRIMARY_KEY.getCode())
                        .setVal(1L);

                iUniqueRepository.save(uniqueEntity);
                return uniqueEntity.getVal();
            }
            uniqueEntity.setVal(uniqueEntity.getVal() + 1);
            iUniqueRepository.save(uniqueEntity);
            return uniqueEntity.getVal();
        }

    }
}

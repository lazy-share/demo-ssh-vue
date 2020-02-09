package com.lazy.demo.sshvue.server.api.service;

import com.lazy.demo.sshvue.server.api.dto.ExampleQueryDto;
import com.lazy.demo.sshvue.server.api.dto.WebResultDto;
import com.lazy.demo.sshvue.server.api.entity.TExampleEntity;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * <p>
 * 登录token服务接口
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
public interface IExampleService {


    WebResultDto<List<TExampleEntity>> findByConditions(ExampleQueryDto queryDto, PageRequest pageable);


    void saveOrUpdate(TExampleEntity entity);

    void deleteAll(List<Long> ids);

}

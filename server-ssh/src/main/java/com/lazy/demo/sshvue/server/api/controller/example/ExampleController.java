package com.lazy.demo.sshvue.server.api.controller.example;

import com.lazy.demo.sshvue.server.api.dto.ExampleQueryDto;
import com.lazy.demo.sshvue.server.api.dto.ResponseDto;
import com.lazy.demo.sshvue.server.api.entity.TExampleEntity;
import com.lazy.demo.sshvue.server.api.service.IExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * example控制器
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/9.
 */
@RestController
public class ExampleController {

    @Autowired
    private IExampleService iExampleService;

    private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);


    @PostMapping("/examples")
    public ResponseDto getExample(@RequestBody ExampleQueryDto queryDto) {

        //排序可以改为从前端传递
        Sort sort = Sort.by(Sort.Order.desc("lastUpdateTime"));


        return
                ResponseDto.success(iExampleService.findByConditions(queryDto,
                        PageRequest.of(queryDto.getPaging().getCurrentPage() - 1, queryDto.getPaging().getPageSize(), sort)));

    }

    @DeleteMapping("/examples/{ids}")
    public ResponseDto deleteExample(@PathVariable("ids") String ids) {

        String[] arr = ids.split(",");
        List<Long> idsList = new ArrayList<>(arr.length);
        for (String s : arr) {
            idsList.add(Long.valueOf(s));
        }
        iExampleService.deleteAll(idsList);
        return ResponseDto.success(null);
    }

    @PutMapping("/examples")
    public ResponseDto putExample(@RequestBody TExampleEntity entity) {

        iExampleService.saveOrUpdate(entity);
        return ResponseDto.success(null);
    }

}

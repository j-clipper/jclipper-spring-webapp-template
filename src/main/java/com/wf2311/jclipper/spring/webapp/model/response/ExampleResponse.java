package com.wf2311.jclipper.spring.webapp.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href="mailto:wf2311@163.com">wf2311</a>
 * @since 2021/6/22 15:26.
 */
@Data
public class ExampleResponse implements Serializable {
    @ApiModelProperty("名称")
    private String name;
}

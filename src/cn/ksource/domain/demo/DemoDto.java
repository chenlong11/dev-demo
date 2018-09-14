package cn.ksource.domain.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenlong
 * Date：2018/9/13
 * time：16:30
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DemoDto {

    private String id;

    private String aString;

    private Integer aInteger;

    private Double aDouble;

    private Long aLong;
}

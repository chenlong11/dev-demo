package cn.ksource.domain.sysUser;

import cn.ksource.domain.sysRole.SysRoleDto;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlong
 * Date：2018/9/26
 * time：10:40
 */
@Data
public class SysUserDto implements Serializable {

    private static final long serialVersionUID = 8373740147950625736L;

    private String id;

    private String userName;

    private String mobileNo;

    private String email;

    private Integer createDate;

    private Integer sn;

    private List<SysRoleDto> roles = new ArrayList<SysRoleDto>();

    private List<Map> modules = new ArrayList<Map>();

}

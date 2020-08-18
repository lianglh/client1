package com.dandan.client1.feign.hystrix;


import com.dandan.client1.common.ResultObject;
import com.dandan.client1.entity.Admin;
import com.dandan.client1.feign.AdminFeign;

import javax.validation.Valid;

public class AdminFeignHystrix implements AdminFeign {


    @Override
    public ResultObject addAdmin(Admin admin) {
        return null;
    }

    @Override
    public ResultObject getAdminDetail(Long adminId) {
        return null;
    }

    @Override
    public ResultObject deleteAdmin(Long adminId) {
        return null;
    }

    @Override
    public ResultObject updateAdmin(@Valid Admin admin) {
        return null;
    }
}

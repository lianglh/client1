package com.dandan.client1.controller;

import com.dandan.client1.common.ResultCode;
import com.dandan.client1.common.ResultObject;
import com.dandan.client1.entity.Admin;
import com.dandan.client1.servisce.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("${service.prefix}/adminApi")
@Api(tags = "AdminController",description="用户管理接口")
public class AdminController {


    @Resource
    AdminService adminService;

    /* 新增用户信息*/
    @ApiOperation("添加用户")
    @PostMapping( value = "/addAdmin" )
    public ResultObject addAdmin(@RequestBody @Valid Admin admin, BindingResult result, HttpServletRequest request) {
        ResultObject<Admin> resultObject=new ResultObject();
        try {

            admin=adminService.inserAdmin(admin);

            resultObject.setCode(ResultCode.SUCCESS.getCode());
            resultObject.setMsg(ResultCode.SUCCESS.getMessage());
            resultObject.setData(admin);
            return resultObject;
        } catch (Exception e) {
            e.printStackTrace();
            resultObject.setCode(ResultCode.FAILURE.getCode());
            resultObject.setMsg(ResultCode.FAILURE.getMessage());
            return resultObject;
        }finally {
            return resultObject;
        }
    }
  /*  *//* 新增用户信息*//*
    @ApiOperation("修改用户")
    @PutMapping( value = "/updateAdmin" )
    public ResultObject updateAdmin(@Valid @RequestBody Admin admin, BindingResult result) {
        ResultObject resultObject=new ResultObject();
        try {
            if (result.hasErrors()) {
                resultObject.setCode(ResultCode.PARAM_BIND_ERROR.getCode());
                resultObject.setMsg(result.getAllErrors().get(0).getDefaultMessage());
                return resultObject;
            }
            Admin existAdmin=new Admin();
            existAdmin.setAdminId(admin.getAdminId());
            existAdmin.setName(admin.getName());
            existAdmin=adminService.queryExistAdmin(existAdmin);
            if (existAdmin!=null){
                resultObject.setCode(ResultCode.PARAM_VALID_ERROR.getCode());
                resultObject.setMsg("用户名已存在");
                return resultObject;
            }
            existAdmin=new Admin();
            existAdmin.setAdminId(admin.getAdminId());
            existAdmin.setPhone(admin.getPhone());
            existAdmin=adminService.queryExistAdmin(existAdmin);
            if (existAdmin!=null){
                resultObject.setCode(ResultCode.PARAM_VALID_ERROR.getCode());
                resultObject.setMsg("手机号已存在");
                return resultObject;
            }
            existAdmin=new Admin();
            existAdmin.setAdminId(admin.getAdminId());
            existAdmin.setEmail(admin.getEmail());
            existAdmin=adminService.queryExistAdmin(existAdmin);
            if (existAdmin!=null){
                resultObject.setCode(ResultCode.PARAM_VALID_ERROR.getCode());
                resultObject.setMsg("邮箱已存在");
                return resultObject;
            }

            adminService.updateAdmin(admin);

            resultObject.setCode(ResultCode.SUCCESS.getCode());
            resultObject.setMsg(ResultCode.SUCCESS.getMessage());
            resultObject.setData(admin);
            return resultObject;
        } catch (Exception e) {
            e.printStackTrace();
            resultObject.setCode(ResultCode.FAILURE.getCode());
            resultObject.setMsg(ResultCode.FAILURE.getMessage());
            return resultObject;
        }finally {
            return resultObject;
        }
    }
    *//* 查询用户信息*//*
    @ApiOperation("根据id查询用户详情信息")
    @GetMapping( value = "/getAdminDetail" )
    public ResultObject<Admin> getAdminDetail(@RequestParam("adminId") Long adminId) {
//        ResultObject<Admin> resultObject=new ResultObject();
        try {
            Admin admin = new Admin();
            admin.setAdminId(adminId);
            admin=adminService.selectById(admin);
//            resultObject.setCode(ResultCode.SUCCESS.getCode());
//            resultObject.setMsg(ResultCode.SUCCESS.getMessage());
//            resultObject.setData(admin);
            return ResultObject.data(ResultCode.SUCCESS.getCode(),admin,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.fail("查询用户详情失败");
        }
    }
    *//* 删除用户信息*//*
    @ApiOperation("根据id删除户信息")
    @DeleteMapping( value = "/deleteAdmin" )
    public ResultObject deleteAdmin(@RequestParam Long adminId) {
        ResultObject resultObject=new ResultObject();
        try {
            adminService.deleteById(adminId);
            resultObject.setCode(ResultCode.SUCCESS.getCode());
            resultObject.setMsg(ResultCode.SUCCESS.getMessage());
            resultObject.setData(adminId);
            return resultObject;
        } catch (Exception e) {
            e.printStackTrace();
            resultObject.setCode(ResultCode.FAILURE.getCode());
            resultObject.setMsg(ResultCode.FAILURE.getMessage());
            return resultObject;
        }finally {
            return resultObject;
        }
    }

    *//* 新增用户信息*//*
    @ApiOperation("个人中心修改用户")
    @PutMapping( value = "/updateAdminInfo" )
    public ResultObject updateAdmin(@RequestBody Admin admin, HttpServletRequest request) {
        ResultObject resultObject=new ResultObject();
        try {

            Admin existAdmin=new Admin();

            Admin user=adminService.selectAdminById(admin)  ;

            if((admin.getNewPhone()!=null&&user.getNewPhone()!="")&&(admin.getOldPhone()!=null&&user.getOldPhone()!="")){


               if(!user.getPhone().equals(admin.getOldPhone())){
                   resultObject.setCode(ResultCode.PARAM_VALID_ERROR.getCode());
                   resultObject.setMsg("原手机号不正确");
                   return resultObject;
               }
               existAdmin=new Admin();
               existAdmin.setAdminId(admin.getAdminId());
               existAdmin.setPhone(admin.getNewPhone());
               existAdmin=adminService.queryExistAdmin(existAdmin);
               if (existAdmin!=null){
                   resultObject.setCode(ResultCode.PARAM_VALID_ERROR.getCode());
                   resultObject.setMsg("手机号已存在");
                   return resultObject;
               }
            }
            if(admin.getEmail()!=null&&admin.getEmail()!=""){


                existAdmin=new Admin();
                existAdmin.setAdminId(admin.getAdminId());
                existAdmin.setEmail(admin.getEmail());
                existAdmin=adminService.queryExistAdmin(existAdmin);
                if (existAdmin!=null){
                    resultObject.setCode(ResultCode.PARAM_VALID_ERROR.getCode());
                    resultObject.setMsg("邮箱已存在");
                    return resultObject;
                }

            }

            admin.setPhone(admin.getNewPhone());

            adminService.updateAdmin(admin);

            resultObject.setCode(ResultCode.SUCCESS.getCode());
            resultObject.setMsg(ResultCode.SUCCESS.getMessage());
            resultObject.setData(admin);
            return resultObject;
        } catch (Exception e) {
            e.printStackTrace();
            resultObject.setCode(ResultCode.FAILURE.getCode());
            resultObject.setMsg(ResultCode.FAILURE.getMessage());
            return resultObject;
        }finally {
            return resultObject;
        }
    }
    *//* 删除用户信息*//*
    @ApiOperation("根据id删除户信息")
    @GetMapping( value = "/test" )
    public ResultObject testAdmin() {
        return  ResultObject.data("hello","成功");
    }*/
}

package com.dandan.client1.servisce.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.dandan.client1.entity.Admin;
import com.dandan.client1.mapper.AdminMapper;
import com.dandan.client1.servisce.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;



@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;

    @Override
    @Transactional
    @LcnTransaction
    public Admin inserAdmin(Admin admin) throws Exception {
        String roles=admin.getRoles();

        adminMapper.insertAdmin(admin);

        return admin;
    }

   /* @Override
    public Admin selectById(Admin admin) {
        admin=adminMapper.selectByPrimaryKey(admin.getAdminId());
        String[]roles=admin.getRoles().split(",");
        long[] roleIds = Arrays.asList(roles).stream().mapToLong(Long::parseLong).toArray();
        List<Role> roleList=roleMapper.getRoleListByRoleIds(roleIds);
        admin.setRoleList(roleList);
        return admin;
    }

    @Override
    @LcnTransaction
    @Transactional
    public void deleteById(Long adminId) {

        adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    @LcnTransaction
    @Transactional
    public void updateAdmin(Admin admin) {
        String roles=admin.getRoles();
        if(roles !=null&&roles!=""){
            String[]roleList=roles.split(",");
            long[] roleIds = Arrays.asList(roleList).stream().mapToLong(Long::parseLong).toArray();
            List<RoleResource>roleResourceList=roleResourceMapper.getRoleResourceList(roleIds);
            List<RoleRes>roleResList=roleResMapper.getRoleResList(roleResourceList);
            String resources = null;
            if(roleResList !=null && roleResList.size()>0){
                for (RoleRes roleRes: roleResList) {
                    resources+=roleRes.getResourceId();
                }
                admin.setPower(resources);
            }
        }
        admin.setUpdated(new Date());
        adminMapper.updateByPrimaryKeySelective(admin);

    }



    @Override
    public String getJobNumber() {
        String jobNumber = null;
        Integer number = 0;
        String seqName = "gh";
        String seqNum = (String) redisUtil.get(seqName);
            if (StringUtils.isBlank(seqNum)) {

                  jobNumber= adminMapper.queryMaxNumber(seqNum);
                if (!StringUtils.isBlank(jobNumber)) {
                    jobNumber.substring(jobNumber.length()-10);
                    number=Integer.valueOf(removePrefix(jobNumber, "0")) + 1;
                } else {
                    number = 1;
                }
                //设置24小时失效
                redisUtil.set(seqName, String.valueOf(number),86400);

            } else {
                number = Integer.valueOf(seqNum) + 1;
                redisUtil.set(seqName, String.valueOf(number),86400);

            }
            jobNumber = seqName + String.format("%010d", number);


        return jobNumber;
    }

    @Override
    public Admin selectAdminById(Admin admin) {
        return adminMapper.selectByPrimaryKey(admin.getAdminId());
    }

    *//**
 * 去掉指定前缀
 *//*
    public static String removePrefix(String str, String prefix) {
        if (str != null && str.startsWith(prefix)) { return str.substring(prefix.length()); }
        return str;
    }*/
}

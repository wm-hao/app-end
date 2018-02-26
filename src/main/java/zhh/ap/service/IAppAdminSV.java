package zhh.ap.service;

import zhh.ap.bean.Admin;

import java.util.List;

public interface IAppAdminSV {
    List<Admin> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin selectByPrimaryKey(Integer id);

}

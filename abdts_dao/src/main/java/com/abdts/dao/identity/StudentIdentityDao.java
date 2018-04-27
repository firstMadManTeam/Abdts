package com.abdts.dao.identity;

import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.identity.StudentIdentity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentIdentityDao {

    List<StudentIdentity> getStuIdentity(DataKeyPair dataKeyPair);

}

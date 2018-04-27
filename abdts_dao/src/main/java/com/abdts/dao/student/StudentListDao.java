package com.abdts.dao.student;

import com.abdts.common.util.DataKeyPair;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author pzy
 */
@Mapper
public interface StudentListDao {

    Integer delStuList(DataKeyPair dkp);

    Integer addStuList(DataKeyPair dkp);

    Integer updStuList(DataKeyPair dkp);

}

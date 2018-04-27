package com.abdts.service.student;

import com.abdts.common.util.DataKeyPair;

/**
 * @author pzy
 */
public interface StudentListService {

    /**
     * 删除操作
     * @param dkp
     * @return
     * @throws Exception
     */
    boolean delStuList(DataKeyPair dkp)throws Exception;

    /**
     * 新增操作
     * @param dkp
     * @return
     * @throws Exception
     */
    boolean addStuList(DataKeyPair dkp)throws Exception;

    /**
     * 更新操作
     * @param dkp
     * @return
     * @throws Exception
     */
    boolean updStuList(DataKeyPair dkp)throws Exception;

}

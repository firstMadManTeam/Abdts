package com.abdts.service.identity;

import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.identity.StudentIdentity;

import java.util.List;

/**
 * @author pzy
 */
public interface StudentIdentityService {

    List<StudentIdentity> getStuIdentity(DataKeyPair dataKeyPair);

}

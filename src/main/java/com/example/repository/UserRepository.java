package com.example.repository;

import com.example.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2021-04-30 13:42
 * @version: 1.0
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {
    UserInfo findByUsername(String username);
}

package com.zzy.dao;

import com.zzy.entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Description:
 *
 * @author litianxiang
 * @date 2019-10-25
 */
public interface ApplyDao extends JpaRepository<Apply, Long> {
    @Query(value = "SELECT * FROM T_APPLY WHERE VERIFICATION_ID = ?1 AND APPLY_USER_ID=?2 ORDER BY APPLY_DATE DESC", nativeQuery = true)
    List<Apply> findByVerificationIdAAndApplyUserId(Long id, Long applyUserId);

    List<Apply> findAllByApplyUserId(Long id);
}

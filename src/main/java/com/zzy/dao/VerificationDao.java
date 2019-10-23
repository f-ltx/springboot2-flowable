package com.zzy.dao;

import com.zzy.entity.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Administrator
 */
public interface VerificationDao extends JpaRepository<Verification, Long> {
}
